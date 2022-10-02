package com.bwgjoseph.springmvcdynamicuserinput;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;

import com.bwgjoseph.springmvcdynamicuserinput.domain.FatherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.MotherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.NationalityUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;
import com.bwgjoseph.springmvcdynamicuserinput.domain.PlaceOfBirthUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.dto.PersonDTO;

/**
 * Instead of taking `PersonRepository` in the constructor, can take this into a `@Component`
 * and then inject directly but it wouldn't make too much sense in doing so (tbd)?
 */
public class PersonDTOtoPersonConverter implements Converter<PersonDTO, Person> {
    private final PersonRepository personRepository;

    public PersonDTOtoPersonConverter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person convert(PersonDTO personDTO) {
        return Person.builder()
            .name(personDTO.name())
            .nationality(NationalityUserInput.of(personDTO.nationality()))
            .placeOfBirth(PlaceOfBirthUserInput.of(personDTO.placeOfBirth()))
            .father(this.initFather(personDTO.father()))
            .mother(this.initMother(personDTO.mother()))
            .build();
    }

    private FatherUserInput initFather(String inputValue) {
        Optional<Person> father = this.personRepository.findById(inputValue);

        if (father.isEmpty()) {
            throw new EntityNotFoundException("Given father value of " + inputValue + " is not valid");
        }

        return FatherUserInput.of(inputValue, father.get());
    }

    private MotherUserInput initMother(String inputValue) {
        Optional<Person> mother = this.personRepository.findById(inputValue);

        if (mother.isPresent()) {
            return MotherUserInput.ofReferenceType(inputValue, mother.get());
        }

        return MotherUserInput.ofFreeTextType(inputValue);
    }

}
