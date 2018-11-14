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

    @Before
    public void init() {
        strings = new String[]{"1", "2", "3"};
        map.put(1, 1);
        list.add(1);
        string = "5";
    }

    @Test
    public void toJson() {
        Json json = new Json();
        Gson gson = new Gson();

        String json1 = json.toJson(strings);
        String gson1 = gson.toJson(strings);
        assertEquals(json1, gson1);

        String json2 = json.toJson(map);
        String gson2 = gson.toJson(map);
        assertEquals(json2, gson2);

        String json3 = json.toJson(list);
        String gson3 = gson.toJson(list);
        assertEquals(json3, gson3);

        String json4 = json.toJson(string);
        String gson4 = gson.toJson(string);
        assertEquals(json4, gson4);
    }
}
