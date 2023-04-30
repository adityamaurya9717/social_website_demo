package com.management.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    public void uploadFileToDIR(){


    }
}
