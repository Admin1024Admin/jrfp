package com.ky.ct.rzdj.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoObjectUtil {
	/**
	 * 拷贝相同属性到另一个对象
	 */
	public static Object copyToFpxexd(Object fromObj, Object toObj) {
		//获取对象的class
		Class<?> clazz1 = fromObj.getClass();
		Class<?> clazz2 = toObj.getClass();
		//获取对象的属性列表
		Field[] field1 = clazz1.getDeclaredFields();
		Field[] field2 = clazz2.getDeclaredFields();
		//遍历属性列表field1
		for (int i = 0; i < field1.length; i++) {
			//遍历属性列表field2
			for (int j = 0; j < field2.length; j++) {
				//如果field1[i]属性名与field2[j]属性名相同,且不是主键
				if (field1[i].getName().equals(field2[j].getName()) && ! "no".equals(field1[i].getName()) && ! "uid".equals(field1[i].getName())) {
					field1[i].setAccessible(true);
					field2[j].setAccessible(true);
					try {
						field2[j].set(toObj, field1[i].get(fromObj));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

		return toObj;
	}

	/**
	 * 属性有内容时拷贝相同属性到另一history对象
	 */
	public static Object copyToFpxexdNotEmpty(Object fromObj, Object toObj) {
		//获取对象的class
		Class<?> clazz1 = fromObj.getClass();
		Class<?> clazz2 = toObj.getClass();
		//获取对象的属性列表
		Field[] field1 = clazz1.getDeclaredFields();
		Field[] field2 = clazz2.getDeclaredFields();
		//遍历属性列表field1
		for (int i = 0; i < field1.length; i++) {
			//遍历属性列表field2
			for (int j = 0; j < field2.length; j++) {
				//如果field1[i]属性名与field2[j]属性名相同,且不为主键
				if (field1[i].getName().equals(field2[j].getName()) && ! "no".equals(field1[i].getName()) && !"uid".equals(field1[i].getName())) {
					field1[i].setAccessible(true);
					field2[j].setAccessible(true);
					try {
						//不为空才设置值进去
						if (field1[i].get(fromObj) != null && !"".equals(field1[i].get(fromObj))) {
							//如果是double且不为0就不设置
							if (field1[i].getType().getTypeName() == double.class.getTypeName() && (double)field1[i].get(fromObj)==0){
							}else {
								field2[j].set(toObj, field1[i].get(fromObj));
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					//如果是日期,就给前端一个值
					break;
				}
			}
		}

		return toObj;
	}

	/**
	 * 比较两个对象的不同值
	 */
	public static List<String> compareFpxexdAndHistory(Object class1, Object class2) throws IllegalAccessException {
		HashMap<String, String> fieldMap = new HashMap<>();
		fieldMap.put("no", "序号");
		fieldMap.put("operation", "操作状态");
		fieldMap.put("operationPerson", "操作人");
		fieldMap.put("operationDate", "操作时间");
		fieldMap.put("checkStatus", "审核状态");
		fieldMap.put("checkPerson", "审核人");
		fieldMap.put("checkDate", "审核时间");
		fieldMap.put("reason", "拒绝理由");
		fieldMap.put("xiang", "乡");
		fieldMap.put("chun", "行政村");
		fieldMap.put("zu", "组别");
		fieldMap.put("name", "户主姓名");
		fieldMap.put("cardId", "身份证号");
		fieldMap.put("members", "家庭人口数");
		fieldMap.put("daiKuanRenXingMing", "贷款人姓名");
		fieldMap.put("daiKuanRenCardId", "贷款人身份证号");
		fieldMap.put("familyRelation", "与户主关系");
		fieldMap.put("tuoPinState", "脱贫属性");
		fieldMap.put("yuanYouYuE", "原有余额");
		fieldMap.put("yuanYouIsYuQi", "原有贷款贷款是否逾期");
		fieldMap.put("yuanYouYuQiJinE", "逾期金额");
		fieldMap.put("yuanYouYuQiShiJian", "逾期时间");
		fieldMap.put("yuanYouQianXiJinE", "欠息金额");
		fieldMap.put("yuanYouQianXiShiJian", "欠息时间");
		fieldMap.put("fuPingivenStars", "等级评定");
		fieldMap.put("fuPinshouXinEDu", "授信额度");
		fieldMap.put("fuPinshouXinJiGou", "授信金融机构");
		fieldMap.put("fuPinshouxinData", "授信时间");
		fieldMap.put("fuPinXiaoDaidaiKuanJinE", "贷款金额");
		fieldMap.put("fuPindaiKuanQiXian", "贷款期限");
		fieldMap.put("fuPinfangKuanRiQi", "放款日期");
		fieldMap.put("fuPindaoQiRiQi", "到期日期");
		fieldMap.put("fuPinXiaoDaiDaiKuanLiLv", "贷款利率");
		fieldMap.put("fuPindaiKuanJiGou", "贷款金融机构");
		fieldMap.put("fuPinleiJiTieXi", "累计贴");
		fieldMap.put("fuPinchangHuanDaiKuanJInE", "偿还贷款金额");
		fieldMap.put("fuPinhuanKuanShiJian", "还款时间");
		fieldMap.put("fuPindaiKuanYuE", "贷款余额");
		fieldMap.put("fuPinyuQiDaiKuanJinE", "逾期贷款金额");
		fieldMap.put("fuPinyuQiDaiKuanShiJian", "贷款逾期时间");
		fieldMap.put("fuPinqianXiJinE", "欠息金额");
		fieldMap.put("fuPinqianXiShiJian", "欠息时间");
		fieldMap.put("fuPinYingDaiWeiDaiShiBie", "应贷未贷识别");
		fieldMap.put("fuPinDaiKuanYongTu", "贷款用途");
		fieldMap.put("chuangYeJinE", "贷款金额");
		fieldMap.put("chuangYeQiXian", "贷款期限");
		fieldMap.put("chuangYeFangKuanRiQi", "放款日期");
		fieldMap.put("chuangYeDaoQiShiJian", "到期日期");
		fieldMap.put("chuangYeLiLv", "贷款利率");
		fieldMap.put("chuangYeChangHuanJinE", "偿还金额");
		fieldMap.put("changYeHuangKuanShiJian", "还款时间");
		fieldMap.put("chuangYeYuE", "贷款余额");
		fieldMap.put("chuangYeYuQiJinE", "逾期贷款金额");
		fieldMap.put("chuangYeYuQiShiJian", "贷款逾期时间");
		fieldMap.put("chuangYeQianXiJinE", "欠息金额");
		fieldMap.put("chuangYeQianXiShiJian", "欠息时间");
		fieldMap.put("chuangYeYongTu", "贷款用途");
		fieldMap.put("shengYuanJinE", "贷款金额");
		fieldMap.put("shengYuanQiXian", "贷款期限");
		fieldMap.put("shengYuanFangKuanRiQi", "放款日期");
		fieldMap.put("shengYaunDaoQiRiQi", "到期日期");
		fieldMap.put("shengYaunLiLv", "贷款利率");
		fieldMap.put("shengYaunChangHuanJinE", "偿还金额");
		fieldMap.put("shengYuanHuanKuanShiJian", "还款时间");
		fieldMap.put("shengYuanYuE", "贷款余额");
		fieldMap.put("shengYuanYuQiJinE", "逾期贷款金额");
		fieldMap.put("shengYuanYuQiShiJian", "贷款逾期时间");
		fieldMap.put("shengYuanQianXiJinE", "欠息金额");
		fieldMap.put("shengYuanQianXiShiJian", "欠息时间");
		fieldMap.put("qiTaJinE", "贷款金额");
		fieldMap.put("qiTaQiXian", "贷款期限");
		fieldMap.put("qiTaFangKuanRiQi", "放款日期");
		fieldMap.put("qiTaDaoQiRiQi", "到期日期");
		fieldMap.put("qiTaLiLv", "贷款利率");
		fieldMap.put("qiTaChangHuanJinE", "偿还金额");
		fieldMap.put("qiTaChangHuangKuanShiJian", "还款时间");
		fieldMap.put("qiTaYuE", "贷款余额");
		fieldMap.put("qiTaYuQiJinE", "逾期贷款金额");
		fieldMap.put("qiTaYuQiShiJian", "贷款逾期时间");
		fieldMap.put("qiTaQianXiJinE", "欠息金额");
		fieldMap.put("qiTaQianXiShiJian", "欠息时间");
		fieldMap.put("qiTaYongTu", "贷款用途");
		fieldMap.put("note", "备注");
		List<String> list = new ArrayList<>();
		//获取对象的class
		Class<?> clazz1 = class1.getClass();
		Class<?> clazz2 = class2.getClass();
		//获取对象的属性列表
		Field[] field1 = clazz1.getDeclaredFields();
		Field[] field2 = clazz2.getDeclaredFields();
		//遍历属性列表field1
		for (int i = 0; i < field1.length; i++) {
			//遍历属性列表field2
			for (int j = 0; j < field2.length; j++) {
				//如果field1[i]属性名与field2[j]属性名内容相同
				if (field1[i].getName().equals(field2[j].getName())) {
					if (field1[i].getName().equals(field2[j].getName())) {
						field1[i].setAccessible(true);
						field2[j].setAccessible(true);
						//如果field1[i]属性值与field2[j]属性值内容不相同
						if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
							//Map<String, Object> map2 = new HashMap<>();
							//map2.put("name", field1[i].getName());//属性名
							//map2.put("old", field1[i].get(class1));//以前的属性值
							//map2.put("new", field2[j].get(class2));//现在的属性值
							//map2.put("nickName", fieldMap.get(field1[i].getName()));//属性的提示名称
							////如果是日期,就给前端一个值
							//if (field1[i].getType().getTypeName() == Date.class.getTypeName()) {
							//	map2.put("isDate", true);
							//} else {
							//	map2.put("isDate", false);
							//}
							String name = field1[i].getName();
							list.add(name);
						}
						break;
					}
				}
			}
		}

		return list;
	}

	/**
	 * 对比两个数据是否内容相同
	 */
	public static boolean compareTwo(Object object1, Object object2) {

		if (object1 == null && object2 == null) {
			return true;
		}
		if (object1 == null && object2 != null) {
			return false;
		}
		if (object1.equals(object2)) {
			return true;
		}
		return false;
	}
}