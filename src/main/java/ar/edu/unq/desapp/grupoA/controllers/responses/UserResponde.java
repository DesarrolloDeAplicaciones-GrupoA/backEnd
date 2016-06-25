package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.UserModel;

public class UserResponde {
    private int id;
    private String fullName;
    private String email;

    public UserResponde(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
       // this.points = points;
    }

    public static UserResponde build(UserModel userModel) {
        return new UserResponde(userModel.getId(), userModel.getFullName(), userModel.getEmail());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
