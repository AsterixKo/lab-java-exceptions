package org.jmc.mydomain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {

    PersonList personList;

    @BeforeEach
    void setUp() {
        personList = new PersonList(new ArrayList<>(
                Arrays.asList(
                        new Person(0, "Juan Cortez", 50, "Developer"),
                        new Person(0, "Maria Casado", 50, "Mecanic"),
                        new Person(0, "Felipe Sanchez", 35, "Farmer"),
                        new Person(0, "Mario Casas", 25, "Teacher"),
                        new Person(0, "Martin Lopez", 40, "Driver"),
                        new Person(0, "Estela Martinez", 18, "Developer"))
        ));

    }

    /**
     * Test the findByName method to ensure that it properly finds and returns the correct Person object when
     * given a properly formatted name.
     */
    @Test
    @DisplayName("Devuelve la Persona correcta dado un nombre correctamente formateado")
    void findByName_finds_correct_person() {
        assertEquals(new Person(0, "Mario Casas", 25, "Teacher"),
                personList.findByName("Mario Casas"));
    }

    /**
     * Test the findByName method to ensure that it throws an exception if the name parameter is not
     * properly formatted.
     */
    @Test
    @DisplayName("Lanza excepción si el parametro name no esta correctamente formateado")
    void findByName_throws_exception_if_name_is_not_propertly_formated() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("MarioCasas"));
        assertThrows(IllegalArgumentException.class, () -> personList.findByName(""));
    }

    /**
     * Test the clone method to ensure that it creates a new Person object with the same properties as the
     * original, except with a new id.
     */
    @Test
    @DisplayName("Crea una nueva Person con las mismas propiedades excepto con un nuevo id")
    void testClone() {
        Person expectedPerson = new Person(0, "Mario Casas", 25, "Teacher");
        Person personToClone = new Person(0, "Mario Casas", 25, "Teacher");
        Person cloned = this.personList.clone(personToClone);
        assertEquals(expectedPerson, cloned);
        assertNotEquals(expectedPerson.getId(), cloned.getId());
    }
}