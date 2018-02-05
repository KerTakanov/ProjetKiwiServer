package com.kiwi.server.repositories;

import com.kiwi.server.models.EventModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository MongoDB permettant d'accéder à nos Evenements 'Vitrine' selon différents paramètres;
 *  - findAll(): tous les événements
 *  - findById(String id): selon l'id de l'événement
 *  - findByTitle(String title): selon le titre de l'événement
 */
public interface EventRepository extends MongoRepository<EventModel, String> {
    public List<EventModel> findAll();

    public EventModel findById(@Param("id") String id);
    public List<EventModel> findByTitle(@Param("title") String title);
}
