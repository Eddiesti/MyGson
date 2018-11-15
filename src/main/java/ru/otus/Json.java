package ru.otus;

import org.json.simple.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Json {
    public String toJson(Object object) {
        if (checkPrimitiveFields(object.getClass())) {
            return JSONValue.toJSONString(object);
        }
        if (object instanceof Map) {
            return JSONObject.toJSONString((Map) object);
        }
        if (object instanceof Iterable || object.getClass().isArray()) {
            Iterable<Object> list;
            if (object.getClass().isArray()) {
                list = arrayToList(object);
            } else {
                list = (Iterable<Object>) object;
            }
            JSONArray jsonArr = jsonToArray(list);
            return jsonArr.toJSONString();
        }
        JSONObject jsonObject = jsonToObject(object);
        return jsonObject.toJSONString();
    }

    private JSONObject jsonToObject(Object object) {
        JSONObject jsonObject = new JSONObject();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (!Modifier.isTransient(field.getModifiers())) {
                if (checkPrimitiveFields(field.getType()) || value instanceof Map) {
                    jsonObject.put(name, value);
                } else {
                    if (value instanceof Iterable || value.getClass().isArray()) {
                        Iterable<Object> list;
                        if (value.getClass().isArray()) {
                            list = arrayToList(value);
                        } else {
                            list = (Iterable<Object>) value;
                        }
                        JSONArray jsonArray = jsonToArray(list);
                        jsonObject.put(name, jsonArray);
                    } else {
                        JSONObject jsonObject1 = jsonToObject(value);
                        jsonObject.put(name, jsonObject1);
                    }
                }
            }
        }
        return jsonObject;
    }

    private JSONArray jsonToArray(Iterable<Object> collection) {
        JSONArray jsonArray = new JSONArray();
        for (Object aCollection : collection) {
            jsonArray.add(aCollection);
        }
        return jsonArray;
    }

    private boolean checkPrimitiveFields(Class clazz) {
        return clazz.isPrimitive() ||
                clazz.equals(String.class);
    }

    private List<Object> arrayToList(Object array) {
        List<Object> list = new ArrayList<>();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            list.add(element);
        }
        return list;
    }
}
