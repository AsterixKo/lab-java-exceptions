package org.jmc.mydomain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class PersonList {
    private List<Person> list;

    public PersonList() {
    }

    public PersonList(ArrayList<Person> persons) {
        this.list = persons;
    }

    /**
     * method that takes in a string name and returns the Person object with a name that matches exactly.
     * The name parameter should be formatted as "firstName lastName". This method should throw an exception
     * if the name parameter is not properly formatted.
     *
     * @param name
     * @return
     */
    public Person findByName(String name) {
        String[] nameSplited = name.split(" ");
        if (nameSplited.length < 2) {
            throw new IllegalArgumentException("Formato de nombre incorrecto");
        }
        Person personFound = null;
        for (Person person : this.list) {
            if (person.getName().equals(name)) {
                personFound = person;
                break;
            }
        }
        return personFound;
    }

    /**
     * method that takes in a Person object and returns a new Person object with the same properties,
     * except with a new id
     *
     * @param personToClone
     * @return
     */
    public Person clone(Person personToClone) {
        int idNew = personToClone.getId();
        do {
            Random random = new Random();
            idNew = random.nextInt(Integer.MAX_VALUE);
        } while (idNew == personToClone.getId());


        return new Person(idNew, personToClone.getName(), personToClone.getAge(), personToClone.getOccupation());
    }

    /**
     * method that takes in a Person object as a parameter and uses the toString method to write the Person
     * information to a file. This method should handle any errors as necessary.
     *
     * @param person
     */
    public void writePersonToFile(Person person) {
        try (FileWriter writer = new FileWriter("person.txt")) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
            throw new RuntimeException(e);
        }
    }
}
