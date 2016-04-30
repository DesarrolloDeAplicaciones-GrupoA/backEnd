package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class Login {

    @Autowired
    private UserModelRepository userModelRepository;

    @Transactional
    public UserModel signUp(String fullName, String email) {
        UserModel user = new UserModel(fullName, email);
        this.userModelRepository.save(user);
        return user;
    }

    public void setRepository(UserModelRepository repository) {
        this.userModelRepository = repository;
    }

    public UserModelRepository getRepository() {
        return userModelRepository;
    }
}
