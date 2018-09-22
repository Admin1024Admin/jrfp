package com.ky.ct.rzdj.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "base_fpxexd_history", schema = "pashanhu", catalog = "")
public class BaseFpxexdHistory {
	public int no;
	public String xiang;
	public String chun;
	public String zu;
	public String name;
	public String cardId;
	public Integer members;
	public String daiKuanRenXingMing;
	public String daiKuanRenCardId;
	public String familyRelation;
	public String tuoPinState;
	public Double yuanYouYuE;
	public String yuanYouIsYuQi;
	public Double yuanYouYuQiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date yuanYouYuQiShiJian;
	public Double yuanYouQianXiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date yuanYouQianXiShiJian;
	public String fuPingivenStars;
	public Double fuPinshouXinEDu;
	public String fuPinshouXinJiGou;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPinshouxinData;
	public Double fuPinXiaoDaidaiKuanJinE;
	public String fuPindaiKuanQiXian;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPinfangKuanRiQi;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPindaoQiRiQi;
	public Double fuPinXiaoDaiDaiKuanLiLv;
	public String fuPindaiKuanJiGou;
	public Double fuPinleiJiTieXi;
	public Double fuPinchangHuanDaiKuanJInE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPinhuanKuanShiJian;
	public Double fuPindaiKuanYuE;
	public Double fuPinyuQiDaiKuanJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPinyuQiDaiKuanShiJian;
	public Double fuPinqianXiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fuPinqianXiShiJian;
	public String fuPinYingDaiWeiDaiShiBie;
	public String fuPinDaiKuanYongTu;
	public Double chuangYeJinE;
	public String chuangYeQiXian;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date chuangYeFangKuanRiQi;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date chuangYeDaoQiShiJian;
	public Double chuangYeLiLv;
	public Double chuangYeChangHuanJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date changYeHuangKuanShiJian;
	public Double chuangYeYuE;
	public Double chuangYeYuQiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date chuangYeYuQiShiJian;
	public Double chuangYeQianXiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date chuangYeQianXiShiJian;
	public String chuangYeYongTu;
	public Double shengYuanJinE;
	public String shengYuanQiXian;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date shengYuanFangKuanRiQi;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date shengYaunDaoQiRiQi;
	public Double shengYaunLiLv;
	public Double shengYaunChangHuanJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date shengYuanHuanKuanShiJian;
	public Double shengYuanYuE;
	public Double shengYuanYuQiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date shengYuanYuQiShiJian;
	public Double shengYuanQianXiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date shengYuanQianXiShiJian;
	public Double qiTaJinE;
	public String qiTaQiXian;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date qiTaFangKuanRiQi;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date qiTaDaoQiRiQi;
	public Double qiTaLiLv;
	public Double qiTaChangHuanJinE;
	@DateTimeFormat(pattern = "yyyy--MM--dd")
	public Date qiTaChangHuangKuanShiJian;
	public Double qiTaYuE;
	public Double qiTaYuQiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date qiTaYuQiShiJian;
	public Double qiTaQianXiJinE;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date qiTaQianXiShiJian;
	public String qiTaYongTu;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date tongJiShiJian;
	public String note;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date operationDate;
	public String operationPerson;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date checkDate;
	public String checkPerson;
	public String checkStatus;
	public String reason;
	public String operation;
	public String delStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date delDate;
	private String unit;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no", nullable = false)
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Basic
	@Column(name = "xiang", length = 255)
	public String getXiang() {
		return xiang;
	}

	public void setXiang(String xiang) {
		this.xiang = xiang;
	}

	@Basic
	@Column(name = "chun", length = 255)
	public String getChun() {
		return chun;
	}

	public void setChun(String chun) {
		this.chun = chun;
	}

	@Basic
	@Column(name = "zu", length = 255)
	public String getZu() {
		return zu;
	}

	public void setZu(String zu) {
		this.zu = zu;
	}

