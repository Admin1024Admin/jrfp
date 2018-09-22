package com.ky.ct.rzdj.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_fpxexd", schema = "pashanhu", catalog = "")
public class BaseFpxexd {
    private int no;
    private String xiang;
    private String chun;
    private String zu;
    private String name;
    private String cardId;
    private Integer members;
    private String daiKuanRenXingMing;
    private String daiKuanRenCardId;
    private String familyRelation;
    private String tuoPinState;
    private Double yuanYouYuE;
    private String yuanYouIsYuQi;
    private Double yuanYouYuQiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yuanYouYuQiShiJian;
    private Double yuanYouQianXiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yuanYouQianXiShiJian;
    private String fuPingivenStars;
    private Double fuPinshouXinEDu;
    private String fuPinshouXinJiGou;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPinshouxinData;
    private Double fuPinXiaoDaidaiKuanJinE;
    private String fuPindaiKuanQiXian;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPinfangKuanRiQi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPindaoQiRiQi;
    private Double fuPinXiaoDaiDaiKuanLiLv;
    private String fuPindaiKuanJiGou;
    private Double fuPinleiJiTieXi;
    private Double fuPinchangHuanDaiKuanJInE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPinhuanKuanShiJian;
    private Double fuPindaiKuanYuE;
    private Double fuPinyuQiDaiKuanJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPinyuQiDaiKuanShiJian;
    private Double fuPinqianXiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fuPinqianXiShiJian;
    private String fuPinYingDaiWeiDaiShiBie;
    private String fuPinDaiKuanYongTu;
    private Double chuangYeJinE;
    private String chuangYeQiXian;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chuangYeFangKuanRiQi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chuangYeDaoQiShiJian;
    private Double chuangYeLiLv;
    private Double chuangYeChangHuanJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date changYeHuangKuanShiJian;
    private Double chuangYeYuE;
    private Double chuangYeYuQiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chuangYeYuQiShiJian;
    private Double chuangYeQianXiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chuangYeQianXiShiJian;
    private String chuangYeYongTu;
    private Double shengYuanJinE;
    private String shengYuanQiXian;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shengYuanFangKuanRiQi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shengYaunDaoQiRiQi;
    private Double shengYaunLiLv;
    private Double shengYaunChangHuanJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shengYuanHuanKuanShiJian;
    private Double shengYuanYuE;
    private Double shengYuanYuQiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shengYuanYuQiShiJian;
    private Double shengYuanQianXiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shengYuanQianXiShiJian;
    private Double qiTaJinE;
    private String qiTaQiXian;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qiTaFangKuanRiQi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qiTaDaoQiRiQi;
    private Double qiTaLiLv;
    private Double qiTaChangHuanJinE;
    @DateTimeFormat(pattern = "yyyy--MM--dd")
    private Date qiTaChangHuangKuanShiJian;
    private Double qiTaYuE;
    private Double qiTaYuQiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qiTaYuQiShiJian;
    private Double qiTaQianXiJinE;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date qiTaQianXiShiJian;
    private String qiTaYongTu;
    private String unit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tongJiShiJian;
    private String note;
    private int historyNo;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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
    @Column(name = "daiKuanRenXingMing")
    public String getDaiKuanRenXingMing() {
        return daiKuanRenXingMing;
    }

    public void setDaiKuanRenXingMing(String daiKuanRenXingMing) {
        this.daiKuanRenXingMing = daiKuanRenXingMing;
    }

    @Basic
    @Column(name = "daiKuanRenCardId")
    public String getDaiKuanRenCardId() {
        return daiKuanRenCardId;
    }

