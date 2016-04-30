package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import ar.edu.unq.desapp.grupoA.repositories.UserModelRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.RouteTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.StringUtils;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TravelAddingTest extends AbstractServiceTest{

    private UserModel userModel;
    @Autowired
    private TravelAdding travelAdding;
    @Autowired
    private UserModelRepository userModelRepository;
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private UserModelTestFactory userModelTestFactory;
    private String travelName;

    @Before
    public void setUp() {
        this.userModel = this.getUserModel();
        Interval rangeHoures = new Interval(new DateTime(2000, 1, 1, 9, 0), new DateTime(2000, 1, 1, 14, 0));
        List<Integer> frequency = new ArrayList<Integer>();
        frequency.add(DateTimeConstants.MONDAY);
        frequency.add(DateTimeConstants.WEDNESDAY);
        frequency.add(DateTimeConstants.FRIDAY);
        Route route = new RouteTestFactory().fromConstitucionToCorrientes();
        this.travelName = StringUtils.getName();
        this.travelAdding.createTravel(userModel, this.travelName, 50, 20, route, rangeHoures, frequency);

    }

    @Test
    public void addingTravelToUserTest() {
        Assert.assertEquals(this.userModel.getTravels().size(), 1);
    }

    @Test
    public void testValuesTravel() {
        Travel travel = this.userModel
                .getTravels()
                .iterator().next();
        Assert.assertEquals(travel.getFuelCost(), 50);
        Assert.assertEquals(travel.getTollCost(), 20);
        Assert.assertEquals(travel.getNameTravel(), this.travelName);
    }

    @Test
    public void hasOneMoreTravel() {
        Assert.assertEquals(1, this.travelRepository.count());
    }

    private UserModel getUserModel() {
        return this.userModelTestFactory.getUser();
    }

    public void setTravelAdding(TravelAdding travelAdding) {
        this.travelAdding = travelAdding;
    }

    public TravelAdding getTravelAdding() {
        return travelAdding;
    }

    public void setUserModelRepository(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    public UserModelRepository getUserModelRepository() {
        return userModelRepository;
    }

    public void setTravelRepository(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public TravelRepository getTravelRepository() {
        return travelRepository;
    }
}
