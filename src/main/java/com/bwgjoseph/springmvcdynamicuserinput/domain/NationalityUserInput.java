package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.mongodb.core.mapping.Field;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.Selection;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class NationalityUserInput implements Selection<Nationality> {
    /**
     * Stores the actual value input by the user, no matter the input type
     */
    private String value;
    /**
     * Map to the respective Enum based on the input value
     */
    @Field("selectionValue")
    private Nationality nationality;
    /**
     * This value should be inferred based on the input
     */
    private InputType inputType;

    /**
     * Private constructor that only called by static method
     *
     * @param inputValue actual input value
     * @param nationality actual enum value
     */
    NationalityUserInput(String inputValue, Nationality nationality) {
        this.value = inputValue;
        this.nationality = nationality;
        this.inputType = nationality.getInferredInputType();
    }

    /**
     * Expose static method to init the class
     *
     * @param inputValue actual input value
     * @return NationalityUserInput instance
     */
    public static NationalityUserInput of(String inputValue) {
        return new NationalityUserInput(inputValue, Nationality.valueOf(inputValue));
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public InputType getInputType() {
        return this.inputType;
    }

    @Override
    public Nationality getSelectionValue() {
        return this.nationality;
    }
}
