package ru.webmarket.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void save (MultipartFile multipartFile, String fileName);
}
