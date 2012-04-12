package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Student;

@Controller
public class DeleteStudent {


    @RequestMapping(value = "/deleteStudent.school" ,method = RequestMethod.POST)
    public String deleteSelectedStudent(@ModelAttribute Student student) {
        Student student1 = student;
        return null;
    }
}
