package com.ky.ct.rzdj.model;
// Generated 2018-3-15 12:35:10 by Hibernate Tools 5.2.5.Final

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Auditperson generated by hbm2java
 */
@Entity
@Table(name = "auditperson", catalog = "audit")
public class AuditPerson implements java.io.Serializable {

	private Integer id;
	private String name;
	private String icon;
	private String sex;
	private String mobile;
	private Date birthday;
	private String jobTitle;
	private String jobType;
	private String certificate;
	private String diploma;

	public AuditPerson() {
	}

	public AuditPerson(String name, String sex, String mobile, Date birthday, String jobType, String diploma) {
		this.name = name;
		this.sex = sex;
		this.mobile = mobile;
		this.birthday = birthday;
		this.jobType = jobType;
		this.diploma = diploma;
	}

	public AuditPerson(String name, String icon, String sex, String mobile, Date birthday, String jobTitle,
			String jobType, String certificate, String diploma) {
		this.name = name;
		this.icon = icon;
		this.sex = sex;
		this.mobile = mobile;
		this.birthday = birthday;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.certificate = certificate;
		this.diploma = diploma;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "icon", length = 32)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "sex", nullable = false, length = 10)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "mobile", nullable = false, length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "jobTitle", length = 32)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "jobType", nullable = false, length = 32)
	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Column(name = "certificate", length = 32)
	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Column(name = "diploma", nullable = false, length = 32)
	public String getDiploma() {
		return this.diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

}
