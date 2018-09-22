package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pkf_pjsx", schema = "pashanhu", catalog = "")
public class PkfPjsxEntity {
    private long uid;
    private Integer no;
    private String xiangZhen;
    private String chunZu;
    private String huZhu;
    private String daiKuanRen;
    private String cardId;
    private String healthState;
    private String wenHuaChengDu;
    private String laoDongNengLi;
    private String givenStars;
    private Double shouXinEDu;
    private Date shouXinDate;
    private String contactPhone;
    private String note;
    private String tianBaoDanWei;
    private String tianBiaoRen;
    private String tianBiaoRenLianXi;
    private String shenHeRen;
    private Date tianBiaoDate;
    private Date importDate;
    private String note1;
    private String note2;
    private String note3;
    private String note4;
    private String note5;

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
    @Column(name = "XiangZhen")
    public String getXiangZhen() {
        return xiangZhen;
    }

    public void setXiangZhen(String xiangZhen) {
        this.xiangZhen = xiangZhen;
    }

    @Basic
    @Column(name = "ChunZu")
    public String getChunZu() {
        return chunZu;
    }

    public void setChunZu(String chunZu) {
        this.chunZu = chunZu;
    }

    @Basic
    @Column(name = "HuZhu")
    public String getHuZhu() {
        return huZhu;
    }

    public void setHuZhu(String huZhu) {
        this.huZhu = huZhu;
    }

    @Basic
    @Column(name = "DaiKuanRen")
    public String getDaiKuanRen() {
        return daiKuanRen;
    }

    public void setDaiKuanRen(String daiKuanRen) {
        this.daiKuanRen = daiKuanRen;
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
    @Column(name = "HealthState")
    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    @Basic
    @Column(name = "WenHuaChengDu")
    public String getWenHuaChengDu() {
        return wenHuaChengDu;
    }

    public void setWenHuaChengDu(String wenHuaChengDu) {
        this.wenHuaChengDu = wenHuaChengDu;
    }

    @Basic
    @Column(name = "LaoDongNengLi")
    public String getLaoDongNengLi() {
        return laoDongNengLi;
    }

    public void setLaoDongNengLi(String laoDongNengLi) {
        this.laoDongNengLi = laoDongNengLi;
    }

    @Basic
    @Column(name = "GivenStars")
    public String getGivenStars() {
        return givenStars;
    }

    public void setGivenStars(String givenStars) {
        this.givenStars = givenStars;
    }

    @Basic
    @Column(name = "ShouXinEDu")
    public Double getShouXinEDu() {
        return shouXinEDu;
    }

    public void setShouXinEDu(Double shouXinEDu) {
        this.shouXinEDu = shouXinEDu;
    }

    @Basic
    @Column(name = "ShouXinDate")
    public Date getShouXinDate() {
        return shouXinDate;
    }

    public void setShouXinDate(Date shouXinDate) {
        this.shouXinDate = shouXinDate;
    }

    @Basic
    @Column(name = "ContactPhone")
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
    @Column(name = "TianBiaoRen")
    public String getTianBiaoRen() {
        return tianBiaoRen;
    }

    public void setTianBiaoRen(String tianBiaoRen) {
        this.tianBiaoRen = tianBiaoRen;
    }

    @Basic
    @Column(name = "TianBiaoRenLianXi")
    public String getTianBiaoRenLianXi() {
        return tianBiaoRenLianXi;
    }

    public void setTianBiaoRenLianXi(String tianBiaoRenLianXi) {
        this.tianBiaoRenLianXi = tianBiaoRenLianXi;
    }

    @Basic
    @Column(name = "ShenHeRen")
    public String getShenHeRen() {
        return shenHeRen;
    }

    public void setShenHeRen(String shenHeRen) {
        this.shenHeRen = shenHeRen;
    }

    @Basic
    @Column(name = "TianBiaoDate")
    public Date getTianBiaoDate() {
        return tianBiaoDate;
    }

    public void setTianBiaoDate(Date tianBiaoDate) {
        this.tianBiaoDate = tianBiaoDate;
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

    @Basic
    @Column(name = "Note4")
    public String getNote4() {
        return note4;
    }

    public void setNote4(String note4) {
        this.note4 = note4;
    }

    @Basic
    @Column(name = "Note5")
    public String getNote5() {
        return note5;
    }

    public void setNote5(String note5) {
        this.note5 = note5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PkfPjsxEntity that = (PkfPjsxEntity) o;
        return uid == that.uid &&
                Objects.equals(no, that.no) &&
                Objects.equals(xiangZhen, that.xiangZhen) &&
                Objects.equals(chunZu, that.chunZu) &&
                Objects.equals(huZhu, that.huZhu) &&
                Objects.equals(daiKuanRen, that.daiKuanRen) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(healthState, that.healthState) &&
                Objects.equals(wenHuaChengDu, that.wenHuaChengDu) &&
                Objects.equals(laoDongNengLi, that.laoDongNengLi) &&
                Objects.equals(givenStars, that.givenStars) &&
                Objects.equals(shouXinEDu, that.shouXinEDu) &&
                Objects.equals(shouXinDate, that.shouXinDate) &&
                Objects.equals(contactPhone, that.contactPhone) &&
                Objects.equals(note, that.note) &&
                Objects.equals(tianBaoDanWei, that.tianBaoDanWei) &&
                Objects.equals(tianBiaoRen, that.tianBiaoRen) &&
                Objects.equals(tianBiaoRenLianXi, that.tianBiaoRenLianXi) &&
                Objects.equals(shenHeRen, that.shenHeRen) &&
                Objects.equals(tianBiaoDate, that.tianBiaoDate) &&
                Objects.equals(importDate, that.importDate) &&
                Objects.equals(note1, that.note1) &&
                Objects.equals(note2, that.note2) &&
                Objects.equals(note3, that.note3) &&
                Objects.equals(note4, that.note4) &&
                Objects.equals(note5, that.note5);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, no, xiangZhen, chunZu, huZhu, daiKuanRen, cardId, healthState, wenHuaChengDu, laoDongNengLi, givenStars, shouXinEDu, shouXinDate, contactPhone, note, tianBaoDanWei, tianBiaoRen, tianBiaoRenLianXi, shenHeRen, tianBiaoDate, importDate, note1, note2, note3, note4, note5);
    }
}
