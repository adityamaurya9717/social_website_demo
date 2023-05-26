package com.management.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// controller to send post for user screen

@RestController
@RequestMapping("/feed")
public class FeedController {

    public ResponseEntity<?> showMutualFriends(@RequestParam("userId") Long userId, HttpServletRequest httpServletRequest){
     return null;
    }
}
