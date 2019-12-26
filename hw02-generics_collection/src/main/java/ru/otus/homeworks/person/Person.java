package ru.otus.homeworks.person;

public class Person /*implements Comparable<Person>*/{
    private String name;
    private int iQ;


    public Person(String name, int iQ){
        this.name=name;
        this.iQ =iQ;
    }

    @Override
    public String toString() {
        return name + ", "+ iQ;
    }

    public int getiQ() {
        return iQ;
    }
}
