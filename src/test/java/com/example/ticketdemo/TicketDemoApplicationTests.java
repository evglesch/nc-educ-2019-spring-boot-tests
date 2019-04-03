package com.example.ticketdemo;

import com.example.ticketdemo.dao.TicketEntity;
import com.example.ticketdemo.dao.TicketRepository;
import com.example.ticketdemo.integration.TicketDto;
import com.example.ticketdemo.service.TicketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketDemoApplicationTests {

    @Autowired
    TicketService ticketService;

    @MockBean
    TicketRepository ticketRepository;

    TicketDto dto;
    String id;

    @Before
    public void setUp() throws Exception {
        id = UUID.randomUUID().toString();

        dto = new TicketDto();
        dto.setId(id);
        dto.setName("test");

        TicketEntity entity = new TicketEntity();
        entity.setId(id);
        entity.setName("test");

        when(ticketRepository.getOne(id)).thenReturn(entity);
    }

    @Test
    public void testSaveSuccessful() {
        TicketEntity entity = ticketRepository.getOne(id);
        Assert.assertEquals(entity.getName(), dto.getName());
    }



}
