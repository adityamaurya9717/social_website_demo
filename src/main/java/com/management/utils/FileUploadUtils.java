package com.management.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileUploadUtils {

    private String BASE_PATH;

    @Autowired
    Environment env;

    @PostConstruct
    public void init(){
        this.BASE_PATH = env.getProperty("upload.dir");
        System.out.println("======"+this.BASE_PATH );

    }
    public void uploadFileToDIR(MultipartFile multipartFile,boolean toDeleted) throws Exception {
    }
    private void uploadFileToDIR(MultipartFile multipartFile) throws Exception {

      if(multipartFile.isEmpty()){
          throw new Exception("MultiPartFile Not found");
      }
      String fileName = multipartFile.getOriginalFilename();
      Path p = Paths.get(this.BASE_PATH + File.separator + fileName);
      byte[] bytes = multipartFile.getBytes();
      try {
         p = Files.write(p, bytes);
      }
      catch (IOException ioException){
          throw ioException;
      }
      catch (Exception ex){
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
