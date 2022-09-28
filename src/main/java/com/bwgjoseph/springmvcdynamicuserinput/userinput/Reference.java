package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface Reference<T> extends UserInput  {
    T getReferenceValue();
    String getCollection();

    default boolean getValidInputType() {
        return this.getInputType().equals(InputType.REFERENCE);
    }
}
