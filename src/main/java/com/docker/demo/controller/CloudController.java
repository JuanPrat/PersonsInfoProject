package com.docker.demo.controller;

import com.docker.demo.model.S3Object;
import com.docker.demo.service.CloudServiceInterface;
import com.docker.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cloud")
public class CloudController {

    @Autowired
    CloudServiceInterface cloudService;

    @Autowired
    PersonService personService;

    @PostMapping("/saveUserFile")
    public Integer saveFileFor(@RequestParam("file") MultipartFile file, @RequestParam("personId") Long personId) throws IOException {
        return cloudService.saveFileForPerson(file, personId);
    }

    @GetMapping("/listAllFiles")
    public List<S3Object> getAllS3Files(){
        return cloudService.listAllFiles();
    }
}
