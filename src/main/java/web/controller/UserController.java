package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService usersDao;

    @Autowired
    public UserController(UserService usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping()
    public String printAllUsers(ModelMap model) {
        model.addAttribute("list", usersDao.getUsers());
        return "users";
    }

    @RequestMapping("user_info")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user_info";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        usersDao.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user_info/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", usersDao.getUser(id));
        return "user_info";
    }

    @RequestMapping("delete_user/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id) {
        usersDao.deleteUser(id);
        return "redirect:/users";
    }


}

