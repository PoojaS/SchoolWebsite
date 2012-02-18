package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.*;
import web.service.StudentService;
import web.validators.StudentValidator;

@Controller
@RequestMapping("/addNewStudent.school")
public class AddNewStudentController {
    private StudentService studentService;
    private StudentValidator studentValidator;

    public AddNewStudentController(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }

    @Autowired
    public AddNewStudentController(StudentService studentService, StudentValidator studentValidator) {
        this.studentService = studentService;
        this.studentValidator = studentValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String addANewStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute(student);
        return "addANewStudent";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("student") Student student,Errors errors) {
        studentValidator.validate(student,errors);
        if(errors.hasErrors())
            return "addANewStudent";
        studentService.saveDetails(student);
        return "newStudent";
    }
}