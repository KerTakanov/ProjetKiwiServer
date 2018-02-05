package com.kiwi.server.models;

import org.springframework.data.annotation.Id;

/**
 * Modèle décrivant un partenaire du site (ex; traiteur).
 */
public class PartnerModel {
    @Id
    private String id;

    private String name;
    private String description;

    public PartnerModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
