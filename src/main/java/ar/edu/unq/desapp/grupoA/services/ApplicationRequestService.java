package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import org.joda.time.DateTime;

public class ApplicationRequestService {


    public ApplicationRequest createApplicationRequest(UserModel user, Travel travel, DateTime dateTime, Point upPoint, Point downpoint) {

        ApplicationRequest request = new ApplicationRequest(user, travel, dateTime, upPoint, downpoint);
        user.addRequestedApplications(request);
        travel.addApplicationRequest(request);
        return request;

    }

    public ApplicationRequest approveApplicationRequest(ApplicationRequest request) {
        request.approve();
        return request;
    }

    public ApplicationRequest rejectApplicationRequest(ApplicationRequest request) {
        request.reject();
        return request;
    }
}
