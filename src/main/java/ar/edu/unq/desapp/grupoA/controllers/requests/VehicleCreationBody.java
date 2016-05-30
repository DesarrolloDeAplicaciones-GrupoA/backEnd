package ar.edu.unq.desapp.grupoA.controllers.requests;

public class VehicleCreationBody {

    private String brand;
    private Integer capacity;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
