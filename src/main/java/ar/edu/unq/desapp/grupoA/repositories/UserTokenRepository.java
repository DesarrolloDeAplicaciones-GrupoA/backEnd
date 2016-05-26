package ar.edu.unq.desapp.grupoA.repositories;

import ar.edu.unq.desapp.grupoA.models.UserToken;
import ar.edu.unq.desapp.grupoA.repositories.utils.GenericRepository;
import ar.edu.unq.desapp.grupoA.repositories.utils.HibernateGenericDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userTokenRepository")
public class UserTokenRepository extends HibernateGenericDAO<UserToken> implements GenericRepository<UserToken> {

    @Override
    protected Class<UserToken> getDomainClass() {
        return UserToken.class;
    }

    public UserToken findByUserId(int id) {
            Criteria cr = this.getSession().createCriteria(this.getDomainClass());
            cr.add(Restrictions.eq("userModel.id", id));
            return (UserToken) cr.uniqueResult();
    }
}
