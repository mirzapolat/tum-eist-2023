package de.tum.in.ase.eist;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import de.tum.in.ase.eist.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void testAddPerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        personService.save(person);

        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void testDeletePerson() {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        person = personRepository.save(person);

        personService.delete(person);

        assertTrue(personRepository.findAll().isEmpty());
    }

    @Test
    void testAddParent() {
        var parent = new Person();
        parent.setFirstName("A");
        parent.setLastName("Mustermann");
        parent.setBirthday(LocalDate.now());

        var child = new Person();
        child.setFirstName("B");
        child.setLastName("Mustermann");
        child.setBirthday(LocalDate.now());

        parent = personRepository.save(parent);
        child = personRepository.save(child);

        assertEquals(2, personRepository.findAll().size());

        child = personService.addParent(child, parent);

        assertEquals(1, child.getParents().size());
    }

    @Test
    void testAddThreeParents() {
        var parent1 = new Person();
        parent1.setFirstName("A");
        parent1.setLastName("Mustermann");
        parent1.setBirthday(LocalDate.now());

        var parent2 = new Person();
        parent2.setFirstName("B");
        parent2.setLastName("Mustermann");
        parent2.setBirthday(LocalDate.now());

        var parent3 = new Person();
        parent3.setFirstName("C");
        parent3.setLastName("Mustermann");
        parent3.setBirthday(LocalDate.now());

        var child = new Person();
        child.setFirstName("D");
        child.setLastName("Mustermann");
        child.setBirthday(LocalDate.now());

        parent1 = personRepository.save(parent1);
        parent2 = personRepository.save(parent2);
        parent3 = personRepository.save(parent3);
        child = personRepository.save(child);

        assertEquals(4, personRepository.findAll().size());

        var newChild = personService.addParent(child, parent1);

        assertEquals(newChild, child);
        assertEquals(1, newChild.getParents().size());
        assertEquals(newChild.getParents().toArray()[0], parent1);
    }
}
