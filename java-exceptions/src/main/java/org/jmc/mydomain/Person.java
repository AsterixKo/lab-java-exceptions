package org.jmc.mydomain;

import java.util.Objects;

public class Person {
    private int id;
    private String name;// formatted as "firstName lastName"
    private int age;
    private String occupation;

    /**
     *
     * @param id
     * @param name formatted as "firstName lastName"
     * @param age
     * @param occupation
     */
    public Person(int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age minus than 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name)
                && Objects.equals(occupation, person.occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
