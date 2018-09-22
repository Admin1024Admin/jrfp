package com.ky.ct.rzdj.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_fpb_history", schema = "pashanhu", catalog = "")
public class BaseFpbHistory {
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operationDate;
    private String operationPerson;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkDate;
    private String checkPerson;
    private String checkStatus;
    private String reason;
    private String operation;
    private String delStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date delDate;

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

    @Basic
    @Column(name = "operationDate")
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    @Basic
    @Column(name = "operationPerson")
    public String getOperationPerson() {
        return operationPerson;
    }

    public void setOperationPerson(String operationPerson) {
        this.operationPerson = operationPerson;
    }

    @Basic
    @Column(name = "checkDate")
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "checkPerson")
    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    @Basic
    @Column(name = "checkStatus")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Basic
    @Column(name = "delStatus")
    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    @Basic
    @Column(name = "delDate")
    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseFpbHistory that = (BaseFpbHistory) o;

        if (id != that.id) return false;
        if (xiang != null ? !xiang.equals(that.xiang) : that.xiang != null) return false;
        if (chun != null ? !chun.equals(that.chun) : that.chun != null) return false;
        if (zu != null ? !zu.equals(that.zu) : that.zu != null) return false;
        if (huZhuName != null ? !huZhuName.equals(that.huZhuName) : that.huZhuName != null) return false;
        if (familyMemberName != null ? !familyMemberName.equals(that.familyMemberName) : that.familyMemberName != null)
            return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (familyRelation != null ? !familyRelation.equals(that.familyRelation) : that.familyRelation != null)
            return false;
        if (familyMemberCount != null ? !familyMemberCount.equals(that.familyMemberCount) : that.familyMemberCount != null)
            return false;
        if (baoFeiZongE != null ? !baoFeiZongE.equals(that.baoFeiZongE) : that.baoFeiZongE != null) return false;
        if (baoFeiZiFu != null ? !baoFeiZiFu.equals(that.baoFeiZiFu) : that.baoFeiZiFu != null) return false;
        if (baoFeiBuTie != null ? !baoFeiBuTie.equals(that.baoFeiBuTie) : that.baoFeiBuTie != null) return false;
        if (baoZhangJinE != null ? !baoZhangJinE.equals(that.baoZhangJinE) : that.baoZhangJinE != null) return false;
        if (baoZhangQiJian != null ? !baoZhangQiJian.equals(that.baoZhangQiJian) : that.baoZhangQiJian != null)
            return false;
        if (touBaoDate != null ? !touBaoDate.equals(that.touBaoDate) : that.touBaoDate != null) return false;
        if (daoQiDate != null ? !daoQiDate.equals(that.daoQiDate) : that.daoQiDate != null) return false;
        if (liPeiShiXiang != null ? !liPeiShiXiang.equals(that.liPeiShiXiang) : that.liPeiShiXiang != null)
            return false;
        if (liPeiDate != null ? !liPeiDate.equals(that.liPeiDate) : that.liPeiDate != null) return false;
        if (liPeiJinE != null ? !liPeiJinE.equals(that.liPeiJinE) : that.liPeiJinE != null) return false;
        if (liPeiShouYiRen != null ? !liPeiShouYiRen.equals(that.liPeiShouYiRen) : that.liPeiShouYiRen != null)
            return false;
        if (chengBaoJiGou != null ? !chengBaoJiGou.equals(that.chengBaoJiGou) : that.chengBaoJiGou != null)
            return false;
        if (touPinYear != null ? !touPinYear.equals(that.touPinYear) : that.touPinYear != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (shuJuWeiHuDanWei != null ? !shuJuWeiHuDanWei.equals(that.shuJuWeiHuDanWei) : that.shuJuWeiHuDanWei != null)
            return false;
        if (operationDate != null ? !operationDate.equals(that.operationDate) : that.operationDate != null)
            return false;
        if (operationPerson != null ? !operationPerson.equals(that.operationPerson) : that.operationPerson != null)
            return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (checkPerson != null ? !checkPerson.equals(that.checkPerson) : that.checkPerson != null) return false;
        if (checkStatus != null ? !checkStatus.equals(that.checkStatus) : that.checkStatus != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (delStatus != null ? !delStatus.equals(that.delStatus) : that.delStatus != null) return false;
        if (delDate != null ? !delDate.equals(that.delDate) : that.delDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (xiang != null ? xiang.hashCode() : 0);
        result = 31 * result + (chun != null ? chun.hashCode() : 0);
        result = 31 * result + (zu != null ? zu.hashCode() : 0);
        result = 31 * result + (huZhuName != null ? huZhuName.hashCode() : 0);
        result = 31 * result + (familyMemberName != null ? familyMemberName.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (familyRelation != null ? familyRelation.hashCode() : 0);
        result = 31 * result + (familyMemberCount != null ? familyMemberCount.hashCode() : 0);
        result = 31 * result + (baoFeiZongE != null ? baoFeiZongE.hashCode() : 0);
        result = 31 * result + (baoFeiZiFu != null ? baoFeiZiFu.hashCode() : 0);
        result = 31 * result + (baoFeiBuTie != null ? baoFeiBuTie.hashCode() : 0);
        result = 31 * result + (baoZhangJinE != null ? baoZhangJinE.hashCode() : 0);
        result = 31 * result + (baoZhangQiJian != null ? baoZhangQiJian.hashCode() : 0);
        result = 31 * result + (touBaoDate != null ? touBaoDate.hashCode() : 0);
        result = 31 * result + (daoQiDate != null ? daoQiDate.hashCode() : 0);
        result = 31 * result + (liPeiShiXiang != null ? liPeiShiXiang.hashCode() : 0);
        result = 31 * result + (liPeiDate != null ? liPeiDate.hashCode() : 0);
        result = 31 * result + (liPeiJinE != null ? liPeiJinE.hashCode() : 0);
        result = 31 * result + (liPeiShouYiRen != null ? liPeiShouYiRen.hashCode() : 0);
        result = 31 * result + (chengBaoJiGou != null ? chengBaoJiGou.hashCode() : 0);
        result = 31 * result + (touPinYear != null ? touPinYear.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (shuJuWeiHuDanWei != null ? shuJuWeiHuDanWei.hashCode() : 0);
        result = 31 * result + (operationDate != null ? operationDate.hashCode() : 0);
        result = 31 * result + (operationPerson != null ? operationPerson.hashCode() : 0);
        result = 31 * result + (checkDate != null ? checkDate.hashCode() : 0);
        result = 31 * result + (checkPerson != null ? checkPerson.hashCode() : 0);
        result = 31 * result + (checkStatus != null ? checkStatus.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        result = 31 * result + (delStatus != null ? delStatus.hashCode() : 0);
        result = 31 * result + (delDate != null ? delDate.hashCode() : 0);
        return result;
    }
}
