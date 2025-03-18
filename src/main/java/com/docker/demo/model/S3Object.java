package com.docker.demo.model;

import lombok.Builder;
import lombok.Value;

import java.net.URL;

@Value
@Builder
public class S3Object {
    String name;
    String key;
    URL url;
}
