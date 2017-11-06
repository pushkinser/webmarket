package ru.webmarket.service.impl;

import org.springframework.web.multipart.MultipartFile;
import ru.webmarket.service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService {

    private static final String UPLOADED_FOLDER = "C:/Projects/webmarket/src/main/webapp/WEB-INF/images/product/";

    @Override
    public void save(MultipartFile file, String fileName) {

        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(UPLOADED_FOLDER + fileName + ".jpg");

        try {
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
