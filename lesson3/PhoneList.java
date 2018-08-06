package ru.geekbrains.maksimov.Java2.lesson3;

import java.util.*;



public class PhoneList {
    private TreeMap<String, ArrayList<String>> phoneList = new TreeMap<>();
    public PhoneList() {}

    public void add (String name, String phoneNumber){

        if (phoneList.get(name)==null){
            ArrayList<String> number = new ArrayList<>();
            number.add(phoneNumber);
        phoneList.put(name,number);
            }
        else phoneList.get(name).add(phoneNumber);
    }
    public ArrayList<String> get (String name) {
        if (phoneList.get(name)==null) {
           return wrongMessage();
        }
        return phoneList.get(name);
    }
    private ArrayList<String> wrongMessage() {
        ArrayList<String> wrongMessage = new ArrayList<>();
        wrongMessage.add("Нет телефонов связанных с данной фамилией");
        return wrongMessage;
    }

    public void printAll () {
        for (Map.Entry<String,ArrayList<String>> entry: phoneList.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
