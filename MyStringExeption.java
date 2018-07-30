package ru.geekbrains.maksimov.Java2;

public class MyStringExeption extends Throwable {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public MyStringExeption(String message) {
        super(message);
    }
}
