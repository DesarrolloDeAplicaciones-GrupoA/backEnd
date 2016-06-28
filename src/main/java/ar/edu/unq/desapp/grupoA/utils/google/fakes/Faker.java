package ar.edu.unq.desapp.grupoA.utils.google.fakes;

import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("faker")
public class Faker {

    private UserModelFactory userModelFactory;

    public UserModel getUser() {
        return this.getUserModelFactory().getUser();
    }

    public UserModelFactory getUserModelFactory() {
        return userModelFactory;
    }

    @Autowired
    public void setUserModelFactory(UserModelFactory userModelFactory) {
        this.userModelFactory = userModelFactory;
    }
}
