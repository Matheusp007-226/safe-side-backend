package com.lab.sidesafe.controller;

import com.lab.sidesafe.model.Events;
import com.lab.sidesafe.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventService eventService;

    @GetMapping
    public ResponseEntity<List<Events>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findAll());
    }

    @PostMapping
    public ResponseEntity <Events> CreatedEvents(@RequestBody Events events) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createdEventes(events));
    }

}
