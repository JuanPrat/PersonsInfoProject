package com.docker.demo.dto;

import com.docker.demo.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    Long id;
    String name;
    String lastName;
    String address;
    Integer age;
    Double height;
    Double weight;

    public boolean notEmpty(){
        return id != null;
    }
}


