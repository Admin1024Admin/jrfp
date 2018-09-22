package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pkf_dzb", schema = "pashanhu", catalog = "")
public class PkfDzbEntity {
    private long uid;
    private Integer no;
    private String name;
    private String address;
    private String cardId;
    private Integer baoXianJinE;
    private Integer baoFei;
    private String canBaoType;
    private String note;
    private String tianBaoDanWei;
    private String tianBaoDate;
    private String touBaoYear;
    private Date importDate;
    private String note1;
    private String note2;
    private String note3;

    @Id
    @Column(name = "UID")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "No")
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
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
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "CardID")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "BaoXianJinE")
    public Integer getBaoXianJinE() {
        return baoXianJinE;
    }

    public void setBaoXianJinE(Integer baoXianJinE) {
        this.baoXianJinE = baoXianJinE;
    }

    @Basic
    @Column(name = "BaoFei")
    public Integer getBaoFei() {
        return baoFei;
    }

    public void setBaoFei(Integer baoFei) {
        this.baoFei = baoFei;
    }

    @Basic
    @Column(name = "CanBaoType")
    public String getCanBaoType() {
        return canBaoType;
    }

    public void setCanBaoType(String canBaoType) {
        this.canBaoType = canBaoType;
    }

    @Basic
    @Column(name = "Note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "TianBaoDanWei")
    public String getTianBaoDanWei() {
        return tianBaoDanWei;
    }

    public void setTianBaoDanWei(String tianBaoDanWei) {
        this.tianBaoDanWei = tianBaoDanWei;
    }

    @Basic
    @Column(name = "TianBaoDate")
    public String getTianBaoDate() {
        return tianBaoDate;
    }

    public void setTianBaoDate(String tianBaoDate) {
        this.tianBaoDate = tianBaoDate;
    }

    @Basic
    @Column(name = "TouBaoYear")
    public String getTouBaoYear() {
        return touBaoYear;
    }

    public void setTouBaoYear(String touBaoYear) {
        this.touBaoYear = touBaoYear;
    }

    @Basic
    @Column(name = "ImportDate")
    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    @Basic
    @Column(name = "Note1")
    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    @Basic
    @Column(name = "Note2")
    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    @Basic
    @Column(name = "Note3")
    public String getNote3() {
        return note3;
    }

    public void setNote3(String note3) {
        this.note3 = note3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PkfDzbEntity that = (PkfDzbEntity) o;
        return uid == that.uid &&
                Objects.equals(no, that.no) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(baoXianJinE, that.baoXianJinE) &&
                Objects.equals(baoFei, that.baoFei) &&
                Objects.equals(canBaoType, that.canBaoType) &&
                Objects.equals(note, that.note) &&
                Objects.equals(tianBaoDanWei, that.tianBaoDanWei) &&
                Objects.equals(tianBaoDate, that.tianBaoDate) &&
                Objects.equals(touBaoYear, that.touBaoYear) &&
                Objects.equals(importDate, that.importDate) &&
                Objects.equals(note1, that.note1) &&
                Objects.equals(note2, that.note2) &&
                Objects.equals(note3, that.note3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, no, name, address, cardId, baoXianJinE, baoFei, canBaoType, note, tianBaoDanWei, tianBaoDate, touBaoYear, importDate, note1, note2, note3);
    }

    @Override
    public String toString() {
        return "PkfDzbEntity{" +
                "uid=" + uid +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cardId='" + cardId + '\'' +
                ", baoXianJinE=" + baoXianJinE +
                ", baoFei=" + baoFei +
                ", canBaoType='" + canBaoType + '\'' +
                ", note='" + note + '\'' +
                ", tianBaoDanWei='" + tianBaoDanWei + '\'' +
                ", tianBaoDate='" + tianBaoDate + '\'' +
                ", touBaoYear='" + touBaoYear + '\'' +
                ", importDate=" + importDate +
                ", note1='" + note1 + '\'' +
                ", note2='" + note2 + '\'' +
                ", note3='" + note3 + '\'' +
                '}';
    }
}
