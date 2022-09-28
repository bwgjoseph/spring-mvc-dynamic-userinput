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
    private Country country;
    /**
     * InputType is inferred based on the value
     * *may not work for reference since it requires external call to validate
     *
     * How to ensure the inputType is within the constraint of `getValidInputType`?
     */
    private InputType inputType;

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
    public PlaceOfBirthUserInput(String input) {
        this.value = input;
        // if we can't cast it to the enum we expect,
        // then we can infer that this is a `freetext` rather than a `selection`
        try {
            this.country = Country.valueOf(input);
            this.inputType = InputType.SELECTION;
        } catch (IllegalArgumentException e) {
            this.country = Country.valueOf("OTHERS");
            this.inputType = InputType.FREETEXT;
        }
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
        return this.country;
    }

}
