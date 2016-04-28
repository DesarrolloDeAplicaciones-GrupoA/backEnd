package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Vehicle;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;

public class VehicleRepository extends HibernateGenericDAO<Vehicle> implements GenericRepository<Vehicle> {

    private static final long serialVersionUID = -4036535812105672220L;

    @Override
    protected Class<Vehicle> getDomainClass() {
        return Vehicle.class;
    }
}
