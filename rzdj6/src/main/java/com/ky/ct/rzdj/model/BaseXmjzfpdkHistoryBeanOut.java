package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.Date;

public class BaseXmjzfpdkHistoryBeanOut {
    private Long uid;
    private String projectName;
    private String projectCompanyName;
    private String tongYiXinYongDaiMa;
    private String address;
    private String telephone;
    private String daiKuanJiGou = "无";
    private String projectContent;
    private String projectPlace;
    private String daiKuanAgreementNo = "无";
    private Double daiKuanJinE;
    private String daiKuanQiXian;
    private Date daiKuanDate;
    private Date daoQiDate;
    private Double daiKuanLiLv;
    private String daiKuanLeiBie;
    private String daiKuanFangShi;
    private String hangYeLeiBie;
    private String type_yiDiBanQianSuiQian;
    private String type_yiDiBanQianPinKun;
    private String type_nongTianJiBenJianSe;
    private String type_shengChanHuanJinGaiZhao;
    private String type_nongCunJiChuSheSi;
    private String type_qiTa;
    private Date touFangDate;
    private Double touFangJinE;
    private Double leiJiTouFangJinE;
    private Double weiTouFangYuE;
    private Date changHuanPlanDate;
    private Double changHuanPlanJinE;
    private Double changHuanJinE;
    private Date changHuanDate;
    private Double leiJiChangHuanJinE;
    private Double weiChangHuanYuE;
    private Double yuQiJinE;
    private Date yuQiDate;
    private Date qianXiDate;
    private Double qianXiJinE;
    private Integer fuWuPkRenCount;
    private String note;
    private String shuJuWeiHuDanWei;
    private Long gid;
    private Date operationDate;
    private String operation;
    private String operationPerson;
    private String checkStatus;
    private String checkPerson;
    private Date checkDate;
    private String reason;


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    public String getTongYiXinYongDaiMa() {
        return tongYiXinYongDaiMa;
    }

