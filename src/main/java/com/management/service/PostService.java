package com.management.service;

import com.management.mongodocument.user.UserPostModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface PostService {

    ResponseEntity<?> createPost(MultipartFile file, HttpServletRequest httpServletRequest) throws Exception;

    public ResponseEntity<?> findPostByEmail(String email);

    ResponseEntity<?> postLike(Long postId, String email);
}
