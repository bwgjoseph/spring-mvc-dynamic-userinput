package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface SelectionFreeText<T extends Enum<T>> extends UserInput {
    T getSelectionValue();
}
