package com.management.service.impl;

import com.management.exception.GlobalControllerExceptionHandler;
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
import com.management.response.UserFriendsResponse;
import com.management.service.UserService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

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
            LOG.info("UserServiceImpl::createAccount  m {}",request.toString());
            UserEntity userEntity = new UserEntity(request);
            userEntity = userRepository.save(userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
        }
        catch (DataIntegrityViolationException integrityViolationException){
           LOG.error("UserServiceImpl::createAccount  e{}",integrityViolationException.getMessage());
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
    @Transactional
    public ResponseEntity<?> userALLFriends(String email) {
       UserEntity userEntity  = userRepository.findByEmailAndActiveTrue(email);
       if( ObjectUtils.isEmpty(userEntity) ){
           return ResponseEntity.notFound().build();
       }
       List<Long> friendsUserIds = userFriendsReposiory.getUserFriendsIds(userEntity.getId());
       List<UserFriendsResponse> userFriendsResponses = new ArrayList<>();
       if( ObjectUtils.isEmpty(friendsUserIds) ){
          return ResponseEntity.ok(userFriendsResponses);
       }
       List<UserEntity> userEntities   = userRepository.findByIdIn(friendsUserIds);
       userEntities.forEach(data->{
           UserFriendsResponse friendsResponse = new UserFriendsResponse();
           BeanUtils.copyProperties(data,friendsResponse);
           userFriendsResponses.add(friendsResponse);
       });
       return ResponseEntity.ok(userFriendsResponses);
    }


    // accepte friend request
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
