package com.dziedzic.warehouse.model;/*
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


@Entity
@Table(name = "parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length=100)
    private String name;

    @NotNull
    @Column(length=100)
    private String value;

    @Column(length=100)
    private String description;

    public Parameter() {
    }

    public Parameter(@NotNull String name, @NotNull String value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
