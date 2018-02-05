package com.kiwi.server.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Modèle décrivant un événément créé par un utilisateur. Il peut le définir comme étant publique (visible de tous) ou
 * privé (visible uniquement par les utilisateurs inscrits et le créateur).
 */
public class UserEventModel {
    @Id
    private String id;

    private String title;
    private String description;
    private String owner;

    private boolean public_event;

    private Date date_begin;
    private Date date_end;

    @DBRef
    private List<UserModel> suscribed_users;

    public UserEventModel() {
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

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public List<UserModel> getSuscribed_users() {
        return suscribed_users;
    }

    public void setSuscribed_users(List<UserModel> suscribed_users) {
        this.suscribed_users = suscribed_users;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isPublic_event() {
        return public_event;
    }

    public void setPublic_event(boolean public_event) {
        this.public_event = public_event;
    }
}
