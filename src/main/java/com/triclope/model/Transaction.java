package com.triclope.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Date;

public class Transaction {

    @Column(name = "CREATION_DATE")
    private Date creationDate;
}
