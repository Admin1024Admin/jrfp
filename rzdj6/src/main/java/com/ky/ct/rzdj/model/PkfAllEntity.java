package com.ky.ct.rzdj.model;

import java.sql.Timestamp;
import java.util.Date;

public class PkfAllEntity {
    //基本信息表字段
    private long uid;
    private String no;
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

    //评级授信表   和主表重复的字段 uid no cardId healthState
    private String xiangZhen;
    private String chunZu;
    private String huZhu;
    private String daiKuanRen;
    private String wenHuaChengDu;
    private String laoDongNengLi;
    private String givenStars;
    private Double shouXinEDu;
    private Date shouXinDate;
    private String contactPhone;
    private String note;
    private String tianBaoDanWei;
    private String tianBiaoRen;
    private String tianBiaoRenLianXi;
    private String shenHeRen;
    private Date tianBiaoDate;


    //贫困户地震保险表  和主表重复的字段 ui no  cardId和评级授信表重复的字段note  tianBaoDanWei importDate
    private String address;
    private Integer baoXianJinE;
    private Integer baoFei;
    private String canBaoType;
    private String tianBaoDate;
    private String touBaoYear;

    //贫困户扶贫保险表  和主表重复的字段 uid no cardId  与评级授信表重复的字段 note  与贫困户地震保险表重复的字段baoFei  touBaoYear
    private String touBaoRen;
    private String beiBaoRen;
    private String gender;
    private String bornDate;
    private String zhiYeCode;
    private String cardIdType;
    private String shouYiRen;
    private String beiBaoRenSign;
    private String huiJiaoRen;
    private String touBaoCompany;
    private String xianZhong;
    private Timestamp importDate;
    private String billNo;
    private Double baoE;

    // 扶贫小额信贷台账表 与主表重复的字段 uid no chun familyRelation  和评级授信表重复的字段 xiangZhen huZhu daiKuanRen givenStars shouXinEDu shouXinDate
    private String familyMember;
    private String familyMemberCardId;
    private Integer familyMemberCount;
    private String pingJiJiGou;
    private String isQueryZhengXin;
    private String shouXinZiLiaoOk;
    private String isHuZhu;
    private Double daiKuanBenJin;
    private Double daiKuanYuE;
    private String daiKuanTimeLimit;
    private String fangKuanDate;
    private String huanKuanDate;
    private String daiKuanLiLv;
    private String leiJiTieXi;
    private String huanBenJinE;
    private String huanBenDate;
    private String benJinYuQiJinE;
    private String benJinYuQiDate;
    private String qianXiJinE;
    private String qianXiDate;
    private String daiKuanZiLiaoOk;
    private String ziJinShiYongOk;
    private String daiKuanJiGou;
    private Date tongJiDate;

    public PkfAllEntity() {
    }

