package com.ky.ct.rzdj.model;
// Generated 2018-3-15 12:35:10 by Hibernate Tools 5.2.5.Final

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Basicwork generated by hbm2java
 */
@Entity
@Table(name = "basicwork", catalog = "audit", uniqueConstraints = @UniqueConstraint(columnNames = "year"))
public class BasicWork implements java.io.Serializable {

	private Integer id;
	private int year;
	private int state;
	private String sumbitOne;
	private String sumbitDate;
	private String name;
	private int editDpt;
	private String dptName;
	private Integer td1;
	private Integer td2;
	private Integer td3;
	private Integer td4;
	private Integer td5;
	private Integer td6;
	private Integer td7;
	private Integer td8;
	private Integer td9;
	private Integer td10;
	private Integer td11;
	private Integer td12;
	private Integer td13;
	private Integer td14;
	private Integer td15;
	private Integer td16;
	private Integer td17;
	private Integer td18;
	private Integer td19;
	private Integer td20;
	private Integer td21;
	private Integer td22;
	private Integer td23;
	private Integer td24;
	private Integer td25;
	private Integer td26;
	private Integer td27;
	private Integer td28;
	private Integer td29;
	private Integer td30;
	private Integer td31;
	private Integer td32;
	private Integer td33;
	private Integer td34;
	private Integer td35;
	private Integer td36;
	private Integer td37;
	private Integer td38;
	private Integer td39;
	private Integer td40;
	private Integer td41;
	private Integer td42;
	private Integer td43;
	private Integer td44;
	private Integer td45;
	private Integer td46;
	private Integer td47;
	private Integer td48;
	private Integer td49;
	private Integer td50;
	private Integer td51;
	private Integer td52;
	private Integer td53;
	private Integer td54;
	private Integer td55;
	private Integer td56;
	private Integer td57;
	private Integer td58;
	private Integer td59;
	private Integer td60;
	private Integer td61;
	private Integer td62;
	private Integer td63;
	private Integer td64;

	public BasicWork() {
	}

	public BasicWork(int year, int state, String sumbitOne, String name, int editDpt) {
		this.year = year;
		this.state = state;
		this.sumbitOne = sumbitOne;
		this.name = name;
		this.editDpt = editDpt;
	}

	public BasicWork(int year, int state, String sumbitOne, String sumbitDate, String name, int editDpt, String dptName,
			Integer td1, Integer td2, Integer td3, Integer td4, Integer td5, Integer td6, Integer td7, Integer td8,
			Integer td9, Integer td10, Integer td11, Integer td12, Integer td13, Integer td14, Integer td15,
			Integer td16, Integer td17, Integer td18, Integer td19, Integer td20, Integer td21, Integer td22,
			Integer td23, Integer td24, Integer td25, Integer td26, Integer td27, Integer td28, Integer td29,
			Integer td30, Integer td31, Integer td32, Integer td33, Integer td34, Integer td35, Integer td36,
			Integer td37, Integer td38, Integer td39, Integer td40, Integer td41, Integer td42, Integer td43,
			Integer td44, Integer td45, Integer td46, Integer td47, Integer td48, Integer td49, Integer td50,
			Integer td51, Integer td52, Integer td53, Integer td54, Integer td55, Integer td56, Integer td57,
			Integer td58, Integer td59, Integer td60, Integer td61, Integer td62, Integer td63, Integer td64) {
		this.year = year;
		this.state = state;
		this.sumbitOne = sumbitOne;
		this.sumbitDate = sumbitDate;
		this.name = name;
		this.editDpt = editDpt;
		this.dptName = dptName;
		this.td1 = td1;
		this.td2 = td2;
		this.td3 = td3;
		this.td4 = td4;
		this.td5 = td5;
		this.td6 = td6;
		this.td7 = td7;
		this.td8 = td8;
		this.td9 = td9;
		this.td10 = td10;
		this.td11 = td11;
		this.td12 = td12;
		this.td13 = td13;
		this.td14 = td14;
		this.td15 = td15;
		this.td16 = td16;
		this.td17 = td17;
		this.td18 = td18;
		this.td19 = td19;
		this.td20 = td20;
		this.td21 = td21;
		this.td22 = td22;
		this.td23 = td23;
		this.td24 = td24;
		this.td25 = td25;
		this.td26 = td26;
		this.td27 = td27;
		this.td28 = td28;
		this.td29 = td29;
		this.td30 = td30;
		this.td31 = td31;
		this.td32 = td32;
		this.td33 = td33;
		this.td34 = td34;
		this.td35 = td35;
		this.td36 = td36;
		this.td37 = td37;
		this.td38 = td38;
		this.td39 = td39;
		this.td40 = td40;
		this.td41 = td41;
		this.td42 = td42;
		this.td43 = td43;
		this.td44 = td44;
		this.td45 = td45;
		this.td46 = td46;
		this.td47 = td47;
		this.td48 = td48;
		this.td49 = td49;
		this.td50 = td50;
		this.td51 = td51;
		this.td52 = td52;
		this.td53 = td53;
		this.td54 = td54;
		this.td55 = td55;
		this.td56 = td56;
		this.td57 = td57;
		this.td58 = td58;
		this.td59 = td59;
		this.td60 = td60;
		this.td61 = td61;
		this.td62 = td62;
		this.td63 = td63;
		this.td64 = td64;
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

	@Column(name = "year", unique = true, nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "sumbitOne", nullable = false, length = 12)
	public String getSumbitOne() {
		return this.sumbitOne;
	}

	public void setSumbitOne(String sumbitOne) {
		this.sumbitOne = sumbitOne;
	}

	@Column(name = "sumbitDate", length = 32)
	public String getSumbitDate() {
		return this.sumbitDate;
	}

	public void setSumbitDate(String sumbitDate) {
		this.sumbitDate = sumbitDate;
	}

	@Column(name = "name", nullable = false, length = 128)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "editDpt", nullable = false)
	public int getEditDpt() {
		return this.editDpt;
	}

