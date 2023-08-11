package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonService {
    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        if (person.getBirthday().isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Birthday may not be in the future");
        }
        return personRepository.save(person);
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findWithParentsAndChildrenById(id);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person addParent(Person person, Person parent) {

        if (person.getParents().size() < 2) {
            Set<Person> allParents = person.getParents();
            allParents.add(parent);
            person.setParents(allParents);

            return save(person);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Person addChild(Person person, Person child) {

        if (child.getParents().size() < 2) {
            Set<Person> allChildren = person.getChildren();
            allChildren.add(child);
            person.setChildren(allChildren);

            return save(person);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Person removeParent(Person person, Person parent) {

        if (person.getParents().size() > 1) {
            Set<Person> allParents = person.getParents();
            if (allParents.contains(parent)) {
                allParents.remove(parent);
                person.setParents(allParents);
                return save(person);
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Person removeChild(Person person, Person child) {

        if (child.getParents().size() > 1) {
            Set<Person> allChildren = person.getChildren();
            if (allChildren.contains(child)) {
                allChildren.remove(child);
                person.setChildren(allChildren);
                return save(person);
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
