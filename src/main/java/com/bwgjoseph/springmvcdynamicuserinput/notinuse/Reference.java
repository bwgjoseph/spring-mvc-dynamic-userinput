package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferentialRecord;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface Reference<T extends ReferentialRecord> extends UserInput  {
    T getReferenceValue();
    String getCollection();
}
