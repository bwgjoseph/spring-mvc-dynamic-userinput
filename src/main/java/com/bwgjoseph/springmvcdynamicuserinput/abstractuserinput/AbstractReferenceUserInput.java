package com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput;

import java.util.Optional;

import org.springframework.data.annotation.Transient;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferentialRecord;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Base class for Selection And SelectionFreeText User Input
 * <p>
 * Accept a generic type <b>S</b> that of a bounded parameter {@link ReferentialRecord}
 */
@ToString
@NoArgsConstructor
public abstract class AbstractReferenceUserInput<R extends ReferentialRecord> implements UserInput  {
    /**
     * Stores the actual value input by the user, no matter the input type
     */
    protected String value;
    /**
     * Map to the respective ReferenceEntity based on the input value
     */
    @Transient
    @JsonIgnore
    protected R referenceValue;
    /**
     * This value should be inferred based on the input
     */
    protected InputType inputType;
    /**
     * The collection of the reference value
     */
    protected String collection;

    protected AbstractReferenceUserInput(String inputValue, InputType inputType) {
        this.value = inputValue;
        this.inputType = inputType;
        this.referenceValue = null;
        this.collection = "";
    }

    protected AbstractReferenceUserInput(String inputValue, InputType inputType, R person) {
        this.value = inputValue;
        this.inputType = inputType;
        this.referenceValue = person;
        this.collection = person.getCollection();
    }

    /**
     * Get referenceValue
     *
     * @return R reference entity
     */
    public Optional<R> getReferenceValue() {
        return Optional.ofNullable(this.referenceValue);
    }

    /**
     * Get InputType
     *
     * @return InputType
     */
    @Override
    public InputType getInputType() {
        return this.inputType;
    }

    /**
     * Get inputValue
     *
     * @return String user input value
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * Get Reference Collection Name
     *
     * @return collection name of reference entity
     */
    public String getCollection() {
        return this.collection;
    }
}
