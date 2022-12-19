package com.example.javaHandsOn.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // good when only certain are needed
        for(int i=0;i<6;i++){
            System.out.print(list.get(i)+" ");
        }

        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        System.out.println();

        // enhanced for loop is good when we want to print all the values
        for(int i:list){
            System.out.print(i +" ");
        }

        // accepts an object of a consumer interface (a functional interface)
        // this interface has one method accept(T t) which needs to be defined
        // which can be done using a lambda expression
        // list is a producer which produces the data while the other is the consumer of data
        list.forEach(i -> System.out.println(i));

        // Since it is an interface, must provide the implementation for that method
        // Anonymous class
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        Consumer c2 = i -> System.out.println(i);

        // when we call the forEach method, it will one by one get the object
        // and send it to the accept method
        list.forEach(c);

        // println is a method
        // :: colon means we are giving method reference
        // of the object out
        // this is a static object from the System class
        list.forEach(System.out::println);

        list.forEach(SampleOperation::process);

        list.stream().forEach(SampleOperation::process);

        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<100;i++){
            list2.add(i);
        }

        // multi threading
        // machine has 4 cores -> to use each core, need one thread
        // by default, we only have 1 thread. We need to create threads
        // With parallelStream() -> it will create the threads for us depending on number of available cores
        list2.parallelStream().forEach(System.out::println);

    }
}
