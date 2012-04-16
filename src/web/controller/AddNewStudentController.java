package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Student;
import web.service.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/addNewStudent.school")
public class AddNewStudentController {
    private StudentService studentService;

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
    public String onSubmit(@Valid @ModelAttribute("student") Student student, Model model) {
        studentService.saveDetails(student);
        model.addAttribute(student);
        return "newStudent";
    }
}