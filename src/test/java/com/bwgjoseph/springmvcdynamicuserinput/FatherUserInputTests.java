package com.bwgjoseph.springmvcdynamicuserinput;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bwgjoseph.springmvcdynamicuserinput.domain.FatherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;
import com.bwgjoseph.springmvcdynamicuserinput.userinput.InputType;

class FatherUserInputTests {
    private FatherUserInput cut;

    @Test
    void givenIdExistInCollection_shouldSetInputTypeAsReference() {
        Person personFromDb = Person.builder().id("123456").name("hello world").build();
        this.cut = FatherUserInput.of("123456", personFromDb);

        Assertions.assertThat(this.cut.getValue()).isEqualTo("123456");
        Assertions.assertThat(this.cut.getReferenceValue()).isEqualTo(personFromDb);
        Assertions.assertThat(this.cut.getInputType()).isEqualTo(InputType.REFERENCE);
        Assertions.assertThat(this.cut.getRef()).isEqualTo("person");
    }
}
