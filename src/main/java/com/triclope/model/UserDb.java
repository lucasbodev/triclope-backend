package com.triclope.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "TRICLOPE_USER")
public class UserDb {

    @Id
    @UuidGenerator
    @Column
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "createdBy")
    private List<TriclopeDb> createdTriclopes;

    @OneToMany(mappedBy = "giver")
    private List<ParticipationDb> givenParticipation;

    @OneToMany(mappedBy = "taker")
    private List<ParticipationDb> takenParticipation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
