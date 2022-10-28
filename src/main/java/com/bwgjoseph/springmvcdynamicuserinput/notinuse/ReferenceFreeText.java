package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import java.util.Optional;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferentialRecord;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface ReferenceFreeText<T extends ReferentialRecord> extends UserInput  {
    Optional<T> getReferenceValue();
    String getCollection();
}
