package com.management.service.impl;

import com.management.jpa.entity.UserFriendsEntity;
import com.management.jpa.repo.UserFriendsReposiory;
import com.management.jpa.repo.UserPostRepository;
import com.management.jpa.repo.UserRepository;
import com.management.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    private static final Logger LOG = LoggerFactory.getLogger(FeedServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserPostRepository userPostRepository;

    @Autowired
    UserFriendsReposiory userFriendsReposiory;

    @Override
    public ResponseEntity<?> getMutualsFriends(Long userId, HttpServletRequest httpServletRequest) {
        List<Long> userFriendUserIds  = userFriendsReposiory.getUserFriendsIds(userId);

        Pageable pageable = PageRequest.of(0,50, Sort.by(Sort.Direction.DESC,"createdAt"));
        List<UserFriendsEntity> userMutuallyFriends  = userFriendsReposiory.findByIdIn(userFriendUserIds,pageable);
        return null;
    }
}
