package com.userManagement.User_Management.service;

import com.userManagement.User_Management.model.UserTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public void createUser (UserTable user);

    public UserTable findUser (Long userId);

    public List<UserTable> findAll ();
    public UserTable updateUser (UserTable user);

    public void deleteUser (Long userId);
}
