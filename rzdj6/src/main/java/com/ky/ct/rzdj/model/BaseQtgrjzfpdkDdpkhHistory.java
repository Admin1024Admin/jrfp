package com.ky.ct.rzdj.model;

import javax.persistence.*;

@Entity
@Table(name = "base_qtgrjzfpdk_ddpkh_history", schema = "pashanhu", catalog = "")
public class BaseQtgrjzfpdkDdpkhHistory {
    private long id;
    private String agreementNo;
    private String huZhuName;
    private String huZhuCardId;
    private Integer familyMembers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "huZhuName")
    public String getHuZhuName() {
        return huZhuName;
    }

    public void setHuZhuName(String huZhuName) {
        this.huZhuName = huZhuName;
    }

    @Basic
    @Column(name = "huZhuCardId")
    public String getHuZhuCardId() {
        return huZhuCardId;
    }

    public void setHuZhuCardId(String huZhuCardId) {
        this.huZhuCardId = huZhuCardId;
    }

    @Basic
    @Column(name = "familyMembers")
    public Integer getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Integer familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public String toString() {
        return "BaseQtgrjzfpdkDdpkh{" +
                "id=" + id +
                ", agreementNo='" + agreementNo + '\'' +
                ", huZhuName='" + huZhuName + '\'' +
                ", huZhuCardId='" + huZhuCardId + '\'' +
                ", familyMembers=" + familyMembers +
                '}';
    }
}
