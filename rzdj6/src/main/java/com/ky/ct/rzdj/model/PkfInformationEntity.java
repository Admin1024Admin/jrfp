package com.ky.ct.rzdj.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pkf_information", schema = "pashanhu", catalog = "")
public class PkfInformationEntity {
    private long uid;
    private int no;
    private String shiQuQi;
    private String xiangZheng;
    private String chun;
    private String she;
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
    private Timestamp tongJiShiJian;
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
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Basic
    @Column(name = "ShiQuQi")
    public String getShiQuQi() {
        return shiQuQi;
    }

    public void setShiQuQi(String shiQuQi) {
        this.shiQuQi = shiQuQi;
    }

    @Basic
    @Column(name = "XiangZheng")
    public String getXiangZheng() {
        return xiangZheng;
    }

    public void setXiangZheng(String xiangZheng) {
        this.xiangZheng = xiangZheng;
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
    @Column(name = "She")
    public String getShe() {
        return she;
    }

    public void setShe(String she) {
        this.she = she;
    }

    @Basic
    @Column(name = "FamilyNo")
    public String getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(String familyNo) {
        this.familyNo = familyNo;
    }

    @Basic
    @Column(name = "MemberNo")
    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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
    @Column(name = "CardID")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "Members")
    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
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
    @Column(name = "mz")
    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    @Basic
    @Column(name = "XueLi")
    public String getXueLi() {
        return xueLi;
    }

    public void setXueLi(String xueLi) {
        this.xueLi = xueLi;
    }

    @Basic
    @Column(name = "SchoolState")
    public String getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
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
    @Column(name = "Skill")
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Basic
    @Column(name = "WorkState")
    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    @Basic
    @Column(name = "WorkMonth")
    public String getWorkMonth() {
        return workMonth;
    }

    public void setWorkMonth(String workMonth) {
        this.workMonth = workMonth;
    }

    @Basic
    @Column(name = "IsDaBinYiLiao")
    public String getIsDaBinYiLiao() {
        return isDaBinYiLiao;
    }

    public void setIsDaBinYiLiao(String isDaBinYiLiao) {
        this.isDaBinYiLiao = isDaBinYiLiao;
    }

    @Basic
    @Column(name = "TuoPinState")
    public String getTuoPinState() {
        return tuoPinState;
    }

    public void setTuoPinState(String tuoPinState) {
        this.tuoPinState = tuoPinState;
    }

    @Basic
    @Column(name = "PinKunState")
    public String getPinKunState() {
        return pinKunState;
    }

    public void setPinKunState(String pinKunState) {
        this.pinKunState = pinKunState;
    }

    @Basic
    @Column(name = "PinKunYuanYin")
    public String getPinKunYuanYin() {
        return pinKunYuanYin;
    }

    public void setPinKunYuanYin(String pinKunYuanYin) {
        this.pinKunYuanYin = pinKunYuanYin;
    }

    @Basic
    @Column(name = "IsWeiFangHu")
    public String getIsWeiFangHu() {
        return isWeiFangHu;
    }

    public void setIsWeiFangHu(String isWeiFangHu) {
        this.isWeiFangHu = isWeiFangHu;
    }

    @Basic
    @Column(name = "IsYinShuiAnQuan")
    public String getIsYinShuiAnQuan() {
        return isYinShuiAnQuan;
    }

    public void setIsYinShuiAnQuan(String isYinShuiAnQuan) {
        this.isYinShuiAnQuan = isYinShuiAnQuan;
    }

    @Basic
    @Column(name = "IsYinShuiKunNan")
    public String getIsYinShuiKunNan() {
        return isYinShuiKunNan;
    }

    public void setIsYinShuiKunNan(String isYinShuiKunNan) {
        this.isYinShuiKunNan = isYinShuiKunNan;
    }

    @Basic
    @Column(name = "RenJunChunShouRu")
    public Double getRenJunChunShouRu() {
        return renJunChunShouRu;
    }

    public void setRenJunChunShouRu(Double renJunChunShouRu) {
        this.renJunChunShouRu = renJunChunShouRu;
    }

    @Basic
    @Column(name = "Telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "TongJiShiJian")
    public Timestamp getTongJiShiJian() {
        return tongJiShiJian;
    }

    public void setTongJiShiJian(Timestamp tongJiShiJian) {
        this.tongJiShiJian = tongJiShiJian;
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
        PkfInformationEntity that = (PkfInformationEntity) o;
        return uid == that.uid &&
                Objects.equals(no, that.no) &&
                Objects.equals(shiQuQi, that.shiQuQi) &&
                Objects.equals(xiangZheng, that.xiangZheng) &&
                Objects.equals(chun, that.chun) &&
                Objects.equals(she, that.she) &&
                Objects.equals(familyNo, that.familyNo) &&
                Objects.equals(memberNo, that.memberNo) &&
                Objects.equals(name, that.name) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(members, that.members) &&
                Objects.equals(familyRelation, that.familyRelation) &&
                Objects.equals(mz, that.mz) &&
                Objects.equals(xueLi, that.xueLi) &&
                Objects.equals(schoolState, that.schoolState) &&
                Objects.equals(healthState, that.healthState) &&
                Objects.equals(skill, that.skill) &&
                Objects.equals(workState, that.workState) &&
                Objects.equals(workMonth, that.workMonth) &&
                Objects.equals(isDaBinYiLiao, that.isDaBinYiLiao) &&
                Objects.equals(tuoPinState, that.tuoPinState) &&
                Objects.equals(pinKunState, that.pinKunState) &&
                Objects.equals(pinKunYuanYin, that.pinKunYuanYin) &&
                Objects.equals(isWeiFangHu, that.isWeiFangHu) &&
                Objects.equals(isYinShuiAnQuan, that.isYinShuiAnQuan) &&
                Objects.equals(isYinShuiKunNan, that.isYinShuiKunNan) &&
                Objects.equals(renJunChunShouRu, that.renJunChunShouRu) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(tongJiShiJian, that.tongJiShiJian) &&
                Objects.equals(note1, that.note1) &&
                Objects.equals(note2, that.note2) &&
                Objects.equals(note3, that.note3) &&
                Objects.equals(note4, that.note4) &&
                Objects.equals(note5, that.note5);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, no, shiQuQi, xiangZheng, chun, she, familyNo, memberNo, name, cardId, members, familyRelation, mz, xueLi, schoolState, healthState, skill, workState, workMonth, isDaBinYiLiao, tuoPinState, pinKunState, pinKunYuanYin, isWeiFangHu, isYinShuiAnQuan, isYinShuiKunNan, renJunChunShouRu, telephone, tongJiShiJian, note1, note2, note3, note4, note5);
    }

    @Override
    public String toString() {
        return "PkfInformationEntity{" +
                "uid=" + uid +
                ", no='" + no + '\'' +
                ", shiQuQi='" + shiQuQi + '\'' +
                ", xiangZheng='" + xiangZheng + '\'' +
                ", chun='" + chun + '\'' +
                ", she='" + she + '\'' +
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
                ", tongJiShiJian=" + tongJiShiJian +
                ", note1='" + note1 + '\'' +
                ", note2='" + note2 + '\'' +
                ", note3='" + note3 + '\'' +
                ", note4='" + note4 + '\'' +
                ", note5='" + note5 + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
