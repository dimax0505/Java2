package ru.geekbrains.maksimov.Java2;

import java.util.Scanner;

public class MainClass {
    public static String in = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
       input_flow(in);
        System.out.println(in);
        sc.next();

    }

    public static String[][] input_flow (String str) {
        String[][] arr =  {{"1","2"},{"3","4"}};
        return arr;
    }

}
