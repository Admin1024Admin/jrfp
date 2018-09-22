package com.ky.ct.rzdj.model;

import javax.persistence.*;

@Entity
@Table(name = "base_information", schema = "pashanhu", catalog = "")
public class BaseInformation {
    private long uid;
    private String sheng;
    private String shi;
    private String xain;
    private String xiang;
    private String chun;
    private String zu;
    private String familyNo;
    private String memberNo;
    private String name;
    private String cardId;
    private Integer members;
    private String familyRelation;
    private String mz;
    private String xueLi;
    private String schoolState;
    private String healthState;
    private String skill;
    private String workState;
    private String workMonth;
    private String isDaBinYiLiao;
    private String tuoPinState;
    private String pinKunState;
    private String pinKunYuanYin;
    private String isWeiFangHu;
    private String isYinShuiAnQuan;
    private String isYinShuiKunNan;
    private Double renJunChunShouRu;
    private String telephone;

    @Id
    @Column(name = "uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "sheng")
    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    @Basic
    @Column(name = "shi")
    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    @Basic
    @Column(name = "xain")
    public String getXain() {
        return xain;
    }

    public void setXain(String xain) {
        this.xain = xain;
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
    @Column(name = "familyNo")
    public String getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(String familyNo) {
        this.familyNo = familyNo;
    }

    @Basic
    @Column(name = "memberNo")
    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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
    @Column(name = "members")
    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
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
    @Column(name = "mz")
    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    @Basic
    @Column(name = "xueLi")
    public String getXueLi() {
        return xueLi;
    }

    public void setXueLi(String xueLi) {
        this.xueLi = xueLi;
    }

    @Basic
    @Column(name = "schoolState")
    public String getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
    }

    @Basic
    @Column(name = "healthState")
    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    @Basic
    @Column(name = "skill")
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Basic
    @Column(name = "workState")
    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    @Basic
    @Column(name = "workMonth")
    public String getWorkMonth() {
        return workMonth;
    }

    public void setWorkMonth(String workMonth) {
        this.workMonth = workMonth;
    }

    @Basic
    @Column(name = "isDaBinYiLiao")
    public String getIsDaBinYiLiao() {
        return isDaBinYiLiao;
    }

    public void setIsDaBinYiLiao(String isDaBinYiLiao) {
        this.isDaBinYiLiao = isDaBinYiLiao;
    }

    @Basic
    @Column(name = "tuoPinState")
    public String getTuoPinState() {
        return tuoPinState;
    }

    public void setTuoPinState(String tuoPinState) {
        this.tuoPinState = tuoPinState;
    }

    @Basic
    @Column(name = "pinKunState")
    public String getPinKunState() {
        return pinKunState;
    }

    public void setPinKunState(String pinKunState) {
        this.pinKunState = pinKunState;
    }

    @Basic
    @Column(name = "pinKunYuanYin")
    public String getPinKunYuanYin() {
        return pinKunYuanYin;
    }

    public void setPinKunYuanYin(String pinKunYuanYin) {
        this.pinKunYuanYin = pinKunYuanYin;
    }

    @Basic
    @Column(name = "isWeiFangHu")
    public String getIsWeiFangHu() {
        return isWeiFangHu;
    }

    public void setIsWeiFangHu(String isWeiFangHu) {
        this.isWeiFangHu = isWeiFangHu;
    }

    @Basic
    @Column(name = "isYinShuiAnQuan")
    public String getIsYinShuiAnQuan() {
        return isYinShuiAnQuan;
    }

    public void setIsYinShuiAnQuan(String isYinShuiAnQuan) {
        this.isYinShuiAnQuan = isYinShuiAnQuan;
    }

    @Basic
    @Column(name = "isYinShuiKunNan")
    public String getIsYinShuiKunNan() {
        return isYinShuiKunNan;
    }

    public void setIsYinShuiKunNan(String isYinShuiKunNan) {
        this.isYinShuiKunNan = isYinShuiKunNan;
    }

    @Basic
    @Column(name = "renJunChunShouRu")
    public Double getRenJunChunShouRu() {
        return renJunChunShouRu;
    }

    public void setRenJunChunShouRu(Double renJunChunShouRu) {
        this.renJunChunShouRu = renJunChunShouRu;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "BaseInformation{" +
                "uid=" + uid +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                ", xain='" + xain + '\'' +
                ", xiang='" + xiang + '\'' +
                ", chun='" + chun + '\'' +
                ", zu='" + zu + '\'' +
                ", familyNo='" + familyNo + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", members=" + members +
                ", familyRelation='" + familyRelation + '\'' +
                ", mz='" + mz + '\'' +
                ", xueLi='" + xueLi + '\'' +
                ", schoolState='" + schoolState + '\'' +
                ", healthState='" + healthState + '\'' +
                ", skill='" + skill + '\'' +
                ", workState='" + workState + '\'' +
                ", workMonth='" + workMonth + '\'' +
                ", isDaBinYiLiao='" + isDaBinYiLiao + '\'' +
                ", tuoPinState='" + tuoPinState + '\'' +
                ", pinKunState='" + pinKunState + '\'' +
                ", pinKunYuanYin='" + pinKunYuanYin + '\'' +
                ", isWeiFangHu='" + isWeiFangHu + '\'' +
                ", isYinShuiAnQuan='" + isYinShuiAnQuan + '\'' +
                ", isYinShuiKunNan='" + isYinShuiKunNan + '\'' +
                ", renJunChunShouRu=" + renJunChunShouRu +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
