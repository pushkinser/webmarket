package ru.webmarket.controller.rest;


import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.webmarket.controller.rest.requestBody.ImageItemBodyJson;

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
    public void addProduct(@RequestPart MultipartFile file) {
        saveUploadedFiles(file);
    }

    private void saveUploadedFiles(MultipartFile file) {
//      String newName = new String();
        byte[] bytes = new byte[0];

        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
