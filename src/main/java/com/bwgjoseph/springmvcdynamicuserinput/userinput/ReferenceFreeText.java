package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface ReferenceFreeText<T> extends UserInput  {
    T getReferenceValue();
    String getCollection();

    default boolean getValidInputType() {
        return this.getInputType().equals(InputType.REFERENCE) || this.getInputType().equals(InputType.FREETEXT);
    }
}
