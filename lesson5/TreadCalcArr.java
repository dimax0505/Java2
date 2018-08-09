package ru.geekbrains.maksimov.Java2.lesson5;

public class TreadCalcArr extends Thread {
    private float[] arr;
    int h;

    TreadCalcArr(String name, float[] arr, int h){
        super(name);
        this.arr = arr;
        this.h = h;
        start();

    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++)
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));

        System.out.println("Время работы потока: " + getName() + "--" + (System.currentTimeMillis()-time));
    }
}