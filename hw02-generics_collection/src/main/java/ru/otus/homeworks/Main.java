package ru.otus.homeworks;


import ru.otus.homeworks.diylist.DIYarrayList;
import ru.otus.homeworks.person.Person;
import ru.otus.homeworks.person.PersonComporator;

import java.util.*;

public class Main {
    public static void main(String args []) {

        DIYarrayList<Person> list = new DIYarrayList<>();
        list.add(new Person("Smith",100));
        list.add(new Person("Johnson",95));
        list.add(new Person("Williams",104));
        list.add(new Person("Jones",100));
        list.add(new Person("King",135));
        list.add(new Person("Brown",85));
        list.add(new Person("Davis",100));
        list.add(new Person("Miller",129));
        list.add(new Person("Wilson",104));
        list.add(new Person("Taylor",130));
        list.add(new Person("Anderson",103));
        list.add(new Person("Thomas",119));
        list.add(new Person("Jackson",100));
        list.add(new Person("White",95));
        list.add(new Person("Harris",99));
        list.add(new Person("Martin",100));
        list.add(new Person("Thompson",88));
        list.add(new Person("Garcia",110));
        list.add(new Person("Martinez",121));
        list.add(new Person("Robinson",115));
        list.add(new Person("Clark",100));
        list.add(new Person("Rodriguez",111));
        list.add(new Person("Lewis",118));
        list.add(new Person("Lee",120));

        print(list);


        Collections.addAll(list,new Person("Walker",100),new Person("Hall",101));
        System.out.println("\nДобавление новых элементов методом Collections.addAll()");
        print(list);


        DIYarrayList<Person> list1 = new DIYarrayList<>(list);
        Collections.copy(list1,list);
        System.out.println("\nСоздание копии list методом Collections.copy()");
        print(list1);

        Collections.sort(list, new PersonComporator());
        System.out.println("\nСортировка листа по значениям IQ, методом Collections.sort()");
        print(list);
    }

    private static void print(DIYarrayList<Person> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}