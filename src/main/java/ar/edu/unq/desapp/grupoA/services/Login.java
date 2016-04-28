package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.transaction.annotation.Transactional;

public class Login {

    private UserModelRepository repository;

    @Transactional
    public UserModel signUp(String fullName, String email) {
        UserModel user = new UserModel(fullName, email);
        this.repository.save(user);
        return user;
    }

    public void setRepository(UserModelRepository repository) {
        this.repository = repository;
    }

    public UserModelRepository getRepository() {
        return repository;
    }
}
