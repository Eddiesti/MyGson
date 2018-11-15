package ru.otus;

public class Student {
    private int age;
    private String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
