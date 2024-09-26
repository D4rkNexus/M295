package org.example.productmanager.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "UserController", description = "")
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

    @PostMapping
    public UserData createUser(@RequestBody UserData user) {
        return userService.createUser(user);
    }

    // Benutzer authentifizieren (POST /users/authenticate)
    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody UserData loginData) {
        return userService.authenticateUser(loginData.getUsername(), loginData.getPassword());
    }

    // Neuen Benutzer registrieren (POST /users/register)
    @PostMapping("/register")
    public UserData registerUser(@RequestBody UserData user) {
        return userService.registerUser(user);
    }

    // Benutzer zum Administrator befördern (PUT /admin/promote/{id})
    @PutMapping("/admin/promote/{id}")
    public String promoteUserToAdmin(@PathVariable Long id) {
        userService.promoteUserToAdmin(id);
        return "Benutzer wurde zum Administrator befördert.";
    }

    // Initiale Daten in die Datenbank seeden (POST /admin/seed-database)
    @PostMapping("/admin/seed-database")
    public String seedDatabase() {
        userService.seedDatabase();
        return "Datenbank wurde initial befüllt.";
    }
}