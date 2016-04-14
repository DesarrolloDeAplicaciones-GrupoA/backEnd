package ar.edu.unq.desapp.grupoA.services;


import ar.edu.unq.desapp.grupoA.exceptions.InvalidTransitionException;
import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.testUtis.factories.TravelTestFactory;
import ar.edu.unq.desapp.grupoA.testUtis.factories.UserModelTestFactory;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ApplicationRequestServiceTest {

    public UserModel requester;
    public Travel travel;
    public ApplicationRequestService service;
    public ApplicationRequest request;

    @Before
    public void setUp() {
        this.requester = new UserModelTestFactory().getUser();
        this.travel = new TravelTestFactory().getTravelTest();
        this.service = new ApplicationRequestService();
        DateTime datetime = DateTime.now();
        Point upPoint = mock(Point.class);
        Point downPoint = mock(Point.class);
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

}
