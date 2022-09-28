package com.bwgjoseph.springmvcdynamicuserinput;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bwgjoseph.springmvcdynamicuserinput.domain.Country;
import com.bwgjoseph.springmvcdynamicuserinput.domain.PlaceOfBirthUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

public class PlaceOfBirthUserInputTests {
    private PlaceOfBirthUserInput cut;

    @Test
    void givenPobAsSingapore_shouldSetInputTypeAsSelection() {
        this.cut = new PlaceOfBirthUserInput("SINGAPORE");

        Assertions.assertThat(this.cut.getValue()).isEqualTo("SINGAPORE");
        Assertions.assertThat(this.cut.getSelectionValue()).isEqualTo(Country.SINGAPORE);
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.SELECTION);
        Assertions.assertThat(this.cut.getValidInputType()).isTrue();
    }

    @Test
    void givenPobAsSomethingElse_shouldSetInputTypeAsFreeText() {
        this.cut = new PlaceOfBirthUserInput("SOMETHING ELSE");

        Assertions.assertThat(this.cut.getValue()).isEqualTo("SOMETHING ELSE");
        Assertions.assertThat(this.cut.getSelectionValue()).isEqualTo(Country.OTHERS);
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.FREETEXT);
        Assertions.assertThat(this.cut.getValidInputType()).isTrue();
    }
}
