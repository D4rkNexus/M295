package org.example.productmanager.user;

import org.example.productmanager.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserData> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::ProductDetailDto)
                .collect(Collectors.toList()).reversed();
    }

    public UserData createUser(ProductCreateDto productCreateDto) {
        UserData user = userMapper.ProductCreateDto(productCreateDto);
        return userMapper.ProductDetailDto(userRepository.save(user));
    }

    public UserData getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::ProductShowDto)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public UserData updateUser(Long id, ProductUpdateDto productUpdateDto) {
        UserData existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        userMapper.ProductUpdateDto(productUpdateDto, existingUser);
        return userMapper.ProductDetailDto(userRepository.save(existingUser));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public String authenticateUser(String username, String password) {
        // Beispiel-Funktion, tatsächlich würde dies eine echte Authentifizierung erfordern
        Optional<UserData> user = userRepository.findByUsernameAndPassword(username, password);

        if (user.isPresent()) {
            return "dummy-jwt-token"; // Platzhalter für einen echten JWT-Token
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public UserData registerUser(ProductCreateDto productCreateDto) {
        UserData user = userMapper.ProductCreateDto(productCreateDto);
        return userMapper.ProductDetailDto(userRepository.save(user));
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