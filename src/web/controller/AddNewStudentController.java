package web.controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/addNewStudent.school")
public class AddNewStudentController {


    private Student student;

    @Autowired
    public AddNewStudentController(Student student) {
        this.student = student;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String addANewStudent(ModelMap model) {

        model.addAttribute("student", student);
        return "addANewStudent";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveANewStudent(){
        return "";
    }

}
