package com.bwgjoseph.springmvcdynamicuserinput.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("person")
@TypeAlias("person")
public class Person {
    @Id
    private String id;
    private String name;
    private NationalityUserInput nationality;
    private PlaceOfBirthUserInput placeOfBirth;
}
