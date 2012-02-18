package web.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Administrator;

import java.util.List;

@Repository
public class AdministratorRepository {

    SessionFactory sessionFactory;

    public AdministratorRepository() {
    }

    @Autowired
    public AdministratorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Administrator getAdminFor(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Administrator.class);
        criteria.add(Restrictions.eq("userName",userName));
        List list = criteria.list();
        return (Administrator) list.get(0);
    }
}
