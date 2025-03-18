package com.docker.demo.service;

import com.docker.demo.dto.PersonDto;
import com.docker.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    PersonDto savePerson(Person person);

    PersonDto findPersonById(Long id);

    List<PersonDto> findAllPersons();
}
