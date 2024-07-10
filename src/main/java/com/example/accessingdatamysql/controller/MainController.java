package com.example.accessingdatamysql.controller;


import com.example.accessingdatamysql.domain.HelloMember;
import com.example.accessingdatamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/demo")
public class MainController {


    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email){
        HelloMember n = new HelloMember(name, email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    @ResponseBody
    public Iterable<HelloMember> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}
