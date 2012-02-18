package web.validators;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.validation.Errors;
import web.Builders.StudentBuilder;
import web.model.Student;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@Ignore
public class StudentValidatorTest {

    StudentValidator studentValidator;
    private Student student;
    @Mock
    private Errors errors;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        studentValidator = new StudentValidator();
        student = new StudentBuilder().withFirstName("");
    }

    @Test
    public void shouldSupportStudentInstanceValidation(){
      assertThat(studentValidator.supports(Student.class),is(true));
    }

    @Test
    public void shouldValidateFieldsNotEmpty(){
     studentValidator.validate(student,errors);
     assertThat(errors.getErrorCount(), is(3));
     assertThat(errors.hasErrors(),is(true));
    }
}
