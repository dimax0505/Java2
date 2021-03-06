package ru.geekbrains.maksimov.Java2.lesson2;

public class MainClass {
    public static String in = "52 3 kjg 1\n2 3 2 2\n5 1 7 1\n3 1 0 7";



    public static void main(String[] args) {


        try {
            System.out.println(mathematics(stringToArr(in)));
        }catch (MyStringExeption e){
            System.out.println(e.getMessage());
        }
    }

    public static String[][] stringToArr(String str) throws MyStringExeption {
        String[] arr1;
        arr1 = str.split("\n");
        if (arr1.length != 4) throw new MyStringExeption ("Должно быть 3 знака перехода на новую строку, а у вас: " + (arr1.length-1) );
        String[][] arr2 = new String[arr1.length][arr1.length];
        for (int i = 0; i<arr1.length; i++){
            arr2[i] = arr1[i].split(" ");
            if (arr2[i].length != 4) throw new MyStringExeption("В каждой строке должно быть по 4 символа, а у вас в " + (i+1) + "строке + " + (arr2[i].length)+ "символов ");
        }
        return arr2;
    }

    public static double mathematics (String [][] arr) throws NumberFormatException, MyStringExeption{
        int sum = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
              catch (NumberFormatException e){
                   System.out.println("неподходящий символ: " + arr[i][j]);
                   System.out.println("находится на " + ((i)*arr.length+(j+1)) + " позиции в строке ввода");
                  if (true) throw new MyStringExeption("Надо что то делать!!!");
               }
            }
        }
            return sum/2.0;
    }

}
