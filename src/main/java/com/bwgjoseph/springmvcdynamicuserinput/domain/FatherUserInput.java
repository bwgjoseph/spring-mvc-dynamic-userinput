package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.annotation.Transient;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.Reference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class FatherUserInput implements Reference<Person> {
    /**
     * Stores the actual value input by the user, no matter the input type
     */
    private String value;
    /**
     * Map to the respective ReferenceEntity based on the input value
     */
    @Transient
    private Person referenceValue;
    /**
     * This value should be inferred based on the input
     */
    private InputType inputType;
    /**
     * The collection of the reference value
     *
     */
    private String collectionName;

    public static FatherUserInput of(String inputValue, Person person) {
        return new FatherUserInput(inputValue, InputType.REFERENCE, person);
    }

    FatherUserInput(String inputValue, InputType inputType, Person person) {
        this.value = inputValue;
        this.inputType = inputType;
        this.referenceValue = person;
        this.collectionName = person.getCollectionName();
    }


    @Override
    public InputType getInputType() {
        return this.inputType;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonIgnore
    @Override
    public Person getReferenceValue() {
        return this.referenceValue;
    }

    @Override
    public String getCollection() {
        return this.collectionName;
    }

}
