package com.management.service.impl;

import com.management.jpa.entity.UserEntity;
import com.management.jpa.entity.UserFriendsEntity;
import com.management.jpa.repo.UserFriendsReposiory;
import com.management.jpa.repo.UserRepository;
import com.management.model.request.UserModelRequest;
import com.management.mongodocument.user.UserAddress;
import com.management.mongodocument.user.UserModel;
import com.management.mongorepo.UserModelRepo;
import com.management.request.AddFriendRequest;
import com.management.request.AddUserRequest;
import com.management.service.UserService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserFriendsReposiory userFriendsReposiory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserModelRepo  userModelRepo;

    @Override
    public ResponseEntity<?> createAccount(AddUserRequest request) {
        try {
            UserEntity userEntity = new UserEntity(request);
            userEntity = userRepository.save(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
        }
        catch (DataIntegrityViolationException integrityViolationException){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("email Already Present");
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body("Something Wrong happend");

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> addFriendRequest(AddFriendRequest request) {
     Integer count = userRepository.isUserExists(Arrays.asList(request.getUserId(), request.getFriendUserId()));
     if(count< 2){
         return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Friend User id not exists ");
     }
     UserFriendsEntity userFriendsEntity = new UserFriendsEntity(request.getUserId(), request.getFriendUserId());
     userFriendsEntity = userFriendsReposiory.save(userFriendsEntity);
     return ResponseEntity.ok(userFriendsEntity);
    }

    @Override
    public ResponseEntity<?> updateFriendRequest(AddFriendRequest request) {
        Integer count = userRepository.isUserExists(Arrays.asList(request.getUserId(), request.getFriendUserId()));
        if(count< 2){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Friend User id not exists ");
        }
        int result = userFriendsReposiory.updateFriendRequest(request.getUserId(),request.getFriendUserId());
         return ResponseEntity.status(HttpStatus.OK).body("SuccessFully accepted friend request");
    }

    @Override
    public void addUser(UserModelRequest request) {

        UserAddress address = new UserAddress();
        address.setCountry("India");
        address.setState("Delhi");
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(request,userModel);

       // userModel  = mongoTemplate.save(userModel);
        userModelRepo.save(userModel);
        System.out.println(userModel);
    }
}
