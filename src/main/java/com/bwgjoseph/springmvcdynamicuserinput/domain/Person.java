package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bwgjoseph.springmvcdynamicuserinput.userinput.ReferentialRecord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("person")
@TypeAlias("person")
public class Person implements ReferentialRecord {
    private static final String COLLECTION_NAME = "person";

    @Id
    private String id;
    private String name;
    // Selection
    private NationalityUserInput nationality;
    // SelectionFreeText
    private PlaceOfBirthUserInput placeOfBirth;
    // Reference
    private FatherUserInput father;
    // ReferenceFreeText
    private MotherUserInput mother;

    @Override
    public String getCollection() {
        return Person.COLLECTION_NAME;
    }
}
