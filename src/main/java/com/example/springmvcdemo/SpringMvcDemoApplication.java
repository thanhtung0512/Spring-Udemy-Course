package com.example.springmvcdemo;

import com.example.springmvcdemo.domain.User;


import jakarta.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Controller
public class SpringMvcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcDemoApplication.class, args);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name",required = false,defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";

    }

    @GetMapping("/")
    public String homepage() {
        return "index1";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user",new User());
        return "registerForm";
    }

    @GetMapping("/processRegister")
    public String processRegister(
          @Valid @ModelAttribute("user") User user
           , BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            System.out.println("Has ERRORRRRR");

            return "registerForm";
        }
        else {
            System.out.println(user.getUsername() + " " + user.getEmail() + " " + user.getPassword() + " " + user.getCountry() + " " + user.getFreePasses() );
            return "registerSuccessfully";
        }
    }
}
