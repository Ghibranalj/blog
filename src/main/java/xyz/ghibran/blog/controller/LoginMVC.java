package xyz.ghibran.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginMVC
 */
@Controller
public class LoginMVC {

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}