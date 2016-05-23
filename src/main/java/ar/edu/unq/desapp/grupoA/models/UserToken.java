package ar.edu.unq.desapp.grupoA.models;

import ar.edu.unq.desapp.grupoA.models.utils.TokenGenerator;

import javax.persistence.*;


@Entity
@Table(name = "UserToken")
public class UserToken {

    @Transient
    private TokenGenerator tokenGenerator = TokenGenerator.defaultGenerator();

    @Id()
    @GeneratedValue()
    @Column(name = "TOKEN_ID")
    private int id;

    @Column(name = "TOKEN_STRING")
    private String token;

    @ManyToOne(optional = false)
    private UserModel userModel;

    public void generateToken() {
        this.setToken(this.tokenGenerator.generate());
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
