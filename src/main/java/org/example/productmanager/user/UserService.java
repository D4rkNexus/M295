package org.example.productmanager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    public UserData createUser(UserData user) {
        return userRepository.save(userMapper.toEntity(user));
    }

    public UserData getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDetailDto)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public UserData updateUser(Long id, UserData updatedUser) {
        UserData existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        userMapper.update(updatedUser, existingUser);
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String authenticateUser(String username, String password) {
        // Authentifizierung logik
        return "dummy-jwt-token"; // Platzhalter
    }

    public UserData registerUser(UserData user) {
        // Benutzerregistrierung logik
        return userRepository.save(userMapper.toEntity(user));
    }

    public void promoteUserToAdmin(Long id) {
        UserData user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        user.setRole("ADMIN");
        userRepository.save(user);
    }

    public void seedDatabase() {
        // Logik zur Initialbefüllung der Datenbank mit Daten
    }
}