package com.management.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {

    public ResponseEntity<?> uploadUserImage(MultipartFile multipartFile,String email) throws Exception;
}
