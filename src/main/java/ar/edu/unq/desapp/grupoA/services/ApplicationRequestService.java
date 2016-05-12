package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.ApplicationRequest;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.models.utils.Point;
import ar.edu.unq.desapp.grupoA.repositories.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("applicationRequestService")
public class ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    public ApplicationRequest createApplicationRequest(UserModel user, Travel travel, Date dateTime, Point upPoint, Point downpoint) {

        ApplicationRequest request = new ApplicationRequest(user, travel, dateTime, upPoint, downpoint);

        user.addRequestedApplications(request);
        travel.addApplicationRequest(request);
        this.applicationRequestRepository.save(request);
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
