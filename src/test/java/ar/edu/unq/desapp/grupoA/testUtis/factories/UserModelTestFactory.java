package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.apache.commons.lang3.RandomStringUtils;


public class UserModelTestFactory {

    private UserModel user;

    public UserModel getUser() {
        return (new UserModel(StringUtils.getName(), StringUtils.getEmail()));
    }
}
