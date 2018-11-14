package ru.otus;

import com.google.gson.Gson;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(3, 3);
        int[] k = {1, 2, 3};
        List list = new ArrayList<Integer>();
        list.add(4);
        list.add(4);
        list.add(4);
        Student[] students = {new Student(1, "1"), new Student(2, "2")};
        Test person = new Test(2, map, list, students, new Student(3, "3"), k);
        Json json = new Json();
        System.out.println(json.toJson(person));
        Gson gson = new Gson();
        System.out.println(gson.toJson(person));
    }
}
