package com.event.onlineeventregistrationmanagementsystem.service;

import com.event.onlineeventregistrationmanagementsystem.entity.Event;
import com.event.onlineeventregistrationmanagementsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public Event addEvent(Event event) {
        return repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event updateEvent(Long id, Event event) {
        Event existing = repository.findById(id).orElseThrow();
        existing.setEventName(event.getEventName());
        existing.setEventDate(event.getEventDate());
        existing.setLocation(event.getLocation());
        return repository.save(existing);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}
