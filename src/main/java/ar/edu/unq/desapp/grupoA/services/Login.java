package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;

public class Login {

    private UserModelRepository repository;

    public UserModel signUp(String fullName, String email) {

        return new UserModel(fullName, email);
    }

    public void setRepository(UserModelRepository repository) {
        this.repository = repository;
    }

    public UserModelRepository getRepository() {
        return repository;
    }
}
