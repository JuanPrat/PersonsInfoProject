package com.docker.demo.service.imps;

import com.docker.demo.dto.PersonDto;
import com.docker.demo.mappers.PersonMapper;
import com.docker.demo.model.Person;
import com.docker.demo.repository.PersonRepository;
import com.docker.demo.service.PersonService;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImp implements PersonService {
    @Autowired
    private PersonRepository personRepository;


    public PersonDto savePerson(Person person){
       Person personCreated = personRepository.save(person);
//       return personMapper().toPersonDto(personCreated);
        return this.createPersonDto(personCreated);
    }

    public PersonDto findPersonById(Long id){
        Optional<Person> personOpt = personRepository.findById(id);
        Person personFound = personOpt.orElseGet(this::emptyPerson);
//        return personMapper().toPersonDto(personFound);
        return this.createPersonDto(personFound);
    }

    private PersonMapper personMapper() {
        return PersonMapper.INSTANCE;
    }

    private Person emptyPerson() {
        return new Person();
    }

    public List<PersonDto> findAllPersons(){
        List<Person> personsFound = personRepository.findAll();
        return personsFound.stream().map(this::createPersonDto).toList();
//                .map(person -> personMapper().toPersonDto(person)).toList();
    }

    private PersonDto createPersonDto(Person person) {
        return new PersonDto(person.getId(), person.getName(), person.getLastName(),
                person.getAddress(), person.getAge(), person.getHeight(), person.getWeight());
    }
}
