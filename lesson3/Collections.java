package ru.geekbrains.maksimov.Java2.lesson3;

import java.util.*;

public class Collections {

    private static String str = "lorem ipsum dolor sit amet consectetur adipiscing " +
            "elit ipsum quis sapien sit nunc efficitur velit at neque " +
            "feugiat eget ipsum";
    private static String name = "Петров";


    public static void main(String[] args) {
        //Задание №1
        System.out.println(Arrays.asList(str.split(" ")));
        System.out.println(uniqlist(str));
        System.out.println(calcIn(str));

        //Задание №2

        PhoneList phoneList = new PhoneList();
        phoneList.add("Иванов", "8-916-829-44-03");
        phoneList.add("Иванов", "8-916-829-47-04");
        phoneList.add("Петров", "8-916-829-47-05");
        phoneList.add("Сидоров", "8-916-829-47-07");
        phoneList.add("Иванов", "8-916-829-47-08");
        phoneList.add("Максимов", "8-916-829-47-03");
        phoneList.add("Иванов", "8-916-829-47-03");
        phoneList.add("Дмитриев", "8-916-829-47-04");
        phoneList.add("Петров", "8-916-829-47-05");
        phoneList.add("Якубович", "8-916-829-47-07");
        phoneList.add("Иванов", "8-916-829-47-08");
        phoneList.add("Петров", "8-916-829-47-09");

        System.out.println("Телефоны связанные с фамилией " + name);
        System.out.println(phoneList.get(name));

        phoneList.printAll();


    }

    private static HashSet uniqlist(String str) {
        HashSet<String> set = new HashSet<>(Arrays.asList(str.split(" ")));
        return set;
    }

    private static TreeMap calcIn(String str) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String aList : Arrays.asList(str.split(" "))) {
            if (map.get(aList) == null)
                map.put(aList, 1);
            else map.put(aList, map.get(aList) + 1);
        }
        return map;
    }
}
