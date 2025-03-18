package com.docker.demo.repository.imps;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.docker.demo.repository.CloudStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.docker.demo.model.S3Object;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AwsS3CloudStorageImp implements CloudStorageRepository {

    private AmazonS3 s3Client;
    private Integer CREATED = 1;
    private Integer NOT_CREATED = -1;

    @Autowired
    public AwsS3CloudStorageImp(AmazonS3 amazonS3){
        this.s3Client = amazonS3;
    }

    @Override
    public List<S3Object> listAllFiles() {
        return s3Client.listObjectsV2("bucket-proyecto-prueba-docker")
                .getObjectSummaries().stream().parallel().map(S3ObjectSummary::getKey)
                .map(key -> mapS3ToObject("bucket-proyecto-prueba-docker", key))
                .collect(Collectors.toList());
    }

    @Override
    public Integer saveFileForUser(MultipartFile file, Long userId) throws IOException {
        PutObjectRequest putObjectRequest = new PutObjectRequest("bucket-proyecto-prueba-docker/"+userId, file.getName(), file.getInputStream(), null);
        PutObjectResult pushResult = s3Client.putObject(putObjectRequest);
        return pushResult.getETag() != null ? CREATED : NOT_CREATED;
    }

    private S3Object mapS3ToObject(String bucket, String key) {

        return S3Object.builder()
                .name(s3Client.getObjectMetadata(bucket, key).getUserMetaDataOf("name"))
                .key(key)
                .url(s3Client.getUrl(bucket, key))
                .build();
    }
}
