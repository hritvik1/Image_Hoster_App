package com.hritvik.ImageHosterApp.controller;

import com.hritvik.ImageHosterApp.model.User;
import com.hritvik.ImageHosterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/login_signup/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login_signup/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login_signup/login")
    public String loginUser(User user, HttpSession session) {
        User existingUser = userService.login(user);
        if(existingUser == null) {
            System.out.println("User Doesn't Exist!!!");
            return "login_signup/login";
        }
        else {
            session.setAttribute("LoggedUser", existingUser);
            System.out.println("User Found!!!");
            return "redirect:/";
        }
    }
}
