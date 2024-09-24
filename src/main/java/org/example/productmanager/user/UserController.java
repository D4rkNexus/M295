package org.example.productmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("repository2")
    public List<UserData> getAllUsers() {
        return userRepository.findAll();
        }

    @PostMapping()
    public UserData createUser(@RequestBody UserData user) {
        return userRepository.save(user);
            }
        }
