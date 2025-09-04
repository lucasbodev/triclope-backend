package com.triclope.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="TRI_CLOPE")
public class TriclopeDb {

    @Id
    @UuidGenerator
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

//    @Column(name = "LOGO")
//    private byte[] logo;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate = LocalDateTime.now();;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private UserDb createdBy;

    @ManyToMany
    @JoinTable(
            name = "triclope_members",
            joinColumns = @JoinColumn(name = "triclope_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserDb> members;

    @OneToMany(mappedBy = "triclope")
    private List<ParticipationDb> participations;


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

    public List<UserDb> getMembers() {
        return members;
    }

    public void setMembers(List<UserDb> members) {
        this.members = members;
    }

    public List<ParticipationDb> getParticipations() {
        return participations;
    }

    public void setParticipations(List<ParticipationDb> participations) {
        this.participations = participations;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

//    public byte[] getLogo() {
//        return logo;
//    }
//
//    public void setLogo(byte[] logo) {
//        this.logo = logo;
//    }
}
