package com.bwgjoseph.springmvcdynamicuserinput.domain;

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
     * Stores the selection value
     */
    private Nationality nationality;
    /**
     * InputType is inferred based on the value
     * *may not work for reference since it requires external call to validate
     *
     * How to ensure the inputType is within the constraint of `getValidInputType`?
     */
    private InputType inputType;

    /**
     *
     * @param input
     */
    public NationalityUserInput(String input) {
        this.nationality = Nationality.valueOf(input);
        this.inputType = InputType.SELECTION;
        this.value = input;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Nationality getSelectionValue() {
        return this.nationality;
    }

    @Override
    public InputType getInputType() {
        return this.inputType;
    }
}
