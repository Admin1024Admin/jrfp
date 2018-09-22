package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "base_qtgrjzfpdk_history", schema = "pashanhu", catalog = "")
public class BaseQtgrjzfpdkHistory implements Serializable {
    private Integer uid;
    private String name;
    private String cardId;
    private String address;
    private String telephone;
    private String agreementNo;
    private Double daiKuanJinE;
    private String daiKuanQiXian;
    private Date daiKuanDate;
    private Date daoQiDate;
    private Double daiKuanLiLv;
    private String daiKuanZhongLei;
    private String daiKuanFangShi;
    private String daiKuanYongTu;
    private String shiYongDiYu;
    private String chanYeLeiBie;
    private String fuPinDaiKuanLeiBie;
    private String zhuTiDaiKuanLeiBie;
    private String daiKuanJinRongJiGou;
    private Date touFangDate;
    private Double touFangJinE;
    private Double leiJiTouFangJinE;
    private Double weiTouFangYuE;
    private Double changHuanJinE;
    private Date changHuanDate;
    private Double leiJiChangHuanJinE;
    private Double weiChangHuanYuE;
    private Double yuQiJinE;
    private Date yuQiDate;
    private Date qianXiDate;
    private Double qianXiJinE;
    private String liYiLianJieFangShi;
    private String daiDongPkhMingDan;
    private Integer daiDongPkRenKouShu;
    private Double zhiJieDaiDongXiaoYi;
    private String note;
    private Date operationDate;
    private String shuJuWeiHuDanWei;
    private String operationPerson;
    private Date checkDate;
    private String checkPerson;
    private String checkStatus;
    private String reason;
    private String operation;
    private String delStatus;
    private Date delDate;
    private String t1;
    private String t2;
    private String t3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "agreementNo")
    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    @Basic
    @Column(name = "daiKuanJinE")
    public Double getDaiKuanJinE() {
        return daiKuanJinE;
    }

    public void setDaiKuanJinE(Double daiKuanJinE) {
        this.daiKuanJinE = daiKuanJinE;
    }

    @Basic
    @Column(name = "daiKuanQiXian")
    public String getDaiKuanQiXian() {
        return daiKuanQiXian;
    }

    public void setDaiKuanQiXian(String daiKuanQiXian) {
        this.daiKuanQiXian = daiKuanQiXian;
    }

    @Basic
    @Column(name = "daiKuanDate")
    public Date getDaiKuanDate() {
        return daiKuanDate;
    }

    public void setDaiKuanDate(Date daiKuanDate) {
        this.daiKuanDate = daiKuanDate;
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
    @Column(name = "daiKuanLiLv")
    public Double getDaiKuanLiLv() {
        return daiKuanLiLv;
    }

    public void setDaiKuanLiLv(Double daiKuanLiLv) {
        this.daiKuanLiLv = daiKuanLiLv;
    }

    @Basic
    @Column(name = "daiKuanZhongLei")
    public String getDaiKuanZhongLei() {
        return daiKuanZhongLei;
    }

    public void setDaiKuanZhongLei(String daiKuanZhongLei) {
        this.daiKuanZhongLei = daiKuanZhongLei;
    }

    @Basic
    @Column(name = "daiKuanFangShi")
    public String getDaiKuanFangShi() {
        return daiKuanFangShi;
    }

    public void setDaiKuanFangShi(String daiKuanFangShi) {
        this.daiKuanFangShi = daiKuanFangShi;
    }

    @Basic
    @Column(name = "daiKuanYongTu")
    public String getDaiKuanYongTu() {
        return daiKuanYongTu;
    }

    public void setDaiKuanYongTu(String daiKuanYongTu) {
        this.daiKuanYongTu = daiKuanYongTu;
    }

    @Basic
    @Column(name = "shiYongDiYu")
    public String getShiYongDiYu() {
        return shiYongDiYu;
    }

    public void setShiYongDiYu(String shiYongDiYu) {
        this.shiYongDiYu = shiYongDiYu;
    }

    @Basic
    @Column(name = "chanYeLeiBie")
    public String getChanYeLeiBie() {
        return chanYeLeiBie;
    }

    public void setChanYeLeiBie(String chanYeLeiBie) {
        this.chanYeLeiBie = chanYeLeiBie;
    }

    @Basic
    @Column(name = "fuPinDaiKuanLeiBie")
    public String getFuPinDaiKuanLeiBie() {
        return fuPinDaiKuanLeiBie;
    }

    public void setFuPinDaiKuanLeiBie(String fuPinDaiKuanLeiBie) {
        this.fuPinDaiKuanLeiBie = fuPinDaiKuanLeiBie;
    }

    @Basic
    @Column(name = "zhuTiDaiKuanLeiBie")
    public String getZhuTiDaiKuanLeiBie() {
        return zhuTiDaiKuanLeiBie;
    }

    public void setZhuTiDaiKuanLeiBie(String zhuTiDaiKuanLeiBie) {
        this.zhuTiDaiKuanLeiBie = zhuTiDaiKuanLeiBie;
    }

    @Basic
    @Column(name = "daiKuanJinRongJiGou")
    public String getDaiKuanJinRongJiGou() {
        return daiKuanJinRongJiGou;
    }

    public void setDaiKuanJinRongJiGou(String daiKuanJinRongJiGou) {
        this.daiKuanJinRongJiGou = daiKuanJinRongJiGou;
    }

    @Basic
    @Column(name = "touFangDate")
    public Date getTouFangDate() {
        return touFangDate;
    }

    public void setTouFangDate(Date touFangDate) {
        this.touFangDate = touFangDate;
    }

    @Basic
    @Column(name = "touFangJinE")
    public Double getTouFangJinE() {
        return touFangJinE;
    }

    public void setTouFangJinE(Double touFangJinE) {
        this.touFangJinE = touFangJinE;
    }

    @Basic
    @Column(name = "leiJiTouFangJinE")
    public Double getLeiJiTouFangJinE() {
        return leiJiTouFangJinE;
    }

    public void setLeiJiTouFangJinE(Double leiJiTouFangJinE) {
        this.leiJiTouFangJinE = leiJiTouFangJinE;
    }

    @Basic
    @Column(name = "weiTouFangYuE")
    public Double getWeiTouFangYuE() {
        return weiTouFangYuE;
    }

    public void setWeiTouFangYuE(Double weiTouFangYuE) {
        this.weiTouFangYuE = weiTouFangYuE;
    }

    @Basic
    @Column(name = "changHuanJinE")
    public Double getChangHuanJinE() {
        return changHuanJinE;
    }

    public void setChangHuanJinE(Double changHuanJinE) {
        this.changHuanJinE = changHuanJinE;
    }

    @Basic
    @Column(name = "changHuanDate")
    public Date getChangHuanDate() {
        return changHuanDate;
    }

    public void setChangHuanDate(Date changHuanDate) {
        this.changHuanDate = changHuanDate;
    }

    @Basic
    @Column(name = "leiJiChangHuanJinE")
    public Double getLeiJiChangHuanJinE() {
        return leiJiChangHuanJinE;
    }

    public void setLeiJiChangHuanJinE(Double leiJiChangHuanJinE) {
        this.leiJiChangHuanJinE = leiJiChangHuanJinE;
    }

    @Basic
    @Column(name = "weiChangHuanYuE")
    public Double getWeiChangHuanYuE() {
        return weiChangHuanYuE;
    }

    public void setWeiChangHuanYuE(Double weiChangHuanYuE) {
        this.weiChangHuanYuE = weiChangHuanYuE;
    }

    @Basic
    @Column(name = "yuQiJinE")
    public Double getYuQiJinE() {
        return yuQiJinE;
    }

    public void setYuQiJinE(Double yuQiJinE) {
        this.yuQiJinE = yuQiJinE;
    }

    @Basic
    @Column(name = "yuQiDate")
    public Date getYuQiDate() {
        return yuQiDate;
    }

    public void setYuQiDate(Date yuQiDate) {
        this.yuQiDate = yuQiDate;
    }

    @Basic
    @Column(name = "qianXiDate")
    public Date getQianXiDate() {
        return qianXiDate;
    }

    public void setQianXiDate(Date qianXiDate) {
        this.qianXiDate = qianXiDate;
    }

    @Basic
    @Column(name = "qianXiJinE")
    public Double getQianXiJinE() {
        return qianXiJinE;
    }

    public void setQianXiJinE(Double qianXiJinE) {
        this.qianXiJinE = qianXiJinE;
    }

    @Basic
    @Column(name = "liYiLianJieFangShi")
    public String getLiYiLianJieFangShi() {
        return liYiLianJieFangShi;
    }

    public void setLiYiLianJieFangShi(String liYiLianJieFangShi) {
        this.liYiLianJieFangShi = liYiLianJieFangShi;
    }

    @Basic
    @Column(name = "daiDongPkhMingDan")
    public String getDaiDongPkhMingDan() {
        return daiDongPkhMingDan;
    }

    public void setDaiDongPkhMingDan(String daiDongPkhMingDan) {
        this.daiDongPkhMingDan = daiDongPkhMingDan;
    }

    @Basic
    @Column(name = "daiDongPkRenKouShu")
    public Integer getDaiDongPkRenKouShu() {
        return daiDongPkRenKouShu;
    }

    public void setDaiDongPkRenKouShu(Integer daiDongPkRenKouShu) {
        this.daiDongPkRenKouShu = daiDongPkRenKouShu;
    }

    @Basic
    @Column(name = "zhiJieDaiDongXiaoYi")
    public Double getZhiJieDaiDongXiaoYi() {
        return zhiJieDaiDongXiaoYi;
    }

    public void setZhiJieDaiDongXiaoYi(Double zhiJieDaiDongXiaoYi) {
        this.zhiJieDaiDongXiaoYi = zhiJieDaiDongXiaoYi;
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
    @Column(name = "operationDate")
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
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

    @Transient
    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }
    @Transient
    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }
    @Transient
    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    @Override
    public String toString() {
        return "BaseQtgrjzfpdkHistory{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", agreementNo='" + agreementNo + '\'' +
                ", daiKuanJinE=" + daiKuanJinE +
                ", daiKuanQiXian='" + daiKuanQiXian + '\'' +
                ", daiKuanDate=" + daiKuanDate +
                ", daoQiDate=" + daoQiDate +
                ", daiKuanLiLv=" + daiKuanLiLv +
                ", daiKuanZhongLei='" + daiKuanZhongLei + '\'' +
                ", daiKuanFangShi='" + daiKuanFangShi + '\'' +
                ", daiKuanYongTu='" + daiKuanYongTu + '\'' +
                ", shiYongDiYu='" + shiYongDiYu + '\'' +
                ", chanYeLeiBie='" + chanYeLeiBie + '\'' +
                ", fuPinDaiKuanLeiBie='" + fuPinDaiKuanLeiBie + '\'' +
                ", zhuTiDaiKuanLeiBie='" + zhuTiDaiKuanLeiBie + '\'' +
                ", daiKuanJinRongJiGou='" + daiKuanJinRongJiGou + '\'' +
                ", touFangDate=" + touFangDate +
                ", touFangJinE=" + touFangJinE +
                ", leiJiTouFangJinE=" + leiJiTouFangJinE +
                ", weiTouFangYuE=" + weiTouFangYuE +
                ", changHuanJinE=" + changHuanJinE +
                ", changHuanDate=" + changHuanDate +
                ", leiJiChangHuanJinE=" + leiJiChangHuanJinE +
                ", weiChangHuanYuE=" + weiChangHuanYuE +
                ", yuQiJinE=" + yuQiJinE +
                ", yuQiDate=" + yuQiDate +
                ", qianXiDate=" + qianXiDate +
                ", qianXiJinE=" + qianXiJinE +
                ", liYiLianJieFangShi='" + liYiLianJieFangShi + '\'' +
                ", daiDongPkhMingDan='" + daiDongPkhMingDan + '\'' +
                ", daiDongPkRenKouShu=" + daiDongPkRenKouShu +
                ", zhiJieDaiDongXiaoYi=" + zhiJieDaiDongXiaoYi +
                ", note='" + note + '\'' +
                ", operationDate=" + operationDate +
                ", shuJuWeiHuDanWei='" + shuJuWeiHuDanWei + '\'' +
                ", operationPerson='" + operationPerson + '\'' +
                ", checkDate=" + checkDate +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", reason='" + reason + '\'' +
                ", operation='" + operation + '\'' +
                ", delStatus='" + delStatus + '\'' +
                ", delDate=" + delDate +
                ", t1='" + t1 + '\'' +
                ", t2='" + t2 + '\'' +
                ", t3='" + t3 + '\'' +
                '}';
    }
}
