package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pkf_fpxexdtz", schema = "pashanhu", catalog = "")
public class PkfFpxexdtzEntity {
    private long uid;
    private Integer no;
    private String xiangZhen;
    private String chun;
    private String huZhu;
    private String familyMember;
    private String cardId;
    private Integer familyMemberCount;
    private String familyRelation;
    private String givenStars;
    private String pingJiJiGou;
    private Double shouXinEDu;
    private String shouXinDate;
    private String isQueryZhengXin;
    private String shouXinZiLiaoOk;
    private String daiKuanRen;
    private String isHuZhu;
    private Double daiKuanBenJin;
    private Double daiKuanYuE;
    private String daiKuanTimeLimit;
    private String fangKuanDate;
    private String huanKuanDate;
    private String daiKuanLiLv;
    private String leiJiTieXi;
    private String huanBenJinE;
    private String huanBenDate;
    private String benJinYuQiJinE;
    private String benJinYuQiDate;
    private String qianXiJinE;
    private String qianXiDate;
    private String daiKuanZiLiaoOk;
    private String ziJinShiYongOk;
    private String daiKuanJiGou;
    private Date tongJiDate;
    private String note;
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
    @Column(name = "Chun")
    public String getChun() {
        return chun;
    }

    public void setChun(String chun) {
        this.chun = chun;
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
    @Column(name = "FamilyMember")
    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
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
    @Column(name = "FamilyMemberCount")
    public Integer getFamilyMemberCount() {
        return familyMemberCount;
    }

    public void setFamilyMemberCount(Integer familyMemberCount) {
        this.familyMemberCount = familyMemberCount;
    }

    @Basic
    @Column(name = "FamilyRelation")
    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
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
    @Column(name = "PingJiJiGou")
    public String getPingJiJiGou() {
        return pingJiJiGou;
    }

    public void setPingJiJiGou(String pingJiJiGou) {
        this.pingJiJiGou = pingJiJiGou;
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
    public String getShouXinDate() {
        return shouXinDate;
    }

    public void setShouXinDate(String shouXinDate) {
        this.shouXinDate = shouXinDate;
    }

    @Basic
    @Column(name = "IsQueryZhengXin")
    public String getIsQueryZhengXin() {
        return isQueryZhengXin;
    }

    public void setIsQueryZhengXin(String isQueryZhengXin) {
        this.isQueryZhengXin = isQueryZhengXin;
    }

    @Basic
    @Column(name = "ShouXinZiLiaoOk")
    public String getShouXinZiLiaoOk() {
        return shouXinZiLiaoOk;
    }

    public void setShouXinZiLiaoOk(String shouXinZiLiaoOk) {
        this.shouXinZiLiaoOk = shouXinZiLiaoOk;
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
    @Column(name = "IsHuZhu")
    public String getIsHuZhu() {
        return isHuZhu;
    }

    public void setIsHuZhu(String isHuZhu) {
        this.isHuZhu = isHuZhu;
    }

    @Basic
    @Column(name = "DaiKuanBenJin")
    public Double getDaiKuanBenJin() {
        return daiKuanBenJin;
    }

    public void setDaiKuanBenJin(Double daiKuanBenJin) {
        this.daiKuanBenJin = daiKuanBenJin;
    }

    @Basic
    @Column(name = "DaiKuanYuE")
    public Double getDaiKuanYuE() {
        return daiKuanYuE;
    }

    public void setDaiKuanYuE(Double daiKuanYuE) {
        this.daiKuanYuE = daiKuanYuE;
    }

    @Basic
    @Column(name = "DaiKuanTimeLimit")
    public String getDaiKuanTimeLimit() {
        return daiKuanTimeLimit;
    }

    public void setDaiKuanTimeLimit(String daiKuanTimeLimit) {
        this.daiKuanTimeLimit = daiKuanTimeLimit;
    }

    @Basic
    @Column(name = "FangKuanDate")
    public String getFangKuanDate() {
        return fangKuanDate;
    }

    public void setFangKuanDate(String fangKuanDate) {
        this.fangKuanDate = fangKuanDate;
    }

    @Basic
    @Column(name = "HuanKuanDate")
    public String getHuanKuanDate() {
        return huanKuanDate;
    }

    public void setHuanKuanDate(String huanKuanDate) {
        this.huanKuanDate = huanKuanDate;
    }

    @Basic
    @Column(name = "DaiKuanLiLv")
    public String getDaiKuanLiLv() {
        return daiKuanLiLv;
    }

    public void setDaiKuanLiLv(String daiKuanLiLv) {
        this.daiKuanLiLv = daiKuanLiLv;
    }

    @Basic
    @Column(name = "LeiJiTieXi")
    public String getLeiJiTieXi() {
        return leiJiTieXi;
    }

    public void setLeiJiTieXi(String leiJiTieXi) {
        this.leiJiTieXi = leiJiTieXi;
    }

    @Basic
    @Column(name = "HuanBenJinE")
    public String getHuanBenJinE() {
        return huanBenJinE;
    }

    public void setHuanBenJinE(String huanBenJinE) {
        this.huanBenJinE = huanBenJinE;
    }

    @Basic
    @Column(name = "HuanBenDate")
    public String getHuanBenDate() {
        return huanBenDate;
    }

    public void setHuanBenDate(String huanBenDate) {
        this.huanBenDate = huanBenDate;
    }

    @Basic
    @Column(name = "BenJinYuQiJinE")
    public String getBenJinYuQiJinE() {
        return benJinYuQiJinE;
    }

    public void setBenJinYuQiJinE(String benJinYuQiJinE) {
        this.benJinYuQiJinE = benJinYuQiJinE;
    }

    @Basic
    @Column(name = "BenJinYuQiDate")
    public String getBenJinYuQiDate() {
        return benJinYuQiDate;
    }

    public void setBenJinYuQiDate(String benJinYuQiDate) {
        this.benJinYuQiDate = benJinYuQiDate;
    }

    @Basic
    @Column(name = "QianXiJinE")
    public String getQianXiJinE() {
        return qianXiJinE;
    }

    public void setQianXiJinE(String qianXiJinE) {
        this.qianXiJinE = qianXiJinE;
    }

    @Basic
    @Column(name = "QianXiDate")
    public String getQianXiDate() {
        return qianXiDate;
    }

    public void setQianXiDate(String qianXiDate) {
        this.qianXiDate = qianXiDate;
    }

    @Basic
    @Column(name = "DaiKuanZiLiaoOk")
    public String getDaiKuanZiLiaoOk() {
        return daiKuanZiLiaoOk;
    }

    public void setDaiKuanZiLiaoOk(String daiKuanZiLiaoOk) {
        this.daiKuanZiLiaoOk = daiKuanZiLiaoOk;
    }

    @Basic
    @Column(name = "ZiJinShiYongOk")
    public String getZiJinShiYongOk() {
        return ziJinShiYongOk;
    }

    public void setZiJinShiYongOk(String ziJinShiYongOk) {
        this.ziJinShiYongOk = ziJinShiYongOk;
    }

    @Basic
    @Column(name = "DaiKuanJiGou")
    public String getDaiKuanJiGou() {
        return daiKuanJiGou;
    }

    public void setDaiKuanJiGou(String daiKuanJiGou) {
        this.daiKuanJiGou = daiKuanJiGou;
    }

    @Basic
    @Column(name = "TongJiDate")
    public Date getTongJiDate() {
        return tongJiDate;
    }

    public void setTongJiDate(Date tongJiDate) {
        this.tongJiDate = tongJiDate;
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
        PkfFpxexdtzEntity that = (PkfFpxexdtzEntity) o;
        return uid == that.uid &&
                Objects.equals(no, that.no) &&
                Objects.equals(xiangZhen, that.xiangZhen) &&
                Objects.equals(chun, that.chun) &&
                Objects.equals(huZhu, that.huZhu) &&
                Objects.equals(familyMember, that.familyMember) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(familyMemberCount, that.familyMemberCount) &&
                Objects.equals(familyRelation, that.familyRelation) &&
                Objects.equals(givenStars, that.givenStars) &&
                Objects.equals(pingJiJiGou, that.pingJiJiGou) &&
                Objects.equals(shouXinEDu, that.shouXinEDu) &&
                Objects.equals(shouXinDate, that.shouXinDate) &&
                Objects.equals(isQueryZhengXin, that.isQueryZhengXin) &&
                Objects.equals(shouXinZiLiaoOk, that.shouXinZiLiaoOk) &&
                Objects.equals(daiKuanRen, that.daiKuanRen) &&
                Objects.equals(isHuZhu, that.isHuZhu) &&
                Objects.equals(daiKuanBenJin, that.daiKuanBenJin) &&
                Objects.equals(daiKuanYuE, that.daiKuanYuE) &&
                Objects.equals(daiKuanTimeLimit, that.daiKuanTimeLimit) &&
                Objects.equals(fangKuanDate, that.fangKuanDate) &&
                Objects.equals(huanKuanDate, that.huanKuanDate) &&
                Objects.equals(daiKuanLiLv, that.daiKuanLiLv) &&
                Objects.equals(leiJiTieXi, that.leiJiTieXi) &&
                Objects.equals(huanBenJinE, that.huanBenJinE) &&
                Objects.equals(huanBenDate, that.huanBenDate) &&
                Objects.equals(benJinYuQiJinE, that.benJinYuQiJinE) &&
                Objects.equals(benJinYuQiDate, that.benJinYuQiDate) &&
                Objects.equals(qianXiJinE, that.qianXiJinE) &&
                Objects.equals(qianXiDate, that.qianXiDate) &&
                Objects.equals(daiKuanZiLiaoOk, that.daiKuanZiLiaoOk) &&
                Objects.equals(ziJinShiYongOk, that.ziJinShiYongOk) &&
                Objects.equals(daiKuanJiGou, that.daiKuanJiGou) &&
                Objects.equals(tongJiDate, that.tongJiDate) &&
                Objects.equals(note, that.note) &&
                Objects.equals(importDate, that.importDate) &&
                Objects.equals(note1, that.note1) &&
                Objects.equals(note2, that.note2) &&
                Objects.equals(note3, that.note3) &&
                Objects.equals(note4, that.note4) &&
                Objects.equals(note5, that.note5);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, no, xiangZhen, chun, huZhu, familyMember, cardId, familyMemberCount, familyRelation, givenStars, pingJiJiGou, shouXinEDu, shouXinDate, isQueryZhengXin, shouXinZiLiaoOk, daiKuanRen, isHuZhu, daiKuanBenJin, daiKuanYuE, daiKuanTimeLimit, fangKuanDate, huanKuanDate, daiKuanLiLv, leiJiTieXi, huanBenJinE, huanBenDate, benJinYuQiJinE, benJinYuQiDate, qianXiJinE, qianXiDate, daiKuanZiLiaoOk, ziJinShiYongOk, daiKuanJiGou, tongJiDate, note, importDate, note1, note2, note3, note4, note5);
    }
}
