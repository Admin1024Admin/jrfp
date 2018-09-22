package com.ky.ct.rzdj.model.cyjzfpdk;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "base_cyjzfpdk_history", schema = "pashanhu", catalog = "")
public class BaseCyjzfpdkHistory {
	private Long uid;
	private String name;
	private String tongYiXinYongMa;
	private String address;
	private String telephone;
	private String agreementNo;
	private Double daiKuanJinE;
	private String daiKuanQiXian;
	private Date daiKuanDate;
	private Date daoQiDate;
	private Double daiKuanLiLv;
	private String daiKuanZhongLei;
	private String daiKuanFangShi;
	private String daiKuanYongTu;
	private String daiKuanShiYongArea;
	private String chanYeLeiBie;
	private String chanYeFuPinLeiBie;
	private String zhuTiDaiKuanLeiBie;
	private String daiKuanJiGou;
	private Date touFangDate;
	private Double touFangJinE;
	private Double leiJiTouFangJinE;
	private Double weiTouFangYuE;
	private Double changHuanJinE;
	private Date changHuanDate;
	private Double leiJiChangHuanJinE;
	private Double weiChangHuanYuE;
	private Double yuQiJinE;
	private Date yuQiDate;
	private Date qianXiDate;
	private Double qianXiJinE;
	private String liYiLianJieFangShi;
	private String daiDongPkHMingDan;
	private Integer daiDongPkRenKouShu;
	private Double zhiJieDaiDongXiaoYi;
	private String note;
	private String shuJuWeiHuDanWei;
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
	@Column(name = "name", nullable = true, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "tongYiXinYongMa", nullable = true, length = 50)
	public String getTongYiXinYongMa() {
		return tongYiXinYongMa;
	}

	public void setTongYiXinYongMa(String tongYiXinYongMa) {
		this.tongYiXinYongMa = tongYiXinYongMa;
	}

	@Basic
	@Column(name = "address", nullable = true, length = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name = "telephone", nullable = true, length = 20)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	@Column(name = "daiKuanJinE", nullable = true, precision = 2)
	public Double getDaiKuanJinE() {
		return daiKuanJinE;
	}

	public void setDaiKuanJinE(Double daiKuanJinE) {
		this.daiKuanJinE = daiKuanJinE;
	}

	@Basic
	@Column(name = "daiKuanQiXian", nullable = true, length = 20)
	public String getDaiKuanQiXian() {
		return daiKuanQiXian;
	}

	public void setDaiKuanQiXian(String daiKuanQiXian) {
		this.daiKuanQiXian = daiKuanQiXian;
	}

	@Basic
	@Column(name = "daiKuanDate", nullable = true)
	public Date getDaiKuanDate() {
		return daiKuanDate;
	}

	public void setDaiKuanDate(Date daiKuanDate) {
		this.daiKuanDate = daiKuanDate;
	}

	@Basic
	@Column(name = "daoQiDate", nullable = true)
	public Date getDaoQiDate() {
		return daoQiDate;
	}

	public void setDaoQiDate(Date daoQiDate) {
		this.daoQiDate = daoQiDate;
	}

	@Basic
	@Column(name = "daiKuanLiLv", nullable = true, precision = 2)
	public Double getDaiKuanLiLv() {
		return daiKuanLiLv;
	}

	public void setDaiKuanLiLv(Double daiKuanLiLv) {
		this.daiKuanLiLv = daiKuanLiLv;
	}

	@Basic
	@Column(name = "daiKuanZhongLei", nullable = true, length = 50)
	public String getDaiKuanZhongLei() {
		return daiKuanZhongLei;
	}

	public void setDaiKuanZhongLei(String daiKuanZhongLei) {
		this.daiKuanZhongLei = daiKuanZhongLei;
	}

	@Basic
	@Column(name = "daiKuanFangShi", nullable = true, length = 50)
	public String getDaiKuanFangShi() {
		return daiKuanFangShi;
	}

