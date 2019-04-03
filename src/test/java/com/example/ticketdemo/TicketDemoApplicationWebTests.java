package com.example.ticketdemo;

import com.example.ticketdemo.dao.TicketEntity;
import com.example.ticketdemo.dao.TicketRepository;
import com.example.ticketdemo.integration.TicketController;
import com.example.ticketdemo.integration.TicketDto;
import com.example.ticketdemo.service.TicketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketDemoApplicationWebTests {

    @Autowired
    TicketController ticketController;

    @MockBean
    TicketService ticketService;

    @MockBean
    TicketRepository ticketRepository;

    @LocalServerPort
    int port;

    TestRestTemplate testRestTemplate;

    TicketDto dto;
    String id;

    @Before
    public void setUp() throws Exception {
        id = UUID.randomUUID().toString();
        dto = new TicketDto();
        dto.setId(id);

        testRestTemplate = new TestRestTemplate();
        when(ticketService.getOne(id)).thenReturn(dto);
    }

    @Test
    public void testSaveSuccessful() {
        ResponseEntity<TicketDto> entity = testRestTemplate.getForEntity(
                String.format("http://localhost:%s/ticket/%s", port, id), TicketDto.class);

        Assert.assertEquals(id, entity.getBody().getId());

    }



}
