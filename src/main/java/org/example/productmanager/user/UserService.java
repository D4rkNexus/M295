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
}
