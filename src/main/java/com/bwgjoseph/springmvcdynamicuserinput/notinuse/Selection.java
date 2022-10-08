package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface Selection<T extends Enum<T>> extends UserInput {
    T getSelectionValue();
}
