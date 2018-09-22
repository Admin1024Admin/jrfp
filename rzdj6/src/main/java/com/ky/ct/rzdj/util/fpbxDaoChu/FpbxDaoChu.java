package com.ky.ct.rzdj.util.fpbxDaoChu;

import java.util.LinkedHashMap;
import java.util.Map;

public class FpbxDaoChu {
    public static Map<String,String> getFpbxField(){
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("id","序号");
        fieldsMap.put("xiang","乡（镇）");
        fieldsMap.put("chun","行政村");
        fieldsMap.put("zu","组别");
        fieldsMap.put("huZhuName","户主姓名");
        fieldsMap.put("familyMemberName","家庭成员姓名");
        fieldsMap.put("cardId","身份证号");
        fieldsMap.put("familyRelation","与户主关系");
        fieldsMap.put("familyMemberCount","家庭人口");
        fieldsMap.put("baoFeiZongE","总额");
        fieldsMap.put("baoFeiZiFu","其中：自付");
        fieldsMap.put("baoFeiBuTie","其中：财政补贴");
        fieldsMap.put("baoZhangJinE","保障金额");
        fieldsMap.put("baoZhangQiJian","保障期间");
        fieldsMap.put("touBaoDate","投保时间");
        fieldsMap.put("daoQiDate","到期时间");
        fieldsMap.put("liPeiShiXiang","理赔事项");
        fieldsMap.put("liPeiDate","理赔时间");
        fieldsMap.put("liPeiJinE","理赔金额");
        fieldsMap.put("liPeiShouYiRen","受益人");
        fieldsMap.put("chengBaoJiGou","承办保险机构");
        fieldsMap.put("touPinYear","脱贫年度");
        fieldsMap.put("note","备注");
        return fieldsMap;
    }
}
