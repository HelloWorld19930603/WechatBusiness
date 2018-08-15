package com.yilin.app.domain;

public class Express {
    private Integer id;

    private String name;

    private String com;

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

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com == null ? null : com.trim();
    }
}