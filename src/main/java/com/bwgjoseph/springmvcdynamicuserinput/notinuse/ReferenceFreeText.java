package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import java.util.Optional;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferenceEntity;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

public interface ReferenceFreeText<T extends ReferenceEntity> extends UserInput  {
    Optional<T> getReferenceValue();
    String getCollection();
}
