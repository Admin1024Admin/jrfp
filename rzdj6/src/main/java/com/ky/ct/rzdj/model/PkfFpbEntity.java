package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pkf_fpb", schema = "pashanhu", catalog = "")
public class PkfFpbEntity {
    private long uid;
    private int no;
    private String touBaoRen;
    private String beiBaoRen;
    private String gender;
    private String bornDate;
    private String zhiYeCode;
    private String cardIdType;
    private String cardId;
    private String shouYiRen;
    private String beiBaoRenSign;
    private String note;
    private String huiJiaoRen;
    private String touBaoCompany;
    private String touBaoYear;
    private String xianZhong;
    private Timestamp importDate;
    private String billNo;
    private Double baoE;
    private Double baoFei;
    private String note1;
    private String note2;
    private String note3;
    private String note4;
    private String note5;
    private String attachment1;
    private String attachment2;
    private String attachment3;
    private String attachment4;
    private String attachment5;
    private String attachment6;
    private String attachment7;
    private String attachment8;
    private String attachment9;
    private String attachment10;

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
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Basic
    @Column(name = "TouBaoRen")
    public String getTouBaoRen() {
        return touBaoRen;
    }

    public void setTouBaoRen(String touBaoRen) {
        this.touBaoRen = touBaoRen;
    }

    @Basic
    @Column(name = "BeiBaoRen")
    public String getBeiBaoRen() {
        return beiBaoRen;
    }

    public void setBeiBaoRen(String beiBaoRen) {
        this.beiBaoRen = beiBaoRen;
    }

    @Basic
    @Column(name = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "BornDate")
    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    @Basic
    @Column(name = "ZhiYeCode")
    public String getZhiYeCode() {
        return zhiYeCode;
    }

    public void setZhiYeCode(String zhiYeCode) {
        this.zhiYeCode = zhiYeCode;
    }

    @Basic
    @Column(name = "CardIDType")
    public String getCardIdType() {
        return cardIdType;
    }

