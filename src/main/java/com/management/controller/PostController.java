package com.management.controller;

import com.management.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/create-post")
    public ResponseEntity<?> post(@RequestParam("file") MultipartFile file, @RequestParam("data") String data, HttpServletRequest httpServletRequest) throws Exception {
        return postService.createPost(file,httpServletRequest);
    }

    @GetMapping("/get-posts-by-email")
    public ResponseEntity<?> getPostByEmail(@RequestParam("email") String email){
        return postService.findPostByEmail(email);
    }
    @GetMapping("/post-likes")
    public ResponseEntity<?> postLike(@RequestParam("postId") Long postId,@RequestParam("email") String email){
       return postService.postLike(postId,email);
    }

}
