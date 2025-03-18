package com.docker.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Persons")
@Entity
public class Person {
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @NumberFormat
    private Integer age;
    @NumberFormat
    private Double height;
    @NumberFormat
    private Double weight;
}
