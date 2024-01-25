package com.example.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    static class CustomData {
        int key;
        int value;

        CustomData(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return this.key;
        }

        int getValue() {
            return this.value;
        }
    }

    private static final int NUM = 1000;
    List<List<CustomData>> myMap;

    public MyHashMap() {
        myMap = new ArrayList<>();
        for (int i = 0; i < NUM; i++) {
            myMap.add(null);
        }
    }

    public void put(int key, int value) {
        int index = hashFunction(key);
        List<CustomData> bucket = myMap.get(index);
        CustomData customData = new CustomData(key, value);
        if (bucket == null) {
            LinkedList<CustomData> list = new LinkedList<>();
            list.add(customData);
            myMap.set(index, list);
        } else {
            for (int i = 0; i < bucket.size(); i++) {
                CustomData data = bucket.get(i);
                if (data.getKey() == key) {
                    bucket.remove(i);
                    break;
                }
            }
            bucket.add(customData);
        }
    }

    public int get(int key) {

        int index = hashFunction(key);
        List<CustomData> bucket = myMap.get(index);

        if (bucket == null) {
            return -1;
        }

        for (CustomData data : bucket) {
            if (data.getKey() == key) {
                return data.getValue();
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hashFunction(key);
        List<CustomData> bucket = myMap.get(index);

        int counter = 0;
        if (bucket != null) {
            for (CustomData data : bucket) {
                if (data.getKey() == key) {
                    bucket.remove(counter);
                    break;
                }
                counter += 1;
            }
        }


    }

    public int hashFunction(int key) {
        return key % NUM;
    }

}
