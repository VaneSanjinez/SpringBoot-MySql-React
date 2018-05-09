package com.example.springbootmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // class is a controller
@RequestMapping(path = "/demo") // URL start with demo
public class MainController {
    @Autowired //repository (bean)
    private UserRepository userRepository;

    @GetMapping(path = "/add") //Map get Request

    public @ResponseBody String addNewUser(@RequestParam String name , @RequestParam Integer age){
        User n = new User();
        n.setName(name);
        n.setAge(age);

        userRepository.save(n);
        return "saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
