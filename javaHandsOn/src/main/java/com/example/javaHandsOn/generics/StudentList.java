package com.example.javaHandsOn.generics;

import java.util.ArrayList;

public class StudentList<T> {

    ArrayList<T> studentList = new ArrayList<>();

    public void addElement(T t){
        studentList.add(t);
    }

    public void removeElement(T t){
        studentList.remove(t);
    }

    public T getElement(int index){
        return studentList.get(index);
    }

    public T beginsWith(String start){
        return null;
    }

    public T bloodGroupOf(String[] array,String search){
        return null;
    }

    public T thresholdScore(int score){
        return null;
    }

}
