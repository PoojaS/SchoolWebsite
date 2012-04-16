package web.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import web.Builders.StudentBuilder;
import web.model.Student;
import web.service.StudentService;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddNewStudentControllerTest {
    private AddNewStudentController controller;
    @Mock
    StudentService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        controller = new AddNewStudentController(service);
    }

    @Test
    public void shouldSaveStudentDetails() {
        Student student = new StudentBuilder().withDefaults().build();
        controller.onSubmit(student, null);

        verify(service).saveDetails(student);
    }
}
