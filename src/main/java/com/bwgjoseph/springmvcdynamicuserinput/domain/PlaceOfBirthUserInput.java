package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput.AbstractSelectionUserInput;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class PlaceOfBirthUserInput extends AbstractSelectionUserInput<Country> {
    PlaceOfBirthUserInput(String inputValue, Country country) {
        super(inputValue, country);
    }

    public static PlaceOfBirthUserInput of(String inputValue) {
        try {
            return new PlaceOfBirthUserInput(inputValue, Country.valueOf(inputValue));
        } catch (IllegalArgumentException e) {
            return new PlaceOfBirthUserInput(inputValue, Country.valueOf("OTHERS"));
        }
    }

}