	public void setDaiKuanFangShi(String daiKuanFangShi) {
		this.daiKuanFangShi = daiKuanFangShi;
	}

	@Basic
	@Column(name = "daiKuanYongTu", nullable = true, length = 200)
	public String getDaiKuanYongTu() {
		return daiKuanYongTu;
	}

	public void setDaiKuanYongTu(String daiKuanYongTu) {
		this.daiKuanYongTu = daiKuanYongTu;
	}

	@Basic
	@Column(name = "daiKuanShiYongArea", nullable = true, length = 200)
	public String getDaiKuanShiYongArea() {
		return daiKuanShiYongArea;
	}

	public void setDaiKuanShiYongArea(String daiKuanShiYongArea) {
		this.daiKuanShiYongArea = daiKuanShiYongArea;
	}

	@Basic
	@Column(name = "chanYeLeiBie", nullable = true, length = 50)
	public String getChanYeLeiBie() {
		return chanYeLeiBie;
	}

	public void setChanYeLeiBie(String chanYeLeiBie) {
		this.chanYeLeiBie = chanYeLeiBie;
	}

	@Basic
	@Column(name = "chanYeFuPinLeiBie", nullable = true, length = 50)
	public String getChanYeFuPinLeiBie() {
		return chanYeFuPinLeiBie;
	}

	public void setChanYeFuPinLeiBie(String chanYeFuPinLeiBie) {
		this.chanYeFuPinLeiBie = chanYeFuPinLeiBie;
	}

	@Basic
	@Column(name = "zhuTiDaiKuanLeiBie", nullable = true, length = 50)
	public String getZhuTiDaiKuanLeiBie() {
		return zhuTiDaiKuanLeiBie;
	}

	public void setZhuTiDaiKuanLeiBie(String zhuTiDaiKuanLeiBie) {
		this.zhuTiDaiKuanLeiBie = zhuTiDaiKuanLeiBie;
	}

	@Basic
	@Column(name = "daiKuanJiGou", nullable = true, length = 100)
	public String getDaiKuanJiGou() {
		return daiKuanJiGou;
	}

	public void setDaiKuanJiGou(String daiKuanJiGou) {
		this.daiKuanJiGou = daiKuanJiGou;
	}

	@Basic
	@Column(name = "touFangDate", nullable = true)
	public Date getTouFangDate() {
		return touFangDate;
	}

	public void setTouFangDate(Date touFangDate) {
		this.touFangDate = touFangDate;
	}

	@Basic
	@Column(name = "touFangJinE", nullable = true, precision = 2)
	public Double getTouFangJinE() {
		return touFangJinE;
	}

	public void setTouFangJinE(Double touFangJinE) {
		this.touFangJinE = touFangJinE;
	}

	@Basic
	@Column(name = "leiJiTouFangJinE", nullable = true, precision = 2)
	public Double getLeiJiTouFangJinE() {
		return leiJiTouFangJinE;
	}

	public void setLeiJiTouFangJinE(Double leiJiTouFangJinE) {
		this.leiJiTouFangJinE = leiJiTouFangJinE;
	}

	@Basic
	@Column(name = "weiTouFangYuE", nullable = true, precision = 2)
	public Double getWeiTouFangYuE() {
		return weiTouFangYuE;
	}

	public void setWeiTouFangYuE(Double weiTouFangYuE) {
		this.weiTouFangYuE = weiTouFangYuE;
	}

	@Basic
	@Column(name = "changHuanJinE", nullable = true, precision = 2)
	public Double getChangHuanJinE() {
		return changHuanJinE;
	}

	public void setChangHuanJinE(Double changHuanJinE) {
		this.changHuanJinE = changHuanJinE;
	}

	@Basic
	@Column(name = "changHuanDate", nullable = true)
	public Date getChangHuanDate() {
		return changHuanDate;
	}

