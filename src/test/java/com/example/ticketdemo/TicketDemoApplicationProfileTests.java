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
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("stub")
public class TicketDemoApplicationProfileTests {

    @Autowired
    Environment environment;

    @Test
    public void checkEnvTest() {
        String property = environment.getProperty("myproperty.value");
        Assert.assertEquals("stub123", property);
    }
}
