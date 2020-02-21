package com.dziedzic.warehouse.model;/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 20.02.2020
 */

public class Definition {
    private String id;
    private String description;

    public Definition(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
