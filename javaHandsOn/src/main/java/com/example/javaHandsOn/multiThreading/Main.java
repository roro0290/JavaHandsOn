package com.example.javaHandsOn.multiThreading;

public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        /*
//        Thread class has useful methods such as currentThread, sleep
//         */
//        Thread t1 = Thread.currentThread(); // can access information about this current thread: main
//        System.out.println("name of current thread: "+t1.getName());
//        Thread.sleep(10); // puts the current thread to sleep for 10ms
//        System.out.println("name of current thread: "+t1.getName());
//    }

//    public static void main(String[] args) {
//        // 1. Extend the Thread class
//        // 2. Use Runnable interface
//
//        MyThread myThread = new MyThread();
//        myThread.start(); // start the thread and execute everything in the run method
//    }
//
//    static class MyThread extends Thread{
//        @Override
//        public void run() {
//            setName("MyThread");
//            System.out.println("name of current thread"+Thread.currentThread().getName());
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("[1] current thread:"+Thread.currentThread().getName());
        Runnable runnable = () -> System.out.println("[2] current thread:"+Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.setName("myThread");
        thread.start();
        thread.join(); // thread must complete before going on to main()
        System.out.println("[3] current thread:"+Thread.currentThread().getName());
        /*
        order of print can be:
         - 1 -> 3 -> 2
         - 1 -> 2 -> 3 depending on the scheduler
         The order is random.
         If we want to ensure that order is 1 -> 2 -> 3, then we must do the join method that says thread must combine before it proceeds further
         */
    }
}
