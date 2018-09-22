package com.ky.ct.rzdj.model.cyjzfpdk;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "base_cyjzfpdk_ddpkh_history", schema = "pashanhu", catalog = "")
public class BaseCyjzfpdkDdpkhHistory {
	private Long uid;
	private String agreementNo;
	private String huZhuName;
	private String huZhuCardId;
	private Integer familyMembers;
	private Date checkDate;
	private String checkPerson;
	private String checkStatus;
	private String reason;
	private String operation;
	private String delStatus;
	private Date delDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid", nullable = true)
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	@Basic
	@Column(name = "agreementNo", nullable = true, length = 50)
	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	@Basic
	@Column(name = "huZhuName", nullable = true, length = 50)
	public String getHuZhuName() {
		return huZhuName;
	}

	public void setHuZhuName(String huZhuName) {
		this.huZhuName = huZhuName;
	}

	@Basic
	@Column(name = "huZhuCardId", nullable = true, length = 100)
	public String getHuZhuCardId() {
		return huZhuCardId;
	}

	public void setHuZhuCardId(String huZhuCardId) {
		this.huZhuCardId = huZhuCardId;
	}

	@Basic
	@Column(name = "familyMembers", nullable = true)
	public Integer getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Integer familyMembers) {
		this.familyMembers = familyMembers;
	}

	@Basic
	@Column(name = "checkDate", nullable = true)
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Basic
	@Column(name = "checkPerson", nullable = true, length = 50)
	public String getCheckPerson() {
		return checkPerson;
	}

	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}

	@Basic
	@Column(name = "checkStatus", nullable = true, length = 10)
	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Basic
	@Column(name = "reason", nullable = true, length = 255)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Basic
	@Column(name = "operation", nullable = true, length = 10)
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Basic
	@Column(name = "delStatus", nullable = true, length = 10)
	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	@Basic
	@Column(name = "delDate", nullable = true)
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
		BaseCyjzfpdkDdpkhHistory that = (BaseCyjzfpdkDdpkhHistory) o;
		return Objects.equals(uid, that.uid) &&
				Objects.equals(agreementNo, that.agreementNo) &&
				Objects.equals(huZhuName, that.huZhuName) &&
				Objects.equals(huZhuCardId, that.huZhuCardId) &&
				Objects.equals(familyMembers, that.familyMembers) &&
				Objects.equals(checkDate, that.checkDate) &&
				Objects.equals(checkPerson, that.checkPerson) &&
				Objects.equals(checkStatus, that.checkStatus) &&
				Objects.equals(reason, that.reason) &&
				Objects.equals(operation, that.operation) &&
				Objects.equals(delStatus, that.delStatus) &&
				Objects.equals(delDate, that.delDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid, agreementNo, huZhuName, huZhuCardId, familyMembers, checkDate, checkPerson, checkStatus, reason, operation, delStatus, delDate);
	}
}
