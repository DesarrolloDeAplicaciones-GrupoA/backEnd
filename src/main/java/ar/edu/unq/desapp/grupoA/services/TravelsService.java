package ar.edu.unq.desapp.grupoA.services;

import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("travelsService")
public class TravelsService {
    private TravelRepository travelRepository;

    public List<Travel> search(String text) {
        return this.getTravelRepository().findByText(text);
    }

    public TravelRepository getTravelRepository() {
        return travelRepository;
    }

    @Autowired
    public void setTravelRepository(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
}
