package com.isabel.NexusApi.model;

import jakarta.persistence.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "follower")
public class FollowModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String status;
    private LocalDateTime date_follow;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel seguido;


    @ManyToOne
    @JoinColumn(name = "seguidor_id")
    private UserModel seguidor;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate_follow() {
        return date_follow;
    }

    public void setDate_follow(LocalDateTime date_follow) {
        this.date_follow = date_follow;
    }

    public UserModel getSeguido() {
        return seguido;
    }

    public void setSeguido(UserModel seguido) {
        this.seguido = seguido;
    }

    public UserModel getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(UserModel seguidor) {
        this.seguidor = seguidor;
    }
}
