package com.docker.demo.service.imps;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.docker.demo.repository.CloudStorageRepository;
import com.docker.demo.service.CloudServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docker.demo.model.S3Object;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public class AwsServiceImp implements CloudServiceInterface {

    @Autowired
    CloudStorageRepository cloudStorageRepository;

    @Override
    public List<S3Object> listAllFiles() {
        return cloudStorageRepository.listAllFiles();
    }

    @Override
    public Integer saveFileForPerson(MultipartFile file, Long userId) throws IOException {
        return cloudStorageRepository.saveFileForUser(file, userId);
    }
}
