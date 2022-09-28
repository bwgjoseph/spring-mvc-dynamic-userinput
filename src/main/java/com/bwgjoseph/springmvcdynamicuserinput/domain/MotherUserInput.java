package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.annotation.Transient;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferenceFreeText;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class MotherUserInput implements ReferenceFreeText<Person> {
    private String value;
    @Transient
    private Person person;
    private InputType inputType;

    public MotherUserInput(String input, boolean validReference) {
        this.value = input;
        this.inputType = validReference ? InputType.REFERENCE : InputType.FREETEXT;
    }

    public MotherUserInput(String input) {
        this.value = input;
        this.inputType = InputType.FREETEXT;
    }

    public MotherUserInput(Person person) {
        this.value = person.getId();
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
