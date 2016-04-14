package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;

public class Login {

    public UserModel signUp(String fullName, String email) {

        return new UserModel(fullName, email);
    }
}
