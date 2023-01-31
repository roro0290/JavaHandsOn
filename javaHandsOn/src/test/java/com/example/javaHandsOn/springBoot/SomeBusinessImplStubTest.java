package com.example.javaHandsOn.springBoot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {

    DataServiceStub stub = new DataServiceStub();
    SomeBusinessImpl impl = new SomeBusinessImpl(stub);

    @Test
    void test(){
        int great = impl.findTheGreatestFromAllData();
        assertEquals(25,great);
    }
}

class DataServiceStub implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 15, 5}; // return some dummy data
    }
}
