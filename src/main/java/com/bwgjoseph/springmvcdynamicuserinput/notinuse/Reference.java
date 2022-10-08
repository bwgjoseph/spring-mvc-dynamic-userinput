package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferenceEntity;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface Reference<T extends ReferenceEntity> extends UserInput  {
    T getReferenceValue();
    String getCollection();
}
