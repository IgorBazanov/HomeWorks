package pac;

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

        System.out.println("Обычный вывод листа.");
        print(list);


        DIYarrayList<person> list1 = new DIYarrayList<>(3);
        list1.add(new person("Walker",100));
        list1.add(new person("Hall",101));
        list1.add(new person("Allen",106));
        list1.add(new person("Young",100));
        list1.add(new person("Hernandez",110));
        list1.add(new person("King",103));
        list1.add(new person("Wright",105));
        list1.add(new person("Lopez",100));

        list.addAll(list1);

        System.out.println("Лист после addAll");
        print(list);

        list.add(new person("Hill",101));
        list.add(new person("Scott",102));
        list.add(new person("Green",99));
        list.add(new person("Adams",103));
        list.add(new person("Baker",106));
        list.add(new person("Gonzalez",100));

        System.out.println("Лист после добавления новых элементов");
        print(list);


        list.set(3,new person("Nelson",120));
        list.set(4,new person("Carter",126));

        System.out.println("Лист после замены элементов с индексами 3 и 4");
        print(list);

        DIYarrayList<person> list2 = new DIYarrayList<>(list);
        Collections.copy(list2,list);

        System.out.println("Скопированный лист");
        print(list2);

        Collections.sort(list2);

        System.out.println("Лист отсортированный в порядке возрастания IQ");
        print(list2);


        Collections.sort(list2,new Comparator<person>() {
            @Override
            public int compare(person o1, person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("Лист отсортированный по именам");
        print(list2);
        /*
        try{
            list2.contains(new person ("jonson",80));
            Iterator <person> itrator=list2.iterator();
            list2.remove(new person ("jonson",80));
            list2.removeAll(list);
            list2.retainAll(list);
            list.clear();
            //...
        }catch(UnsupportedOperationException e){
            System.out.println("\nWe are sorry!");
        }*/
    }

    private static void print(DIYarrayList<person> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}