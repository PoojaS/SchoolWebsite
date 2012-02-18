package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.ListStudentsService;
import web.service.ListStudentsServiceImpl;

@Controller
public class ListStudentsController {

    ListStudentsService studentsService;

    @Autowired
    public ListStudentsController(ListStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @RequestMapping("/listStudents.school")
    public String viewListOfStudents(Model model){

        model.addAttribute("students", studentsService.getListOfStudents());
        return "studentList";

    }
}
