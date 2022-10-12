package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput.AbstractReferenceUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class MotherUserInput extends AbstractReferenceUserInput<Person> {

    MotherUserInput(String inputValue, InputType inputType) {
        super(inputValue, inputType);
    }

    MotherUserInput(String inputValue, InputType inputType, Person person) {
        super(inputValue, inputType, person);
    }

    public static MotherUserInput ofReferenceType(String inputValue, Person person) {
        return new MotherUserInput(inputValue, InputType.REFERENCE, person);
    }

    public static MotherUserInput ofFreeTextType(String inputValue) {
        return new MotherUserInput(inputValue, InputType.FREETEXT);
    }

}
