package com.bwgjoseph.springmvcdynamicuserinput.userinput;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A placeholder interface to identify referential entity,
 * used to constraint the upper bound of `Reference` and `ReferenceFreeText` generic type
 */
public interface ReferenceEntity {
    @JsonIgnore
    String getCollection();
}
