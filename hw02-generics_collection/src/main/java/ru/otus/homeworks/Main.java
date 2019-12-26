package ru.Otus.HomeWorks;

import ru.otus.homework.DIY.DIYarrayList;
import ru.otus.homework.Person.Person;

import java.util.*;

public class main {
    public static void main(String args []) {

        DIYarrayList<person> list = new DIYarrayList<>();
        list.add(new person("Smith",100));
        list.add(new person("Johnson",95));
        list.add(new person("Williams",104));
        list.add(new person("Jones",100));
        list.add(new person("King",135));
        list.add(new person("Brown",85));
        list.add(new person("Davis",100));
        list.add(new person("Miller",129));
        list.add(new person("Wilson",104));
        list.add(new person("Taylor",130));
        list.add(new person("Anderson",103));
        list.add(new person("Thomas",119));
        list.add(new person("Jackson",100));
        list.add(new person("White",95));
        list.add(new person("Harris",99));
        list.add(new person("Martin",100));
        list.add(new person("Thompson",88));
        list.add(new person("Garcia",110));
        list.add(new person("Martinez",121));
        list.add(new person("Robinson",115));
        list.add(new person("Clark",100));
        list.add(new person("Rodriguez",111));
        list.add(new person("Lewis",118));
        list.add(new person("Lee",120));

        print(list);


        Collections.addAll(list,new person("Walker",100),new person("Hall",101));
        System.out.println("\nДобавление новых элементов методом Collections.addAll()");
        print(list);


        DIYarrayList<person> list1 = new DIYarrayList<>(list);
        Collections.copy(list1,list);
        System.out.println("\nСоздание копии list методом Collections.copy()");
        print(list1);

        Collections.sort(list);
        System.out.println("\nСортировка листа по значениям IQ, методом Collections.sort()");
        print(list1);
    }

    private static void print(DIYarrayList<person> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}