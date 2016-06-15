package ar.edu.unq.desapp.grupoA.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseUserModelFactory {

    private UserModelRepository userModelRepository;

    public UserModel getUser() {
        UserModel user = new UserModel(StringUtils.getName(), StringUtils.getEmail());
        this.getUserModelRepository().save(user);
        return this.getUserModelRepository().findById(user.getId());
    }
    public UserModel getUserAdmin() {
        UserModel user = new UserModel("Administrator","admin@noreply.com");
        this.getUserModelRepository().save(user);
        return this.getUserModelRepository().findById(user.getId());
    }


    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    @Autowired
    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }
}
