package de.tum.in.ase.eist.controller;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import java.util.List;
import java.util.function.Consumer;

public class PersonController {

    public void addPerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http post request to the server
    }

    public void updatePerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http put request to the server
    }

    public void deletePerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http delete request to the server
    }

    public void getAllPersons(PersonSortingOptions sortingOptions, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an https get request to the server
    }
}
