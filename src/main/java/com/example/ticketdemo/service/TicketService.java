package com.example.ticketdemo.service;

import com.example.ticketdemo.dao.TicketEntity;
import com.example.ticketdemo.dao.TicketRepository;
import com.example.ticketdemo.integration.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketConverter converter;

    public List<TicketDto> getAll() {
        // get all
        List<TicketEntity> entities = ticketRepository.findAll();
        List<TicketDto> dtoList = new ArrayList<>();

        // convert
        entities.forEach(entity -> dtoList.add(convert(entity)));

        return dtoList;
    }

    public TicketDto getOne(String id) {
        // get one
        TicketEntity ticketEntity = ticketRepository.getOne(id);

        // convert and return
        return convert(ticketEntity);
    }

    public TicketDto saveOne(TicketDto dto) {
        // save one
        TicketEntity ticketEntity = ticketRepository.save(convertBack(dto));

        // convert and return
        return convert(ticketEntity);
    }

    public void remove(String id) {
        ticketRepository.deleteById(id);
    }

    public TicketDto convert(TicketEntity entity) {
        return converter.convert(entity);
    }

    public TicketEntity convertBack(TicketDto dto) {
        return converter.convertBack(dto);
    }
}
