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

@Ignore
public class AddNewStudentControllerTest {
    private AddNewStudentController controller;
    private Validator validator;
    @Mock
    private StudentService studentService;
    @Mock
    private BindingResult result;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        ValidatorFactory validatorFactory = (ValidatorFactory) buildDefaultValidatorFactory().usingContext().traversableResolver(new DefaultTraversableResolver()).getValidator();
        validator= (Validator) validatorFactory.getValidator();
        controller = new AddNewStudentController(studentService);
    }

    @Test
    public void shouldValidateStudent(){
        Student student = new StudentBuilder();
        controller.onSubmit(student,result);
        verify(validator).validate(student, result);
    }
}
