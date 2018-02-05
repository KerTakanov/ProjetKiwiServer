package com.kiwi.server.controllers;

import com.kiwi.server.models.EventModel;
import com.kiwi.server.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controlleur REST définissant plusieurs endpoints afin de récupérer ou d'ajouter des données liées aux événements
 * créés par les administrateurs du site. Ce sont les événements 'featured' qui s'affichent sur la page d'accueil.
 */
@RestController
@RequestMapping("/events")
public class EventRestController {
    /** Notre dépôt d'événements vitrine */
    @Autowired
    private EventRepository eventRepository;

    /** Endpoint '/events/' récupérant tous les événements vitrine */
    @GetMapping
    public List<EventModel> getAll() {
        return eventRepository.findAll();
    }

    /** Endpoint '/events/{id}' récupérant un événement particulier selon son ID */
    @GetMapping("/{id}")
    public EventModel getById(@PathVariable String id) {
        return eventRepository.findById(id);
    }

    /** Endpoint '/events/title/{title}' récupérant un événément particulier selon son titre */
    @GetMapping("/title/{title}")
    public List<EventModel> getByTitle(@PathVariable String title) {
        return eventRepository.findByTitle(title);
    }

    /** Créé un événement, ne se préoccupe pas des doublons */
    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventModel event) {
        EventModel result = eventRepository.save(event);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
