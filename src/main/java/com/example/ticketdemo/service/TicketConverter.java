package com.example.ticketdemo.service;

import com.example.ticketdemo.dao.TicketEntity;
import com.example.ticketdemo.integration.TicketDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter {

    public TicketDto convert(TicketEntity entity) {
        TicketDto dto = new TicketDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        //BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public TicketEntity convertBack(TicketDto dto) {
        TicketEntity ticketEntity = new TicketEntity();
        BeanUtils.copyProperties(dto, ticketEntity);
        return ticketEntity;
    }
}
