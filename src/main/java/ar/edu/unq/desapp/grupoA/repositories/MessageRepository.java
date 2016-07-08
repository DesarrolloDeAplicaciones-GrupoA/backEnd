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


    public List<Message> findAllMyMessagesReceived(UserModel receiver) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("receiver", receiver));
        return (List<Message>) cr.list();
    }

    public List<Message> findAllMyMessagesSended(UserModel sender) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("sender", sender));
        return (List<Message>) cr.list();}

    public List<Message> findAllPublicMessage() {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.eq("isPublic", true));
        return (List<Message>) cr.list();}

    public List<Message> findAllPublicSendedAndReceivedForAUser(UserModel user) {
        Criteria cr = this.getSession().createCriteria(this.getDomainClass());
        cr.add(Restrictions.disjunction()
                .add(Restrictions.eq("sender",user))
                .add(Restrictions.eq("receiver",user)) )
        .add(Restrictions.eq("isPublic", true))  ;
        return (List<Message>) cr.list();}
    }
