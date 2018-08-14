package ru.geekbrains.maksimov.Java2.lesson5;

import java.util.Arrays;

public class MainClass {
    public static final int syze = 10000000;
    public static final int h = syze/2/*+syze/8*/
            ;
    public static float [] arr1 = new float[syze];
    public static float [] arr2 = new float[syze];

    public static void main(String[] args) {

//        try {
//            new Thread("r1").join();
//            new Thread("r2").join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException();
//        }


        simplcalc(arr1);


        threadcalc(arr2);

       // System.out.println(arr1[h-1] + " " + arr1[h]+ " " + arr1[h+1]);
       // System.out.println(arr2[h-1]+ " " + arr2[h]+ " " + arr2[h+1]);

        System.out.println(Arrays.equals(arr1,arr2));
    }



    public static void fillArr (float[] arr) {
        for (int i=0; i<arr.length; i++)
            arr[i]=1;
    }



    public static void simplcalc (float[] arr) {
        fillArr(arr);
        long time = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("Время работы простого метода: " + (System.currentTimeMillis()-time));
    }

    public static void threadcalc (float[] arr){
        fillArr(arr);
        long time = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[syze-h];
        System.arraycopy(arr, 0, a1, 0,h);
        System.arraycopy(arr, h, a2, 0, syze-h);
       // System.out.println(a1.length + " " + a2.length);
        System.out.println("Время разбивки массива: " + (System.currentTimeMillis()-time));
//        TreadCalcArr t1 = new TreadCalcArr("1", a1,0);
//        TreadCalcArr t2 = new TreadCalcArr("2", a2,h);
        try {
            new TreadCalcArr("1", a1,0).join();
            new TreadCalcArr("2", a2,h).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time1 = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, syze-h);
        System.out.println("Время сборки массива: " + (System.currentTimeMillis()-time1));
        System.out.println("Время работы поточного метода: " + (System.currentTimeMillis()-time));
    }

}