	public void setChangHuanDate(Date changHuanDate) {
		this.changHuanDate = changHuanDate;
	}

	@Basic
	@Column(name = "leiJiChangHuanJinE", nullable = true, precision = 2)
	public Double getLeiJiChangHuanJinE() {
		return leiJiChangHuanJinE;
	}

	public void setLeiJiChangHuanJinE(Double leiJiChangHuanJinE) {
		this.leiJiChangHuanJinE = leiJiChangHuanJinE;
	}

	@Basic
	@Column(name = "weiChangHuanYuE", nullable = true, precision = 2)
	public Double getWeiChangHuanYuE() {
		return weiChangHuanYuE;
	}

	public void setWeiChangHuanYuE(Double weiChangHuanYuE) {
		this.weiChangHuanYuE = weiChangHuanYuE;
	}

	@Basic
	@Column(name = "yuQiJinE", nullable = true, precision = 2)
	public Double getYuQiJinE() {
		return yuQiJinE;
	}

	public void setYuQiJinE(Double yuQiJinE) {
		this.yuQiJinE = yuQiJinE;
	}

	@Basic
	@Column(name = "yuQiDate", nullable = true)
	public Date getYuQiDate() {
		return yuQiDate;
	}

	public void setYuQiDate(Date yuQiDate) {
		this.yuQiDate = yuQiDate;
	}

	@Basic
	@Column(name = "qianXiDate", nullable = true)
	public Date getQianXiDate() {
		return qianXiDate;
	}

	public void setQianXiDate(Date qianXiDate) {
		this.qianXiDate = qianXiDate;
	}

	@Basic
	@Column(name = "qianXiJinE", nullable = true, precision = 2)
	public Double getQianXiJinE() {
		return qianXiJinE;
	}

	public void setQianXiJinE(Double qianXiJinE) {
		this.qianXiJinE = qianXiJinE;
	}

	@Basic
	@Column(name = "LiYiLianJieFangShi", nullable = true, length = 50)
	public String getLiYiLianJieFangShi() {
		return liYiLianJieFangShi;
	}

	public void setLiYiLianJieFangShi(String liYiLianJieFangShi) {
		this.liYiLianJieFangShi = liYiLianJieFangShi;
	}

	@Basic
	@Column(name = "daiDongPkHMingDan", nullable = true, length = 50)
	public String getDaiDongPkHMingDan() {
		return daiDongPkHMingDan;
	}

	public void setDaiDongPkHMingDan(String daiDongPkHMingDan) {
		this.daiDongPkHMingDan = daiDongPkHMingDan;
	}

	@Basic
	@Column(name = "daiDongPkRenKouShu", nullable = true)
	public Integer getDaiDongPkRenKouShu() {
		return daiDongPkRenKouShu;
	}

	public void setDaiDongPkRenKouShu(Integer daiDongPkRenKouShu) {
		this.daiDongPkRenKouShu = daiDongPkRenKouShu;
	}

	@Basic
	@Column(name = "zhiJieDaiDongXiaoYi", nullable = true, precision = 2)
	public Double getZhiJieDaiDongXiaoYi() {
		return zhiJieDaiDongXiaoYi;
	}

	public void setZhiJieDaiDongXiaoYi(Double zhiJieDaiDongXiaoYi) {
		this.zhiJieDaiDongXiaoYi = zhiJieDaiDongXiaoYi;
	}

	@Basic
	@Column(name = "note", nullable = true, length = 200)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Basic
	@Column(name = "shuJuWeiHuDanWei", nullable = true, length = 50)
	public String getShuJuWeiHuDanWei() {
		return shuJuWeiHuDanWei;
	}

