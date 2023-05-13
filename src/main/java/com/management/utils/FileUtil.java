package com.management.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public static boolean isFile(File file){
        LOG.info("FileUtil::isFile m{} is a file",file.toPath());
        return file.isFile();
    }
    public static boolean isFile(Path path){
        File file = path.toFile();
        LOG.info("FileUtil::isFile m{} is a file",file.toPath());
        return file.isFile();
    }

    public static Path copyFile( byte[] bytes,Path destination) throws Exception {
        try {
            Path path  = Files.write(destination,bytes);
            LOG.info("FileUtil::copyFile successfully copy the data into location {}  ",path.toUri());
            return path;
        } catch (IOException e) {
            LOG.info("FileUtil::copyFile e{} ",e.getMessage());
            throw new IOException(e);
        } catch (Exception ex){
            LOG.info("FileUtil::copyFile e{} ",ex.getMessage());
            throw new Exception(ex);
        }
    }
    public static void deleteFile(Path path) throws IOException {
          Files.delete(path);
    }




}
