package com.bwgjoseph.springmvcdynamicuserinput.domain;

import java.util.Optional;

import org.springframework.data.annotation.Transient;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferenceFreeText;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class MotherUserInput implements ReferenceFreeText<Person> {
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

    public static MotherUserInput ofReferenceType(String inputValue, Person person) {
        return new MotherUserInput(inputValue, InputType.REFERENCE, person);
    }

    public static MotherUserInput ofFreeTextType(String inputValue) {
        return new MotherUserInput(inputValue, InputType.FREETEXT);
    }

    MotherUserInput(String inputValue, InputType inputType) {
        this.value = inputValue;
        this.inputType = inputType;
        this.referenceValue = null;
        this.collectionName = "";
    }

    MotherUserInput(String inputValue, InputType inputType, Person person) {
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
    public Optional<Person> getReferenceValue() {
        return Optional.ofNullable(this.referenceValue);
    }

    @Override
    public String getCollection() {
        return this.collectionName;
    }

}
