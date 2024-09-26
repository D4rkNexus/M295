package org.example.productmanager.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.dto.*;
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
    // Auflisten aller User
    @GetMapping("/list")
    @Operation(summary = "Listet alle User auf")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    @Operation(summary = "Erstellt einen neuen User")
    public UserData createUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.createUser(productCreateDto);
    }

    // Benutzer authentifizieren (POST /users/authenticate)
    @PostMapping("/authenticate")
    @Operation(summary = "Benutzer authentifizieren")
    public String authenticateUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.authenticateUser(productCreateDto.getUsername(), productCreateDto.getPassword());
    }

    // Neuen Benutzer registrieren (POST /users/register)
    @PostMapping("/register")
    @Operation(summary = "Einen neuen Benuzer erstellen")
    public UserData registerUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.registerUser(productCreateDto);
    }

    // Benutzer zum Administrator befördern (PUT /admin/promote/{id})
    @PutMapping("/admin/promote/{id}")
    @Operation(summary = "Benutzer zum Adminstrator befördern")
    public String promoteUserToAdmin(@PathVariable Long id) {
        userService.promoteUserToAdmin(id);
        return "Benutzer wurde zum Administrator befördert.";
    }

    // Initiale Daten in die Datenbank seeden (POST /admin/seed-database)
    @PostMapping("/admin/seed-database")
    @Operation(summary = "Initiale Daten in die Datenbank seeden")
    public String seedDatabase() {
        userService.seedDatabase();
        return "Datenbank wurde initial befüllt.";
    }
}