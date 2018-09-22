package com.ky.ct.rzdj.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="role_permissions_table")
public class RolePermissionsEntity {
    private int id;
    private int pid;
    private int rid;

    public RolePermissionsEntity() {}
    public RolePermissionsEntity(int pid, int rid) {
        this.pid = pid;
        this.rid = rid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
