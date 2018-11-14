package ru.otus;

public class Student {
    int age;
     String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ru.otus.Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
