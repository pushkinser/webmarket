package ru.webmarket.controller.rest;


import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/api/upload")
@Secured({"ROLE_ADMIN", "ROLE_SELLER"})
public class ImageUploadController {

    private static final String UPLOADED_FOLDER = "C:/Projects/webmarket/src/main/webapp/WEB-INF/images/product/";

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addProduct(@RequestPart("file") MultipartFile file,
                           @RequestParam("id") String id) {
        saveUploadedFiles(file, id);
    }

    private void saveUploadedFiles(MultipartFile file, String id) {
//      String newName = new String();
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(UPLOADED_FOLDER + id + ".jpg");

        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
