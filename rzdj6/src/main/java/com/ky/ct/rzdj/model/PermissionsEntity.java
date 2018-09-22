package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="permissions")
public class PermissionsEntity {
    private int pid;
    private String pname;
    private String ptype;
    private String purl;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
    //    @JoinTable(name="permissions_role_table",
//            joinColumns = {@JoinColumn(name="pid",referencedColumnName = "pid")},
//            inverseJoinColumns = {@JoinColumn(name="rid",referencedColumnName = "rid")})
//    @ManyToMany
}
