package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.oauth.GoogleOauthCredential;
import ar.edu.unq.desapp.grupoA.repositories.GoogleOauthCredentialRepository;
import ar.edu.unq.desapp.grupoA.utils.google.AuthClient;
import ar.edu.unq.desapp.grupoA.utils.google.ClientFactory;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.CodeExchangeException;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.NoRefreshTokenException;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.NoUserIdException;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.oauth2.model.Userinfoplus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.io.IOException;

@Service("googleCredentialsService")
public class GoogleCredentialsService {

    private GoogleOauthCredentialRepository googleOauthCredentialRepository;
    private ClientFactory clientFactory;

    @Transactional
    public GoogleOauthCredential get(String userId) {
        return this.getGoogleOauthCredentialRepository().findByUserId(userId);
    }

    @Transactional
    public Userinfoplus getUserinfo(Credential credential){
        try {
            return this.getClientFactory().getDefaultClient(this.getGoogleOauthCredentialRepository()).getUserInfo(credential);
        } catch (NoUserIdException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Credential create(String authorizationCode) {

        AuthClient authClient = this.getClientFactory().getDefaultClient(this.getGoogleOauthCredentialRepository());
        try {
            return authClient.getCredentials(authorizationCode, "failed");
        } catch (CodeExchangeException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (NoRefreshTokenException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public GoogleOauthCredentialRepository getGoogleOauthCredentialRepository() {
        return googleOauthCredentialRepository;
    }

    @Autowired
    public void setGoogleOauthCredentialRepository(GoogleOauthCredentialRepository googleOauthCredentialRepository) {
        this.googleOauthCredentialRepository = googleOauthCredentialRepository;
    }

    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    @Autowired
    public void setClientFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
}
