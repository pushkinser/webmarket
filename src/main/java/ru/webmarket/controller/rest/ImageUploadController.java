package ru.webmarket.controller.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.webmarket.service.impl.FileServiceImpl;

@RestController
@RequestMapping(value = "/api/upload")
@Secured({"ROLE_ADMIN", "ROLE_SELLER"})
public class ImageUploadController {

    private FileServiceImpl fileService = new FileServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addProduct(@RequestPart("file") MultipartFile file,
                           @RequestParam("id") String id) {
        fileService.save(file, id);
    }

}