    public void setDaiKuanRenCardId(String daiKuanRenCardId) {
        this.daiKuanRenCardId = daiKuanRenCardId;
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
    @Column(name = "tuoPinState")
    public String getTuoPinState() {
        return tuoPinState;
    }

    public void setTuoPinState(String tuoPinState) {
        this.tuoPinState = tuoPinState;
    }

    @Basic
    @Column(name = "yuanYouYuE")
    public Double getYuanYouYuE() {
        return yuanYouYuE;
    }

    public void setYuanYouYuE(Double yuanYouYuE) {
        this.yuanYouYuE = yuanYouYuE;
    }

    @Basic
    @Column(name = "yuanYouIsYuQi")
    public String getYuanYouIsYuQi() {
        return yuanYouIsYuQi;
    }

    public void setYuanYouIsYuQi(String yuanYouIsYuQi) {
        this.yuanYouIsYuQi = yuanYouIsYuQi;
    }

    @Basic
    @Column(name = "yuanYouYuQiJinE")
    public Double getYuanYouYuQiJinE() {
        return yuanYouYuQiJinE;
    }

    public void setYuanYouYuQiJinE(Double yuanYouYuQiJinE) {
        this.yuanYouYuQiJinE = yuanYouYuQiJinE;
    }

    @Basic
    @Column(name = "yuanYouYuQiShiJian")
    public Date getYuanYouYuQiShiJian() {
        return yuanYouYuQiShiJian;
    }

    public void setYuanYouYuQiShiJian(Date yuanYouYuQiShiJian) {
        this.yuanYouYuQiShiJian = yuanYouYuQiShiJian;
    }

    @Basic
    @Column(name = "yuanYouQianXiJinE")
    public Double getYuanYouQianXiJinE() {
        return yuanYouQianXiJinE;
    }

    public void setYuanYouQianXiJinE(Double yuanYouQianXiJinE) {
        this.yuanYouQianXiJinE = yuanYouQianXiJinE;
    }

    @Basic
    @Column(name = "yuanYouQianXiShiJian")
    public Date getYuanYouQianXiShiJian() {
        return yuanYouQianXiShiJian;
    }

    public void setYuanYouQianXiShiJian(Date yuanYouQianXiShiJian) {
        this.yuanYouQianXiShiJian = yuanYouQianXiShiJian;
    }

    @Basic
    @Column(name = "fuPingivenStars")
    public String getFuPingivenStars() {
        return fuPingivenStars;
    }

    public void setFuPingivenStars(String fuPingivenStars) {
        this.fuPingivenStars = fuPingivenStars;
    }

    @Basic
    @Column(name = "fuPinshouXinEDu")
    public Double getFuPinshouXinEDu() {
        return fuPinshouXinEDu;
    }

    public void setFuPinshouXinEDu(Double fuPinshouXinEDu) {
        this.fuPinshouXinEDu = fuPinshouXinEDu;
    }

    @Basic
    @Column(name = "fuPinshouXinJiGou")
    public String getFuPinshouXinJiGou() {
        return fuPinshouXinJiGou;
    }

    public void setFuPinshouXinJiGou(String fuPinshouXinJiGou) {
        this.fuPinshouXinJiGou = fuPinshouXinJiGou;
    }

    @Basic
    @Column(name = "fuPinshouxinData")
    public Date getFuPinshouxinData() {
        return fuPinshouxinData;
    }

    public void setFuPinshouxinData(Date fuPinshouxinData) {
        this.fuPinshouxinData = fuPinshouxinData;
    }

    @Basic
    @Column(name = "fuPinXiaoDaidaiKuanJinE")
    public Double getFuPinXiaoDaidaiKuanJinE() {
        return fuPinXiaoDaidaiKuanJinE;
    }

    public void setFuPinXiaoDaidaiKuanJinE(Double fuPinXiaoDaidaiKuanJinE) {
        this.fuPinXiaoDaidaiKuanJinE = fuPinXiaoDaidaiKuanJinE;
    }

    @Basic
    @Column(name = "fuPindaiKuanQiXian")
    public String getFuPindaiKuanQiXian() {
        return fuPindaiKuanQiXian;
    }

    public void setFuPindaiKuanQiXian(String fuPindaiKuanQiXian) {
        this.fuPindaiKuanQiXian = fuPindaiKuanQiXian;
    }

    @Basic
    @Column(name = "fuPinfangKuanRiQi")
    public Date getFuPinfangKuanRiQi() {
        return fuPinfangKuanRiQi;
    }

    public void setFuPinfangKuanRiQi(Date fuPinfangKuanRiQi) {
        this.fuPinfangKuanRiQi = fuPinfangKuanRiQi;
    }

    @Basic
    @Column(name = "fuPindaoQiRiQi")
    public Date getFuPindaoQiRiQi() {
        return fuPindaoQiRiQi;
    }

    public void setFuPindaoQiRiQi(Date fuPindaoQiRiQi) {
        this.fuPindaoQiRiQi = fuPindaoQiRiQi;
    }

    @Basic
    @Column(name = "fuPinXiaoDaiDaiKuanLiLv")
    public Double getFuPinXiaoDaiDaiKuanLiLv() {
        return fuPinXiaoDaiDaiKuanLiLv;
    }

    public void setFuPinXiaoDaiDaiKuanLiLv(Double fuPinXiaoDaiDaiKuanLiLv) {
        this.fuPinXiaoDaiDaiKuanLiLv = fuPinXiaoDaiDaiKuanLiLv;
    }

    @Basic
    @Column(name = "fuPindaiKuanJiGou")
    public String getFuPindaiKuanJiGou() {
        return fuPindaiKuanJiGou;
    }

    public void setFuPindaiKuanJiGou(String fuPindaiKuanJiGou) {
        this.fuPindaiKuanJiGou = fuPindaiKuanJiGou;
    }

    @Basic
    @Column(name = "fuPinleiJiTieXi")
    public Double getFuPinleiJiTieXi() {
        return fuPinleiJiTieXi;
    }

    public void setFuPinleiJiTieXi(Double fuPinleiJiTieXi) {
        this.fuPinleiJiTieXi = fuPinleiJiTieXi;
    }

    @Basic
    @Column(name = "fuPinchangHuanDaiKuanJInE")
    public Double getFuPinchangHuanDaiKuanJInE() {
        return fuPinchangHuanDaiKuanJInE;
    }

    public void setFuPinchangHuanDaiKuanJInE(Double fuPinchangHuanDaiKuanJInE) {
        this.fuPinchangHuanDaiKuanJInE = fuPinchangHuanDaiKuanJInE;
    }

    @Basic
    @Column(name = "fuPinhuanKuanShiJian")
    public Date getFuPinhuanKuanShiJian() {
        return fuPinhuanKuanShiJian;
    }

    public void setFuPinhuanKuanShiJian(Date fuPinhuanKuanShiJian) {
        this.fuPinhuanKuanShiJian = fuPinhuanKuanShiJian;
    }

    @Basic
    @Column(name = "fuPindaiKuanYuE")
    public Double getFuPindaiKuanYuE() {
        return fuPindaiKuanYuE;
    }

    public void setFuPindaiKuanYuE(Double fuPindaiKuanYuE) {
        this.fuPindaiKuanYuE = fuPindaiKuanYuE;
    }

    @Basic
    @Column(name = "fuPinyuQiDaiKuanJinE")
    public Double getFuPinyuQiDaiKuanJinE() {
        return fuPinyuQiDaiKuanJinE;
    }

    public void setFuPinyuQiDaiKuanJinE(Double fuPinyuQiDaiKuanJinE) {
        this.fuPinyuQiDaiKuanJinE = fuPinyuQiDaiKuanJinE;
    }

    @Basic
    @Column(name = "fuPinyuQiDaiKuanShiJian")
    public Date getFuPinyuQiDaiKuanShiJian() {
        return fuPinyuQiDaiKuanShiJian;
    }

    public void setFuPinyuQiDaiKuanShiJian(Date fuPinyuQiDaiKuanShiJian) {
        this.fuPinyuQiDaiKuanShiJian = fuPinyuQiDaiKuanShiJian;
    }

    @Basic
    @Column(name = "fuPinqianXiJinE")
    public Double getFuPinqianXiJinE() {
        return fuPinqianXiJinE;
    }

    public void setFuPinqianXiJinE(Double fuPinqianXiJinE) {
        this.fuPinqianXiJinE = fuPinqianXiJinE;
    }

    @Basic
    @Column(name = "fuPinqianXiShiJian")
    public Date getFuPinqianXiShiJian() {
        return fuPinqianXiShiJian;
    }

    public void setFuPinqianXiShiJian(Date fuPinqianXiShiJian) {
        this.fuPinqianXiShiJian = fuPinqianXiShiJian;
    }

    @Basic
    @Column(name = "fuPinYingDaiWeiDaiShiBie")
    public String getFuPinYingDaiWeiDaiShiBie() {
        return fuPinYingDaiWeiDaiShiBie;
    }

    public void setFuPinYingDaiWeiDaiShiBie(String fuPinYingDaiWeiDaiShiBie) {
        this.fuPinYingDaiWeiDaiShiBie = fuPinYingDaiWeiDaiShiBie;
    }

    @Basic
    @Column(name = "fuPinDaiKuanYongTu")
    public String getFuPinDaiKuanYongTu() {
        return fuPinDaiKuanYongTu;
    }

    public void setFuPinDaiKuanYongTu(String fuPinDaiKuanYongTu) {
        this.fuPinDaiKuanYongTu = fuPinDaiKuanYongTu;
    }

    @Basic
    @Column(name = "chuangYeJinE")
    public Double getChuangYeJinE() {
        return chuangYeJinE;
    }

    public void setChuangYeJinE(Double chuangYeJinE) {
        this.chuangYeJinE = chuangYeJinE;
    }

    @Basic
    @Column(name = "chuangYeQiXian")
    public String getChuangYeQiXian() {
        return chuangYeQiXian;
    }

    public void setChuangYeQiXian(String chuangYeQiXian) {
        this.chuangYeQiXian = chuangYeQiXian;
    }

    @Basic
    @Column(name = "chuangYeFangKuanRiQi")
    public Date getChuangYeFangKuanRiQi() {
        return chuangYeFangKuanRiQi;
    }

    public void setChuangYeFangKuanRiQi(Date chuangYeFangKuanRiQi) {
        this.chuangYeFangKuanRiQi = chuangYeFangKuanRiQi;
    }

    @Basic
    @Column(name = "chuangYeDaoQiShiJian")
    public Date getChuangYeDaoQiShiJian() {
        return chuangYeDaoQiShiJian;
    }

    public void setChuangYeDaoQiShiJian(Date chuangYeDaoQiShiJian) {
        this.chuangYeDaoQiShiJian = chuangYeDaoQiShiJian;
    }

    @Basic
    @Column(name = "chuangYeLiLv")
    public Double getChuangYeLiLv() {
        return chuangYeLiLv;
    }

    public void setChuangYeLiLv(Double chuangYeLiLv) {
        this.chuangYeLiLv = chuangYeLiLv;
    }

    @Basic
    @Column(name = "chuangYeChangHuanJinE")
    public Double getChuangYeChangHuanJinE() {
        return chuangYeChangHuanJinE;
    }

    public void setChuangYeChangHuanJinE(Double chuangYeChangHuanJinE) {
        this.chuangYeChangHuanJinE = chuangYeChangHuanJinE;
    }

    @Basic
    @Column(name = "changYeHuangKuanShiJian")
    public Date getChangYeHuangKuanShiJian() {
        return changYeHuangKuanShiJian;
    }

    public void setChangYeHuangKuanShiJian(Date changYeHuangKuanShiJian) {
        this.changYeHuangKuanShiJian = changYeHuangKuanShiJian;
    }

    @Basic
    @Column(name = "chuangYeYuE")
    public Double getChuangYeYuE() {
        return chuangYeYuE;
    }

    public void setChuangYeYuE(Double chuangYeYuE) {
        this.chuangYeYuE = chuangYeYuE;
    }

    @Basic
    @Column(name = "chuangYeYuQiJinE")
    public Double getChuangYeYuQiJinE() {
        return chuangYeYuQiJinE;
    }

    public void setChuangYeYuQiJinE(Double chuangYeYuQiJinE) {
        this.chuangYeYuQiJinE = chuangYeYuQiJinE;
    }

    @Basic
    @Column(name = "chuangYeYuQiShiJian")
    public Date getChuangYeYuQiShiJian() {
        return chuangYeYuQiShiJian;
    }

    public void setChuangYeYuQiShiJian(Date chuangYeYuQiShiJian) {
        this.chuangYeYuQiShiJian = chuangYeYuQiShiJian;
    }

    @Basic
    @Column(name = "chuangYeQianXiJinE")
    public Double getChuangYeQianXiJinE() {
        return chuangYeQianXiJinE;
    }

    public void setChuangYeQianXiJinE(Double chuangYeQianXiJinE) {
        this.chuangYeQianXiJinE = chuangYeQianXiJinE;
    }

    @Basic
    @Column(name = "chuangYeQianXiShiJian")
    public Date getChuangYeQianXiShiJian() {
        return chuangYeQianXiShiJian;
    }

    public void setChuangYeQianXiShiJian(Date chuangYeQianXiShiJian) {
        this.chuangYeQianXiShiJian = chuangYeQianXiShiJian;
    }

    @Basic
    @Column(name = "chuangYeYongTu")
    public String getChuangYeYongTu() {
        return chuangYeYongTu;
    }

    public void setChuangYeYongTu(String chuangYeYongTu) {
        this.chuangYeYongTu = chuangYeYongTu;
    }

    @Basic
    @Column(name = "shengYuanJinE")
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
    @Column(name = "shengYuanFangKuanRiQi")
    public Date getShengYuanFangKuanRiQi() {
        return shengYuanFangKuanRiQi;
    }

    public void setShengYuanFangKuanRiQi(Date shengYuanFangKuanRiQi) {
        this.shengYuanFangKuanRiQi = shengYuanFangKuanRiQi;
    }

    @Basic
    @Column(name = "shengYaunDaoQiRiQi")
    public Date getShengYaunDaoQiRiQi() {
        return shengYaunDaoQiRiQi;
    }

    public void setShengYaunDaoQiRiQi(Date shengYaunDaoQiRiQi) {
        this.shengYaunDaoQiRiQi = shengYaunDaoQiRiQi;
    }

    @Basic
    @Column(name = "shengYaunLiLv")
    public Double getShengYaunLiLv() {
        return shengYaunLiLv;
    }

    public void setShengYaunLiLv(Double shengYaunLiLv) {
        this.shengYaunLiLv = shengYaunLiLv;
    }

    @Basic
    @Column(name = "shengYaunChangHuanJinE")
    public Double getShengYaunChangHuanJinE() {
        return shengYaunChangHuanJinE;
    }

    public void setShengYaunChangHuanJinE(Double shengYaunChangHuanJinE) {
        this.shengYaunChangHuanJinE = shengYaunChangHuanJinE;
    }

    @Basic
    @Column(name = "shengYuanHuanKuanShiJian")
    public Date getShengYuanHuanKuanShiJian() {
        return shengYuanHuanKuanShiJian;
    }

    public void setShengYuanHuanKuanShiJian(Date shengYuanHuanKuanShiJian) {
        this.shengYuanHuanKuanShiJian = shengYuanHuanKuanShiJian;
    }

    @Basic
    @Column(name = "shengYuanYuE")
    public Double getShengYuanYuE() {
        return shengYuanYuE;
    }

    public void setShengYuanYuE(Double shengYuanYuE) {
        this.shengYuanYuE = shengYuanYuE;
    }

    @Basic
    @Column(name = "shengYuanYuQiJinE")
    public Double getShengYuanYuQiJinE() {
        return shengYuanYuQiJinE;
    }

    public void setShengYuanYuQiJinE(Double shengYuanYuQiJinE) {
        this.shengYuanYuQiJinE = shengYuanYuQiJinE;
    }

    @Basic
    @Column(name = "shengYuanYuQiShiJian")
    public Date getShengYuanYuQiShiJian() {
        return shengYuanYuQiShiJian;
    }

    public void setShengYuanYuQiShiJian(Date shengYuanYuQiShiJian) {
        this.shengYuanYuQiShiJian = shengYuanYuQiShiJian;
    }

    @Basic
    @Column(name = "shengYuanQianXiJinE")
    public Double getShengYuanQianXiJinE() {
        return shengYuanQianXiJinE;
    }

    public void setShengYuanQianXiJinE(Double shengYuanQianXiJinE) {
        this.shengYuanQianXiJinE = shengYuanQianXiJinE;
    }

    @Basic
    @Column(name = "shengYuanQianXiShiJian")
    public Date getShengYuanQianXiShiJian() {
        return shengYuanQianXiShiJian;
    }

    public void setShengYuanQianXiShiJian(Date shengYuanQianXiShiJian) {
        this.shengYuanQianXiShiJian = shengYuanQianXiShiJian;
    }

    @Basic
    @Column(name = "qiTaJinE")
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
    @Column(name = "qiTaFangKuanRiQi")
    public Date getQiTaFangKuanRiQi() {
        return qiTaFangKuanRiQi;
    }

    public void setQiTaFangKuanRiQi(Date qiTaFangKuanRiQi) {
        this.qiTaFangKuanRiQi = qiTaFangKuanRiQi;
    }

    @Basic
    @Column(name = "qiTaDaoQiRiQi")
    public Date getQiTaDaoQiRiQi() {
        return qiTaDaoQiRiQi;
    }

    public void setQiTaDaoQiRiQi(Date qiTaDaoQiRiQi) {
        this.qiTaDaoQiRiQi = qiTaDaoQiRiQi;
    }

    @Basic
    @Column(name = "qiTaLiLv")
    public Double getQiTaLiLv() {
        return qiTaLiLv;
    }

    public void setQiTaLiLv(Double qiTaLiLv) {
        this.qiTaLiLv = qiTaLiLv;
    }

    @Basic
    @Column(name = "qiTaChangHuanJinE")
    public Double getQiTaChangHuanJinE() {
        return qiTaChangHuanJinE;
    }

    public void setQiTaChangHuanJinE(Double qiTaChangHuanJinE) {
        this.qiTaChangHuanJinE = qiTaChangHuanJinE;
    }

    @Basic
    @Column(name = "qiTaChangHuangKuanShiJian")
    public Date getQiTaChangHuangKuanShiJian() {
        return qiTaChangHuangKuanShiJian;
    }

    public void setQiTaChangHuangKuanShiJian(Date qiTaChangHuangKuanShiJian) {
        this.qiTaChangHuangKuanShiJian = qiTaChangHuangKuanShiJian;
    }

    @Basic
    @Column(name = "qiTaYuE")
    public Double getQiTaYuE() {
        return qiTaYuE;
    }

    public void setQiTaYuE(Double qiTaYuE) {
        this.qiTaYuE = qiTaYuE;
    }

    @Basic
    @Column(name = "qiTaYuQiJinE")
    public Double getQiTaYuQiJinE() {
        return qiTaYuQiJinE;
    }

    public void setQiTaYuQiJinE(Double qiTaYuQiJinE) {
        this.qiTaYuQiJinE = qiTaYuQiJinE;
    }

    @Basic
    @Column(name = "qiTaYuQiShiJian")
    public Date getQiTaYuQiShiJian() {
        return qiTaYuQiShiJian;
    }

    public void setQiTaYuQiShiJian(Date qiTaYuQiShiJian) {
        this.qiTaYuQiShiJian = qiTaYuQiShiJian;
    }

    @Basic
    @Column(name = "qiTaQianXiJinE")
    public Double getQiTaQianXiJinE() {
        return qiTaQianXiJinE;
    }

    public void setQiTaQianXiJinE(Double qiTaQianXiJinE) {
        this.qiTaQianXiJinE = qiTaQianXiJinE;
    }

    @Basic
    @Column(name = "qiTaQianXiShiJian")
    public Date getQiTaQianXiShiJian() {
        return qiTaQianXiShiJian;
    }

    public void setQiTaQianXiShiJian(Date qiTaQianXiShiJian) {
        this.qiTaQianXiShiJian = qiTaQianXiShiJian;
    }

    @Basic
    @Column(name = "qiTaYongTu")
    public String getQiTaYongTu() {
        return qiTaYongTu;
    }

    public void setQiTaYongTu(String qiTaYongTu) {
        this.qiTaYongTu = qiTaYongTu;
    }
    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "tongJiShiJian")
    public Date getTongJiShiJian() {
        return tongJiShiJian;
    }

    public void setTongJiShiJian(Date tongJiShiJian) {
        this.tongJiShiJian = tongJiShiJian;
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
    @Column(name = "historyNo")
    public int getHistoryNo() {
        return historyNo;
    }

    public void setHistoryNo(int historyNo) {
        this.historyNo = historyNo;
    }

    @Override
    public String toString() {
        return "BaseFpxexd{" +
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
                ", historyNo=" + historyNo +
                '}';
    }
}
