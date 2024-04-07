package pl.event.manager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.event.manager.entity.Event;
import pl.event.manager.entity.User;
import pl.event.manager.service.EventService;
import pl.event.manager.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final EventService eventService;

    public UserController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }


    @GetMapping("register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("register")
    public String registerUser(@RequestBody User userToRegister) {
       userService.saveUser(userToRegister);
       return "redirect:/";
    }
    @PostMapping("logged")
    public String getLoginPage(Model model) {
        List<Event> events = eventService.getFutureEvents();
        model.addAttribute("events", events);
        return "logged";
    }
}
