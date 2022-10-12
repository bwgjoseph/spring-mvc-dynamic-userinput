package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput.AbstractReferenceUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@NoArgsConstructor
public class FatherUserInput extends AbstractReferenceUserInput<Person> {

    FatherUserInput(String inputValue, InputType inputType, Person person) {
        super(inputValue, inputType, person);
    }

    public static FatherUserInput of(String inputValue, Person person) {
        return new FatherUserInput(inputValue, InputType.REFERENCE, person);
    }

}
