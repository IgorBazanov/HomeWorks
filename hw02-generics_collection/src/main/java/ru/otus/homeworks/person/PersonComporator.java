package ru.otus.homeworks.person;

import java.util.Comparator;

public class PersonComporator implements Comparator<Person> {

    public int compare(Person a, Person b){
        return a.getiQ() -b.getiQ();
    }
}
