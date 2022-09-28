package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface Selection<T extends Enum<T>> extends UserInput {
    T getSelectionValue();

    default boolean getValidInputType() {
        return this.getInputType().equals(InputType.SELECTION);
    }
}
