package com.bwgjoseph.springmvcdynamicuserinput.userinput;

public interface UserInput {
    /**
    * Get inputValue
    *
    * @return String user input value
    */
    String getValue();
    /**
     * Get InputType
     *
     * @return InputType
     */
    InputType getInputType();
}
