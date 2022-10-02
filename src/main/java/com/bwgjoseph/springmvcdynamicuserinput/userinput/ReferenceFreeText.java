package com.bwgjoseph.springmvcdynamicuserinput.userinput;

import java.util.Optional;

public interface ReferenceFreeText<T extends ReferenceEntity> extends UserInput  {
    Optional<T> getReferenceValue();
    String getCollection();
}
