package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class RoleEntity {
    private int rid;
    private String rcname;
    private String rname;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRcname() {
        return rcname;
    }

    public void setRcname(String rcname) {
        this.rcname = rcname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }


    //    @JoinTable(name="permissions_role_table",
//            joinColumns = {@JoinColumn(name="rid",referencedColumnName = "rid")},
//            inverseJoinColumns = {@JoinColumn(name="pid",referencedColumnName = "pid")})
//
//    @ManyToMany


}
