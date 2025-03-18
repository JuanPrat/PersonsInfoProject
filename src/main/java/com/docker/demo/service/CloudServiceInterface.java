package com.docker.demo.service;

import com.docker.demo.model.S3Object;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CloudServiceInterface {
    List<S3Object> listAllFiles();

    Integer saveFileForPerson(MultipartFile file, Long userId) throws IOException;
}
