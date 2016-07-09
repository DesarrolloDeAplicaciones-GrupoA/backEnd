package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.UserModel;

public class UserResponde {
    private int id;
    private String fullName;
    private String email;
    private String picture;

    public UserResponde(int id, String fullName, String email, String picture) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.picture = picture;
        // this.points = points;
    }

    public static UserResponde build(UserModel userModel) {
        return new UserResponde(userModel.getId(), userModel.getFullName(), userModel.getEmail(), userModel.getPicture());
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