    public void setCardIdType(String cardIdType) {
        this.cardIdType = cardIdType;
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
    @Column(name = "ShouYiRen")
    public String getShouYiRen() {
        return shouYiRen;
    }

    public void setShouYiRen(String shouYiRen) {
        this.shouYiRen = shouYiRen;
    }

    @Basic
    @Column(name = "BeiBaoRenSign")
    public String getBeiBaoRenSign() {
        return beiBaoRenSign;
    }

    public void setBeiBaoRenSign(String beiBaoRenSign) {
        this.beiBaoRenSign = beiBaoRenSign;
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
    @Column(name = "HuiJiaoRen")
    public String getHuiJiaoRen() {
        return huiJiaoRen;
    }

    public void setHuiJiaoRen(String huiJiaoRen) {
        this.huiJiaoRen = huiJiaoRen;
    }

    @Basic
    @Column(name = "TouBaoCompany")
    public String getTouBaoCompany() {
        return touBaoCompany;
    }

    public void setTouBaoCompany(String touBaoCompany) {
        this.touBaoCompany = touBaoCompany;
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
    @Column(name = "XianZhong")
    public String getXianZhong() {
        return xianZhong;
    }

    public void setXianZhong(String xianZhong) {
        this.xianZhong = xianZhong;
    }

    @Basic
    @Column(name = "ImportDate")
    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    @Basic
    @Column(name = "BillNo")
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    @Basic
    @Column(name = "BaoE")
    public Double getBaoE() {
        return baoE;
    }

    public void setBaoE(Double baoE) {
        this.baoE = baoE;
    }

    @Basic
    @Column(name = "BaoFei")
    public Double getBaoFei() {
        return baoFei;
    }

    public void setBaoFei(Double baoFei) {
        this.baoFei = baoFei;
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

    @Basic
    @Column(name = "Attachment1")
    public String getAttachment1() {
        return attachment1;
    }

    public void setAttachment1(String attachment1) {
        this.attachment1 = attachment1;
    }

    @Basic
    @Column(name = "Attachment2")
    public String getAttachment2() {
        return attachment2;
    }

    public void setAttachment2(String attachment2) {
        this.attachment2 = attachment2;
    }

    @Basic
    @Column(name = "Attachment3")
    public String getAttachment3() {
        return attachment3;
    }

    public void setAttachment3(String attachment3) {
        this.attachment3 = attachment3;
    }

    @Basic
    @Column(name = "Attachment4")
    public String getAttachment4() {
        return attachment4;
    }

    public void setAttachment4(String attachment4) {
        this.attachment4 = attachment4;
    }

    @Basic
    @Column(name = "Attachment5")
    public String getAttachment5() {
        return attachment5;
    }

    public void setAttachment5(String attachment5) {
        this.attachment5 = attachment5;
    }

    @Basic
    @Column(name = "Attachment6")
    public String getAttachment6() {
        return attachment6;
    }

    public void setAttachment6(String attachment6) {
        this.attachment6 = attachment6;
    }

    @Basic
    @Column(name = "Attachment7")
    public String getAttachment7() {
        return attachment7;
    }

    public void setAttachment7(String attachment7) {
        this.attachment7 = attachment7;
    }

    @Basic
    @Column(name = "Attachment8")
    public String getAttachment8() {
        return attachment8;
    }

    public void setAttachment8(String attachment8) {
        this.attachment8 = attachment8;
    }

    @Basic
    @Column(name = "Attachment9")
    public String getAttachment9() {
        return attachment9;
    }

    public void setAttachment9(String attachment9) {
        this.attachment9 = attachment9;
    }

    @Basic
    @Column(name = "Attachment10")
    public String getAttachment10() {
        return attachment10;
    }

    public void setAttachment10(String attachment10) {
        this.attachment10 = attachment10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PkfFpbEntity that = (PkfFpbEntity) o;
        return uid == that.uid &&
                Objects.equals(no, that.no) &&
                Objects.equals(touBaoRen, that.touBaoRen) &&
                Objects.equals(beiBaoRen, that.beiBaoRen) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(bornDate, that.bornDate) &&
                Objects.equals(zhiYeCode, that.zhiYeCode) &&
                Objects.equals(cardIdType, that.cardIdType) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(shouYiRen, that.shouYiRen) &&
                Objects.equals(beiBaoRenSign, that.beiBaoRenSign) &&
                Objects.equals(note, that.note) &&
                Objects.equals(huiJiaoRen, that.huiJiaoRen) &&
                Objects.equals(touBaoCompany, that.touBaoCompany) &&
                Objects.equals(touBaoYear, that.touBaoYear) &&
                Objects.equals(xianZhong, that.xianZhong) &&
                Objects.equals(importDate, that.importDate) &&
                Objects.equals(billNo, that.billNo) &&
                Objects.equals(baoE, that.baoE) &&
                Objects.equals(baoFei, that.baoFei) &&
                Objects.equals(note1, that.note1) &&
                Objects.equals(note2, that.note2) &&
                Objects.equals(note3, that.note3) &&
                Objects.equals(note4, that.note4) &&
                Objects.equals(note5, that.note5) &&
                Objects.equals(attachment1, that.attachment1) &&
                Objects.equals(attachment2, that.attachment2) &&
                Objects.equals(attachment3, that.attachment3) &&
                Objects.equals(attachment4, that.attachment4) &&
                Objects.equals(attachment5, that.attachment5) &&
                Objects.equals(attachment6, that.attachment6) &&
                Objects.equals(attachment7, that.attachment7) &&
                Objects.equals(attachment8, that.attachment8) &&
                Objects.equals(attachment9, that.attachment9) &&
                Objects.equals(attachment10, that.attachment10);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, no, touBaoRen, beiBaoRen, gender, bornDate, zhiYeCode, cardIdType, cardId, shouYiRen, beiBaoRenSign, note, huiJiaoRen, touBaoCompany, touBaoYear, xianZhong, importDate, billNo, baoE, baoFei, note1, note2, note3, note4, note5, attachment1, attachment2, attachment3, attachment4, attachment5, attachment6, attachment7, attachment8, attachment9, attachment10);
    }

    @Override
    public String toString() {
        return "PkfFpbEntity{" +
                "uid=" + uid +
                ", no='" + no + '\'' +
                ", touBaoRen='" + touBaoRen + '\'' +
                ", beiBaoRen='" + beiBaoRen + '\'' +
                ", gender='" + gender + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", zhiYeCode='" + zhiYeCode + '\'' +
                ", cardIdType='" + cardIdType + '\'' +
                ", cardId='" + cardId + '\'' +
                ", shouYiRen='" + shouYiRen + '\'' +
                ", beiBaoRenSign='" + beiBaoRenSign + '\'' +
                ", note='" + note + '\'' +
                ", huiJiaoRen='" + huiJiaoRen + '\'' +
                ", touBaoCompany='" + touBaoCompany + '\'' +
                ", touBaoYear='" + touBaoYear + '\'' +
                ", xianZhong='" + xianZhong + '\'' +
                ", importDate=" + importDate +
                ", billNo='" + billNo + '\'' +
                ", baoE=" + baoE +
                ", baoFei=" + baoFei +
                ", note1='" + note1 + '\'' +
                ", note2='" + note2 + '\'' +
                ", note3='" + note3 + '\'' +
                ", note4='" + note4 + '\'' +
                ", note5='" + note5 + '\'' +
                ", attachment1='" + attachment1 + '\'' +
                ", attachment2='" + attachment2 + '\'' +
                ", attachment3='" + attachment3 + '\'' +
                ", attachment4='" + attachment4 + '\'' +
                ", attachment5='" + attachment5 + '\'' +
                ", attachment6='" + attachment6 + '\'' +
                ", attachment7='" + attachment7 + '\'' +
                ", attachment8='" + attachment8 + '\'' +
                ", attachment9='" + attachment9 + '\'' +
                ", attachment10='" + attachment10 + '\'' +
                '}';
    }
}
