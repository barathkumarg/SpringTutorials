package com.learn.SpringBootApplication.Controller;

import com.learn.SpringBootApplication.service.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    //Logging object
    private Logger logger = LoggerFactory.getLogger(getClass());

    //Authentication
    @Autowired
    private Authentication authentication;

    //Login controller to render the login  jsp file -->  get method
    @RequestMapping(value="login",method = RequestMethod.GET)
    public String logincontrollerget()
    {
        return "login";
    }

    //Post logic to collect the data from the form
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String logincontrollerpost(@RequestParam String name, String password,ModelMap map){

        if (authentication.authenticate(name,password)){
            map.put("name", name);
            map.put("password",password);
            return "index";
        }
        map.put("message","error occured");
        return "login";

    }
}
