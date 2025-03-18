package com.docker.demo.controller;

import com.docker.demo.dto.PersonDto;
import com.docker.demo.model.Person;
import com.docker.demo.repository.PersonRepository;
import com.docker.demo.service.PersonService;
import com.docker.demo.service.imps.PersonsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    @Autowired
    PersonService personsService;

//    public PersonsController(PersonsServiceImp personsService){
//        this.personsService = personsService;
//    }

    @GetMapping
    ResponseEntity<Object> listPerson(@RequestParam Long id){
        if(id == null){
            return createHttpResponse("Id can't be null", HttpStatus.BAD_REQUEST);
        }
        PersonDto personResult = personsService.findPersonById(id);
        if(personResult.notEmpty()){
            return createHttpResponse(personResult, HttpStatus.OK);
        }
        else {
            return createHttpResponse("There's no such id within the DataBase", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    ResponseEntity<Object> savePerson(@RequestBody Person person){
        if(person == null){
            return createHttpResponse("Person object can't be null", HttpStatus.BAD_REQUEST);
        }
        PersonDto created = personsService.savePerson(person);
        return createHttpResponse(created, HttpStatus.OK);
    }

    @GetMapping("/fetchAll")
    ResponseEntity<Object> fetchAllPersons(){
        List<PersonDto> allPersonsFound = personsService.findAllPersons();
        return createHttpResponse(allPersonsFound, HttpStatus.OK);
    }

    public ResponseEntity<Object> createHttpResponse(Object message, HttpStatus httpStatus){
        return new ResponseEntity<>(message, httpStatus);
    }
}
