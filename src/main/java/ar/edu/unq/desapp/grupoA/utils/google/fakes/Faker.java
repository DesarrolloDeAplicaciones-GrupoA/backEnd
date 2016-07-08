package ar.edu.unq.desapp.grupoA.utils.google.fakes;

import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.services.TravelAdding;
import ar.edu.unq.desapp.grupoA.services.VehicleAdding;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

@Component("faker")
public class Faker {

    private UserModelFactory userModelFactory;
    private VehicleAdding vehicleAdding;
    private TravelAdding travelAdding;
    private RouteFactory routeFactory;

    public void createData() {
        Arrays.asList(this.getUser(), this.getUser(), this.getUser()).forEach(this::setUpUser);
    }

    @Transactional
    private void setUpUser(UserModel userModel) {
        Point from = this.getRouteFactory().getPointFactory().create(-34.731192, -58.256765);
        Point to = this.getRouteFactory().getPointFactory().create(-34.708636, -58.282860);
        Route route = this.getRouteFactory().fromTo(from, to);

        List<Integer> freq = Arrays.asList(1, 2, 3, 4);

        Interval rangeHours = new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));

        Time fromTime = new Time(rangeHours.getStartMillis());
        Time toTime = new Time(rangeHours.getEndMillis());
        this.getTravelAdding().createTravel(userModel, "Viaje de " + userModel.getFullName(), 200, 200, route, fromTime, toTime, freq);
    }

    private UserModel getUser() {
        return this.getUserModelFactory().getUser();
    }

    public UserModelFactory getUserModelFactory() {
        return userModelFactory;
    }

    @Autowired
    public void setUserModelFactory(UserModelFactory userModelFactory) {
        this.userModelFactory = userModelFactory;
    }

    public VehicleAdding getVehicleAdding() {
        return vehicleAdding;
    }

    @Autowired
    public void setVehicleAdding(VehicleAdding vehicleAdding) {
        this.vehicleAdding = vehicleAdding;
    }

    public TravelAdding getTravelAdding() {
        return travelAdding;
    }

    @Autowired
    public void setTravelAdding(TravelAdding travelAdding) {
        this.travelAdding = travelAdding;
    }

    public RouteFactory getRouteFactory() {
        return routeFactory;
    }

    @Autowired
    public void setRouteFactory(RouteFactory routeFactory) {
        this.routeFactory = routeFactory;
    }
}