	@Basic
	@Column(name = "name", length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "cardId", length = 40)
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Basic
	@Column(name = "members", nullable = true)
	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}

	@Basic
	@Column(name = "daiKuanRenXingMing", length = 255)
	public String getDaiKuanRenXingMing() {
		return daiKuanRenXingMing;
	}

	public void setDaiKuanRenXingMing(String daiKuanRenXingMing) {
		this.daiKuanRenXingMing = daiKuanRenXingMing;
	}

	@Basic
	@Column(name = "daiKuanRenCardId", length = 255)
	public String getDaiKuanRenCardId() {
		return daiKuanRenCardId;
	}

	public void setDaiKuanRenCardId(String daiKuanRenCardId) {
		this.daiKuanRenCardId = daiKuanRenCardId;
	}

	@Basic
	@Column(name = "familyRelation", length = 255)
	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}

	@Basic
	@Column(name = "tuoPinState", length = 255)
	public String getTuoPinState() {
		return tuoPinState;
	}

	public void setTuoPinState(String tuoPinState) {
		this.tuoPinState = tuoPinState;
	}

	@Basic
	@Column(name = "yuanYouYuE", precision = 2)
	public Double getYuanYouYuE() {
		return yuanYouYuE;
	}

	public void setYuanYouYuE(Double yuanYouYuE) {
		this.yuanYouYuE = yuanYouYuE;
	}

	@Basic
	@Column(name = "yuanYouIsYuQi", length = 30)
	public String getYuanYouIsYuQi() {
		return yuanYouIsYuQi;
	}

	public void setYuanYouIsYuQi(String yuanYouIsYuQi) {
		this.yuanYouIsYuQi = yuanYouIsYuQi;
	}

	@Basic
	@Column(name = "yuanYouYuQiJinE", precision = 2)
	public Double getYuanYouYuQiJinE() {
		return yuanYouYuQiJinE;
	}

	public void setYuanYouYuQiJinE(Double yuanYouYuQiJinE) {
		this.yuanYouYuQiJinE = yuanYouYuQiJinE;
	}

	@Basic
	@Column(name = "yuanYouYuQiShiJian", nullable = true)
	public Date getYuanYouYuQiShiJian() {
		return yuanYouYuQiShiJian;
	}

	public void setYuanYouYuQiShiJian(Date yuanYouYuQiShiJian) {
		this.yuanYouYuQiShiJian = yuanYouYuQiShiJian;
	}

	@Basic
	@Column(name = "yuanYouQianXiJinE", precision = 2)
	public Double getYuanYouQianXiJinE() {
		return yuanYouQianXiJinE;
	}

	public void setYuanYouQianXiJinE(Double yuanYouQianXiJinE) {
		this.yuanYouQianXiJinE = yuanYouQianXiJinE;
	}

	@Basic
	@Column(name = "yuanYouQianXiShiJian", nullable = true)
	public Date getYuanYouQianXiShiJian() {
		return yuanYouQianXiShiJian;
	}

	public void setYuanYouQianXiShiJian(Date yuanYouQianXiShiJian) {
		this.yuanYouQianXiShiJian = yuanYouQianXiShiJian;
	}

	@Basic
	@Column(name = "fuPingivenStars", length = 255)
	public String getFuPingivenStars() {
		return fuPingivenStars;
	}

	public void setFuPingivenStars(String fuPingivenStars) {
		this.fuPingivenStars = fuPingivenStars;
	}

	@Basic
	@Column(name = "fuPinshouXinEDu", precision = 2)
	public Double getFuPinshouXinEDu() {
		return fuPinshouXinEDu;
	}

	public void setFuPinshouXinEDu(Double fuPinshouXinEDu) {
		this.fuPinshouXinEDu = fuPinshouXinEDu;
	}

	@Basic
	@Column(name = "fuPinshouXinJiGou", length = 255)
	public String getFuPinshouXinJiGou() {
		return fuPinshouXinJiGou;
	}

	public void setFuPinshouXinJiGou(String fuPinshouXinJiGou) {
		this.fuPinshouXinJiGou = fuPinshouXinJiGou;
	}

	@Basic
	@Column(name = "fuPinshouxinData", nullable = true)
	public Date getFuPinshouxinData() {
		return fuPinshouxinData;
	}

	public void setFuPinshouxinData(Date fuPinshouxinData) {
		this.fuPinshouxinData = fuPinshouxinData;
	}

	@Basic
	@Column(name = "fuPinXiaoDaidaiKuanJinE", precision = 2)
	public Double getFuPinXiaoDaidaiKuanJinE() {
		return fuPinXiaoDaidaiKuanJinE;
	}

	public void setFuPinXiaoDaidaiKuanJinE(Double fuPinXiaoDaidaiKuanJinE) {
		this.fuPinXiaoDaidaiKuanJinE = fuPinXiaoDaidaiKuanJinE;
	}

	@Basic
	@Column(name = "fuPindaiKuanQiXian", length = 50)
	public String getFuPindaiKuanQiXian() {
		return fuPindaiKuanQiXian;
	}

	public void setFuPindaiKuanQiXian(String fuPindaiKuanQiXian) {
		this.fuPindaiKuanQiXian = fuPindaiKuanQiXian;
	}

	@Basic
	@Column(name = "fuPinfangKuanRiQi", nullable = true)
	public Date getFuPinfangKuanRiQi() {
		return fuPinfangKuanRiQi;
	}

	public void setFuPinfangKuanRiQi(Date fuPinfangKuanRiQi) {
		this.fuPinfangKuanRiQi = fuPinfangKuanRiQi;
	}

	@Basic
	@Column(name = "fuPindaoQiRiQi", nullable = true)
	public Date getFuPindaoQiRiQi() {
		return fuPindaoQiRiQi;
	}

	public void setFuPindaoQiRiQi(Date fuPindaoQiRiQi) {
		this.fuPindaoQiRiQi = fuPindaoQiRiQi;
	}

	@Basic
	@Column(name = "fuPinXiaoDaiDaiKuanLiLv", precision = 6)
	public Double getFuPinXiaoDaiDaiKuanLiLv() {
		return fuPinXiaoDaiDaiKuanLiLv;
	}

	public void setFuPinXiaoDaiDaiKuanLiLv(Double fuPinXiaoDaiDaiKuanLiLv) {
		this.fuPinXiaoDaiDaiKuanLiLv = fuPinXiaoDaiDaiKuanLiLv;
	}

	@Basic
	@Column(name = "fuPindaiKuanJiGou", length = 255)
	public String getFuPindaiKuanJiGou() {
		return fuPindaiKuanJiGou;
	}

	public void setFuPindaiKuanJiGou(String fuPindaiKuanJiGou) {
		this.fuPindaiKuanJiGou = fuPindaiKuanJiGou;
	}

	@Basic
	@Column(name = "fuPinleiJiTieXi", precision = 4)
	public Double getFuPinleiJiTieXi() {
		return fuPinleiJiTieXi;
	}

	public void setFuPinleiJiTieXi(Double fuPinleiJiTieXi) {
		this.fuPinleiJiTieXi = fuPinleiJiTieXi;
	}

	@Basic
	@Column(name = "fuPinchangHuanDaiKuanJInE", precision = 4)
	public Double getFuPinchangHuanDaiKuanJInE() {
		return fuPinchangHuanDaiKuanJInE;
	}

	public void setFuPinchangHuanDaiKuanJInE(Double fuPinchangHuanDaiKuanJInE) {
		this.fuPinchangHuanDaiKuanJInE = fuPinchangHuanDaiKuanJInE;
	}

	@Basic
	@Column(name = "fuPinhuanKuanShiJian", nullable = true)
	public Date getFuPinhuanKuanShiJian() {
		return fuPinhuanKuanShiJian;
	}

	public void setFuPinhuanKuanShiJian(Date fuPinhuanKuanShiJian) {
		this.fuPinhuanKuanShiJian = fuPinhuanKuanShiJian;
	}

	@Basic
	@Column(name = "fuPindaiKuanYuE", precision = 2)
	public Double getFuPindaiKuanYuE() {
		return fuPindaiKuanYuE;
	}

	public void setFuPindaiKuanYuE(Double fuPindaiKuanYuE) {
		this.fuPindaiKuanYuE = fuPindaiKuanYuE;
	}

	@Basic
	@Column(name = "fuPinyuQiDaiKuanJinE", precision = 2)
	public Double getFuPinyuQiDaiKuanJinE() {
		return fuPinyuQiDaiKuanJinE;
	}

	public void setFuPinyuQiDaiKuanJinE(Double fuPinyuQiDaiKuanJinE) {
		this.fuPinyuQiDaiKuanJinE = fuPinyuQiDaiKuanJinE;
	}

	@Basic
	@Column(name = "fuPinyuQiDaiKuanShiJian", nullable = true)
	public Date getFuPinyuQiDaiKuanShiJian() {
		return fuPinyuQiDaiKuanShiJian;
	}

	public void setFuPinyuQiDaiKuanShiJian(Date fuPinyuQiDaiKuanShiJian) {
		this.fuPinyuQiDaiKuanShiJian = fuPinyuQiDaiKuanShiJian;
	}

	@Basic
	@Column(name = "fuPinqianXiJinE", precision = 2)
	public Double getFuPinqianXiJinE() {
		return fuPinqianXiJinE;
	}

	public void setFuPinqianXiJinE(Double fuPinqianXiJinE) {
		this.fuPinqianXiJinE = fuPinqianXiJinE;
	}

	@Basic
	@Column(name = "fuPinqianXiShiJian", nullable = true)
	public Date getFuPinqianXiShiJian() {
		return fuPinqianXiShiJian;
	}

	public void setFuPinqianXiShiJian(Date fuPinqianXiShiJian) {
		this.fuPinqianXiShiJian = fuPinqianXiShiJian;
	}

	@Basic
	@Column(name = "fuPinYingDaiWeiDaiShiBie", length = 20)
	public String getFuPinYingDaiWeiDaiShiBie() {
		return fuPinYingDaiWeiDaiShiBie;
	}

	public void setFuPinYingDaiWeiDaiShiBie(String fuPinYingDaiWeiDaiShiBie) {
		this.fuPinYingDaiWeiDaiShiBie = fuPinYingDaiWeiDaiShiBie;
	}

	@Basic
	@Column(name = "fuPinDaiKuanYongTu", length = 255)
	public String getFuPinDaiKuanYongTu() {
		return fuPinDaiKuanYongTu;
	}

	public void setFuPinDaiKuanYongTu(String fuPinDaiKuanYongTu) {
		this.fuPinDaiKuanYongTu = fuPinDaiKuanYongTu;
	}

	@Basic
	@Column(name = "chuangYeJinE", precision = 2)
	public Double getChuangYeJinE() {
		return chuangYeJinE;
	}

	public void setChuangYeJinE(Double chuangYeJinE) {
		this.chuangYeJinE = chuangYeJinE;
	}

	@Basic
	@Column(name = "chuangYeQiXian", length = 20)
	public String getChuangYeQiXian() {
		return chuangYeQiXian;
	}

	public void setChuangYeQiXian(String chuangYeQiXian) {
		this.chuangYeQiXian = chuangYeQiXian;
	}

	@Basic
	@Column(name = "chuangYeFangKuanRiQi", nullable = true)
	public Date getChuangYeFangKuanRiQi() {
		return chuangYeFangKuanRiQi;
	}

	public void setChuangYeFangKuanRiQi(Date chuangYeFangKuanRiQi) {
		this.chuangYeFangKuanRiQi = chuangYeFangKuanRiQi;
	}

	@Basic
	@Column(name = "chuangYeDaoQiShiJian", nullable = true)
	public Date getChuangYeDaoQiShiJian() {
		return chuangYeDaoQiShiJian;
	}

	public void setChuangYeDaoQiShiJian(Date chuangYeDaoQiShiJian) {
		this.chuangYeDaoQiShiJian = chuangYeDaoQiShiJian;
	}

	@Basic
	@Column(name = "chuangYeLiLv", precision = 6)
	public Double getChuangYeLiLv() {
		return chuangYeLiLv;
	}

	public void setChuangYeLiLv(Double chuangYeLiLv) {
		this.chuangYeLiLv = chuangYeLiLv;
	}

	@Basic
	@Column(name = "chuangYeChangHuanJinE", precision = 2)
	public Double getChuangYeChangHuanJinE() {
		return chuangYeChangHuanJinE;
	}

	public void setChuangYeChangHuanJinE(Double chuangYeChangHuanJinE) {
		this.chuangYeChangHuanJinE = chuangYeChangHuanJinE;
	}

	@Basic
	@Column(name = "changYeHuangKuanShiJian", nullable = true)
	public Date getChangYeHuangKuanShiJian() {
		return changYeHuangKuanShiJian;
	}

	public void setChangYeHuangKuanShiJian(Date changYeHuangKuanShiJian) {
		this.changYeHuangKuanShiJian = changYeHuangKuanShiJian;
	}

	@Basic
	@Column(name = "chuangYeYuE", precision = 2)
	public Double getChuangYeYuE() {
		return chuangYeYuE;
	}

	public void setChuangYeYuE(Double chuangYeYuE) {
		this.chuangYeYuE = chuangYeYuE;
	}

	@Basic
	@Column(name = "chuangYeYuQiJinE", precision = 2)
	public Double getChuangYeYuQiJinE() {
		return chuangYeYuQiJinE;
	}

	public void setChuangYeYuQiJinE(Double chuangYeYuQiJinE) {
		this.chuangYeYuQiJinE = chuangYeYuQiJinE;
	}

	@Basic
	@Column(name = "chuangYeYuQiShiJian", nullable = true)
	public Date getChuangYeYuQiShiJian() {
		return chuangYeYuQiShiJian;
	}

	public void setChuangYeYuQiShiJian(Date chuangYeYuQiShiJian) {
		this.chuangYeYuQiShiJian = chuangYeYuQiShiJian;
	}

	@Basic
	@Column(name = "chuangYeQianXiJinE", precision = 2)
	public Double getChuangYeQianXiJinE() {
		return chuangYeQianXiJinE;
	}

	public void setChuangYeQianXiJinE(Double chuangYeQianXiJinE) {
		this.chuangYeQianXiJinE = chuangYeQianXiJinE;
	}

	@Basic
	@Column(name = "chuangYeQianXiShiJian", nullable = true)
	public Date getChuangYeQianXiShiJian() {
		return chuangYeQianXiShiJian;
	}

	public void setChuangYeQianXiShiJian(Date chuangYeQianXiShiJian) {
		this.chuangYeQianXiShiJian = chuangYeQianXiShiJian;
	}

	@Basic
	@Column(name = "chuangYeYongTu", length = 255)
	public String getChuangYeYongTu() {
		return chuangYeYongTu;
	}

	public void setChuangYeYongTu(String chuangYeYongTu) {
		this.chuangYeYongTu = chuangYeYongTu;
	}

	@Basic
	@Column(name = "shengYuanJinE", precision = 2)
	public Double getShengYuanJinE() {
		return shengYuanJinE;
	}

	public void setShengYuanJinE(Double shengYuanJinE) {
		this.shengYuanJinE = shengYuanJinE;
	}

	@Basic
	@Column(name = "shengYuanQiXian")
	public String getShengYuanQiXian() {
		return shengYuanQiXian;
	}

	public void setShengYuanQiXian(String shengYuanQiXian) {
		this.shengYuanQiXian = shengYuanQiXian;
	}

	@Basic
	@Column(name = "shengYuanFangKuanRiQi", nullable = true)
	public Date getShengYuanFangKuanRiQi() {
		return shengYuanFangKuanRiQi;
	}

	public void setShengYuanFangKuanRiQi(Date shengYuanFangKuanRiQi) {
		this.shengYuanFangKuanRiQi = shengYuanFangKuanRiQi;
	}

	@Basic
	@Column(name = "shengYaunDaoQiRiQi", nullable = true)
	public Date getShengYaunDaoQiRiQi() {
		return shengYaunDaoQiRiQi;
	}

	public void setShengYaunDaoQiRiQi(Date shengYaunDaoQiRiQi) {
		this.shengYaunDaoQiRiQi = shengYaunDaoQiRiQi;
	}

	@Basic
	@Column(name = "shengYaunLiLv", precision = 6)
	public Double getShengYaunLiLv() {
		return shengYaunLiLv;
	}

	public void setShengYaunLiLv(Double shengYaunLiLv) {
		this.shengYaunLiLv = shengYaunLiLv;
	}

	@Basic
	@Column(name = "shengYaunChangHuanJinE", precision = 2)
	public Double getShengYaunChangHuanJinE() {
		return shengYaunChangHuanJinE;
	}

	public void setShengYaunChangHuanJinE(Double shengYaunChangHuanJinE) {
		this.shengYaunChangHuanJinE = shengYaunChangHuanJinE;
	}

	@Basic
	@Column(name = "shengYuanHuanKuanShiJian", nullable = true)
	public Date getShengYuanHuanKuanShiJian() {
		return shengYuanHuanKuanShiJian;
	}

	public void setShengYuanHuanKuanShiJian(Date shengYuanHuanKuanShiJian) {
		this.shengYuanHuanKuanShiJian = shengYuanHuanKuanShiJian;
	}

	@Basic
	@Column(name = "shengYuanYuE", precision = 2)
	public Double getShengYuanYuE() {
		return shengYuanYuE;
	}

	public void setShengYuanYuE(Double shengYuanYuE) {
		this.shengYuanYuE = shengYuanYuE;
	}

	@Basic
	@Column(name = "shengYuanYuQiJinE", precision = 2)
	public Double getShengYuanYuQiJinE() {
		return shengYuanYuQiJinE;
	}

	public void setShengYuanYuQiJinE(Double shengYuanYuQiJinE) {
		this.shengYuanYuQiJinE = shengYuanYuQiJinE;
	}

	@Basic
	@Column(name = "shengYuanYuQiShiJian", nullable = true)
	public Date getShengYuanYuQiShiJian() {
		return shengYuanYuQiShiJian;
	}

	public void setShengYuanYuQiShiJian(Date shengYuanYuQiShiJian) {
		this.shengYuanYuQiShiJian = shengYuanYuQiShiJian;
	}

	@Basic
	@Column(name = "shengYuanQianXiJinE", precision = 2)
	public Double getShengYuanQianXiJinE() {
		return shengYuanQianXiJinE;
	}

	public void setShengYuanQianXiJinE(Double shengYuanQianXiJinE) {
		this.shengYuanQianXiJinE = shengYuanQianXiJinE;
	}

	@Basic
	@Column(name = "shengYuanQianXiShiJian", nullable = true)
	public Date getShengYuanQianXiShiJian() {
		return shengYuanQianXiShiJian;
	}

	public void setShengYuanQianXiShiJian(Date shengYuanQianXiShiJian) {
		this.shengYuanQianXiShiJian = shengYuanQianXiShiJian;
	}

	@Basic
	@Column(name = "qiTaJinE", precision = 2)
	public Double getQiTaJinE() {
		return qiTaJinE;
	}

	public void setQiTaJinE(Double qiTaJinE) {
		this.qiTaJinE = qiTaJinE;
	}

	@Basic
	@Column(name = "qiTaQiXian")
	public String getQiTaQiXian() {
		return qiTaQiXian;
	}

	public void setQiTaQiXian(String qiTaQiXian) {
		this.qiTaQiXian = qiTaQiXian;
	}

	@Basic
	@Column(name = "qiTaFangKuanRiQi", nullable = true)
	public Date getQiTaFangKuanRiQi() {
		return qiTaFangKuanRiQi;
	}

	public void setQiTaFangKuanRiQi(Date qiTaFangKuanRiQi) {
		this.qiTaFangKuanRiQi = qiTaFangKuanRiQi;
	}

	@Basic
	@Column(name = "qiTaDaoQiRiQi", nullable = true)
	public Date getQiTaDaoQiRiQi() {
		return qiTaDaoQiRiQi;
	}

	public void setQiTaDaoQiRiQi(Date qiTaDaoQiRiQi) {
		this.qiTaDaoQiRiQi = qiTaDaoQiRiQi;
	}

	@Basic
	@Column(name = "qiTaLiLv", precision = 6)
	public Double getQiTaLiLv() {
		return qiTaLiLv;
	}

	public void setQiTaLiLv(Double qiTaLiLv) {
		this.qiTaLiLv = qiTaLiLv;
	}

	@Basic
	@Column(name = "qiTaChangHuanJinE", precision = 2)
	public Double getQiTaChangHuanJinE() {
		return qiTaChangHuanJinE;
	}

	public void setQiTaChangHuanJinE(Double qiTaChangHuanJinE) {
		this.qiTaChangHuanJinE = qiTaChangHuanJinE;
	}

	@Basic
	@Column(name = "qiTaChangHuangKuanShiJian", nullable = true)
	public Date getQiTaChangHuangKuanShiJian() {
		return qiTaChangHuangKuanShiJian;
	}

	public void setQiTaChangHuangKuanShiJian(Date qiTaChangHuangKuanShiJian) {
		this.qiTaChangHuangKuanShiJian = qiTaChangHuangKuanShiJian;
	}

	@Basic
	@Column(name = "qiTaYuE", precision = 2)
	public Double getQiTaYuE() {
		return qiTaYuE;
	}

	public void setQiTaYuE(Double qiTaYuE) {
		this.qiTaYuE = qiTaYuE;
	}

	@Basic
	@Column(name = "qiTaYuQiJinE", precision = 2)
	public Double getQiTaYuQiJinE() {
		return qiTaYuQiJinE;
	}

	public void setQiTaYuQiJinE(Double qiTaYuQiJinE) {
		this.qiTaYuQiJinE = qiTaYuQiJinE;
	}

	@Basic
	@Column(name = "qiTaYuQiShiJian", nullable = true)
	public Date getQiTaYuQiShiJian() {
		return qiTaYuQiShiJian;
	}

	public void setQiTaYuQiShiJian(Date qiTaYuQiShiJian) {
		this.qiTaYuQiShiJian = qiTaYuQiShiJian;
	}

	@Basic
	@Column(name = "qiTaQianXiJinE", precision = 2)
	public Double getQiTaQianXiJinE() {
		return qiTaQianXiJinE;
	}

	public void setQiTaQianXiJinE(Double qiTaQianXiJinE) {
		this.qiTaQianXiJinE = qiTaQianXiJinE;
	}

	@Basic
	@Column(name = "qiTaQianXiShiJian", nullable = true)
	public Date getQiTaQianXiShiJian() {
		return qiTaQianXiShiJian;
	}

	public void setQiTaQianXiShiJian(Date qiTaQianXiShiJian) {
		this.qiTaQianXiShiJian = qiTaQianXiShiJian;
	}

	@Basic
	@Column(name = "qiTaYongTu", length = 255)
	public String getQiTaYongTu() {
		return qiTaYongTu;
	}

	public void setQiTaYongTu(String qiTaYongTu) {
		this.qiTaYongTu = qiTaYongTu;
	}

	@Basic
	@Column(name = "tongJiShiJian", nullable = false)
	public Date getTongJiShiJian() {
		return tongJiShiJian;
	}

	public void setTongJiShiJian(Date tongJiShiJian) {
		this.tongJiShiJian = tongJiShiJian;
	}

	@Basic
	@Column(name = "note", length = 255)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Basic
	@Column(name = "operationDate", nullable = true)
	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	@Basic
	@Column(name = "operationPerson", length = 50)
	public String getOperationPerson() {
		return operationPerson;
	}

	public void setOperationPerson(String operationPerson) {
		this.operationPerson = operationPerson;
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
	@Column(name = "checkPerson", length = 50)
	public String getCheckPerson() {
		return checkPerson;
	}

	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}

	@Basic
	@Column(name = "checkStatus", length = 10)
	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Basic
	@Column(name = "reason", length = 255)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Basic
	@Column(name = "operation", length = 10)
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Basic
	@Column(name = "delStatus", length = 10)
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "BaseFpxexdHistory{" +
				"no=" + no +
				", xiang='" + xiang + '\'' +
				", chun='" + chun + '\'' +
				", zu='" + zu + '\'' +
				", name='" + name + '\'' +
				", cardId='" + cardId + '\'' +
				", members=" + members +
				", daiKuanRenXingMing='" + daiKuanRenXingMing + '\'' +
				", daiKuanRenCardId='" + daiKuanRenCardId + '\'' +
				", familyRelation='" + familyRelation + '\'' +
				", tuoPinState='" + tuoPinState + '\'' +
				", yuanYouYuE=" + yuanYouYuE +
				", yuanYouIsYuQi='" + yuanYouIsYuQi + '\'' +
				", yuanYouYuQiJinE=" + yuanYouYuQiJinE +
				", yuanYouYuQiShiJian=" + yuanYouYuQiShiJian +
				", yuanYouQianXiJinE=" + yuanYouQianXiJinE +
				", yuanYouQianXiShiJian=" + yuanYouQianXiShiJian +
				", fuPingivenStars='" + fuPingivenStars + '\'' +
				", fuPinshouXinEDu=" + fuPinshouXinEDu +
				", fuPinshouXinJiGou='" + fuPinshouXinJiGou + '\'' +
				", fuPinshouxinData=" + fuPinshouxinData +
				", fuPinXiaoDaidaiKuanJinE=" + fuPinXiaoDaidaiKuanJinE +
				", fuPindaiKuanQiXian='" + fuPindaiKuanQiXian + '\'' +
				", fuPinfangKuanRiQi=" + fuPinfangKuanRiQi +
				", fuPindaoQiRiQi=" + fuPindaoQiRiQi +
				", fuPinXiaoDaiDaiKuanLiLv=" + fuPinXiaoDaiDaiKuanLiLv +
				", fuPindaiKuanJiGou='" + fuPindaiKuanJiGou + '\'' +
				", fuPinleiJiTieXi=" + fuPinleiJiTieXi +
				", fuPinchangHuanDaiKuanJInE=" + fuPinchangHuanDaiKuanJInE +
				", fuPinhuanKuanShiJian=" + fuPinhuanKuanShiJian +
				", fuPindaiKuanYuE=" + fuPindaiKuanYuE +
				", fuPinyuQiDaiKuanJinE=" + fuPinyuQiDaiKuanJinE +
				", fuPinyuQiDaiKuanShiJian=" + fuPinyuQiDaiKuanShiJian +
				", fuPinqianXiJinE=" + fuPinqianXiJinE +
				", fuPinqianXiShiJian=" + fuPinqianXiShiJian +
				", fuPinYingDaiWeiDaiShiBie='" + fuPinYingDaiWeiDaiShiBie + '\'' +
				", fuPinDaiKuanYongTu='" + fuPinDaiKuanYongTu + '\'' +
				", chuangYeJinE=" + chuangYeJinE +
				", chuangYeQiXian='" + chuangYeQiXian + '\'' +
				", chuangYeFangKuanRiQi=" + chuangYeFangKuanRiQi +
				", chuangYeDaoQiShiJian=" + chuangYeDaoQiShiJian +
				", chuangYeLiLv=" + chuangYeLiLv +
				", chuangYeChangHuanJinE=" + chuangYeChangHuanJinE +
				", changYeHuangKuanShiJian=" + changYeHuangKuanShiJian +
				", chuangYeYuE=" + chuangYeYuE +
				", chuangYeYuQiJinE=" + chuangYeYuQiJinE +
				", chuangYeYuQiShiJian=" + chuangYeYuQiShiJian +
				", chuangYeQianXiJinE=" + chuangYeQianXiJinE +
				", chuangYeQianXiShiJian=" + chuangYeQianXiShiJian +
				", chuangYeYongTu='" + chuangYeYongTu + '\'' +
				", shengYuanJinE=" + shengYuanJinE +
				", shengYuanQiXian='" + shengYuanQiXian + '\'' +
				", shengYuanFangKuanRiQi=" + shengYuanFangKuanRiQi +
				", shengYaunDaoQiRiQi=" + shengYaunDaoQiRiQi +
				", shengYaunLiLv=" + shengYaunLiLv +
				", shengYaunChangHuanJinE=" + shengYaunChangHuanJinE +
				", shengYuanHuanKuanShiJian=" + shengYuanHuanKuanShiJian +
				", shengYuanYuE=" + shengYuanYuE +
				", shengYuanYuQiJinE=" + shengYuanYuQiJinE +
				", shengYuanYuQiShiJian=" + shengYuanYuQiShiJian +
				", shengYuanQianXiJinE=" + shengYuanQianXiJinE +
				", shengYuanQianXiShiJian=" + shengYuanQianXiShiJian +
				", qiTaJinE=" + qiTaJinE +
				", qiTaQiXian='" + qiTaQiXian + '\'' +
				", qiTaFangKuanRiQi=" + qiTaFangKuanRiQi +
				", qiTaDaoQiRiQi=" + qiTaDaoQiRiQi +
				", qiTaLiLv=" + qiTaLiLv +
				", qiTaChangHuanJinE=" + qiTaChangHuanJinE +
				", qiTaChangHuangKuanShiJian=" + qiTaChangHuangKuanShiJian +
				", qiTaYuE=" + qiTaYuE +
				", qiTaYuQiJinE=" + qiTaYuQiJinE +
				", qiTaYuQiShiJian=" + qiTaYuQiShiJian +
				", qiTaQianXiJinE=" + qiTaQianXiJinE +
				", qiTaQianXiShiJian=" + qiTaQianXiShiJian +
				", qiTaYongTu='" + qiTaYongTu + '\'' +
				", tongJiShiJian=" + tongJiShiJian +
				", note='" + note + '\'' +
				", operationDate=" + operationDate +
				", operationPerson='" + operationPerson + '\'' +
				", checkDate=" + checkDate +
				", checkPerson='" + checkPerson + '\'' +
				", checkStatus='" + checkStatus + '\'' +
				", reason='" + reason + '\'' +
				", operation='" + operation + '\'' +
				", delStatus='" + delStatus + '\'' +
				", delDate=" + delDate +
				", unit='" + unit + '\'' +
				'}';
	}
}
