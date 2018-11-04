package com.example.demopojo.restcontrollers;

import com.example.demopojo.models.User;
import com.example.demopojo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
//@ResponseBody both two equal to @RestController

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getUser() {
        return userService.getAll();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return this.userService.save(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Integer id) {
        return this.userService.delete(id);
    }
}
