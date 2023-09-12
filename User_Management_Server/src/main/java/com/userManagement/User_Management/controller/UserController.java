package com.userManagement.User_Management.controller;

import com.userManagement.User_Management.model.UserTable;
import com.userManagement.User_Management.service.UserServiceImp;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/user/")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @PostMapping("createUser")
    public ResponseEntity<String> CreateUser(@RequestBody UserTable user){
        userService.createUser(user);
        return ResponseEntity.ok("User Created");
    }

    @GetMapping("getUser/{userID}")
    public ResponseEntity<UserTable> GetUser(@PathVariable Long userID){
        return ResponseEntity.ok(userService.findUser(userID));
    }

    @GetMapping("{userId}")
    public boolean CheckUser (@PathVariable Long userId){
        return this.userService.checkUser(userId);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<UserTable>> GetAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PutMapping("updateUser")
    public ResponseEntity<UserTable> UpdateUser(@RequestBody UserTable user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("deleteUser/{userID}")
    public ResponseEntity<String> DeleteUser(@PathVariable Long userID){
        userService.deleteUser(userID);
        return ResponseEntity.ok("User was deleted");
    }
}
