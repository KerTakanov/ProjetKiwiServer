package com.kiwi.server.repositories;

import com.kiwi.server.models.UserEventModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository MongoDB permettant d'accéder à nos Evenements utilisateurs selon différents paramètres;
 *  - findAll(): tous les événements
 *  - findById(String id): selon l'id de l'événement
 *  - findByTitle(String title): selon le titre de l'événement
 *  - findByOwner(String owner): selon le *username* du créateur de l'événement
 */
public interface UserEventRepository extends MongoRepository<UserEventModel, String> {
    public List<UserEventModel> findAll();

    public UserEventModel findById(@Param("id") String id);
    public List<UserEventModel> findByTitle(@Param("title") String title);

    public List<UserEventModel> findByOwner(@Param("owner") String owner);
}
