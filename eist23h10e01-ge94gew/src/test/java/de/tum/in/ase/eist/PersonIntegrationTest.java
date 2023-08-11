package de.tum.in.ase.eist;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.repository.PersonRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PersonIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void testAddPerson() throws Exception {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        var response = this.mvc.perform(
                post("/persons")
                        .content(objectMapper.writeValueAsString(person))
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(1, personRepository.findAll().size());
    }

    @Test
    void testDeletePerson() throws Exception {
        var person = new Person();
        person.setFirstName("Max");
        person.setLastName("Mustermann");
        person.setBirthday(LocalDate.now());

        person = personRepository.save(person);

        var response = this.mvc.perform(
                delete("/persons/" + person.getId())
                        .contentType("application/json")
        ).andReturn().getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
        assertTrue(personRepository.findAll().isEmpty());
    }

    // TODO: Add more test cases here
}
