package ar.edu.unq.desapp.grupoA.controllers.responses;

import ar.edu.unq.desapp.grupoA.models.Vehicle;

public class VehicleCreationResponse {

    private String brand;
    private Integer capacity;
    private Integer id;

    public VehicleCreationResponse(String brand, Integer capacity, Integer id) {
        this.setBrand(brand);
        this.setCapacity(capacity);
        this.setId(id);
    }

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

    public static VehicleCreationResponse build(Vehicle vehicle) {
        return new VehicleCreationResponse(vehicle.getBrand(), vehicle.getCapacity(), vehicle.getId());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
