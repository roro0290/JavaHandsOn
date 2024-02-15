package com.example.dataStructures.priorityQueue;

import java.util.*;

public class QueuePractice {

    public static void main(String[] args) {

        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        Queue<Person> personQueue = new PriorityQueue<>();

        Queue<Human> humanQueue = new PriorityQueue<>(Comparator.comparingInt(h -> h.age));

    }
}
