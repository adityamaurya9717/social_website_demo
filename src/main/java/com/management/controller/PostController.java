package com.management.controller;
import com.management.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // like post of some user
    @PostMapping("/post-likes")
    public ResponseEntity<?> postLike(@RequestParam("postId") Long postId,@RequestParam("email") String email){
       return postService.postLike(postId,email);
    }
   // api to comment on Post >  postId, email address who is comment and comment detail
    public ResponseEntity<?> postComment(Long postId,String email,String description){
     return null;
    }

}
