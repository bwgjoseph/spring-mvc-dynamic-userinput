package com.bwgjoseph.springmvcdynamicuserinput;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bwgjoseph.springmvcdynamicuserinput.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
