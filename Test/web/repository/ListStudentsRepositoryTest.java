package web.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.Builders.StudentBuilder;
import web.model.Student;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ListStudentsRepositoryTest {

    private ListStudentsRepository repository;
    @Mock
    private SessionFactory sessionFactory;
    @Mock
    private Criteria criteria;
    @Mock
    private Session session;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        repository = new ListStudentsRepository(sessionFactory);
    }

    @Test
    public void shouldGetAListOfStudents(){
        Student student1 = new StudentBuilder().withDefaults().build();
        Student student2 = new StudentBuilder().withDefaults().withFirstName("Punya").build();
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(Student.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(asList(student1,student2));

        List<Student> students = repository.getStudents();

        assertThat(students,hasItems(student1,student2));

        verify(sessionFactory).getCurrentSession();
        verify(session).createCriteria(Student.class);
        verify(criteria).list();
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(sessionFactory);
        verifyNoMoreInteractions(session);
        verifyNoMoreInteractions(criteria);
    }
}
