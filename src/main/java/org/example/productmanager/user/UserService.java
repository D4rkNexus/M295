package org.example.productmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    public UserData createUser(UserData user) {
        return userRepository.save(user);
    }

    public String authenticateUser(String username, String password) {
        // Authentifizierung logik
        // Rückgabe eines JWT-Tokens nach erfolgreicher Authentifizierung
        return "dummy-jwt-token"; // Platzhalter
    }

    public UserData registerUser(UserData user) {
        // Benutzerregistrierung logik
        return userRepository.save(user);
    }

    public void promoteUserToAdmin(Long id) {
        // Logic zur Beförderung eines Benutzers zum Admin
        UserData user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Benutzer nicht gefunden"));
        user.setRole("ADMIN"); // Annahme: Benutzer haben Rollen und die Rolle "ADMIN" existiert
        userRepository.save(user);
    }

    public void seedDatabase() {
        // Logik zur Initialbefüllung der Datenbank mit Daten
    }
}