    public PkfAllEntity(long uid, String no, String shiQuQi, String xiangZheng, String chun,
                        String she, String familyNo, String memberNo, String name, String cardId,
                        Integer members, String familyRelation, String mz, String xueLi, String schoolState,
                        String healthState, String skill, String workState, String workMonth, String isDaBinYiLiao,
                        String tuoPinState, String pinKunState, String pinKunYuanYin, String isWeiFangHu, String isYinShuiAnQuan,
                        String isYinShuiKunNan, Double renJunChunShouRu, String telephone, Timestamp tongJiShiJian, String xiangZhen,
                        String chunZu, String huZhu, String daiKuanRen, String wenHuaChengDu, String laoDongNengLi, String givenStars,
                        Double shouXinEDu, Date shouXinDate, String contactPhone, String note, String tianBaoDanWei, String tianBiaoRen,
                        String tianBiaoRenLianXi, String shenHeRen, Date tianBiaoDate, String address, Integer baoXianJinE, Integer baoFei,
                        String canBaoType, String tianBaoDate, String touBaoYear, String touBaoRen, String beiBaoRen, String gender,
                        String bornDate, String zhiYeCode, String cardIdType, String shouYiRen, String beiBaoRenSign, String huiJiaoRen,
                        String touBaoCompany, String xianZhong, Timestamp importDate, String billNo, Double baoE, String familyMember,
                        String familyMemberCardId, Integer familyMemberCount, String pingJiJiGou, String isQueryZhengXin, String shouXinZiLiaoOk,
                        String isHuZhu, Double daiKuanBenJin, Double daiKuanYuE, String daiKuanTimeLimit, String fangKuanDate, String huanKuanDate,
                        String daiKuanLiLv, String leiJiTieXi, String huanBenJinE, String huanBenDate, String benJinYuQiJinE, String benJinYuQiDate,
                        String qianXiJinE, String qianXiDate, String daiKuanZiLiaoOk, String ziJinShiYongOk, String daiKuanJiGou, Date tongJiDate) {
        this.uid = uid;
        this.no = no;
        this.shiQuQi = shiQuQi;
        this.xiangZheng = xiangZheng;
        this.chun = chun;
        this.she = she;
        this.familyNo = familyNo;
        this.memberNo = memberNo;
        this.name = name;
        this.cardId = cardId;
        this.members = members;
        this.familyRelation = familyRelation;
        this.mz = mz;
        this.xueLi = xueLi;
        this.schoolState = schoolState;
        this.healthState = healthState;
        this.skill = skill;
        this.workState = workState;
        this.workMonth = workMonth;
        this.isDaBinYiLiao = isDaBinYiLiao;
        this.tuoPinState = tuoPinState;
        this.pinKunState = pinKunState;
        this.pinKunYuanYin = pinKunYuanYin;
        this.isWeiFangHu = isWeiFangHu;
        this.isYinShuiAnQuan = isYinShuiAnQuan;
        this.isYinShuiKunNan = isYinShuiKunNan;
        this.renJunChunShouRu = renJunChunShouRu;
        this.telephone = telephone;
        this.tongJiShiJian = tongJiShiJian;
        this.xiangZhen = xiangZhen;
        this.chunZu = chunZu;
        this.huZhu = huZhu;
        this.daiKuanRen = daiKuanRen;
        this.wenHuaChengDu = wenHuaChengDu;
        this.laoDongNengLi = laoDongNengLi;
        this.givenStars = givenStars;
        this.shouXinEDu = shouXinEDu;
        this.shouXinDate = shouXinDate;
        this.contactPhone = contactPhone;
        this.note = note;
        this.tianBaoDanWei = tianBaoDanWei;
        this.tianBiaoRen = tianBiaoRen;
        this.tianBiaoRenLianXi = tianBiaoRenLianXi;
        this.shenHeRen = shenHeRen;
        this.tianBiaoDate = tianBiaoDate;
        this.address = address;
        this.baoXianJinE = baoXianJinE;
        this.baoFei = baoFei;
        this.canBaoType = canBaoType;
        this.tianBaoDate = tianBaoDate;
        this.touBaoYear = touBaoYear;
        this.touBaoRen = touBaoRen;
        this.beiBaoRen = beiBaoRen;
        this.gender = gender;
        this.bornDate = bornDate;
        this.zhiYeCode = zhiYeCode;
        this.cardIdType = cardIdType;
        this.shouYiRen = shouYiRen;
        this.beiBaoRenSign = beiBaoRenSign;
        this.huiJiaoRen = huiJiaoRen;
        this.touBaoCompany = touBaoCompany;
        this.xianZhong = xianZhong;
        this.importDate = importDate;
        this.billNo = billNo;
        this.baoE = baoE;
        this.familyMember = familyMember;
        this.familyMemberCardId = familyMemberCardId;
        this.familyMemberCount = familyMemberCount;
        this.pingJiJiGou = pingJiJiGou;
        this.isQueryZhengXin = isQueryZhengXin;
        this.shouXinZiLiaoOk = shouXinZiLiaoOk;
        this.isHuZhu = isHuZhu;
        this.daiKuanBenJin = daiKuanBenJin;
        this.daiKuanYuE = daiKuanYuE;
        this.daiKuanTimeLimit = daiKuanTimeLimit;
        this.fangKuanDate = fangKuanDate;
        this.huanKuanDate = huanKuanDate;
        this.daiKuanLiLv = daiKuanLiLv;
        this.leiJiTieXi = leiJiTieXi;
        this.huanBenJinE = huanBenJinE;
        this.huanBenDate = huanBenDate;
        this.benJinYuQiJinE = benJinYuQiJinE;
        this.benJinYuQiDate = benJinYuQiDate;
        this.qianXiJinE = qianXiJinE;
        this.qianXiDate = qianXiDate;
        this.daiKuanZiLiaoOk = daiKuanZiLiaoOk;
        this.ziJinShiYongOk = ziJinShiYongOk;
        this.daiKuanJiGou = daiKuanJiGou;
        this.tongJiDate = tongJiDate;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getShiQuQi() {
        return shiQuQi;
    }

    public void setShiQuQi(String shiQuQi) {
        this.shiQuQi = shiQuQi;
    }

    public String getXiangZheng() {
        return xiangZheng;
    }

    public void setXiangZheng(String xiangZheng) {
        this.xiangZheng = xiangZheng;
    }

    public String getChun() {
        return chun;
    }

    public void setChun(String chun) {
        this.chun = chun;
    }

    public String getShe() {
        return she;
    }

    public void setShe(String she) {
        this.she = she;
    }

    public String getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(String familyNo) {
        this.familyNo = familyNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getXueLi() {
        return xueLi;
    }

    public void setXueLi(String xueLi) {
        this.xueLi = xueLi;
    }

    public String getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
    }

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkMonth() {
        return workMonth;
    }

    public void setWorkMonth(String workMonth) {
        this.workMonth = workMonth;
    }

    public String getIsDaBinYiLiao() {
        return isDaBinYiLiao;
    }

    public void setIsDaBinYiLiao(String isDaBinYiLiao) {
        this.isDaBinYiLiao = isDaBinYiLiao;
    }

    public String getTuoPinState() {
        return tuoPinState;
    }

    public void setTuoPinState(String tuoPinState) {
        this.tuoPinState = tuoPinState;
    }

    public String getPinKunState() {
        return pinKunState;
    }

    public void setPinKunState(String pinKunState) {
        this.pinKunState = pinKunState;
    }

    public String getPinKunYuanYin() {
        return pinKunYuanYin;
    }

    public void setPinKunYuanYin(String pinKunYuanYin) {
        this.pinKunYuanYin = pinKunYuanYin;
    }

    public String getIsWeiFangHu() {
        return isWeiFangHu;
    }

    public void setIsWeiFangHu(String isWeiFangHu) {
        this.isWeiFangHu = isWeiFangHu;
    }

    public String getIsYinShuiAnQuan() {
        return isYinShuiAnQuan;
    }

    public void setIsYinShuiAnQuan(String isYinShuiAnQuan) {
        this.isYinShuiAnQuan = isYinShuiAnQuan;
    }

    public String getIsYinShuiKunNan() {
        return isYinShuiKunNan;
    }

    public void setIsYinShuiKunNan(String isYinShuiKunNan) {
        this.isYinShuiKunNan = isYinShuiKunNan;
    }

    public Double getRenJunChunShouRu() {
        return renJunChunShouRu;
    }

    public void setRenJunChunShouRu(Double renJunChunShouRu) {
        this.renJunChunShouRu = renJunChunShouRu;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Timestamp getTongJiShiJian() {
        return tongJiShiJian;
    }

    public void setTongJiShiJian(Timestamp tongJiShiJian) {
        this.tongJiShiJian = tongJiShiJian;
    }

    public String getXiangZhen() {
        return xiangZhen;
    }

    public void setXiangZhen(String xiangZhen) {
        this.xiangZhen = xiangZhen;
    }

    public String getChunZu() {
        return chunZu;
    }

    public void setChunZu(String chunZu) {
        this.chunZu = chunZu;
    }

    public String getHuZhu() {
        return huZhu;
    }

    public void setHuZhu(String huZhu) {
        this.huZhu = huZhu;
    }

    public String getDaiKuanRen() {
        return daiKuanRen;
    }

    public void setDaiKuanRen(String daiKuanRen) {
        this.daiKuanRen = daiKuanRen;
    }

    public String getWenHuaChengDu() {
        return wenHuaChengDu;
    }

    public void setWenHuaChengDu(String wenHuaChengDu) {
        this.wenHuaChengDu = wenHuaChengDu;
    }

    public String getLaoDongNengLi() {
        return laoDongNengLi;
    }

    public void setLaoDongNengLi(String laoDongNengLi) {
        this.laoDongNengLi = laoDongNengLi;
    }

    public String getGivenStars() {
        return givenStars;
    }

    public void setGivenStars(String givenStars) {
        this.givenStars = givenStars;
    }

    public Double getShouXinEDu() {
        return shouXinEDu;
    }

    public void setShouXinEDu(Double shouXinEDu) {
        this.shouXinEDu = shouXinEDu;
    }

    public Date getShouXinDate() {
        return shouXinDate;
    }

    public void setShouXinDate(Date shouXinDate) {
        this.shouXinDate = shouXinDate;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTianBaoDanWei() {
        return tianBaoDanWei;
    }

    public void setTianBaoDanWei(String tianBaoDanWei) {
        this.tianBaoDanWei = tianBaoDanWei;
    }

    public String getTianBiaoRen() {
        return tianBiaoRen;
    }

    public void setTianBiaoRen(String tianBiaoRen) {
        this.tianBiaoRen = tianBiaoRen;
    }

    public String getTianBiaoRenLianXi() {
        return tianBiaoRenLianXi;
    }

    public void setTianBiaoRenLianXi(String tianBiaoRenLianXi) {
        this.tianBiaoRenLianXi = tianBiaoRenLianXi;
    }

    public String getShenHeRen() {
        return shenHeRen;
    }

    public void setShenHeRen(String shenHeRen) {
        this.shenHeRen = shenHeRen;
    }

    public Date getTianBiaoDate() {
        return tianBiaoDate;
    }

    public void setTianBiaoDate(Date tianBiaoDate) {
        this.tianBiaoDate = tianBiaoDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBaoXianJinE() {
        return baoXianJinE;
    }

    public void setBaoXianJinE(Integer baoXianJinE) {
        this.baoXianJinE = baoXianJinE;
    }

    public Integer getBaoFei() {
        return baoFei;
    }

    public void setBaoFei(Integer baoFei) {
        this.baoFei = baoFei;
    }

    public String getCanBaoType() {
        return canBaoType;
    }

    public void setCanBaoType(String canBaoType) {
        this.canBaoType = canBaoType;
    }

    public String getTianBaoDate() {
        return tianBaoDate;
    }

    public void setTianBaoDate(String tianBaoDate) {
        this.tianBaoDate = tianBaoDate;
    }

    public String getTouBaoYear() {
        return touBaoYear;
    }

    public void setTouBaoYear(String touBaoYear) {
        this.touBaoYear = touBaoYear;
    }

    public String getTouBaoRen() {
        return touBaoRen;
    }

    public void setTouBaoRen(String touBaoRen) {
        this.touBaoRen = touBaoRen;
    }

    public String getBeiBaoRen() {
        return beiBaoRen;
    }

    public void setBeiBaoRen(String beiBaoRen) {
        this.beiBaoRen = beiBaoRen;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getZhiYeCode() {
        return zhiYeCode;
    }

    public void setZhiYeCode(String zhiYeCode) {
        this.zhiYeCode = zhiYeCode;
    }

    public String getCardIdType() {
        return cardIdType;
    }

    public void setCardIdType(String cardIdType) {
        this.cardIdType = cardIdType;
    }

    public String getShouYiRen() {
        return shouYiRen;
    }

    public void setShouYiRen(String shouYiRen) {
        this.shouYiRen = shouYiRen;
    }

    public String getBeiBaoRenSign() {
        return beiBaoRenSign;
    }

    public void setBeiBaoRenSign(String beiBaoRenSign) {
        this.beiBaoRenSign = beiBaoRenSign;
    }

    public String getHuiJiaoRen() {
        return huiJiaoRen;
    }

    public void setHuiJiaoRen(String huiJiaoRen) {
        this.huiJiaoRen = huiJiaoRen;
    }

    public String getTouBaoCompany() {
        return touBaoCompany;
    }

    public void setTouBaoCompany(String touBaoCompany) {
        this.touBaoCompany = touBaoCompany;
    }

    public String getXianZhong() {
        return xianZhong;
    }

    public void setXianZhong(String xianZhong) {
        this.xianZhong = xianZhong;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Double getBaoE() {
        return baoE;
    }

    public void setBaoE(Double baoE) {
        this.baoE = baoE;
    }

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public String getFamilyMemberCardId() {
        return familyMemberCardId;
    }

    public void setFamilyMemberCardId(String familyMemberCardId) {
        this.familyMemberCardId = familyMemberCardId;
    }

    public Integer getFamilyMemberCount() {
        return familyMemberCount;
    }

    public void setFamilyMemberCount(Integer familyMemberCount) {
        this.familyMemberCount = familyMemberCount;
    }

    public String getPingJiJiGou() {
        return pingJiJiGou;
    }

    public void setPingJiJiGou(String pingJiJiGou) {
        this.pingJiJiGou = pingJiJiGou;
    }

    public String getIsQueryZhengXin() {
        return isQueryZhengXin;
    }

    public void setIsQueryZhengXin(String isQueryZhengXin) {
        this.isQueryZhengXin = isQueryZhengXin;
    }

    public String getShouXinZiLiaoOk() {
        return shouXinZiLiaoOk;
    }

    public void setShouXinZiLiaoOk(String shouXinZiLiaoOk) {
        this.shouXinZiLiaoOk = shouXinZiLiaoOk;
    }

    public String getIsHuZhu() {
        return isHuZhu;
    }

    public void setIsHuZhu(String isHuZhu) {
        this.isHuZhu = isHuZhu;
    }

    public Double getDaiKuanBenJin() {
        return daiKuanBenJin;
    }

    public void setDaiKuanBenJin(Double daiKuanBenJin) {
        this.daiKuanBenJin = daiKuanBenJin;
    }

    public Double getDaiKuanYuE() {
        return daiKuanYuE;
    }

    public void setDaiKuanYuE(Double daiKuanYuE) {
        this.daiKuanYuE = daiKuanYuE;
    }

    public String getDaiKuanTimeLimit() {
        return daiKuanTimeLimit;
    }

    public void setDaiKuanTimeLimit(String daiKuanTimeLimit) {
        this.daiKuanTimeLimit = daiKuanTimeLimit;
    }

    public String getFangKuanDate() {
        return fangKuanDate;
    }

    public void setFangKuanDate(String fangKuanDate) {
        this.fangKuanDate = fangKuanDate;
    }

    public String getHuanKuanDate() {
        return huanKuanDate;
    }

    public void setHuanKuanDate(String huanKuanDate) {
        this.huanKuanDate = huanKuanDate;
    }

    public String getDaiKuanLiLv() {
        return daiKuanLiLv;
    }

    public void setDaiKuanLiLv(String daiKuanLiLv) {
        this.daiKuanLiLv = daiKuanLiLv;
    }

    public String getLeiJiTieXi() {
        return leiJiTieXi;
    }

    public void setLeiJiTieXi(String leiJiTieXi) {
        this.leiJiTieXi = leiJiTieXi;
    }

    public String getHuanBenJinE() {
        return huanBenJinE;
    }

    public void setHuanBenJinE(String huanBenJinE) {
        this.huanBenJinE = huanBenJinE;
    }

    public String getHuanBenDate() {
        return huanBenDate;
    }

    public void setHuanBenDate(String huanBenDate) {
        this.huanBenDate = huanBenDate;
    }

    public String getBenJinYuQiJinE() {
        return benJinYuQiJinE;
    }

    public void setBenJinYuQiJinE(String benJinYuQiJinE) {
        this.benJinYuQiJinE = benJinYuQiJinE;
    }

    public String getBenJinYuQiDate() {
        return benJinYuQiDate;
    }

    public void setBenJinYuQiDate(String benJinYuQiDate) {
        this.benJinYuQiDate = benJinYuQiDate;
    }

    public String getQianXiJinE() {
        return qianXiJinE;
    }

    public void setQianXiJinE(String qianXiJinE) {
        this.qianXiJinE = qianXiJinE;
    }

    public String getQianXiDate() {
        return qianXiDate;
    }

    public void setQianXiDate(String qianXiDate) {
        this.qianXiDate = qianXiDate;
    }

    public String getDaiKuanZiLiaoOk() {
        return daiKuanZiLiaoOk;
    }

    public void setDaiKuanZiLiaoOk(String daiKuanZiLiaoOk) {
        this.daiKuanZiLiaoOk = daiKuanZiLiaoOk;
    }

    public String getZiJinShiYongOk() {
        return ziJinShiYongOk;
    }

    public void setZiJinShiYongOk(String ziJinShiYongOk) {
        this.ziJinShiYongOk = ziJinShiYongOk;
    }

    public String getDaiKuanJiGou() {
        return daiKuanJiGou;
    }

    public void setDaiKuanJiGou(String daiKuanJiGou) {
        this.daiKuanJiGou = daiKuanJiGou;
    }

    public Date getTongJiDate() {
        return tongJiDate;
    }

    public void setTongJiDate(Date tongJiDate) {
        this.tongJiDate = tongJiDate;
    }

    @Override
    public String toString() {
        return "PkfAllEntity{" +
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
                ", xiangZhen='" + xiangZhen + '\'' +
                ", chunZu='" + chunZu + '\'' +
                ", huZhu='" + huZhu + '\'' +
                ", daiKuanRen='" + daiKuanRen + '\'' +
                ", wenHuaChengDu='" + wenHuaChengDu + '\'' +
                ", laoDongNengLi='" + laoDongNengLi + '\'' +
                ", givenStars='" + givenStars + '\'' +
                ", shouXinEDu=" + shouXinEDu +
                ", shouXinDate=" + shouXinDate +
                ", contactPhone='" + contactPhone + '\'' +
                ", note='" + note + '\'' +
                ", tianBaoDanWei='" + tianBaoDanWei + '\'' +
                ", tianBiaoRen='" + tianBiaoRen + '\'' +
                ", tianBiaoRenLianXi='" + tianBiaoRenLianXi + '\'' +
                ", shenHeRen='" + shenHeRen + '\'' +
                ", tianBiaoDate=" + tianBiaoDate +
                ", address='" + address + '\'' +
                ", baoXianJinE=" + baoXianJinE +
                ", baoFei=" + baoFei +
                ", canBaoType='" + canBaoType + '\'' +
                ", tianBaoDate='" + tianBaoDate + '\'' +
                ", touBaoYear='" + touBaoYear + '\'' +
                ", touBaoRen='" + touBaoRen + '\'' +
                ", beiBaoRen='" + beiBaoRen + '\'' +
                ", gender='" + gender + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", zhiYeCode='" + zhiYeCode + '\'' +
                ", cardIdType='" + cardIdType + '\'' +
                ", shouYiRen='" + shouYiRen + '\'' +
                ", beiBaoRenSign='" + beiBaoRenSign + '\'' +
                ", huiJiaoRen='" + huiJiaoRen + '\'' +
                ", touBaoCompany='" + touBaoCompany + '\'' +
                ", xianZhong='" + xianZhong + '\'' +
                ", importDate=" + importDate +
                ", billNo='" + billNo + '\'' +
                ", baoE=" + baoE +
                ", familyMember='" + familyMember + '\'' +
                ", familyMemberCardId='" + familyMemberCardId + '\'' +
                ", familyMemberCount=" + familyMemberCount +
                ", pingJiJiGou='" + pingJiJiGou + '\'' +
                ", isQueryZhengXin='" + isQueryZhengXin + '\'' +
                ", shouXinZiLiaoOk='" + shouXinZiLiaoOk + '\'' +
                ", isHuZhu='" + isHuZhu + '\'' +
                ", daiKuanBenJin=" + daiKuanBenJin +
                ", daiKuanYuE=" + daiKuanYuE +
                ", daiKuanTimeLimit='" + daiKuanTimeLimit + '\'' +
                ", fangKuanDate='" + fangKuanDate + '\'' +
                ", huanKuanDate='" + huanKuanDate + '\'' +
                ", daiKuanLiLv='" + daiKuanLiLv + '\'' +
                ", leiJiTieXi='" + leiJiTieXi + '\'' +
                ", huanBenJinE='" + huanBenJinE + '\'' +
                ", huanBenDate='" + huanBenDate + '\'' +
                ", benJinYuQiJinE='" + benJinYuQiJinE + '\'' +
                ", benJinYuQiDate='" + benJinYuQiDate + '\'' +
                ", qianXiJinE='" + qianXiJinE + '\'' +
                ", qianXiDate='" + qianXiDate + '\'' +
                ", daiKuanZiLiaoOk='" + daiKuanZiLiaoOk + '\'' +
                ", ziJinShiYongOk='" + ziJinShiYongOk + '\'' +
                ", daiKuanJiGou='" + daiKuanJiGou + '\'' +
                ", tongJiDate=" + tongJiDate +
                '}';
    }
}
