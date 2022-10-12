package com.bwgjoseph.springmvcdynamicuserinput.notinuse;

import java.io.IOException;
import java.util.Optional;

import com.bwgjoseph.springmvcdynamicuserinput.PersonRepository;
import com.bwgjoseph.springmvcdynamicuserinput.domain.MotherUserInput;
import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import lombok.RequiredArgsConstructor;

/**
 * Using @JsonComponent is possible over RequestBodyAdvice but it is slightly more troublesome
 * to set the value back since we don't work with objectMapper to map to Person class
 * but instead, dealing with TreeNode/TextNode
 */
// @JsonComponent
@RequiredArgsConstructor
public class MotherJsonComponent extends JsonDeserializer<Person> {
    private final PersonRepository personRepository;

    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JacksonException {

        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        TextNode motherValue = (TextNode) treeNode.get("mother");

        Optional<Person> mother = this.personRepository.findById(motherValue.textValue());

        if (mother.isPresent()) {
            return Person.builder().mother(MotherUserInput.ofReferenceType(motherValue.textValue(), mother.get())).build();
        }

        return null;
    }

}
