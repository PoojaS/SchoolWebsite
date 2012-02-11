package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.*;
import web.service.StudentService;

@Controller
@RequestMapping("/addNewStudent.school")
public class AddNewStudentController {
    private StudentService studentService;

    public AddNewStudentController() {
    }

    @Autowired
    public AddNewStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String addANewStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute(student);
        return "addANewStudent";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("student") Student student) {
        studentService.saveDetails(student);
        return "newStudent";
    }
}