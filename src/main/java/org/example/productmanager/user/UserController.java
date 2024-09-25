package org.example.productmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("repository2")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
        }

    @PostMapping()
    public UserData createUser(@RequestBody UserData user) {
        return userService.createUser(user);
            }
        }
