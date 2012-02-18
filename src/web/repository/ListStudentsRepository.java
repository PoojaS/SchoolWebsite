package web.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Student;
import java.util.List;

@Repository
public class ListStudentsRepository {

    private SessionFactory sessionFactory;

    public ListStudentsRepository() {
    }

    @Autowired
    public ListStudentsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Student.class);
        return (List<Student>) criteria.list();
    }
}
