package net.prose.demo_3_1_2.controller;

import net.prose.demo_3_1_2.model.User;
import net.prose.demo_3_1_2.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImp  userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userServiceImp.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user_create")
    public String createUserForm(User user){
        return "user_create";
    }
    @PostMapping("/user_create")
    public String createUser(User user){
        userServiceImp.saveUser(user);
        return "redirect:/users ";
    }

    @GetMapping ("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userServiceImp.deleteUser(id);
        return "redirect:/users ";
    }

    @GetMapping("/user_update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userServiceImp.getUser(id);
        model.addAttribute("user", user);
        return "user_update";
    }
    @PostMapping("/user_update")
    public String updateUser(User user){
        userServiceImp.saveUser(user);
        return "redirect:/users ";
    }

}
