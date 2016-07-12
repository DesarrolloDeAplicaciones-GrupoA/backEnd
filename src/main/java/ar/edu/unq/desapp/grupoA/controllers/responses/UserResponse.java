package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.UserModel;

public class UserResponse {
    private int id;
    private String fullName;
    private String email;
    private String picture;
    private int points;

    public UserResponse(int id, String fullName, String email, String picture, int points) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.picture = picture;
        this.points = points;
    }

    public static UserResponse build(UserModel userModel) {
        return new UserResponse(userModel.getId(), userModel.getFullName(), userModel.getEmail(), userModel.getPicture(),userModel.getPoints());
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
