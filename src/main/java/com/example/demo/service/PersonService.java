package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.Person;


@Service
public class PersonService {
    private List<Person> persons = new ArrayList<Person>();

    public PersonService() {
        persons.add(new Person("Mark", "Kwan"));
        persons.add(new Person("Darryl", "Eddie"));
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void addPerson(Person newPerson) {
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    public void removePerson(Person personToDelete) {
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    public void updatePerson(Person personToUpdate) {
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToUpdate.getId())).findAny().orElse(null);

        foundPerson.setFirstName(personToUpdate.getFirstName());
        foundPerson.setLastName(personToUpdate.getLastName());
        // Person updatePerson = new Person();
        // updatePerson.setId(foundPerson.getId());
        // updatePerson.setFirstName(personToUpdate.getFirstName());
        // updatePerson.setLastName(personToUpdate.getLastName());
        // persons.remove(foundPerson);
        // persons.add(updatePerson);
    }




}
