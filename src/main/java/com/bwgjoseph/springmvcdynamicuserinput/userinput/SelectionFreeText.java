package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface SelectionFreeText<T extends Enum<T>> extends UserInput {
    T getSelectionValue();

    // how can we use this to restrict/validate each implementing class
    // to not violate the acceptable inputType?
    default boolean getValidInputType() {
        return this.getInputType().equals(InputType.SELECTION) || this.getInputType().equals(InputType.FREETEXT);
    }
}
