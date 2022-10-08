package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface SelectionFreeText<T extends Enum<T>> extends UserInput {
    T getSelectionValue();
}
