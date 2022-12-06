package com.example.demo.model;

//to generate UUID
import java.util.UUID;

//to set automatic getter and setter
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data
@NoArgsConstructor
public class Person {

    private String id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = UUID.randomUUID().toString().substring(0,8);
        this.firstName=firstName;
        this.lastName = lastName;
    }
    
    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
}
