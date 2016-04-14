package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.testUtis.factories.RouteTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TravelAddingTest {

    private UserModel user;
    private TravelAdding travelAdding;

    @Before
    public void setUp() {
        this.user = new UserModelTestFactory().getUser();
        this.travelAdding = new TravelAdding();
        Interval rangeHoures = new Interval(new DateTime(2000, 1, 01, 9, 0), new DateTime(2000, 1, 01, 14, 0));
        List<Integer> frequency = new ArrayList<Integer>();
        frequency.add(DateTimeConstants.MONDAY);
        frequency.add(DateTimeConstants.WEDNESDAY);
        frequency.add(DateTimeConstants.FRIDAY);
        Route route = new RouteTestFactory().fromConstitucionToCorrientes();
        this.travelAdding.createTravel(user, "Viaje Trabajo", 50, 20, route, rangeHoures, frequency);

    }

    @Test
    public void addingTravelToUserTest() {
        Assert.assertEquals(this.user.getTravels().size(), 1);
    }
    @Test
    public void testValuesTravel(){
        Assert.assertEquals(this.user.getTravels().get(0).getFuelCost(),50);
        Assert.assertEquals(this.user.getTravels().get(0).getTollCost(),20);
        Assert.assertEquals(this.user.getTravels().get(0).getNameTravel(), "Viaje Trabajo");
    }
}
