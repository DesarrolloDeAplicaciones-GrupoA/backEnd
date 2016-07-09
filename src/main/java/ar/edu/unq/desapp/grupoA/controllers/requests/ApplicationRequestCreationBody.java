package ar.edu.unq.desapp.grupoA.controllers.requests;

import ar.edu.unq.desapp.grupoA.utils.google.DateUtils;

import java.sql.Date;

public class ApplicationRequestCreationBody {
    private String upDate;

    public Date buildUpDate() {
        return DateUtils.parse(this.getUpDate());
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public String getUpDate() {
        return upDate;
    }
}
