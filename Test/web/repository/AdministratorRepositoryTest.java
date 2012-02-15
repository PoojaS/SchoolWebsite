package web.repository;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.Builders.AdministratorBuilder;
import web.model.Administrator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AdministratorRepositoryTest {

    AdministratorRepository administratorRepository;
    @Mock
    SessionFactory sessionFactory;
    @Mock
    private Session session;
    private Administrator administrator;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        administratorRepository = new AdministratorRepository(sessionFactory);
        administrator = new AdministratorBuilder().withDefaults();
    }

    @Test
    public void shouldReturnTrueIfValidAdmin() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Administrator administratorResult = new AdministratorBuilder();
        when(session.load("userName", administratorResult)).thenReturn(administrator);

        assertThat(administratorRepository.getAdminFor(administrator.getUserName()), is(administrator));
    }
}
