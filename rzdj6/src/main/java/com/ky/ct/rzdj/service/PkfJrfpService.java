package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.*;
import com.ky.ct.rzdj.model.*;
import com.ky.ct.rzdj.util.Fields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PkfJrfpService {
    @Autowired
    private PkfInformationDao pkfInformationDao;
    @Autowired
    private PkfDzbDao pkfDzbDao;
    @Autowired
    private PkfFpbxDao pkfFpbxDao;
    @Autowired
    private PkfPjsxDao pkfPjsxDao;
    @Autowired
    private PkfFpxexdtzDao pkfFpxexdtzDao;

    /**
     * 根据条件吧id查询出来
     */
    public Set<String> getCardId(Map<String,Object> params){
        Set<String> cardIdSet = new HashSet<>();
        //根据传递过来的条件把身份证查询出来放入一个不可重复的Set集合里面
        for(String param:params.keySet()){
            switch (param){
                case "xiangZheng":case "chun":case "she":case "name":{
                    List<Object[]> cardIds = pkfInformationDao.findListBySql2("select cardID from pkf_information where "+ Fields.toUpperCaseFirstOne(param)+"="+Fields.toQuotes(params.get(param).toString()));
                    for(Object o:cardIds){
                        cardIdSet.add(o.toString());
                    }
                    System.out.println("身份证列表："+cardIds.toString());
                    break;
                }
                case "cardId":{
                    List<Object[]> cardIds = pkfInformationDao.findListBySql2("select cardID from pkf_information where CardID"+"="+Fields.toQuotes(params.get(param).toString()));
                    for(Object o:cardIds){
                        cardIdSet.add(o.toString());
                    }
                    break;
                }
            }
        }
        return cardIdSet;
    }
    /**
     * 根据字段和条件查询相关数据
     */
    public Map<String,Object> findFieldsAndWhere(Map<String,Object> params, Set<String> cardIdSet,List<String> fields){
        System.out.println("params:"+params);
        int i=1;
        long startTime = System.currentTimeMillis();    //获取开始时间
        StringBuffer pkfInformationSql = new StringBuffer();
        StringBuffer pkfFpbxSql = new StringBuffer();
        StringBuffer pkfDzbSql = new StringBuffer();
        StringBuffer pkfPjsxSql = new StringBuffer();
        StringBuffer pkfFpxexdtzSql = new StringBuffer();
        pkfInformationSql.append("select ");
        pkfFpbxSql.append("select ");
        pkfDzbSql.append("select ");
        pkfPjsxSql.append("select ");
        pkfFpxexdtzSql.append("select ");
        for(String field:fields){
            if(Fields.isInside(PkfInformationEntity.class,field)){
                pkfInformationSql.append(Fields.toUpperCaseFirstOne(field)+",");
            }else if(Fields.isInside(PkfFpbEntity.class,field)){
                pkfFpbxSql.append(Fields.toUpperCaseFirstOne(field)+",");
            }else if(Fields.isInside(PkfDzbEntity.class,field)){
                pkfDzbSql.append(Fields.toUpperCaseFirstOne(field)+",");
            }else if(Fields.isInside(PkfPjsxEntity.class,field)){
                pkfPjsxSql.append(Fields.toUpperCaseFirstOne(field)+",");
            }else{
                pkfFpxexdtzSql.append(Fields.toUpperCaseFirstOne(field)+",");
            }
        }
        Boolean isFieldPkfInformation = false;
        Boolean isFieldPkfFpbx = false;
        Boolean isFieldPkfDzb = false;
        Boolean isFieldPkfPjsx = false;
        Boolean isFieldPkfFpxexdtz = false;
        if(pkfInformationSql.length()>7){
            pkfInformationSql.delete(pkfInformationSql.length()-1,pkfInformationSql.length());
            pkfInformationSql.append(" from pkf_information where CardID=");
            isFieldPkfInformation = true;
        }
        if(pkfFpbxSql.length()>7){
            pkfFpbxSql.delete(pkfFpbxSql.length()-1,pkfFpbxSql.length());
            pkfFpbxSql.append(" from pkf_fpb where CardID=");
            isFieldPkfFpbx = true;
        }
        if(pkfDzbSql.length()>7){
            pkfDzbSql.delete(pkfDzbSql.length()-1,pkfDzbSql.length());
            pkfDzbSql.append(" from pkf_dzb where CardID=");
            isFieldPkfDzb = true;
        }
        if(pkfPjsxSql.length()>7){
            pkfPjsxSql.delete(pkfPjsxSql.length()-1,pkfPjsxSql.length());
            pkfPjsxSql.append(" from pkf_pjsx where CardID=");
            isFieldPkfPjsx = true;
        }
        if(pkfFpxexdtzSql.length()>7){
            pkfFpxexdtzSql.delete(pkfFpxexdtzSql.length()-1,pkfFpxexdtzSql.length());
            pkfFpxexdtzSql.append(" from pkf_fpxexdtz where CardID=");
            isFieldPkfFpxexdtz = true;
        }
        List<Object[]>  pkfInformationList= new ArrayList<>();
        List<Object[]>  pkfFpbxList= new ArrayList<>();
        List<Object[]>  pkfDzbList= new ArrayList<>();
        List<Object[]>  pkfPjsxList= new ArrayList<>();
        List<Object[]>  pkfFpxexdtzList= new ArrayList<>();
       for(String cardId:cardIdSet){
           if(i>9){
               break;
           }
          //PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(cardId);
//           if(isFieldPkfInformation){
//               Object[] objects1= pkfInformationDao.findBySql2(pkfInformationSql.toString()+Fields.toQuotes(cardId));
//               pkfInformationList.add(objects1);
//           }
//           if(isFieldPkfFpbx){
//               Object[] objects2= pkfFpbxDao.findBySql2(pkfFpbxSql.toString()+Fields.toQuotes(cardId));
//               pkfFpbxList.add(objects2);
//           }
//          if(isFieldPkfDzb){
//              Object[] objects3= pkfDzbDao.findBySql2(pkfDzbSql.toString()+Fields.toQuotes(cardId));
//              pkfDzbList.add(objects3);
//          }
//          if(isFieldPkfPjsx){
//              Object[] objects4= pkfPjsxDao.findBySql2(pkfPjsxSql.toString()+Fields.toQuotes(cardId));
//              pkfPjsxList.add(objects4);
//          }
//          if(isFieldPkfFpxexdtz){
//              Object[] objects5= pkfFpxexdtzDao.findBySql2(pkfFpxexdtzSql.toString()+Fields.toQuotes(cardId));
//              pkfFpxexdtzList.add(objects5);
//          }
          System.out.println("i:"+i);
//           for(Object o:objects){
//               System.out.println("o:"+o);
//           }
//           PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(cardId);
//           PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(cardId);
//           PkfFpxexdtzEntity pkfFpxexdtzEntity = pkfFpxexdtzDao.findByCardId(cardId);
//           p1List.add(pkfInformationEntity);
//           p2List.add(pkfPjsxEntity);
//           p3List.add(pkfDzbEntity);
//           p4List.add(pkfFpbEntity);
//           p5List.add(pkfFpxexdtzEntity);
           i++;
          // p5List.add(pkfFpxexdtzEntity);
       }
//       for(String field:fields){
//           if(Fields.){
//
//           }
//       }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时
       Map<String,Object> resuleMap = new HashMap<>();
//        resuleMap.put("p1List",p1List);
//        resuleMap.put("p2List",p2List);
//        resuleMap.put("p3List",p3List);
//        resuleMap.put("p4List",p4List);
//        resuleMap.put("p5List",p5List);
        System.out.println("所有的"+pkfInformationList.size());
        System.out.println("所有的"+pkfFpbxList.size());
        System.out.println("所有的"+pkfDzbList.size());
        System.out.println("所有的"+pkfPjsxList.size());
        System.out.println("所有的"+pkfFpxexdtzList.size());
        return resuleMap;
    }
}
