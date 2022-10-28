package com.bwgjoseph.springmvcdynamicuserinput;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bwgjoseph.springmvcdynamicuserinput.domain.MotherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

class MotherUserInputTests {
    private MotherUserInput cut;

    @Test
    void givenIdDoesNotExistInCollection_shouldSetInputTypeAsFreeText() {
        this.cut = MotherUserInput.ofFreeTextType("123456");

        Assertions.assertThat(this.cut.getValue()).isEqualTo("123456");
        Assertions.assertThat(this.cut.getReferenceValue()).isEmpty();
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.FREETEXT);
        Assertions.assertThat(this.cut.getRef()).isEmpty();
    }

    @Test
    void givenIdExistInCollection_shouldSetInputTypeAsReference() {
        Person personFromDb = Person.builder().id("123456").name("hello world").build();
        this.cut = MotherUserInput.ofReferenceType("123456", personFromDb);

        Assertions.assertThat(this.cut.getValue()).isEqualTo("123456");
        Assertions.assertThat(this.cut.getReferenceValue().get()).isEqualTo(personFromDb);
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.REFERENCE);
        Assertions.assertThat(this.cut.getRef()).isEqualTo("person");
    }
}
