package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InferredInputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

/**
 * Selection + FreeText
 */
public enum Country implements InferredInputType {
    SINGAPORE,
    MALAYSIA,
    OTHERS {
        @Override
        public InputType getInferredInputType() {
            return InputType.FREETEXT;
        }
    };

    @Override
    public InputType getInferredInputType() {
        return InputType.SELECTION;
    }
}
