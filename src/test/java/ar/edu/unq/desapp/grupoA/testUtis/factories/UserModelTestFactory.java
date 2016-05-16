package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("userModelTestFactory")
public class UserModelTestFactory {

    @Autowired
    private UserModelRepository userModelRepository;

    public UserModel getUser() {
        UserModel user = new UserModel(StringUtils.getName(), StringUtils.getEmail());
        this.getUserModelRepository().save(user);
        return this.getUserModelRepository().findById(user.getId());
    }

    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }
}
