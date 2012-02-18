package web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import web.model.Student;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;


@Component
public class StudentValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Student.class);
    }

    public void validate(Object target, Errors errors) {
        rejectIfEmptyOrWhitespace(errors, "firstName", "firstname.empty");
        rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.empty");
        rejectIfEmptyOrWhitespace(errors, "standard", "class.empty");
    }
}
