package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.SelectionFreeText;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class PlaceOfBirthUserInput implements SelectionFreeText<Country> {
    /**
     * Stores the actual value input by the user, no matter the input type
     */
    private String value;
    /**
     * Stores the selection value
     */
    private Country selectionValue;
    /**
     * InputType is inferred based on the value
     * *may not work for reference since it requires external call to validate
     *
     * How to ensure the inputType is within the constraint of `getValidInputType`?
     */
    private InputType inputType;

    public static PlaceOfBirthUserInput of(String inputValue) {
        try {
            return new PlaceOfBirthUserInput(inputValue, Country.valueOf(inputValue));
        } catch (IllegalArgumentException e) {
            return new PlaceOfBirthUserInput(inputValue, Country.valueOf("OTHERS"));
        }
    }

    /**
     * Client should not pass `OTHERS` if it is selected, instead, they should pass the `freetext` value
     * *what if client pass OTHERS instead of the actual text?
     *
     * try/catch in constructor may not also be the best
     * an alternative would be creating `@JsonComponent` to validate and init the object,
     * otherwise, throw an serialize/deserialize exception upfront
     *
     * @param input input value
     */
    public PlaceOfBirthUserInput(String input, Country country) {
        this.value = input;
        this.selectionValue = country;
        this.inputType = country.getInferredInputType();
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
    public Country getSelectionValue() {
        return this.selectionValue;
    }

}
