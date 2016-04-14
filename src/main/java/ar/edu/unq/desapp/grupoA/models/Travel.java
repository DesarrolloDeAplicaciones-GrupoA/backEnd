package ar.edu.unq.desapp.grupoA.models;

import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

public class Travel {
    private String nameTravel; //un nombre guia para identificar y luego listar los viajes
    private Route route;
    private int fuelCost;
    private int tollCost; //Costo Del Peaje
    private Interval rangeHours; //Rango horario, se tendra que definir como maximo un rango de 2 hs/
    private List<Integer> frequency; //Frecuencia realizacion del recorrido Ej: Mon - Wed - Fri, Lista de Dias
    private List<ApplicationRequest> applicationRequests;

    public Travel(String nameTravel, int fuel, int toll, Route route, Interval rangeHours, List<Integer> frequency) {
        this.nameTravel = nameTravel;
        this.route = route;
        this.fuelCost = fuel;
        this.tollCost = toll;
        this.rangeHours = rangeHours;
        this.frequency = frequency;
        this.applicationRequests = new ArrayList<>();
    }

    public String getNameTravel() {
        return nameTravel;
    }

    public void addApplicationRequest(ApplicationRequest request) {
        this.applicationRequests.add(request);
    }

    public int getFuelCost() { return fuelCost;  }

    public int getTollCost() { return tollCost;  }
}
