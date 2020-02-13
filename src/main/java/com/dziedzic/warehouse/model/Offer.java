package com.dziedzic.warehouse.model;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length=100)
    private String signature;

    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "offer_parameter",
            joinColumns = {@JoinColumn(name = "offer_id")},
            inverseJoinColumns = {@JoinColumn(name = "parameter_id")})
    private Set<Parameter> parameters = new HashSet<>();

    public Offer() {
    }

    public Offer(@NotNull String signature, Set<Parameter> parameters) {
        this.signature = signature;
        this.parameters = parameters;
    }

    public String getSignature() {
        return signature;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }
}

