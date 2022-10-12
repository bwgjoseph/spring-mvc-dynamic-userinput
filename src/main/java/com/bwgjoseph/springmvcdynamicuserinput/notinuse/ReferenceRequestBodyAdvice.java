package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.bwgjoseph.springmvcdynamicuserinput.EntityNotFoundException;
import com.bwgjoseph.springmvcdynamicuserinput.PersonRepository;
import com.bwgjoseph.springmvcdynamicuserinput.domain.MotherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;

import lombok.RequiredArgsConstructor;

// @RestControllerAdvice
@RequiredArgsConstructor
public class ReferenceRequestBodyAdvice implements RequestBodyAdvice {
    private final PersonRepository personRepository;

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        if (body instanceof Person person && person.getFather() != null) {
            String inputValue = person.getFather().getValue();
            Optional<Person> father = this.personRepository.findById(inputValue);

            if (father.isEmpty()) {
                throw new EntityNotFoundException("Given father value of " + inputValue + " is not valid");
            }
        }

        if (body instanceof Person person && person.getMother() != null) {
            String inputValue = person.getMother().getValue();
            Optional<Person> mother = this.personRepository.findById(inputValue);

            if (mother.isPresent()) {
                return person.toBuilder().mother(MotherUserInput.ofReferenceType(inputValue, mother.get())).build();
            }
        }

        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        // supports everything first
        return true;
    }

}
