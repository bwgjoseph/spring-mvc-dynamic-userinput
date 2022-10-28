package com.bwgjoseph.springmvcdynamicuserinput.userinput;

/**
 * Implementing class must declare the correct InputType
 * <p>
 * For Selection/SelectionFreeText, it should be implemented in the `enum` class
 */
public interface InferableSelection {
    default InputType getInferredInputType() {
        return InputType.SELECTION;
    }
}
