package com.ky.ct.rzdj.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_fpb", schema = "pashanhu", catalog = "")
public class BaseFpb {
    private Integer id;
    private String xiang;
    private String chun;
    private String zu;
    private String huZhuName;
    private String familyMemberName;
    private String cardId;
    private String familyRelation;
    private Integer familyMemberCount;
    private Double baoFeiZongE;
    private Double baoFeiZiFu;
    private Double baoFeiBuTie;
    private Double baoZhangJinE;
    private String baoZhangQiJian;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date touBaoDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date daoQiDate;
    private String liPeiShiXiang;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date liPeiDate;
    private Double liPeiJinE;
    private String liPeiShouYiRen;
    private String chengBaoJiGou;
    private String touPinYear;
    private String note;
    private String shuJuWeiHuDanWei;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "xiang")
    public String getXiang() {
        return xiang;
    }

    public void setXiang(String xiang) {
        this.xiang = xiang;
    }

    @Basic
    @Column(name = "chun")
    public String getChun() {
        return chun;
    }

    public void setChun(String chun) {
        this.chun = chun;
    }

    @Basic
    @Column(name = "zu")
    public String getZu() {
        return zu;
    }

    public void setZu(String zu) {
        this.zu = zu;
    }

    @Basic
    @Column(name = "huZhuName")
    public String getHuZhuName() {
        return huZhuName;
    }

    public void setHuZhuName(String huZhuName) {
        this.huZhuName = huZhuName;
    }

    @Basic
    @Column(name = "familyMemberName")
    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    @Basic
    @Column(name = "cardId")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "familyRelation")
    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    @Basic
    @Column(name = "familyMemberCount")
    public Integer getFamilyMemberCount() {
        return familyMemberCount;
    }

    public void setFamilyMemberCount(Integer familyMemberCount) {
        this.familyMemberCount = familyMemberCount;
    }

    @Basic
    @Column(name = "baoFeiZongE")
    public Double getBaoFeiZongE() {
        return baoFeiZongE;
    }

    public void setBaoFeiZongE(Double baoFeiZongE) {
        this.baoFeiZongE = baoFeiZongE;
    }

    @Basic
    @Column(name = "baoFeiZiFu")
    public Double getBaoFeiZiFu() {
        return baoFeiZiFu;
    }

    public void setBaoFeiZiFu(Double baoFeiZiFu) {
        this.baoFeiZiFu = baoFeiZiFu;
    }

    @Basic
    @Column(name = "baoFeiBuTie")
    public Double getBaoFeiBuTie() {
        return baoFeiBuTie;
    }

    public void setBaoFeiBuTie(Double baoFeiBuTie) {
        this.baoFeiBuTie = baoFeiBuTie;
    }

    @Basic
    @Column(name = "baoZhangJinE")
    public Double getBaoZhangJinE() {
        return baoZhangJinE;
    }

    public void setBaoZhangJinE(Double baoZhangJinE) {
        this.baoZhangJinE = baoZhangJinE;
    }

    @Basic
    @Column(name = "baoZhangQiJian")
    public String getBaoZhangQiJian() {
        return baoZhangQiJian;
    }

    public void setBaoZhangQiJian(String baoZhangQiJian) {
        this.baoZhangQiJian = baoZhangQiJian;
    }

    @Basic
    @Column(name = "touBaoDate")
    public Date getTouBaoDate() {
        return touBaoDate;
    }

    public void setTouBaoDate(Date touBaoDate) {
        this.touBaoDate = touBaoDate;
    }

    @Basic
    @Column(name = "daoQiDate")
    public Date getDaoQiDate() {
        return daoQiDate;
    }

    public void setDaoQiDate(Date daoQiDate) {
        this.daoQiDate = daoQiDate;
    }

    @Basic
    @Column(name = "liPeiShiXiang")
    public String getLiPeiShiXiang() {
        return liPeiShiXiang;
    }

    public void setLiPeiShiXiang(String liPeiShiXiang) {
        this.liPeiShiXiang = liPeiShiXiang;
    }

    @Basic
    @Column(name = "liPeiDate")
    public Date getLiPeiDate() {
        return liPeiDate;
    }

    public void setLiPeiDate(Date liPeiDate) {
        this.liPeiDate = liPeiDate;
    }

    @Basic
    @Column(name = "liPeiJinE")
    public Double getLiPeiJinE() {
        return liPeiJinE;
    }

    public void setLiPeiJinE(Double liPeiJinE) {
        this.liPeiJinE = liPeiJinE;
    }

    @Basic
    @Column(name = "liPeiShouYiRen")
    public String getLiPeiShouYiRen() {
        return liPeiShouYiRen;
    }

    public void setLiPeiShouYiRen(String liPeiShouYiRen) {
        this.liPeiShouYiRen = liPeiShouYiRen;
    }

    @Basic
    @Column(name = "chengBaoJiGou")
    public String getChengBaoJiGou() {
        return chengBaoJiGou;
    }

    public void setChengBaoJiGou(String chengBaoJiGou) {
        this.chengBaoJiGou = chengBaoJiGou;
    }

    @Basic
    @Column(name = "touPinYear")
    public String getTouPinYear() {
        return touPinYear;
    }

    public void setTouPinYear(String touPinYear) {
        this.touPinYear = touPinYear;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "shuJuWeiHuDanWei")
    public String getShuJuWeiHuDanWei() {
        return shuJuWeiHuDanWei;
    }

    public void setShuJuWeiHuDanWei(String shuJuWeiHuDanWei) {
        this.shuJuWeiHuDanWei = shuJuWeiHuDanWei;
    }

    @Override
    public String toString() {
        return "BaseFpb{" +
                "id=" + id +
                ", xiang='" + xiang + '\'' +
                ", chun='" + chun + '\'' +
                ", zu='" + zu + '\'' +
                ", huZhuName='" + huZhuName + '\'' +
                ", familyMemberName='" + familyMemberName + '\'' +
                ", cardId='" + cardId + '\'' +
                ", familyRelation='" + familyRelation + '\'' +
                ", familyMemberCount=" + familyMemberCount +
                ", baoFeiZongE=" + baoFeiZongE +
                ", baoFeiZiFu=" + baoFeiZiFu +
                ", baoFeiBuTie=" + baoFeiBuTie +
                ", baoZhangJinE=" + baoZhangJinE +
                ", baoZhangQiJian='" + baoZhangQiJian + '\'' +
                ", touBaoDate=" + touBaoDate +
                ", daoQiDate=" + daoQiDate +
                ", liPeiShiXiang='" + liPeiShiXiang + '\'' +
                ", liPeiDate=" + liPeiDate +
                ", liPeiJinE=" + liPeiJinE +
                ", liPeiShouYiRen='" + liPeiShouYiRen + '\'' +
                ", chengBaoJiGou='" + chengBaoJiGou + '\'' +
                ", touPinYear='" + touPinYear + '\'' +
                ", note='" + note + '\'' +
                ", shuJuWeiHuDanWei='" + shuJuWeiHuDanWei + '\'' +
                '}';
    }
}
