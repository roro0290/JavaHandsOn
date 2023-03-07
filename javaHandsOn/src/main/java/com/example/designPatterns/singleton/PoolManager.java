package com.example.designPatterns.singleton;

import org.springframework.stereotype.Component;

import javax.ejb.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@Singleton // only one instance of this class can be instantiated
@ConcurrencyManagement(ConcurrencyManagementType.BEAN) // concurrency managed on our own
public class PoolManager {
    private final Queue<Object> pooledObjects = new LinkedBlockingQueue<>(1000);

    private PoolManager() {
        for(int i=0;i<100;i++){
            pooledObjects.offer(new Object()); // offer() = to insert object into list
        }
    }

    @Lock(LockType.WRITE)
    public void insertObject(Object object){
        pooledObjects.offer(object);
    }

    @Lock(LockType.READ)
    public Object retrieveObject(){
        return pooledObjects.poll(); // retrieve and remove head of the queue
    }
}

