package com.isabel.NexusApi.model;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;

@Entity(name = "seguidores")
@Table(name = "/seguidores")
public class FollowModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String status;

    public FollowModel(Integer id, String status, Date date_follow) {
        Id = id;
        this.status = status;
        this.date_follow = date_follow;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_follow() {
        return date_follow;
    }

    public void setDate_follow(Date date_follow) {
        this.date_follow = date_follow;
    }

    private Date date_follow;
}

