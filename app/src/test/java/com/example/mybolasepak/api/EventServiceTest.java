package com.example.mybolasepak.api;

import com.example.mybolasepak.service.EventService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Test
    public void getDataValidator() {
        System.out.println("HMMMM HELLOOO");
        System.out.println(EventService.getData());
        assertEquals(0,0);
    }
}
