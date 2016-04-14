package ar.edu.unq.desapp.grupoA.testUtis.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;

/**
 * Created by Loiacono.P671 on 09/04/2016.
 */
public class UserModelTestFactory {

    private UserModel user;

    public UserModel getUser() {
        return (new UserModel("Pepe Santillan", "pepeSantillan@gmail.com"));
    }
}
