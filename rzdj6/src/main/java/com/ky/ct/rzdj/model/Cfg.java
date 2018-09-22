package com.ky.ct.rzdj.model;
// Generated 2018-3-15 12:35:10 by Hibernate Tools 5.2.5.Final

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Cfg generated by hbm2java
 */
@Entity
@Table(name = "cfg", catalog = "audit")
public class Cfg implements java.io.Serializable {

	private Integer id;
	private String projectName;
	private String dptName;
	private int dptType;

	public Cfg() {
	}

	public Cfg(String projectName, String dptName, int dptType) {
		this.projectName = projectName;
		this.dptName = dptName;
		this.dptType = dptType;
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

	@Column(name = "projectName", nullable = false, length = 128)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "dptName", nullable = false, length = 63)
	public String getDptName() {
		return this.dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	@Column(name = "dptType", nullable = false)
	public int getDptType() {
		return this.dptType;
	}

	public void setDptType(int dptType) {
		this.dptType = dptType;
	}

}