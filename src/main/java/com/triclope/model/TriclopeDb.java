package com.triclope.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TRI_CLOPE", indexes = {
    @Index(name = "idx_triclope_name", columnList = "name"),
    @Index(name = "idx_triclope_created_by", columnList = "created_by"),
    @Index(name = "idx_triclope_creation_date", columnList = "creation_date")
})
public class TriclopeDb {

    @Id
    @UuidGenerator
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME", nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String name;

//    @Column(name = "LOGO")
//    private byte[] logo;

    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDate = LocalDateTime.now();

    // @PrePersist
    // protected void onCreate() {
    //     if (creationDate == null) {
    //         creationDate = LocalDateTime.now();
    //     }
    // }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private UserDb createdBy;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "triclope_members",
            joinColumns = @JoinColumn(name = "triclope_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            indexes = {
                @Index(name = "idx_triclope_members_triclope", columnList = "triclope_id"),
                @Index(name = "idx_triclope_members_user", columnList = "user_id")
            }
    )
    private List<UserDb> members = new ArrayList<>();

    @OneToMany(mappedBy = "triclope", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParticipationDb> participations = new ArrayList<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public UserDb getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDb createdBy) {
        this.createdBy = createdBy;
    }

//    public byte[] getLogo() {
//        return logo;
//    }
//
//    public void setLogo(byte[] logo) {
//        this.logo = logo;
//    }
}
