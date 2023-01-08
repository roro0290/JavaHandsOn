package com.example.javaHandsOn.multiThreading;

import java.util.ArrayList;
import java.util.Scanner;

class Task1 extends Thread{
    static int a; // = input #1 = 80
    static int beg; /// = 0

    int min = 0, max = 0, range = 0,track=0;

    ArrayList<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        synchronized (Solution.threadArray){
            for(int i=beg;i<=a;i++){ // add 0 to 79
                list.add(i);
            }
            while(track<a-beg+1){
                max = list.size();
                range = max - min;
                int i = (int) (Math.random() * range);
                Solution.threadArray[track]=list.get(i);
                list.remove(i);
                track+=1;
            }
        }
    }
}

class Task2 extends Thread{
    static int a; // = input #2 = 130
    static int beg; // = input #1 = 80

    ArrayList<Integer> list = new ArrayList<>();

    int min = 0, max = 0, range = 0,track=beg; // 80

    @Override
    public void run() {
        synchronized (Solution.threadArray){
            for(int i=beg;i<beg+a;i++){
                list.add(i);
            }
            while(track<beg+a){
                max = list.size();
                range = max - min;
                int i = (int) (Math.random() * range);
                Solution.threadArray[track]=list.get(i);
                list.remove(i);
                track+=1;
            }
        }
    }

}

class Task3 extends Thread{
    static int a; // = input #3 = 90
    static int beg; // = input #1 + input #2 = 80 + 130 = 210

    ArrayList<Integer> list = new ArrayList<>();

    int min = 0, max = 0, range = 0,track=beg;

    @Override
    public void run() {
        synchronized (Solution.threadArray){
            for(int i=beg;i<beg+a;i++){
                Solution.threadArray[i]=i;
            }
        }
    }
}
public class Solution {
    public static final int[] threadArray = new int[300];
    public static volatile String i = 0+"";
    public boolean test() throws InterruptedException
    {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        int first = Task1.a+Task2.a;
        int containsSecondThread = Task1.a;
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for(int i=0;i<first;i++)
        {
            oneAndTwo += threadArray[i]+" ";
        }
        for(int i=0;i<containsSecondThread;i++)
        {
            sizeOfTask1 += threadArray[i]+" ";
        }
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for(int i=begOfTask3;i<threadArray.length;i++)
        {
            checkingString += i + " ";
        }
        String task3String = "";
        for(int j = begOfTask3;j<threadArray.length;j++)
        {
            task3String += threadArray[j]+" ";
        }
        if((oneAndTwo.contains(begOfTask3+"") && sizeOfTask1.contains(Task2.beg+"")) && task3String.equals(checkingString))
        {
            return true;
        }
        for(int i=0;i<300;i++){
            System.out.print(threadArray[i]);
        }
        return false;
    }
    // SAMPLE INPUT: 80, 130, 90
    public static void main(String[] args) throws InterruptedException
    {
        Scanner sc= new Scanner(System.in);
        Solution solution = new Solution();
        int one = 80;
        Task1.a = one; // 80
        Task1.beg = 0;
        int two = 130;
        Task2.a = two; // 130
        Task2.beg = one; // 80
        int three = 90;
        Task3.a = three; // 90
        Task3.beg = one+two; // 80 + 130 = 210
        System.out.print(solution.test());
    }
}
