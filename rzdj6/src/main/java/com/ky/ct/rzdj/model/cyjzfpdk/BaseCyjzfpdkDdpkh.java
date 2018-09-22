package com.ky.ct.rzdj.model.cyjzfpdk;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "base_cyjzfpdk_ddpkh", schema = "pashanhu", catalog = "")
public class BaseCyjzfpdkDdpkh {
	private Long uid;
	private String agreementNo;
	private String huZhuName;
	private String huZhuCardId;
	private Integer familyMembers;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseCyjzfpdkDdpkh that = (BaseCyjzfpdkDdpkh) o;
		return Objects.equals(uid, that.uid) &&
				Objects.equals(agreementNo, that.agreementNo) &&
				Objects.equals(huZhuName, that.huZhuName) &&
				Objects.equals(huZhuCardId, that.huZhuCardId) &&
				Objects.equals(familyMembers, that.familyMembers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid, agreementNo, huZhuName, huZhuCardId, familyMembers);
	}

	@Override
	public String toString() {
		return "BaseCyjzfpdkDdpkh{" +
				"uid=" + uid +
				", agreementNo='" + agreementNo + '\'' +
				", huZhuName='" + huZhuName + '\'' +
				", huZhuCardId='" + huZhuCardId + '\'' +
				", familyMembers=" + familyMembers +
				'}';
	}
}
