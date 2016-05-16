package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("loginService")
public class Login {

    private UserModelRepository userModelRepository;

    @Transactional
    public UserModel signUp(String fullName, String email) {
        UserModel user = new UserModel(fullName, email);
        this.userModelRepository.save(user);
        return user;
    }

    @Transactional
    public List<UserModel> findAll() {
        return this.getRepository().findAll();
    }

    @Autowired
    public void setRepository(UserModelRepository repository) {
        this.userModelRepository = repository;
    }

    public UserModelRepository getRepository() {
        return userModelRepository;
    }
}
