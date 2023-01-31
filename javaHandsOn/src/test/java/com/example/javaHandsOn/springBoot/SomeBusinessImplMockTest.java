package com.example.javaHandsOn.springBoot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // so that @Mock and @InjectMock will have real mocks
public class SomeBusinessImplMockTest {

    @Mock
    private DataService service;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void test1(){
        // CREATE a MOCK FOR THIS CLASS
        DataService dataMock = mock(DataService.class);
        // tell the mock to return a value when a method is called
        when(dataMock.retrieveAllData()).thenReturn(new int[]{5,10,25});
        SomeBusinessImpl impl = new SomeBusinessImpl(dataMock);
        int great = impl.findTheGreatestFromAllData();
        assertEquals(25,great);
    }

    @Test
    void test2(){
        when(service.retrieveAllData()).thenReturn(new int[]{5,10,25});
        assertEquals(25,someBusiness.findTheGreatestFromAllData());
    }
}


