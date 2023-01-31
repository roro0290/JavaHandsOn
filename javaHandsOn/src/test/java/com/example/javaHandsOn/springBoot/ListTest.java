package com.example.javaHandsOn.springBoot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Mock
    List<Integer> listMock;

    @Test
    void simpleTest(){
        // mock a simple method of the list interface
        // we set only 1 value. So no matter how many times we call, it will return 3
        when(listMock.size()).thenReturn(3);
        assertEquals(3,listMock.size());
    }

    @Test
    void multipleReturns(){
        when(listMock.size()).thenReturn(3).thenReturn(2);
        assertEquals(3,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }

    @Test
    void mockMethodWithParameter(){
        when(listMock.get(0)).thenReturn(5);
        assertEquals(5,listMock.get(0));
        assertEquals(null,listMock.get(2));
    }

    @Test
    void genericParameter(){
        when(listMock.get(Mockito.anyInt())).thenReturn(5);
        assertEquals(5,listMock.get(0));
        assertEquals(5,listMock.get(2));
    }

}
