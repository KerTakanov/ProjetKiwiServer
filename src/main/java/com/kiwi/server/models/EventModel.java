package com.kiwi.server.models;

import org.springframework.data.annotation.Id;

/**
 * Modèle décrivant un événement 'Vitrine' créé par les administrateurs du site, qui sont -normalement- affichés sur
 * la page d'accueil en tant qu'événements 'featured'.
 */
public class EventModel {
    @Id
    private String id;

    private String title;
    private String description;
    private String imageUrl;

    public EventModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
