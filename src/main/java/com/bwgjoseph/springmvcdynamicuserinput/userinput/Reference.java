package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface Reference<T extends ReferenceEntity> extends UserInput  {
    T getReferenceValue();
    String getCollection();
}
