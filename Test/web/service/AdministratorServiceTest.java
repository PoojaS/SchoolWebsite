package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.Builders.AdministratorBuilder;
import web.model.Administrator;
import web.repository.AdministratorRepository;

import javax.swing.table.TableStringConverter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AdministratorServiceTest {

    AdministratorService service;
    @Mock
    AdministratorRepository repository;

    Administrator administrator;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        service = new AdministratorServiceImpl(repository);
        administrator = new AdministratorBuilder().withDefaults();
    }

    @Test
    public void shouldReturnTrueForValidAdministrator() {

        Administrator expectedAdmin = new AdministratorBuilder().withDefaults();
        when(repository.getAdminFor(administrator.getUserName())).thenReturn(expectedAdmin);
        boolean isValid = service.isValidCredentials(administrator);
        assertThat(isValid, is(true));
        verify(repository).getAdminFor(administrator.getUserName());

    }

    @Test
    public void shouldReturnFalseForInvalidAdministrator() {

        Administrator expectedAdmin = new AdministratorBuilder().withDefaults().withPassword("wrong password");
        when(repository.getAdminFor(administrator.getUserName())).thenReturn(expectedAdmin);
        boolean isValid = service.isValidCredentials(administrator);
        assertThat(isValid, is(false));
        verify(repository).getAdminFor(administrator.getUserName());

    }

    @Test
    public void shouldReturnFalseIfUserDoesNotExist(){

        Administrator invalidAdmin = new AdministratorBuilder().withDefaults().withUserName("invalid");
        when(repository.getAdminFor(invalidAdmin.getUserName())).thenReturn(null);
        assertThat(service.isValidCredentials(invalidAdmin),is(false));
        verify(repository).getAdminFor(invalidAdmin.getUserName());

    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(repository);
    }
}