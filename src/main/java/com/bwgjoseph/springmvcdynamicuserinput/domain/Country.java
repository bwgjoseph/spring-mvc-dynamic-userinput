package com.bwgjoseph.springmvcdynamicuserinput.domain;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InferableSelection;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

/**
 * Selection + FreeText
 */
public enum Country implements InferableSelection {
    SINGAPORE,
    MALAYSIA,
    OTHERS {
        @Override
        public InputType getInferredInputType() {
            return InputType.FREETEXT;
        }
    };
}
