package org.example.productmanager.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "UserController", description = "Controller für Benutzerverwaltung")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Auflisten aller User
    @GetMapping("/list")
    @Operation(summary = "Listet alle User auf", operationId = "getAllUsers", description = "Gibt eine Liste aller Benutzer zurück.")
    public List<UserData> getAllUsers() {
        return userService.getAllUsers();
    }

    // Neuen Benutzer erstellen
    @PostMapping("/create")
    @Operation(summary = "Erstellt einen neuen User", operationId = "createUser", description = "Erstellt einen neuen Benutzer basierend auf den bereitgestellten Informationen.")
    public UserData createUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.createUser(productCreateDto);
    }

    // Benutzer authentifizieren
    @PostMapping("/authenticate")
    @Operation(summary = "Benutzer authentifizieren", operationId = "authenticateUser", description = "Authentifiziert einen Benutzer basierend auf den bereitgestellten Anmeldedaten.")
    public String authenticateUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.authenticateUser(productCreateDto.getUsername(), productCreateDto.getPassword());
    }

    // Neuen Benutzer registrieren
    @PostMapping("/register")
    @Operation(summary = "Einen neuen Benutzer erstellen", operationId = "registerUser", description = "Registriert einen neuen Benutzer basierend auf den bereitgestellten Informationen.")
    public UserData registerUser(@RequestBody ProductCreateDto productCreateDto) {
        return userService.registerUser(productCreateDto);
    }

    // Benutzer zum Administrator befördern
    @PutMapping("/admin/promote/{id}")
    @Operation(summary = "Benutzer zum Administrator befördern", operationId = "promoteUserToAdmin", description = "Befördert einen Benutzer mit der angegebenen ID zum Administrator.")
    public String promoteUserToAdmin(@PathVariable Long id) {
        userService.promoteUserToAdmin(id);
        return "Benutzer wurde zum Administrator befördert.";
    }

    // Initiale Daten in die Datenbank seeden
    @PostMapping("/admin/seed-database")
    @Operation(summary = "Initiale Daten in die Datenbank seeden", operationId = "seedDatabase", description = "Befüllt die Datenbank initial mit vorgegebenen Daten.")
    public String seedDatabase() {
        userService.seedDatabase();
        return "Datenbank wurde initial befüllt.";
    }
}