	public void setShuJuWeiHuDanWei(String shuJuWeiHuDanWei) {
		this.shuJuWeiHuDanWei = shuJuWeiHuDanWei;
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
		BaseCyjzfpdkHistory that = (BaseCyjzfpdkHistory) o;
		return Objects.equals(uid, that.uid) &&
				Objects.equals(name, that.name) &&
				Objects.equals(tongYiXinYongMa, that.tongYiXinYongMa) &&
				Objects.equals(address, that.address) &&
				Objects.equals(telephone, that.telephone) &&
				Objects.equals(agreementNo, that.agreementNo) &&
				Objects.equals(daiKuanJinE, that.daiKuanJinE) &&
				Objects.equals(daiKuanQiXian, that.daiKuanQiXian) &&
				Objects.equals(daiKuanDate, that.daiKuanDate) &&
				Objects.equals(daoQiDate, that.daoQiDate) &&
				Objects.equals(daiKuanLiLv, that.daiKuanLiLv) &&
				Objects.equals(daiKuanZhongLei, that.daiKuanZhongLei) &&
				Objects.equals(daiKuanFangShi, that.daiKuanFangShi) &&
				Objects.equals(daiKuanYongTu, that.daiKuanYongTu) &&
				Objects.equals(daiKuanShiYongArea, that.daiKuanShiYongArea) &&
				Objects.equals(chanYeLeiBie, that.chanYeLeiBie) &&
				Objects.equals(chanYeFuPinLeiBie, that.chanYeFuPinLeiBie) &&
				Objects.equals(zhuTiDaiKuanLeiBie, that.zhuTiDaiKuanLeiBie) &&
				Objects.equals(daiKuanJiGou, that.daiKuanJiGou) &&
				Objects.equals(touFangDate, that.touFangDate) &&
				Objects.equals(touFangJinE, that.touFangJinE) &&
				Objects.equals(leiJiTouFangJinE, that.leiJiTouFangJinE) &&
				Objects.equals(weiTouFangYuE, that.weiTouFangYuE) &&
				Objects.equals(changHuanJinE, that.changHuanJinE) &&
				Objects.equals(changHuanDate, that.changHuanDate) &&
				Objects.equals(leiJiChangHuanJinE, that.leiJiChangHuanJinE) &&
				Objects.equals(weiChangHuanYuE, that.weiChangHuanYuE) &&
				Objects.equals(yuQiJinE, that.yuQiJinE) &&
				Objects.equals(yuQiDate, that.yuQiDate) &&
				Objects.equals(qianXiDate, that.qianXiDate) &&
				Objects.equals(qianXiJinE, that.qianXiJinE) &&
				Objects.equals(liYiLianJieFangShi, that.liYiLianJieFangShi) &&
				Objects.equals(daiDongPkHMingDan, that.daiDongPkHMingDan) &&
				Objects.equals(daiDongPkRenKouShu, that.daiDongPkRenKouShu) &&
				Objects.equals(zhiJieDaiDongXiaoYi, that.zhiJieDaiDongXiaoYi) &&
				Objects.equals(note, that.note) &&
				Objects.equals(shuJuWeiHuDanWei, that.shuJuWeiHuDanWei) &&
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
		return Objects.hash(uid, name, tongYiXinYongMa, address, telephone, agreementNo, daiKuanJinE, daiKuanQiXian, daiKuanDate, daoQiDate, daiKuanLiLv, daiKuanZhongLei, daiKuanFangShi, daiKuanYongTu, daiKuanShiYongArea, chanYeLeiBie, chanYeFuPinLeiBie, zhuTiDaiKuanLeiBie, daiKuanJiGou, touFangDate, touFangJinE, leiJiTouFangJinE, weiTouFangYuE, changHuanJinE, changHuanDate, leiJiChangHuanJinE, weiChangHuanYuE, yuQiJinE, yuQiDate, qianXiDate, qianXiJinE, liYiLianJieFangShi, daiDongPkHMingDan, daiDongPkRenKouShu, zhiJieDaiDongXiaoYi, note, shuJuWeiHuDanWei, checkDate, checkPerson, checkStatus, reason, operation, delStatus, delDate);
	}
}