	public void setEditDpt(int editDpt) {
		this.editDpt = editDpt;
	}

	@Column(name = "dptName", length = 32)
	public String getDptName() {
		return this.dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	@Column(name = "td1")
	public Integer getTd1() {
		return this.td1;
	}

	public void setTd1(Integer td1) {
		this.td1 = td1;
	}

	@Column(name = "td2")
	public Integer getTd2() {
		return this.td2;
	}

	public void setTd2(Integer td2) {
		this.td2 = td2;
	}

	@Column(name = "td3")
	public Integer getTd3() {
		return this.td3;
	}

	public void setTd3(Integer td3) {
		this.td3 = td3;
	}

	@Column(name = "td4")
	public Integer getTd4() {
		return this.td4;
	}

	public void setTd4(Integer td4) {
		this.td4 = td4;
	}

	@Column(name = "td5")
	public Integer getTd5() {
		return this.td5;
	}

	public void setTd5(Integer td5) {
		this.td5 = td5;
	}

	@Column(name = "td6")
	public Integer getTd6() {
		return this.td6;
	}

	public void setTd6(Integer td6) {
		this.td6 = td6;
	}

	@Column(name = "td7")
	public Integer getTd7() {
		return this.td7;
	}

	public void setTd7(Integer td7) {
		this.td7 = td7;
	}

	@Column(name = "td8")
	public Integer getTd8() {
		return this.td8;
	}

	public void setTd8(Integer td8) {
		this.td8 = td8;
	}

	@Column(name = "td9")
	public Integer getTd9() {
		return this.td9;
	}

	public void setTd9(Integer td9) {
		this.td9 = td9;
	}

	@Column(name = "td10")
	public Integer getTd10() {
		return this.td10;
	}

	public void setTd10(Integer td10) {
		this.td10 = td10;
	}

	@Column(name = "td11")
	public Integer getTd11() {
		return this.td11;
	}

	public void setTd11(Integer td11) {
		this.td11 = td11;
	}

	@Column(name = "td12")
	public Integer getTd12() {
		return this.td12;
	}

	public void setTd12(Integer td12) {
		this.td12 = td12;
	}

	@Column(name = "td13")
	public Integer getTd13() {
		return this.td13;
	}

	public void setTd13(Integer td13) {
		this.td13 = td13;
	}

	@Column(name = "td14")
	public Integer getTd14() {
		return this.td14;
	}

	public void setTd14(Integer td14) {
		this.td14 = td14;
	}

	@Column(name = "td15")
	public Integer getTd15() {
		return this.td15;
	}

	public void setTd15(Integer td15) {
		this.td15 = td15;
	}

	@Column(name = "td16")
	public Integer getTd16() {
		return this.td16;
	}

	public void setTd16(Integer td16) {
		this.td16 = td16;
	}

	@Column(name = "td17")
	public Integer getTd17() {
		return this.td17;
	}

	public void setTd17(Integer td17) {
		this.td17 = td17;
	}

	@Column(name = "td18")
	public Integer getTd18() {
		return this.td18;
	}

	public void setTd18(Integer td18) {
		this.td18 = td18;
	}

	@Column(name = "td19")
	public Integer getTd19() {
		return this.td19;
	}

	public void setTd19(Integer td19) {
		this.td19 = td19;
	}

	@Column(name = "td20")
	public Integer getTd20() {
		return this.td20;
	}

	public void setTd20(Integer td20) {
		this.td20 = td20;
	}

	@Column(name = "td21")
	public Integer getTd21() {
		return this.td21;
	}

	public void setTd21(Integer td21) {
		this.td21 = td21;
	}

	@Column(name = "td22")
	public Integer getTd22() {
		return this.td22;
	}

	public void setTd22(Integer td22) {
		this.td22 = td22;
	}

	@Column(name = "td23")
	public Integer getTd23() {
		return this.td23;
	}

	public void setTd23(Integer td23) {
		this.td23 = td23;
	}

	@Column(name = "td24")
	public Integer getTd24() {
		return this.td24;
	}

	public void setTd24(Integer td24) {
		this.td24 = td24;
	}

	@Column(name = "td25")
	public Integer getTd25() {
		return this.td25;
	}

	public void setTd25(Integer td25) {
		this.td25 = td25;
	}

	@Column(name = "td26")
	public Integer getTd26() {
		return this.td26;
	}

	public void setTd26(Integer td26) {
		this.td26 = td26;
	}

	@Column(name = "td27")
	public Integer getTd27() {
		return this.td27;
	}

	public void setTd27(Integer td27) {
		this.td27 = td27;
	}

	@Column(name = "td28")
	public Integer getTd28() {
		return this.td28;
	}

	public void setTd28(Integer td28) {
		this.td28 = td28;
	}

	@Column(name = "td29")
	public Integer getTd29() {
		return this.td29;
	}

	public void setTd29(Integer td29) {
		this.td29 = td29;
	}

	@Column(name = "td30")
	public Integer getTd30() {
		return this.td30;
	}

	public void setTd30(Integer td30) {
		this.td30 = td30;
	}

	@Column(name = "td31")
	public Integer getTd31() {
		return this.td31;
	}

	public void setTd31(Integer td31) {
		this.td31 = td31;
	}

	@Column(name = "td32")
	public Integer getTd32() {
		return this.td32;
	}

	public void setTd32(Integer td32) {
		this.td32 = td32;
	}

	@Column(name = "td33")
	public Integer getTd33() {
		return this.td33;
	}

	public void setTd33(Integer td33) {
		this.td33 = td33;
	}

	@Column(name = "td34")
	public Integer getTd34() {
		return this.td34;
	}

	public void setTd34(Integer td34) {
		this.td34 = td34;
	}

	@Column(name = "td35")
	public Integer getTd35() {
		return this.td35;
	}

	public void setTd35(Integer td35) {
		this.td35 = td35;
	}

	@Column(name = "td36")
	public Integer getTd36() {
		return this.td36;
	}

	public void setTd36(Integer td36) {
		this.td36 = td36;
	}

	@Column(name = "td37")
	public Integer getTd37() {
		return this.td37;
	}

	public void setTd37(Integer td37) {
		this.td37 = td37;
	}

	@Column(name = "td38")
	public Integer getTd38() {
		return this.td38;
	}

	public void setTd38(Integer td38) {
		this.td38 = td38;
	}

	@Column(name = "td39")
	public Integer getTd39() {
		return this.td39;
	}

	public void setTd39(Integer td39) {
		this.td39 = td39;
	}

	@Column(name = "td40")
	public Integer getTd40() {
		return this.td40;
	}

	public void setTd40(Integer td40) {
		this.td40 = td40;
	}

	@Column(name = "td41")
	public Integer getTd41() {
		return this.td41;
	}

	public void setTd41(Integer td41) {
		this.td41 = td41;
	}

	@Column(name = "td42")
	public Integer getTd42() {
		return this.td42;
	}

	public void setTd42(Integer td42) {
		this.td42 = td42;
	}

	@Column(name = "td43")
	public Integer getTd43() {
		return this.td43;
	}

	public void setTd43(Integer td43) {
		this.td43 = td43;
	}

	@Column(name = "td44")
	public Integer getTd44() {
		return this.td44;
	}

	public void setTd44(Integer td44) {
		this.td44 = td44;
	}

	@Column(name = "td45")
	public Integer getTd45() {
		return this.td45;
	}

	public void setTd45(Integer td45) {
		this.td45 = td45;
	}

	@Column(name = "td46")
	public Integer getTd46() {
		return this.td46;
	}

	public void setTd46(Integer td46) {
		this.td46 = td46;
	}

	@Column(name = "td47")
	public Integer getTd47() {
		return this.td47;
	}

	public void setTd47(Integer td47) {
		this.td47 = td47;
	}

	@Column(name = "td48")
	public Integer getTd48() {
		return this.td48;
	}

	public void setTd48(Integer td48) {
		this.td48 = td48;
	}

	@Column(name = "td49")
	public Integer getTd49() {
		return this.td49;
	}

	public void setTd49(Integer td49) {
		this.td49 = td49;
	}

	@Column(name = "td50")
	public Integer getTd50() {
		return this.td50;
	}

	public void setTd50(Integer td50) {
		this.td50 = td50;
	}

	@Column(name = "td51")
	public Integer getTd51() {
		return this.td51;
	}

	public void setTd51(Integer td51) {
		this.td51 = td51;
	}

	@Column(name = "td52")
	public Integer getTd52() {
		return this.td52;
	}

	public void setTd52(Integer td52) {
		this.td52 = td52;
	}

	@Column(name = "td53")
	public Integer getTd53() {
		return this.td53;
	}

	public void setTd53(Integer td53) {
		this.td53 = td53;
	}

	@Column(name = "td54")
	public Integer getTd54() {
		return this.td54;
	}

	public void setTd54(Integer td54) {
		this.td54 = td54;
	}

	@Column(name = "td55")
	public Integer getTd55() {
		return this.td55;
	}

	public void setTd55(Integer td55) {
		this.td55 = td55;
	}

	@Column(name = "td56")
	public Integer getTd56() {
		return this.td56;
	}

	public void setTd56(Integer td56) {
		this.td56 = td56;
	}

	@Column(name = "td57")
	public Integer getTd57() {
		return this.td57;
	}

	public void setTd57(Integer td57) {
		this.td57 = td57;
	}

	@Column(name = "td58")
	public Integer getTd58() {
		return this.td58;
	}

	public void setTd58(Integer td58) {
		this.td58 = td58;
	}

	@Column(name = "td59")
	public Integer getTd59() {
		return this.td59;
	}

	public void setTd59(Integer td59) {
		this.td59 = td59;
	}

	@Column(name = "td60")
	public Integer getTd60() {
		return this.td60;
	}

	public void setTd60(Integer td60) {
		this.td60 = td60;
	}

	@Column(name = "td61")
	public Integer getTd61() {
		return this.td61;
	}

	public void setTd61(Integer td61) {
		this.td61 = td61;
	}

	@Column(name = "td62")
	public Integer getTd62() {
		return this.td62;
	}

	public void setTd62(Integer td62) {
		this.td62 = td62;
	}

	@Column(name = "td63")
	public Integer getTd63() {
		return this.td63;
	}

	public void setTd63(Integer td63) {
		this.td63 = td63;
	}

	@Column(name = "td64")
	public Integer getTd64() {
		return this.td64;
	}

	public void setTd64(Integer td64) {
		this.td64 = td64;
	}

}
