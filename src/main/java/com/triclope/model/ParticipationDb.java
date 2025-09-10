package com.triclope.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PARTICIPATION", indexes = {
    @Index(name = "idx_participation_triclope", columnList = "triclope_id"),
    @Index(name = "idx_participation_giver", columnList = "giver_id"),
    @Index(name = "idx_participation_taker", columnList = "taker_id"),
    @Index(name = "idx_participation_created_at", columnList = "created_at")
})
public class ParticipationDb {

    @Id
    @UuidGenerator
    @Column(name = "ID")
    private UUID id;

    @Column(name = "QUANTITY", nullable = false)
    @NotNull
    @Positive
    private int quantity;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "triclope_id", nullable = false)
    @NotNull
    private TriclopeDb triclope;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "giver_id", nullable = false)
    @NotNull
    private UserDb giver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taker_id", nullable = false)
    @NotNull
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
