package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.annotation.Transient;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.Reference;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class FatherUserInput implements Reference<Person> {
    private String value;
    @Transient
    private Person person;
    private InputType inputType;

    public FatherUserInput(String input) {
        this.value = input;
        this.inputType = InputType.REFERENCE;
    }

    @Override
    public InputType getInputType() {
        return this.inputType;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Person getReferenceValue() {
        return this.person;
    }

    @Override
    public String getCollection() {
        return "person";
    }

}
