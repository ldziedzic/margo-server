package com.dziedzic.warehouse.model;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length=100)
    private String signature;

    public Offer() {
    }

    public Offer(@NotNull String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

}

