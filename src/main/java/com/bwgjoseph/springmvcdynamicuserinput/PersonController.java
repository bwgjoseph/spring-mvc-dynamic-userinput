package com.bwgjoseph.springmvcdynamicuserinput;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;
import com.bwgjoseph.springmvcdynamicuserinput.dto.PersonDTO;

@RestController
public class PersonController {
    private final PersonRepository personRepository;
    private final PersonDTOtoPersonConverter personDTOtoPersonConverter;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.personDTOtoPersonConverter = new PersonDTOtoPersonConverter(personRepository);
    }

    @PostMapping("person")
    public Person create(@RequestBody PersonDTO personDTO) {
        return this.personRepository.insert(this.personDTOtoPersonConverter.convert(personDTO));
    }
}
