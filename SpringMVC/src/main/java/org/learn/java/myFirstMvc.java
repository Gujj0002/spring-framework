package org.learn.java;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class myFirstMvc {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("message", "Welcome to Spring Web MVC!!.....");
        return "mvc-view-template";
    }
}
