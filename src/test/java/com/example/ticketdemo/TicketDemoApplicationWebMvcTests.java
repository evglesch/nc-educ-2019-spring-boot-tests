package com.example.ticketdemo;

import com.example.ticketdemo.integration.TicketController;
import com.example.ticketdemo.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TicketDemoApplicationWebMvcTests {

    @Autowired
    TicketController ticketController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TicketService ticketService;

    @Test
    public void testSaveSuccessful() throws Exception {
        mockMvc.perform(get("/ticket/hello"))
                .andDo(print())
                .andExpect(content().string("helloWorld"));
    }
}
