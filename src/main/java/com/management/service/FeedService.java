package com.management.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface FeedService {

    public ResponseEntity<?> getMutualsFriends(Long userId, HttpServletRequest httpServletRequest);
}
