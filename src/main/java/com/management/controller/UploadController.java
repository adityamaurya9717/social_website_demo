package com.management.controller;


import com.management.utils.FileUploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("upload")
public class UploadController {
    private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);
    public ResponseEntity<?> uploadUserImage(@RequestParam("file") MultipartFile multipartFile,
                                              @Email(message = "invalid email format") @RequestParam("email") String email){

        return null;
    }


}
