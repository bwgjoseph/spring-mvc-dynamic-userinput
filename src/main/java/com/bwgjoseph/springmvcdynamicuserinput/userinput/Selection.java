package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface Selection<T extends Enum<T>> extends UserInput {
    T getSelectionValue();
}
