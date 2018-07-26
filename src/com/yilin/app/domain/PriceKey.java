package com.yilin.app.domain;

public class PriceKey {
    private Integer commId;

    private Integer roleId;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public PriceKey(Integer commId, Integer roleId) {
        this.commId = commId;
        this.roleId = roleId;
    }

    public PriceKey(){}
}