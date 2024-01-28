package com.learn.SpringBootApplication.Controller;

import com.learn.SpringBootApplication.service.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("name")
@Controller
public class LoginController {
    //Logging object
    private Logger logger = LoggerFactory.getLogger(getClass());

    //Authentication
    @Autowired
    private Authentication authentication;

    //Login controller to render the login  jsp file -->  get method
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String logincontrollerget(ModelMap map)
    {
        map.put("name",getloggedinUser());
        return "welcome";
    }

    // Logic to get the username from the spring security
    private String getloggedinUser(){
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
