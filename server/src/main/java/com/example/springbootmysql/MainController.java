package com.example.springbootmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // class is a controller
@RequestMapping(path = "/demo") // URL start with demo
public class MainController {

    private UserRepository userRepository;
    @Autowired //repository (bean)
    public MainController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create (@RequestBody User user){
        userRepository.save(user);

        return userRepository.findAll();
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public  List<User> delete (@PathVariable long id){
        userRepository.deleteById(id);

        return userRepository.findAll();
    }
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long id){
        return userRepository.findById(id).get();
    }
}
