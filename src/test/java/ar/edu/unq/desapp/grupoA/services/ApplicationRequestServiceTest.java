package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;
import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.repositories.ApplicationRequestRepository;
import ar.edu.unq.desapp.grupoA.testUtis.factories.PointTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.TravelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

import static org.junit.Assert.*;

public class ApplicationRequestServiceTest extends AbstractServiceTest {

    public UserModel requester;
    public UserModel owner;
    public Travel travel;
    @Autowired
    private PointTestFactory pointTestFactory;
    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;
    @Autowired
    public ApplicationRequestService service;
    @Autowired
    private TravelTestFactory travelTestFactory;
    public ApplicationRequest request;

    @Autowired
    private UserModelTestFactory userModelTestFactory;

    @Before
    public void setUp() {
        this.requester = this.userModelTestFactory.getUser();
        this.owner = this.userModelTestFactory.getUser();
        this.travel = this.travelTestFactory.getTravel(this.owner);
        Date datetime = new Date(1000);
        Point upPoint = this.pointTestFactory.getPointOne();
        Point downPoint = this.pointTestFactory.getPointTwo();
        request = this.service.createApplicationRequest(requester, travel, datetime, upPoint, downPoint);
    }

    @Test
    public void testCreateRequestCorrectly() {
        assertEquals(request.getRequester(), requester);
        assertEquals(request.getTravel(), travel);
    }

    @Test
    public void testApplicationRequestIsPendingByDefaul() {
        assertTrue(request.isPending());
        assertFalse(request.isApproved());
        assertFalse(request.isRejected());
    }

    @Test
    public void testApplicationRequestIsApproved() {
        ApplicationRequest aprovedRequest = this.service.approveApplicationRequest(request);
        assertTrue(aprovedRequest.isApproved());
        assertFalse(request.isRejected());
        assertFalse(request.isPending());
    }

    @Test(expected = InvalidTransitionException.class)
    public void testApplicationRequestIsApprovedThenRejected() {
        ApplicationRequest aprovedRequest = this.service.approveApplicationRequest(request);
        try {
            this.service.rejectApplicationRequest(aprovedRequest);
        } catch (InvalidTransitionException ite) {
            assertEquals(ite.getMessage(), "can not pass from approved to reject");
            throw ite;
        }
    }

    @Test(expected = InvalidTransitionException.class)
    public void testApplicationRequestIsApprovedThenApproved() {
        ApplicationRequest aprovedRequest = this.service.approveApplicationRequest(request);
        try {
            this.service.approveApplicationRequest(aprovedRequest);
        } catch (InvalidTransitionException ite) {
            assertEquals(ite.getMessage(), "Allready approved");
            throw ite;
        }
    }

    @Test
    public void testApplicationRequestIsReject() {
        ApplicationRequest rejectedRequest = this.service.rejectApplicationRequest(request);
        assertTrue(rejectedRequest.isRejected());
        assertFalse(rejectedRequest.isApproved());
        assertFalse(rejectedRequest.isPending());
    }

    @Test(expected = InvalidTransitionException.class)
    public void testApplicationRequestIsRejectThenApproved() {
        ApplicationRequest rejectedRequest = this.service.rejectApplicationRequest(request);
        try {
            this.service.approveApplicationRequest(rejectedRequest);
        } catch (InvalidTransitionException ite) {

            assertEquals(ite.getMessage(), "can not pass from rejected to approved");
            throw ite;
        }
    }

    @Test(expected = InvalidTransitionException.class)
    public void testApplicationRequestIsRejectThenrejected() {
        ApplicationRequest rejectedRequest = this.service.rejectApplicationRequest(request);
        try {
            this.service.rejectApplicationRequest(rejectedRequest);
        } catch (InvalidTransitionException ite) {

            assertEquals(ite.getMessage(), "Already rejected");
            throw ite;
        }
    }

    @Test
    public void hasOneMoreAppRequest() {
        assertEquals(1, this.applicationRequestRepository.count());
    }

}
