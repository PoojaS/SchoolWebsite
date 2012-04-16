package web.controller;


import org.hibernate.validator.engine.resolver.DefaultTraversableResolver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import web.Builders.StudentBuilder;
import web.model.Student;
import web.service.StudentService;

import javax.validation.ValidatorFactory;

import static javax.validation.Validation.buildDefaultValidatorFactory;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddNewStudentControllerTest {
    private AddNewStudentController controller;
    @Mock
    StudentService service;
    @Mock
    private BindingResult result;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new AddNewStudentController(service);
    }

    @Test
    public void shouldSaveStudentDetails() {
        Student student = new StudentBuilder().withDefaults().build();
        controller.onSubmit(student,result);

        verify(service).saveDetails(student);
    }
}
