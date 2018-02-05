package com.kiwi.server.controllers;

import com.kiwi.server.models.UserEventModel;
import com.kiwi.server.repositories.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controlleur REST définissant plusieurs endpoints afin de récupérer ou d'ajouter des données liées aux événements
 * créés par les utilisateurs du site. Ce sont les événements des utilisateurs eux-même et un événément particulier ne
 * devrait être affiché uniquement s'il est considéré "publique".
 */
@RestController
@RequestMapping("/userEvents")
public class UserEventRestController {
        /** Notre dépôt d'événements utilisateurs */
        @Autowired
        private UserEventRepository userEventRepository;

        /** Endpoint '/userEvents/' récupérant tous les événements utilisateurs */
        @GetMapping
        public List<UserEventModel> getAll() {
            return userEventRepository.findAll();
        }

        /** Endpoint '/events/{id}' récupérant un événement particulier selon son ID */
        @GetMapping("/{id}")
        public UserEventModel getById(@PathVariable String id) {
            return userEventRepository.findById(id);
        }

        /** Endpoint '/events/title/{title}' récupérant un événément particulier selon son titre */
        @GetMapping("/title/{title}")
        public List<UserEventModel> getByTitle(@PathVariable String title) {
            return userEventRepository.findByTitle(title);
        }

        /** Endpoint '/events/title/{title}' récupérant un événément particulier selon l'utilisateur le 'possédant'
         * (la plupart du temps; l'ayant créé) */
        @GetMapping("owner/{owner}")
        public List<UserEventModel> getByUsername(@PathVariable String owner) {
            return userEventRepository.findByOwner(owner);
        }

        /** Créé un événement, ne se préoccupe pas des doublons */
        @PostMapping
        public ResponseEntity<?> createEvent(@RequestBody UserEventModel event) {
            UserEventModel result = userEventRepository.save(event);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(result.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
}
