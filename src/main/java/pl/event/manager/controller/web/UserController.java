package pl.event.manager.controller.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.event.manager.entity.User;
import pl.event.manager.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getRegister() {
        return "register";
    }

    @PostMapping()
    public String registerUser(@RequestBody User userToRegister) {
       userService.saveUser(userToRegister);
       return "redirect:/";
    }

}
