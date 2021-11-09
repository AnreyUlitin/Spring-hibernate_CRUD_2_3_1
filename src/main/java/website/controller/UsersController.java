package website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import website.model.User;
import website.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PutMapping ("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println("before");
        userService.updateUser(user);
        return "redirect:/users";
    }
}










