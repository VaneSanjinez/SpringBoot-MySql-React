package com.example.springbootmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "/user/{id}")
    public Optional<User> getSingleUser(@PathVariable Integer id){
        //return userRepository.findById(Long.valueOf(id)).get();
        return  userRepository.findById(id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody Iterable<User> deleteUser(@PathVariable("id") Integer id){
        userRepository.deleteById(id);

        return userRepository.findAll();
    }

}
