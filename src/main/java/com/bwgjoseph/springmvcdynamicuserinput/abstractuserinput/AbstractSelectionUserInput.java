package com.bwgjoseph.springmvcdynamicuserinput.abstractuserinput;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.InferredInputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.UserInput;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Base class for Selection And SelectionFreeText User Input
 * <p>
 * Accept a generic type <b>S</b> that of a bounded parameter {@link Enum} & {@link InferredInputType}
 */
@ToString
@NoArgsConstructor
public abstract class AbstractSelectionUserInput<S extends Enum<S> & InferredInputType> implements UserInput  {
    /**
     * Stores the actual value input by the user, no matter the input type
     */
    private String value;
    /**
     * Map to the respective Enum based on the input value
     */
    private S selectionValue;
    /**
     * This value should be inferred based on the input
     */
    private InputType inputType;

    protected AbstractSelectionUserInput(String inputValue, S selection) {
        this.value = inputValue;
        this.selectionValue = selection;
        this.inputType = selection.getInferredInputType();
    }

    /**
     * Get selectionValue
     *
     * @return S selection type
     */
    public S getSelectionValue() {
        return this.selectionValue;
    }

    /**
     * Get InputType
     *
     * @return InputType
     */
    @Override
    public InputType getInputType() {
        return this.inputType;
    }

    /**
     * Get inputValue
     *
     * @return String user input value
     */
    @Override
    public String getValue() {
        return this.value;
    }
}