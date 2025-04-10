package org.jmc.mydomain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("La edad no puede ser menor que 0")
    void setAge() {
        assertThrows(IllegalArgumentException.class, () -> new Person(1, "Juan", -1, "Developer"));
    }
    @Test
    @DisplayName("la edad debe ser mayor de 0")
    void setAgeGreatherThanZero(){
        Person person = new Person(0, "Juan", 50, "Developer");
        assertEquals(50, person.getAge());
    }
}