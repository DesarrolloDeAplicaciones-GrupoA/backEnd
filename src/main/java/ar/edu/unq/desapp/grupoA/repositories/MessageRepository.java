package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.springframework.stereotype.Repository;

@Repository("messageRepository")
public class MessageRepository extends HibernateGenericDAO<Message> implements GenericRepository<Message> {

    private static final long serialVersionUID = -4036535812105655532L;

    @Override
    protected Class<Message> getDomainClass() {
        return Message.class;
    }
}
