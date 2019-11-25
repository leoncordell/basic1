package com.simple.basicbootswaginmem.controllers;

import com.simple.basicbootswaginmem.db.User;
import com.simple.basicbootswaginmem.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User user(Long  id) {
        return userRepository.getOne(id);
    }

    @PostMapping(value="/user")
    public User createEmployee(@Valid @RequestBody User user) {
        return  userRepository.save(user);

    }

    @GetMapping (value="/users")
    public List<User> users() {
        return  userRepository.findAll();
    }





}
