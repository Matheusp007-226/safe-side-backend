package com.lab.sidesafe.service;

import com.lab.sidesafe.model.Events;
import com.lab.sidesafe.repositories.EventServiceRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventServiceRepositore eventServiceRepositore;

    @Autowired
    UserService userService;

    public List<Events> findAll() {
        return eventServiceRepositore.findAll();
    }

    public Events createdEventes(Events events) {

        return eventServiceRepositore.save(events);
    }
}
