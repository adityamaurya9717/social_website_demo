package com.management.service;

import com.management.model.request.UserModelRequest;
import com.management.request.AddFriendRequest;
import com.management.request.AddUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    public ResponseEntity<?> createAccount(AddUserRequest request);

    public ResponseEntity<?> addFriendRequest(AddFriendRequest request);

    public ResponseEntity<?> updateFriendRequest(AddFriendRequest request);

    public void addUser(UserModelRequest request);
}
