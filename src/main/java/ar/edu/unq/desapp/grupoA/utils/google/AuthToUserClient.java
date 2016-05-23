package ar.edu.unq.desapp.grupoA.utils.google;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.oauth.GoogleOauthCredential;
import ar.edu.unq.desapp.grupoA.repositories.GoogleOauthCredentialRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.CodeExchangeException;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.NoRefreshTokenException;
import ar.edu.unq.desapp.grupoA.utils.google.exceptions.NoUserIdException;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;

import java.io.IOException;
import java.util.List;

// ...

public class AuthToUserClient extends AuthClient{

    private GoogleOauthCredentialRepository googleOauthCredentialRepository;

    public AuthToUserClient(GoogleClientSecrets clientSecrets, List<String> scopes, String redirectURI, GoogleOauthCredentialRepository googleOauthCredentialRepository) {
        super(clientSecrets, scopes, redirectURI);
        this.setGoogleOauthCredentialRepository(googleOauthCredentialRepository);
    }

    @Override
    Credential getStoredCredentials(String userId) {
        return null;
    }

    @Override
    void storeCredentials(String userId, Credential credentials) {
        GoogleOauthCredential user = new GoogleOauthCredential();
        user.setGoogleUserId(userId);
        user.setGoogleAccessToken(credentials.getAccessToken());
        user.setGoogleRefreshToken(credentials.getRefreshToken());
        this.getGoogleOauthCredentialRepository().save(user);
    }

    public GoogleOauthCredentialRepository getGoogleOauthCredentialRepository() {
        return googleOauthCredentialRepository;
    }

    public void setGoogleOauthCredentialRepository(GoogleOauthCredentialRepository googleOauthCredentialRepository) {
        this.googleOauthCredentialRepository = googleOauthCredentialRepository;
    }
}

