package ru.otus;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class JsonTest {

    String[] strings;
    Map map = new HashMap();
    List list = new ArrayList();
    String string;
    Json json = new Json();
    Gson gson = new Gson();


    @Before
    public void init() {
        strings = new String[]{"1", "2", "3"};
        map.put(1, 1);
        list.add(1);
        string = "5";
    }

    @Test
    public void testArrayToJson() {
        String json1 = json.toJson(strings);
        String gson1 = gson.toJson(strings);
        assertEquals(gson1, json1);
    }

    @Test
    public void testMapToJson() {
        String json2 = json.toJson(map);
        String gson2 = gson.toJson(map);
        assertEquals(gson2, json2);
    }

    @Test
    public void testListTOJson() {
        String json3 = json.toJson(list);
        String gson3 = gson.toJson(list);
        assertEquals(gson3, json3);
    }

    @Test
    public void testPrimitivToJson() {
        String json4 = json.toJson(string);
        String gson4 = gson.toJson(string);
        assertEquals(gson4, json4);
    }
}
