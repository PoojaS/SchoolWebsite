package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Administrator;
import web.service.AdministratorService;

@Controller
public class LoginController {

    private AdministratorService administratorService;

    @Autowired
    public LoginController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/loginPage.school")
       public String login(ModelMap model){
        Administrator administrator = new Administrator();
        model.addAttribute(administrator);
        return "loginPage" ;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/login.school")
    public String login(@ModelAttribute("administrator")Administrator administrator){

        if(administratorService.isValidCredentials(administrator))
          return "homePage";
        return null;
    }
}
