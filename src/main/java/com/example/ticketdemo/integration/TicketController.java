package com.example.ticketdemo.integration;

import com.example.ticketdemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/hello")
    public String sayHello() {
        return "helloWorld";
    }

    @GetMapping("/all")
    public List<TicketDto> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public TicketDto getOne(@PathVariable String id) {
        return ticketService.getOne(id);
    }

    @PostMapping("/")
    public TicketDto saveOne(@RequestBody  TicketDto dto) {
        return ticketService.saveOne(dto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        ticketService.remove(id);
    }
}
