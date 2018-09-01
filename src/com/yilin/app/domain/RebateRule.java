package com.yilin.app.domain;

public class RebateRule {
    private Integer id;

    private String name;

    private Float firster;

    private Float second;

    private Byte type;

    private Integer role;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getFirster() {
        return firster;
    }

    public void setFirster(Float firster) {
        this.firster = firster;
    }

    public Float getSecond() {
        return second;
    }

    public void setSecond(Float second) {
        this.second = second;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}