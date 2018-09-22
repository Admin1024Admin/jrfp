package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_xmjzfpdk_history", schema = "pashanhu", catalog = "")
public class BaseXmjzfpdkHistoryBean {
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
    private String type;
    private String yiDaiDaiKuanType;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "projectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "projectCompanyName")
    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    @Basic
    @Column(name = "tongYiXinYongDaiMa")
    public String getTongYiXinYongDaiMa() {
        return tongYiXinYongDaiMa;
    }

    public void setTongYiXinYongDaiMa(String tongYiXinYongDaiMa) {
        this.tongYiXinYongDaiMa = tongYiXinYongDaiMa;
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
    @Column(name = "daiKuanJiGou")
    public String getDaiKuanJiGou() {
        return daiKuanJiGou;
    }

    public void setDaiKuanJiGou(String daiKuanJiGou) {
        this.daiKuanJiGou = daiKuanJiGou;
    }

    @Basic
    @Column(name = "projectContent")
    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    @Basic
    @Column(name = "projectPlace")
    public String getProjectPlace() {
        return projectPlace;
    }

    public void setProjectPlace(String projectPlace) {
        this.projectPlace = projectPlace;
    }

    @Basic
    @Column(name = "daiKuanAgreementNo")
    public String getDaiKuanAgreementNo() {
        return daiKuanAgreementNo;
    }

    public void setDaiKuanAgreementNo(String daiKuanAgreementNo) {
        this.daiKuanAgreementNo = daiKuanAgreementNo;
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
    @Column(name = "daiKuanLeiBie")
    public String getDaiKuanLeiBie() {
        return daiKuanLeiBie;
    }

    public void setDaiKuanLeiBie(String daiKuanLeiBie) {
        this.daiKuanLeiBie = daiKuanLeiBie;
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
    @Column(name = "hangYeLeiBie")
    public String getHangYeLeiBie() {
        return hangYeLeiBie;
    }

    public void setHangYeLeiBie(String hangYeLeiBie) {
        this.hangYeLeiBie = hangYeLeiBie;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "yiDaiDaiKuanType")
    public String getYiDaiDaiKuanType() {
        return yiDaiDaiKuanType;
    }

    public void setYiDaiDaiKuanType(String yiDaiDaiKuanType) {
        this.yiDaiDaiKuanType = yiDaiDaiKuanType;
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
    @Column(name = "changHuanPlanDate")
    public Date getChangHuanPlanDate() {
        return changHuanPlanDate;
    }

    public void setChangHuanPlanDate(Date changHuanPlanDate) {
        this.changHuanPlanDate = changHuanPlanDate;
    }

    @Basic
    @Column(name = "changHuanPlanJinE")
    public Double getChangHuanPlanJinE() {
        return changHuanPlanJinE;
    }

    public void setChangHuanPlanJinE(Double changHuanPlanJinE) {
        this.changHuanPlanJinE = changHuanPlanJinE;
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
    @Column(name = "fuWuPKRenCount")
    public Integer getFuWuPkRenCount() {
        return fuWuPkRenCount;
    }

    public void setFuWuPkRenCount(Integer fuWuPkRenCount) {
        this.fuWuPkRenCount = fuWuPkRenCount;
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
    @Column(name = "gid")
    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
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
    @Column(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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
    @Column(name = "checkStatus")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
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
    @Column(name = "checkDate")
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseXmjzfpdkHistoryBean that = (BaseXmjzfpdkHistoryBean) o;

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
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (yiDaiDaiKuanType != null ? !yiDaiDaiKuanType.equals(that.yiDaiDaiKuanType) : that.yiDaiDaiKuanType != null)
            return false;
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


    @Override
    public String toString() {
        return "BaseXmjzfpdkHistoryBean{" +
                "uid=" + uid +
                ", projectName='" + projectName + '\'' +
                ", projectCompanyName='" + projectCompanyName + '\'' +
                ", tongYiXinYongDaiMa='" + tongYiXinYongDaiMa + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", daiKuanJiGou='" + daiKuanJiGou + '\'' +
                ", projectContent='" + projectContent + '\'' +
                ", projectPlace='" + projectPlace + '\'' +
                ", daiKuanAgreementNo='" + daiKuanAgreementNo + '\'' +
                ", daiKuanJinE=" + daiKuanJinE +
                ", daiKuanQiXian='" + daiKuanQiXian + '\'' +
                ", daiKuanDate=" + daiKuanDate +
                ", daoQiDate=" + daoQiDate +
                ", daiKuanLiLv=" + daiKuanLiLv +
                ", daiKuanLeiBie='" + daiKuanLeiBie + '\'' +
                ", daiKuanFangShi='" + daiKuanFangShi + '\'' +
                ", hangYeLeiBie='" + hangYeLeiBie + '\'' +
                ", type='" + type + '\'' +
                ", yiDaiDaiKuanType='" + yiDaiDaiKuanType + '\'' +
                ", touFangDate=" + touFangDate +
                ", touFangJinE=" + touFangJinE +
                ", leiJiTouFangJinE=" + leiJiTouFangJinE +
                ", weiTouFangYuE=" + weiTouFangYuE +
                ", changHuanPlanDate=" + changHuanPlanDate +
                ", changHuanPlanJinE=" + changHuanPlanJinE +
                ", changHuanJinE=" + changHuanJinE +
                ", changHuanDate=" + changHuanDate +
                ", leiJiChangHuanJinE=" + leiJiChangHuanJinE +
                ", weiChangHuanYuE=" + weiChangHuanYuE +
                ", yuQiJinE=" + yuQiJinE +
                ", yuQiDate=" + yuQiDate +
                ", qianXiDate=" + qianXiDate +
                ", qianXiJinE=" + qianXiJinE +
                ", fuWuPkRenCount=" + fuWuPkRenCount +
                ", note='" + note + '\'' +
                ", shuJuWeiHuDanWei='" + shuJuWeiHuDanWei + '\'' +
                ", gid=" + gid +
                ", operationDate=" + operationDate +
                ", operation='" + operation + '\'' +
                ", operationPerson='" + operationPerson + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", checkPerson='" + checkPerson + '\'' +
                ", checkDate=" + checkDate +
                ", reason='" + reason + '\'' +
                '}';
    }
}
