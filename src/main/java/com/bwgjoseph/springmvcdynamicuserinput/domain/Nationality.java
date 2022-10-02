package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InferredInputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

/**
 * Selection ONLY
 */
public enum Nationality implements InferredInputType {
    SINGAPOREAN("Singaporean"),
    MALAYSIAN("Malaysian");

    private String value;

    Nationality(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public InputType getInferredInputType() {
        return InputType.SELECTION;
    }
}