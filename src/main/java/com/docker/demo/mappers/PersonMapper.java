package com.docker.demo.mappers;

import com.docker.demo.dto.PersonDto;
import com.docker.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDto toPersonDto(Person person);

    Person toPerson(PersonDto personDto);

}
