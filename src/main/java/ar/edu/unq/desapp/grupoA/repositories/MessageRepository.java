package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.Message;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository("messageRepository")
public class MessageRepository extends HibernateGenericDAO<Message> implements GenericRepository<Message> {

    private static final long serialVersionUID = -4036535812105655532L;

    @Override
    protected Class<Message> getDomainClass() {
        return Message.class;
    }


    public Set<Message> findMessagesReceived(UserModel receiver) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("receiver", receiver));
        return (Set<Message>) cr.list();
    }

    public Set<Message> findMessagesSended(UserModel sender) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("sender", sender));
        return (Set<Message>) cr.list();}

    public List<Message> findPublicMessage() {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("isPublic", true));
        return (List<Message>) cr.list();}
    }
