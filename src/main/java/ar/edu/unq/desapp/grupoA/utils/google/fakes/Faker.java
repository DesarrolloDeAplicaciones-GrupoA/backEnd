package ar.edu.unq.desapp.grupoA.utils.google.fakes;

import ar.edu.unq.desapp.grupoA.factories.RouteFactory;
import ar.edu.unq.desapp.grupoA.factories.UserModelFactory;
import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.services.ApplicationRequestService;
import ar.edu.unq.desapp.grupoA.services.TravelAdding;
import ar.edu.unq.desapp.grupoA.services.VehicleAdding;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("faker")
public class Faker {

    private UserModelFactory userModelFactory;
    private VehicleAdding vehicleAdding;
    private TravelAdding travelAdding;
    private RouteFactory routeFactory;
    private RoutesReader routesReader;
    private ApplicationRequestService applicationRequestService;
    private UserModelRepository userModelRepository;

    public void createData() {
        List<Route> routes = this.createRoutes();
        routes.forEach((route) -> setUpUser(getUser(), route));
    }

    public void afterSignUp(UserModel user) {
        List<Route> routes = this.createRoutes();
        routes.forEach((route) -> setUpUser(user, route));
        this.getUserModelRepository().findAll().stream().filter(aUser -> aUser.getId() != user.getId()).forEach(aUser -> {
            Travel travel = (Travel) user.getTravels().toArray()[0];
            Date datetime = new Date(1000);
            Point upPoint = travel.getRoute().getStart();
            Point downPoint = travel.getRoute().getEnd();
            this.getApplicationRequestService().createApplicationRequest(aUser, travel, datetime, upPoint, downPoint);
        });
    }

    private List<Route> createRoutes() {
        return this.getRoutesReader().build();
    }

    @Transactional
    private void setUpUser(UserModel userModel, Route route) {

        Set<Integer> freq = new HashSet<Integer>();
        freq.add(1);
        freq.add(2);
        freq.add(3);
        freq.add(4);

        Interval rangeHours = new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));

        Time fromTime = new Time(rangeHours.getStartMillis());
        Time toTime = new Time(rangeHours.getEndMillis());
        this.getTravelAdding().createTravel(userModel, "Viaje por " + userModel.getFullName(), 200, 200, route, fromTime, toTime, freq);
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

    public RoutesReader getRoutesReader() {
        return routesReader;
    }

    @Autowired
    public void setRoutesReader(RoutesReader routesReader) {
        this.routesReader = routesReader;
    }

    public ApplicationRequestService getApplicationRequestService() {
        return applicationRequestService;
    }

    @Autowired
    public void setApplicationRequestService(ApplicationRequestService applicationRequestService) {
        this.applicationRequestService = applicationRequestService;
    }

    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    @Autowired
    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }
}
