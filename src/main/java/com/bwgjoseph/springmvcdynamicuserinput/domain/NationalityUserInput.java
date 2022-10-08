package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput.AbstractSelectionUserInput;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class NationalityUserInput extends AbstractSelectionUserInput<Nationality> {
    /**
     * Private constructor that only called by static method
     *
     * @param inputValue actual input value
     * @param nationality actual enum value
     */
    NationalityUserInput(String inputValue, Nationality nationality) {
        super(inputValue, nationality);
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

}
