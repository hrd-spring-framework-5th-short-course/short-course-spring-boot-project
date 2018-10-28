package com.example.demopojo.controllers;

import com.example.demopojo.models.User;
import com.example.demopojo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

//@Component
@Controller
public class UserController {

    private UserService userService;

    //    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/all")
    public String getAll(ModelMap modelMap) {
        List<User> users = userService.getAll();

        modelMap.addAttribute("userList", users);
        modelMap.addAttribute("userList1", users);

        return "index";
    }


    @GetMapping("/users/one/{user_id}")
    public String getOne(@PathVariable("user_id") Integer id, ModelMap modelMap) {

        User user = userService.getOne(id);

        modelMap.addAttribute("user", user);

        return "view-user";
    }


    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }


    @PostMapping("/users/add/submit")
    public String submitUser(@Valid User user, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {

            System.out.println("Error occur!");
            return "add-user";
        }


        System.out.println(user);

        this.userService.save(user);

        return "redirect:/users/all";

    }


    @GetMapping("/users/update/{id}")
    public String showUpdateUserForm(@PathVariable("id") Integer id, Model model) {

        User user = this.userService.getOne(id);

        model.addAttribute("user", user);

        return "update-user";
    }


    @GetMapping("/users/update/submit")
    public String updateUserSubmit(User user) {
        this.userService.update(user);

        return "redirect:/users/all";
    }

    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        this.userService.delete(id);

        return "redirect:/users/all";
    }


}
