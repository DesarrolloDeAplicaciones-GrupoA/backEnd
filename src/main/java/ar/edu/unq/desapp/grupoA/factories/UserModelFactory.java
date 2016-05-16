package ar.edu.unq.desapp.grupoA.factories;

import ar.edu.unq.desapp.grupoA.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userFactory")
public class UserModelFactory extends BaseUserModelFactory{

    @Transactional
    public UserModel getUser() {
        return super.getUser();
    }
}
