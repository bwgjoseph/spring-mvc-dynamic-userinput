package com.bwgjoseph.springmvcdynamicuserinput;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bwgjoseph.springmvcdynamicuserinput.domain.Nationality;
import com.bwgjoseph.springmvcdynamicuserinput.domain.NationalityUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

class NationalityUserInputTests {
    private NationalityUserInput cut;

    @Test
    void givenNationalityAsSingaporean_shouldSetInputTypeAsSelection() {
        this.cut = NationalityUserInput.of("SINGAPOREAN");

        Assertions.assertThat(this.cut.getValue()).isEqualTo("SINGAPOREAN");
        Assertions.assertThat(this.cut.getSelectionValue()).isEqualTo(Nationality.SINGAPOREAN);
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.SELECTION);
    }

    @Test
    void givenNationalityAsSomethingElse_shouldThrowException() {
        Assertions.assertThatThrownBy(() -> NationalityUserInput.of("SOMETHING ELSE"))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
