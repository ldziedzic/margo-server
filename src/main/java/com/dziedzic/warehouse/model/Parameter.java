package com.dziedzic.warehouse.model;/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private Integer key;

    @NotNull
    @Column(length=100)
    private String value;

    public Parameter() {
    }

    public Parameter(@NotNull Integer key, @NotNull String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
