package com.management.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUploadUtils {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploadUtils.class);

    private String BASE_PATH;

    @Autowired
    Environment env;

    @PostConstruct
    public void init(){
        this.BASE_PATH = env.getProperty("upload.dir");
        LOG.info("FileUploadUtils::init  basepath {}",this.BASE_PATH);
    }
    public void uploadFileToDIR(MultipartFile multipartFile,boolean toDeleted) throws Exception {
    }
    public String uploadFileToDIR(MultipartFile multipartFile) throws Exception {

      if(multipartFile.isEmpty()){
          LOG.info("FileUploadUtils::uploadFileToDIR m { multipart in empty }");
          throw new Exception("MultiPartFile Not found");
      }
      String fileName = multipartFile.getOriginalFilename();
      Path p = Paths.get(this.BASE_PATH + File.separator + fileName);
      byte[] bytes = multipartFile.getBytes();
      try {
         p = Files.write(p, bytes);
         return p.toString();
      }
      catch (IOException ioException){
          LOG.error("FileUploadUtils::uploadFileToDIR  e {}",ioException);
          throw ioException;
      }
      catch (Exception ex){
          LOG.error("FileUploadUtils::uploadFileToDIR  e {}",ex);
          throw ex;
      }
    }
    // read File
    public void readFile(Path path){
        try {
           byte[] bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
