package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Route;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("travelAdding")
public class TravelAdding {

    @Autowired
    private TravelRepository travelRepository;

    @Transactional
    public Travel createTravel(UserModel user, String nameTravel, int fuel, int toll, Route route, Interval rangeHours, List<Integer> frequency) {
        Travel travel = new Travel(nameTravel, fuel, toll, route, rangeHours, frequency);
        travel.setUserModel(user);
        user.addTravel(travel);
        this.travelRepository.save(travel);
        return travel;
    }

    public void setRepository(TravelRepository repository) {
        this.travelRepository = repository;
    }

    public TravelRepository getRepository() {
        return travelRepository;
    }
}
