package com.userManagement.User_Management.service;

import com.userManagement.User_Management.model.UserTable;
import com.userManagement.User_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

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
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
