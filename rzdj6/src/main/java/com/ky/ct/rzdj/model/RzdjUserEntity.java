package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "rzdj_user", schema = "pashanhu", catalog = "")
public class RzdjUserEntity {
    private Integer uid;
    private String loginName;
    private String pwd;
    private String name;
    private String type;
    private Integer role;
    private String mobile;
    private String weiXinOpenId;
    private Integer valid;
    private String note;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "LoginName")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "Pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "Mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "WeiXinOpenID")
    public String getWeiXinOpenId() {
        return weiXinOpenId;
    }

    public void setWeiXinOpenId(String weiXinOpenId) {
        this.weiXinOpenId = weiXinOpenId;
    }

    @Basic
    @Column(name = "Valid")
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "Note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    @JoinTable(name="user_role_table",
//            joinColumns = {@JoinColumn(name="uid",referencedColumnName = "uid")},
//            inverseJoinColumns = {@JoinColumn(name="rid",referencedColumnName = "rid")})

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RzdjUserEntity that = (RzdjUserEntity) o;
        return uid == that.uid &&
                Objects.equals(loginName, that.loginName) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(role, that.role) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(weiXinOpenId, that.weiXinOpenId) &&
                Objects.equals(valid, that.valid) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, loginName, pwd, name, type, role, mobile, weiXinOpenId, valid, note);
    }

    @Override
    public String toString() {
        return "RzdjUserEntity{" +
                "uid=" + uid +
                ", loginName='" + loginName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", role=" + role +
                ", mobile='" + mobile + '\'' +
                ", weiXinOpenId='" + weiXinOpenId + '\'' +
                ", valid=" + valid +
                ", note='" + note + '\'' +
                '}';
    }
}
