package com.userManagement.User_Management.service;

import com.userManagement.User_Management.model.UserTable;
import com.userManagement.User_Management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    private final WebClient webClient;

    @Override
    public void createUser(UserTable user) {
        userRepository.save(user);
    }

    @Override
    public UserTable findUser(Long userId) {
        UserTable user = new UserTable();
        return userRepository.findById(userId).orElse(user);
    }

    @Override
    public boolean checkUser(Long userId) {
        return this.userRepository.existsById(userId);
    }

    @Override
    public List<UserTable> findAll (){
        return userRepository.findAll();
    }

    @Override
    public UserTable updateUser(UserTable user) {
        if (userRepository.existsById(user.getUserID())){
            return userRepository.save(user);
        }
        else{
            UserTable nullUser = new UserTable();
            return nullUser;
        }
    }

    @Override
    public String deleteUser(Long userId) {

        userRepository.deleteById(userId);
        return " User "+userId + " was deleted. " +
                this.webClient.delete()
                .uri("http://localhost:8081/api/order/deleteUser/{userId}",  userId)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
