package ar.edu.unq.desapp.grupoA.models;

import org.joda.time.Interval;

import java.sql.Time;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Travel")
public class Travel {

    private static final long serialVersionUID = -3495963290665047361L;

    public Travel(){}

    @Id()
    @GeneratedValue()
    @Column(name = "TRAVEL_ID")
    private int id;

    @Column(name = "name_travel")
    private String nameTravel; //un nombre guia para identificar y luego listar los viajes
    @Column(name = "fuel_cost")
    private int fuelCost;
    @Column(name = "fuel_toll")
    private int tollCost; //Costo Del Peaje
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel userModel;
    @OneToMany(mappedBy = "travel")
    private Set<Score> scores;

    @ManyToOne
    private Route route;
    @Column(name = "range_form")
    private Time rangeFrom; //Rango horario, se tendra que definir como maximo un rango de 2 hs/
    @Column(name = "range_to")
    private Time rangeTo; //Rango horario, se tendra que definir como maximo un rango de 2 hs/
    @Transient
    private List<Integer> frequency; //Frecuencia realizacion del recorrido Ej: Mon - Wed - Fri, Lista de Dias
    @Transient
    private List<ApplicationRequest> applicationRequests;


    public List<Integer> getFrequency() {
        return frequency;
    }

    public void setFrequency(List<Integer> frequency) {
        this.frequency = frequency;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Travel(String nameTravel, int fuel, int toll, Route route, Time rangeFrom, Time rangeTo, List<Integer> frequency) {
        super();
        this.nameTravel = nameTravel;
        this.route = route;
        this.fuelCost = fuel;
        this.tollCost = toll;
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.frequency = frequency;
        this.applicationRequests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNameTravel() {
        return nameTravel;
    }

    public void addApplicationRequest(ApplicationRequest request) {
        this.applicationRequests.add(request);
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public int getTollCost() {
        return tollCost;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public Time getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(Time rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public Time getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Time rangeTo) {
        this.rangeTo = rangeTo;
    }
}
