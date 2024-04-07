package pl.event.manager.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.event.manager.entity.User;
import pl.event.manager.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User newUser){
      return userService.saveUser(newUser);

    }
    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser (@PathVariable long id){
        return userService.deleteUserById(id);
    }
}
