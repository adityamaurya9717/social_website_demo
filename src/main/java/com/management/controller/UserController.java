package com.management.controller;

import com.management.model.request.UserModelRequest;
import com.management.request.AddFriendRequest;
import com.management.request.AddUserRequest;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("create-user")
    public ResponseEntity<?> createAccount(@RequestBody AddUserRequest request){
        return userService.createAccount(request);
    }

    @PostMapping("friend-request")
    public ResponseEntity<?> addFriendRequest(@RequestBody AddFriendRequest request){
     return null;
    }

    @PostMapping("add-user")
    public ResponseEntity<?> addUser(@RequestBody UserModelRequest request){
          userService.addUser(request);
          return null;

    }
}