    public void setTongYiXinYongDaiMa(String tongYiXinYongDaiMa) {
        this.tongYiXinYongDaiMa = tongYiXinYongDaiMa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDaiKuanJiGou() {
        return daiKuanJiGou;
    }

    public void setDaiKuanJiGou(String daiKuanJiGou) {
        this.daiKuanJiGou = daiKuanJiGou;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getProjectPlace() {
        return projectPlace;
    }

    public void setProjectPlace(String projectPlace) {
        this.projectPlace = projectPlace;
    }

    public String getDaiKuanAgreementNo() {
        return daiKuanAgreementNo;
    }

    public void setDaiKuanAgreementNo(String daiKuanAgreementNo) {
        this.daiKuanAgreementNo = daiKuanAgreementNo;
    }

    public Double getDaiKuanJinE() {
        return daiKuanJinE;
    }

    public void setDaiKuanJinE(Double daiKuanJinE) {
        this.daiKuanJinE = daiKuanJinE;
    }

    public String getDaiKuanQiXian() {
        return daiKuanQiXian;
    }

    public void setDaiKuanQiXian(String daiKuanQiXian) {
        this.daiKuanQiXian = daiKuanQiXian;
    }

    public Date getDaiKuanDate() {
        return daiKuanDate;
    }

    public void setDaiKuanDate(Date daiKuanDate) {
        this.daiKuanDate = daiKuanDate;
    }

    public Date getDaoQiDate() {
        return daoQiDate;
    }

    public void setDaoQiDate(Date daoQiDate) {
        this.daoQiDate = daoQiDate;
    }

    public Double getDaiKuanLiLv() {
        return daiKuanLiLv;
    }

    public void setDaiKuanLiLv(Double daiKuanLiLv) {
        this.daiKuanLiLv = daiKuanLiLv;
    }

    public String getDaiKuanLeiBie() {
        return daiKuanLeiBie;
    }

    public void setDaiKuanLeiBie(String daiKuanLeiBie) {
        this.daiKuanLeiBie = daiKuanLeiBie;
    }

    public String getDaiKuanFangShi() {
        return daiKuanFangShi;
    }

    public void setDaiKuanFangShi(String daiKuanFangShi) {
        this.daiKuanFangShi = daiKuanFangShi;
    }

    public String getHangYeLeiBie() {
        return hangYeLeiBie;
    }

    public void setHangYeLeiBie(String hangYeLeiBie) {
        this.hangYeLeiBie = hangYeLeiBie;
    }
    
    public Date getTouFangDate() {
        return touFangDate;
    }

    public void setTouFangDate(Date touFangDate) {
        this.touFangDate = touFangDate;
    }

    
    public Double getTouFangJinE() {
        return touFangJinE;
    }

    public void setTouFangJinE(Double touFangJinE) {
        this.touFangJinE = touFangJinE;
    }

    
    public Double getLeiJiTouFangJinE() {
        return leiJiTouFangJinE;
    }

    public void setLeiJiTouFangJinE(Double leiJiTouFangJinE) {
        this.leiJiTouFangJinE = leiJiTouFangJinE;
    }

    
    public Double getWeiTouFangYuE() {
        return weiTouFangYuE;
    }

    public void setWeiTouFangYuE(Double weiTouFangYuE) {
        this.weiTouFangYuE = weiTouFangYuE;
    }

    
    public Date getChangHuanPlanDate() {
        return changHuanPlanDate;
    }

    public void setChangHuanPlanDate(Date changHuanPlanDate) {
        this.changHuanPlanDate = changHuanPlanDate;
    }

    
    public Double getChangHuanPlanJinE() {
        return changHuanPlanJinE;
    }

    public void setChangHuanPlanJinE(Double changHuanPlanJinE) {
        this.changHuanPlanJinE = changHuanPlanJinE;
    }

    
    public Double getChangHuanJinE() {
        return changHuanJinE;
    }

    public void setChangHuanJinE(Double changHuanJinE) {
        this.changHuanJinE = changHuanJinE;
    }

    
    public Date getChangHuanDate() {
        return changHuanDate;
    }

    public void setChangHuanDate(Date changHuanDate) {
        this.changHuanDate = changHuanDate;
    }

    
    public Double getLeiJiChangHuanJinE() {
        return leiJiChangHuanJinE;
    }

    public void setLeiJiChangHuanJinE(Double leiJiChangHuanJinE) {
        this.leiJiChangHuanJinE = leiJiChangHuanJinE;
    }

    
    public Double getWeiChangHuanYuE() {
        return weiChangHuanYuE;
    }

    public void setWeiChangHuanYuE(Double weiChangHuanYuE) {
        this.weiChangHuanYuE = weiChangHuanYuE;
    }

    
    public Double getYuQiJinE() {
        return yuQiJinE;
    }

    public void setYuQiJinE(Double yuQiJinE) {
        this.yuQiJinE = yuQiJinE;
    }

    
    public Date getYuQiDate() {
        return yuQiDate;
    }

    public void setYuQiDate(Date yuQiDate) {
        this.yuQiDate = yuQiDate;
    }

    
    public Date getQianXiDate() {
        return qianXiDate;
    }

    public void setQianXiDate(Date qianXiDate) {
        this.qianXiDate = qianXiDate;
    }

    
    public Double getQianXiJinE() {
        return qianXiJinE;
    }

    public void setQianXiJinE(Double qianXiJinE) {
        this.qianXiJinE = qianXiJinE;
    }

    
    public Integer getFuWuPkRenCount() {
        return fuWuPkRenCount;
    }

    public void setFuWuPkRenCount(Integer fuWuPkRenCount) {
        this.fuWuPkRenCount = fuWuPkRenCount;
    }

    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    
    public String getShuJuWeiHuDanWei() {
        return shuJuWeiHuDanWei;
    }

    public void setShuJuWeiHuDanWei(String shuJuWeiHuDanWei) {
        this.shuJuWeiHuDanWei = shuJuWeiHuDanWei;
    }

    
    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    
    public String getOperationPerson() {
        return operationPerson;
    }

    public void setOperationPerson(String operationPerson) {
        this.operationPerson = operationPerson;
    }

    
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    
    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType_yiDiBanQianSuiQian() {
        return type_yiDiBanQianSuiQian;
    }

    public void setType_yiDiBanQianSuiQian(String type_yiDiBanQianSuiQian) {
        this.type_yiDiBanQianSuiQian = type_yiDiBanQianSuiQian;
    }

    public String getType_yiDiBanQianPinKun() {
        return type_yiDiBanQianPinKun;
    }

    public void setType_yiDiBanQianPinKun(String type_yiDiBanQianPinKun) {
        this.type_yiDiBanQianPinKun = type_yiDiBanQianPinKun;
    }

    public String getType_nongTianJiBenJianSe() {
        return type_nongTianJiBenJianSe;
    }

    public void setType_nongTianJiBenJianSe(String type_nongTianJiBenJianSe) {
        this.type_nongTianJiBenJianSe = type_nongTianJiBenJianSe;
    }

    public String getType_shengChanHuanJinGaiZhao() {
        return type_shengChanHuanJinGaiZhao;
    }

    public void setType_shengChanHuanJinGaiZhao(String type_shengChanHuanJinGaiZhao) {
        this.type_shengChanHuanJinGaiZhao = type_shengChanHuanJinGaiZhao;
    }

    public String getType_nongCunJiChuSheSi() {
        return type_nongCunJiChuSheSi;
    }

    public void setType_nongCunJiChuSheSi(String type_nongCunJiChuSheSi) {
        this.type_nongCunJiChuSheSi = type_nongCunJiChuSheSi;
    }

    public String getType_qiTa() {
        return type_qiTa;
    }

    public void setType_qiTa(String type_qiTa) {
        this.type_qiTa = type_qiTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseXmjzfpdkHistoryBeanOut that = (BaseXmjzfpdkHistoryBeanOut) o;

        if (uid != that.uid) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (projectCompanyName != null ? !projectCompanyName.equals(that.projectCompanyName) : that.projectCompanyName != null)
            return false;
        if (tongYiXinYongDaiMa != null ? !tongYiXinYongDaiMa.equals(that.tongYiXinYongDaiMa) : that.tongYiXinYongDaiMa != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (daiKuanJiGou != null ? !daiKuanJiGou.equals(that.daiKuanJiGou) : that.daiKuanJiGou != null) return false;
        if (projectContent != null ? !projectContent.equals(that.projectContent) : that.projectContent != null)
            return false;
        if (projectPlace != null ? !projectPlace.equals(that.projectPlace) : that.projectPlace != null) return false;
        if (daiKuanAgreementNo != null ? !daiKuanAgreementNo.equals(that.daiKuanAgreementNo) : that.daiKuanAgreementNo != null)
            return false;
        if (daiKuanJinE != null ? !daiKuanJinE.equals(that.daiKuanJinE) : that.daiKuanJinE != null) return false;
        if (daiKuanQiXian != null ? !daiKuanQiXian.equals(that.daiKuanQiXian) : that.daiKuanQiXian != null)
            return false;
        if (daiKuanDate != null ? !daiKuanDate.equals(that.daiKuanDate) : that.daiKuanDate != null) return false;
        if (daoQiDate != null ? !daoQiDate.equals(that.daoQiDate) : that.daoQiDate != null) return false;
        if (daiKuanLiLv != null ? !daiKuanLiLv.equals(that.daiKuanLiLv) : that.daiKuanLiLv != null) return false;
        if (daiKuanLeiBie != null ? !daiKuanLeiBie.equals(that.daiKuanLeiBie) : that.daiKuanLeiBie != null)
            return false;
        if (daiKuanFangShi != null ? !daiKuanFangShi.equals(that.daiKuanFangShi) : that.daiKuanFangShi != null)
            return false;
        if (hangYeLeiBie != null ? !hangYeLeiBie.equals(that.hangYeLeiBie) : that.hangYeLeiBie != null) return false;
        if (touFangDate != null ? !touFangDate.equals(that.touFangDate) : that.touFangDate != null) return false;
        if (touFangJinE != null ? !touFangJinE.equals(that.touFangJinE) : that.touFangJinE != null) return false;
        if (leiJiTouFangJinE != null ? !leiJiTouFangJinE.equals(that.leiJiTouFangJinE) : that.leiJiTouFangJinE != null)
            return false;
        if (weiTouFangYuE != null ? !weiTouFangYuE.equals(that.weiTouFangYuE) : that.weiTouFangYuE != null)
            return false;
        if (changHuanPlanDate != null ? !changHuanPlanDate.equals(that.changHuanPlanDate) : that.changHuanPlanDate != null)
            return false;
        if (changHuanPlanJinE != null ? !changHuanPlanJinE.equals(that.changHuanPlanJinE) : that.changHuanPlanJinE != null)
            return false;
        if (changHuanJinE != null ? !changHuanJinE.equals(that.changHuanJinE) : that.changHuanJinE != null)
            return false;
        if (changHuanDate != null ? !changHuanDate.equals(that.changHuanDate) : that.changHuanDate != null)
            return false;
        if (leiJiChangHuanJinE != null ? !leiJiChangHuanJinE.equals(that.leiJiChangHuanJinE) : that.leiJiChangHuanJinE != null)
            return false;
        if (weiChangHuanYuE != null ? !weiChangHuanYuE.equals(that.weiChangHuanYuE) : that.weiChangHuanYuE != null)
            return false;
        if (yuQiJinE != null ? !yuQiJinE.equals(that.yuQiJinE) : that.yuQiJinE != null) return false;
        if (yuQiDate != null ? !yuQiDate.equals(that.yuQiDate) : that.yuQiDate != null) return false;
        if (qianXiDate != null ? !qianXiDate.equals(that.qianXiDate) : that.qianXiDate != null) return false;
        if (qianXiJinE != null ? !qianXiJinE.equals(that.qianXiJinE) : that.qianXiJinE != null) return false;
        if (fuWuPkRenCount != null ? !fuWuPkRenCount.equals(that.fuWuPkRenCount) : that.fuWuPkRenCount != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (shuJuWeiHuDanWei != null ? !shuJuWeiHuDanWei.equals(that.shuJuWeiHuDanWei) : that.shuJuWeiHuDanWei != null)
            return false;
        if (gid != null ? !gid.equals(that.gid) : that.gid != null) return false;
        if (operationDate != null ? !operationDate.equals(that.operationDate) : that.operationDate != null)
            return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;
        if (operationPerson != null ? !operationPerson.equals(that.operationPerson) : that.operationPerson != null)
            return false;
        if (checkStatus != null ? !checkStatus.equals(that.checkStatus) : that.checkStatus != null) return false;
        if (checkPerson != null ? !checkPerson.equals(that.checkPerson) : that.checkPerson != null) return false;
        if (checkDate != null ? !checkDate.equals(that.checkDate) : that.checkDate != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

}
