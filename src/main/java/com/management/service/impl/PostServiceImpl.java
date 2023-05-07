package com.management.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.jpa.entity.UserPostEntity;
import com.management.jpa.repo.UserPostRepository;
import com.management.mongodocument.user.PostLikeModel;
import com.management.mongodocument.user.UserPostModel;
import com.management.mongorepo.UserPostModelRepo;
import com.management.request.CreatePostRequest;
import com.management.service.PostService;
import com.management.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    UserPostRepository userPostRepository;
    @Autowired
    UserPostModelRepo userPostModelRepo;

    @Autowired
    FileUploadUtils  fileUploadUtils;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<?> createPost(MultipartFile file, HttpServletRequest httpServletRequest) throws Exception {
     //  String fileName =  fileUploadUtils.uploadFileToDIR(file);
        String requestPayload  = httpServletRequest.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePostRequest postRequest = null;
        try {
           Map<String,Object> map  =  objectMapper.readValue(requestPayload,new TypeReference<Map<String, Object>>() {});
           postRequest = new CreatePostRequest(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // saved in mysql
        UserPostEntity userPostEntity = new UserPostEntity(postRequest);
        userPostEntity = userPostRepository.save(userPostEntity);
        //saving in mongo db

        UserPostModel userPostModel = new UserPostModel(userPostEntity);
        userPostModel = userPostModelRepo.save(userPostModel);
       return ResponseEntity.ok("Successfully created Posts");
    }

    @Override
    public ResponseEntity<?> findPostByEmail(String email){
        Query query = new Query();
        query.addCriteria( Criteria.where("userEmail").is(email));
        List<UserPostModel> userPostModelList  = mongoTemplate.find(query,UserPostModel.class);
        for (UserPostModel userPostModel : userPostModelList){
            userPostModel.getPostLikeModelList();
        }
        userPostModelList =userPostModelRepo.findAll();
        return ResponseEntity.ok(userPostModelList);
    }

    @Override
    public ResponseEntity<?> postLike(Long postId, String email) {
        PostLikeModel postLikeModel = new PostLikeModel();
        postLikeModel.setPostId(postId);
        postLikeModel.setLikeEmail(email);
        postLikeModel = mongoTemplate.insert(postLikeModel);
        return ResponseEntity.ok(postLikeModel) ;
    }
}
