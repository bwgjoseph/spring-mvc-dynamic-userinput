package com.bwgjoseph.springmvcdynamicuserinput.userinput;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A placeholder interface to identify referential entity,
 * used to constraint the upper bound of `Reference` and `ReferenceFreeText` generic type
 */
@FunctionalInterface
public interface ReferentialRecord {
    @JsonIgnore
    String getCollection();
}
