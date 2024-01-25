package com.example.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Design a HashSet without using any built-in set libraries. Cannot use tree set

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Input will be a list which will be converted into a hash set

Constraints:

0 <= key <= 1000000
At most 104 calls will be made to add, remove, and contains.
 */
public class MyHashSet {

    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> parentSet;
//    boolean[] mySet;

    /*
    Initialise your data structure here
    0 <= key <= 1000000 --> using this information, we can actually initialise an array of size range + 1
     */
//    public MyHashSet() {
//        this.mySet = new boolean[1000001];
//    }
//
//    /*
//    In the actual hashSet,
//    it will return true in case element is added and false if element was already there and nothing was added
//     */
//    public void add(int key) {
//        mySet[key] = true;
//    }
//
//    public void remove(int key) {
//        mySet[key] = false;
//    }
//
//    public boolean contains(int key) {
//        return mySet[key];
//    }

    public MyHashSet() {
        this.parentSet = new ArrayList<>(ARRAY_SIZE);
        // initialise with null
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentSet.add(null);
        }
    }

    /*
    In the actual hashSet,
    it will return true in case element is added and false if element was already there and nothing was added
     */
    public void add(int key) {
        int hashValue = myHashFunction(key);
        List<Integer> bucket = parentSet.get(hashValue);
        if (bucket == null) {
            LinkedList<Integer> linked = new LinkedList<>();
            linked.add(key);
            parentSet.set(hashValue, linked);
        } else {
            if (!bucket.contains(key)) {
                bucket.add(key);
                //parentSet.set(hashValue, bucket);
            }
        }
    }

    public void remove(int key) {
        int hashValue = myHashFunction(key);
        List<Integer> bucket = parentSet.get(hashValue);
        if (bucket != null) {
            bucket.remove(Integer.valueOf(key)); // remove the object, not the object which is at that int index
            //parentSet.set(key,bucket);
        }

    }

    public boolean contains(int key) {
        int hashValue = myHashFunction(key);
        List<Integer> bucket = parentSet.get(hashValue);
        if (bucket == null) {
            return false;
        } else {
            return bucket.contains(key);
        }

    }

    // returns the index value
    int myHashFunction(int x) {
        return x % ARRAY_SIZE;
    }

}
