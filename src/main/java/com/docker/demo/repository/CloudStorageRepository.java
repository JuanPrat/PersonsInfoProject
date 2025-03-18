package com.docker.demo.repository;

import java.io.IOException;
import java.util.List;
import com.docker.demo.model.S3Object;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface CloudStorageRepository {

    List<S3Object> listAllFiles();

    Integer saveFileForUser(MultipartFile file, Long userId) throws IOException;
}
