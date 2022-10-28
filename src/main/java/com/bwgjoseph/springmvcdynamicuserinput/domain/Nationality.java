package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InferableSelection;

/**
 * Selection ONLY
 */
public enum Nationality implements InferableSelection {
    SINGAPOREAN("Singaporean"),
    MALAYSIAN("Malaysian");

    private String value;

    Nationality(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}