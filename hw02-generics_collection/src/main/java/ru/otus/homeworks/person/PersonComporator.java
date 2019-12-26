package ru.Otus.HomeWorks.Person;

import java.util.Comparator;

public class c implements Comparator<person> {

    public int compare(person a,person b){
        return a.getName().compareTo(b.getName());
    }
}
