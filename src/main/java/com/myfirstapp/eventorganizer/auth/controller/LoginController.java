package com.myfirstapp.eventorganizer.auth.controller;

import com.myfirstapp.eventorganizer.auth.model.User;
import com.myfirstapp.eventorganizer.auth.service.SecurityService;
import com.myfirstapp.eventorganizer.auth.service.UserService;
import com.myfirstapp.eventorganizer.auth.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/", "/login"})
    public String loginPage(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Username or password id invalid");
        }
        if(logout != null) {
            model.addAttribute("message", "Successfully logged out");
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPage(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/main";
    }
}
