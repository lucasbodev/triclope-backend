package com.triclope.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PARTICIPATION")
public class ParticipationDb {

    @Id
    @UuidGenerator
    private UUID id;

    private int quantity;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "triclope_id", nullable = false)
    private TriclopeDb triclope;

    @ManyToOne
    @JoinColumn(name = "giver_id", nullable = false)
    private UserDb giver;

    @ManyToOne
    @JoinColumn(name = "taker_id", nullable = false)
    private UserDb taker;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TriclopeDb getTriclope() {
        return triclope;
    }

    public void setTriclope(TriclopeDb triclope) {
        this.triclope = triclope;
    }

    public UserDb getGiver() {
        return giver;
    }

    public void setGiver(UserDb giver) {
        this.giver = giver;
    }

    public UserDb getTaker() {
        return taker;
    }

    public void setTaker(UserDb taker) {
        this.taker = taker;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
