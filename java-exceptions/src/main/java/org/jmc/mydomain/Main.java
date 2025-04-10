package org.jmc.mydomain;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    PersonList personList = new PersonList();

    personList.writePersonToFile(new Person(0, "Juan Cortez", 50, "Developer"));
    }
}