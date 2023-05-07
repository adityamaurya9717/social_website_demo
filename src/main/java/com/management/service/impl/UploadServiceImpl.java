package com.management.service.impl;

import com.management.controller.UploadController;
import com.management.jpa.entity.UserEntity;
import com.management.jpa.repo.UserRepository;
import com.management.service.UploadService;
import com.management.utils.FileUploadUtils;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger LOG = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileUploadUtils fileUploadUtils;

    @Override
    @Transactional
    public ResponseEntity<?> uploadUserImage(MultipartFile multipartFile, String email) throws Exception {
        if(multipartFile.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("image cannot be empty");
        }
       UserEntity userEntity = userRepository.findByEmailAndActiveTrue(email);
       if(ObjectUtils.isEmpty(userEntity)){
           return ResponseEntity.notFound().build();
       }
       String path  =  fileUploadUtils.uploadFileToDIR(multipartFile);
       userEntity.setImageUrl(path);
       userEntity = userRepository.save(userEntity);
       return ResponseEntity.ok("image uploaded successfully");
    }
}
