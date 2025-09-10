package com.triclope.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TRICLOPE_USER", indexes = {
    @Index(name = "idx_user_name", columnList = "first_name, last_name")
})
public class UserDb {

    @Id
    @UuidGenerator
    @Column(name = "ID")
    private UUID id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @NotBlank
    private String email;



    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TriclopeDb> createdTriclopes = new ArrayList<>();

    @OneToMany(mappedBy = "giver", fetch = FetchType.LAZY)
    private List<ParticipationDb> givenParticipation = new ArrayList<>();

    @OneToMany(mappedBy = "taker", fetch = FetchType.LAZY)
    private List<ParticipationDb> takenParticipation = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<TriclopeDb> getCreatedTriclopes() {
        return createdTriclopes;
    }

    public void setCreatedTriclopes(List<TriclopeDb> createdTriclopes) {
        this.createdTriclopes = createdTriclopes;
    }

    public List<ParticipationDb> getGivenParticipation() {
        return givenParticipation;
    }

    public void setGivenParticipation(List<ParticipationDb> givenParticipation) {
        this.givenParticipation = givenParticipation;
    }

    public List<ParticipationDb> getTakenParticipation() {
        return takenParticipation;
    }

    public void setTakenParticipation(List<ParticipationDb> takenParticipation) {
        this.takenParticipation = takenParticipation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
