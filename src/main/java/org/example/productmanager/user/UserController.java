package org.example.productmanager.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.productmanager.products.dto.ProductShowDto;
import org.example.productmanager.user.dto.LoginRequestDto;
import org.example.productmanager.products.dto.ProductCreateDto;
import org.example.productmanager.user.dto.RegisterDto;
import org.example.productmanager.user.security.TokenWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "UserController", description = "Controller für Benutzerverwaltung")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Benutzer authentifizieren", operationId = "authenticateUser", description = "Authentifiziert einen Benutzer basierend auf den bereitgestellten Anmeldedaten.")
    public String authenticateUser(@RequestBody LoginRequestDto loginRequestDto) {
        // Optional<UserData> entpacken
        UserData user = userService.getUserWithCredentials(loginRequestDto)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        // Token generieren
        return tokenService.generateToken(user);
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
    public UserData createUser(@RequestBody LoginRequestDto userCreateDto) {
        ProductCreateDto LoginRequestDto = null;
        return userService.createUser(LoginRequestDto);
    }

    // Neuen Benutzer registrieren
    @PostMapping("/register")
    @Operation(summary = "Registriert einen neuen Benutzer", operationId = "registerUser", description = "Registriert einen neuen Benutzer basierend auf den bereitgestellten Informationen.")
    public UserData registerUser(@RequestBody RegisterDto userCreateDto) {
        return userService.registerUser(userCreateDto);
    }

    // Benutzer zum Administrator befördern
    @PutMapping("/admin/promote/{id}")
    @Operation(summary = "Befördert einen Benutzer zum Administrator", operationId = "promoteUserToAdmin", description = "Befördert einen Benutzer mit der angegebenen ID zum Administrator.")
    public String promoteUserToAdmin(@PathVariable Long id) {
        userService.promoteUserToAdmin(id);
        return "Benutzer wurde zum Administrator befördert.";
    }

    // Initiale Daten in die Datenbank seeden
    @PostMapping("/admin/seed-database")
    @Operation(summary = "Seeden der initialen Datenbank", operationId = "seedDatabase", description = "Befüllt die Datenbank initial mit vorgegebenen Daten.")
    public String seedDatabase() {
        userService.seedDatabase();
        return "Datenbank wurde initial befüllt.";

    }
}


