package com.bwgjoseph.springmvcdynamicuserinput;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @PostMapping("person")
    public Person create(@RequestBody Person person) {
        return this.personRepository.insert(person);
    }
}
