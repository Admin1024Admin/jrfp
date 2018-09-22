package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.*;
import com.ky.ct.rzdj.model.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.lang.reflect.Field;
import java.util.*;

@Controller
public class PkfAllController {
    @Autowired
    private PkfAllDao pkfAllDao;
    @Autowired
    private PkfInformationDao pkfInformationDao;
    @Autowired
    private PkfDzbDao pkfDzbDao;
    @Autowired
    private PkfFpbxDao pkfFpbxDao;
    @Autowired
    private PkfPjsxDao pkfPjsxDao;


    @GetMapping("/fpxdtz")
    public String pkfDzb(Map<String,Object> map){
        return "admin/poor/fpxdtz/findAll";
    }

    @PostMapping("/findAllWhere")
    @ResponseBody
   public List<PkfAllEntity>  findAllWhere(HttpServletRequest request){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from pkf_information p1,pkf_pjsx p2,pkf_dzb p3,pkf_fpb p4,pkf_fpxexdtz p5 where ");
//        sb.append("select new com.ky.ct.rzdj.model.PkfAllEntity(uid,no,shiQuQi,xiangZheng,chun,she,familyNo,\n" +
//                "                        memberNo,name,cardId,members,familyRelation,mz,\n" +
//                "                        xueLi,schoolState,healthState,skill,workState,workMonth,\n" +
//                "                        isDaBinYiLiao,tuoPinState,pinKunState,pinKunYuanYin,isWeiFangHu,\n" +
//                "                        isYinShuiAnQuan,isYinShuiKunNan,renJunChunShouRu,telephone,tongJiShiJian,\n" +
//                "                        xiangZhen,chunZu,huZhu,daiKuanRen,wenHuaChengDu,laoDongNengLi,\n" +
//                "                        givenStars,shouXinEDu,shouXinDate,contactPhone,note,tianBaoDanWei,\n" +
//                "                        tianBiaoRen,tianBiaoRenLianXi,shenHeRen,tianBiaoDate,address,baoXianJinE,\n" +
//                "                        baoFei,canBaoType,tianBaoDate,touBaoYear,touBaoRen,beiBaoRen,\n" +
//                "                        gender,bornDate,zhiYeCode,cardIdType,shouYiRen,beiBaoRenSign,\n" +
//                "                        huiJiaoRen,touBaoCompany,xianZhong, importDate,billNo,baoE,\n" +
//                "                        familyMember,familyMemberCardId,familyMemberCount,pingJiJiGou,isQueryZhengXin,\n" +
//                "                        shouXinZiLiaoOk,isHuZhu,daiKuanBenJin,daiKuanYuE,daiKuanTimeLimit,fangKuanDate,\n" +
//                "                        huanKuanDate,daiKuanLiLv,leiJiTieXi,huanBenJinE, huanBenDate,benJinYuQiJinE,\n" +
//                "                        benJinYuQiDate,qianXiJinE,qianXiDate,daiKuanZiLiaoOk,ziJinShiYongOk,\n" +
//                "                        daiKuanJiGou,tongJiDate) from PkfInformationEntity p1,PkfPjsxEntity p2,PkfDzbEntity p3,PkfFpbEntity p4,PkfFpxexdtzEntity p5 where ");
        Enumeration enumeration = request.getParameterNames();
        Map<String,Object> map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String paramValue =request.getParameter(paramName);
            //形成键值对应的map
            map.put(paramName, paramValue);
            if("cardId".equals(paramName)){
                paramName = "CardID";
            }
            if(paramValue!=null&&!"".equals(paramValue)){
                if(isInside(PkfInformationEntity.class,paramName)){
                    sb.append("p1.");
                    sb.append(toUpperCaseFirstOne(paramName));
                    sb.append(paramName);
                    sb.append("=");
                    sb.append("'"+paramValue+"'");
                    sb.append(" and ");
                }else if(isInside(PkfPjsxEntity.class,paramName)){
                    sb.append("p2.");
                    sb.append(toUpperCaseFirstOne(paramName));
                    sb.append("=");
                    sb.append(paramValue);
                    sb.append(" and ");

                }else if(isInside(PkfDzbEntity.class,paramName)){
                    sb.append("p3.");
                    sb.append(toUpperCaseFirstOne(paramName));
                    sb.append("=");
                    sb.append(paramValue);
                    sb.append(" and ");

                }else if(isInside(PkfFpbEntity.class,paramName)){
                    sb.append("p4.");
                    sb.append(toUpperCaseFirstOne(paramName));
                    sb.append("=");
                    sb.append(paramValue);
                    sb.append(" and ");

                }else{
                    sb.append("p5.");
                    sb.append(toUpperCaseFirstOne(paramName));
                    sb.append("=");
                    sb.append(paramValue);
                    sb.append(" and ");
                }
            }
                String sql = sb.toString().substring(0,sb.length()-4);
                System.out.println("sql---"+sql);
                //List<PkfAllEntity> pkfAllEntities= pkfAllDao.findListBySql4(sql);
            List pkfAllEntities= pkfAllDao.findListBySql5(sql);
                System.out.println(pkfAllEntities);
                return null;
            }
        return null;
    }

    @PostMapping("/findAllWhere2")
    public String  findAllWhere2(HttpServletRequest request,Map<String,Object> map){
        StringBuffer sb = new StringBuffer();
        Enumeration enumeration = request.getParameterNames();
        Map<String,Object> p1Map = new HashMap<>();
        Map<String,Object> p2Map = new HashMap<>();
        Map<String,Object> p3Map = new HashMap<>();
        Map<String,Object> p4Map = new HashMap<>();
        Map<String,Object> p5Map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String paramValue =request.getParameter(paramName);
            System.out.println("Name-------"+paramName+"Value"+paramValue);
            //形成键值对应的map
            if(paramValue!=null&&!"".equals(paramValue)){
                if(isInside(PkfInformationEntity.class,paramName)){
                    p1Map.put(paramName,paramValue);
                }else if(isInside(PkfPjsxEntity.class,paramName)){
                    p2Map.put(paramName,paramValue);
                }else if(isInside(PkfDzbEntity.class,paramName)){
                    p3Map.put(paramName,paramValue);
                }else if(isInside(PkfFpbEntity.class,paramName)){
                    p4Map.put(paramName,paramValue);
                }else{
                    p5Map.put(paramName,paramValue);
                }
            }
        }
        List<String> p1Nos = new ArrayList<>();
        List<String> p2Nos = new ArrayList<>();
        List<String> p3Nos = new ArrayList<>();
        List<String> p4Nos = new ArrayList<>();
        if(p1Map!=null&&p1Map.size()>0){
          List<PkfInformationEntity> pkfInformationEntities=pkfInformationDao.findAll(p1Map);
          for(PkfInformationEntity p:pkfInformationEntities){
              System.out.println("no"+p.getNo());
              p1Nos.add(p.getCardId());
          }
        }
        if(p2Map!=null&&p2Map.size()>0){
            List<PkfPjsxEntity> pkfPjsxEntities = pkfPjsxDao.findAll(p2Map);
            for(PkfPjsxEntity p:pkfPjsxEntities){
                p2Nos.add(p.getCardId());
            }
        }
        if(p3Map!=null&&p3Map.size()>0){
            List<PkfDzbEntity> pkfDzbEntities = pkfDzbDao.findAll(p3Map);
            for(PkfDzbEntity p:pkfDzbEntities){
                p3Nos.add(p.getCardId());
            }
        }
        if(p4Map!=null&&p4Map.size()>0){
            System.out.println("------------------"+p4Map);
            List<PkfFpbEntity> pkfFpbEntities = pkfFpbxDao.findAll(p4Map);
            for(PkfFpbEntity p:pkfFpbEntities){
                p4Nos.add(p.getCardId());
            }
        }
        if(p5Map!=null&&p5Map.size()>0){

        }
        int[] sizeArr = new int[4];
        sizeArr[0] = p1Nos.size();
        sizeArr[1] = p2Nos.size();
        sizeArr[2] = p3Nos.size();
        sizeArr[3] = p4Nos.size();
        int min =sizeArr[0];
        for(int i = 1;i<sizeArr.length;i++){
            if(min<sizeArr[i]){
                min = sizeArr[i];
            }
        }
        System.out.println("min-------------------"+min+"size="+p1Nos.size());
        List<PkfInformationEntity> p1List = new ArrayList<>();
        List<PkfPjsxEntity> p2List = new ArrayList<>();
        List<PkfDzbEntity> p3List = new ArrayList<>();
        List<PkfFpbEntity> p4List = new ArrayList<>();
        if(p1Nos.size()==min){
            for(int i=0;i<p1Nos.size();i++){
                PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(p1Nos.get(i));
                PkfPjsxEntity pkfPjsxEntity = pkfPjsxDao.findByCardId(p1Nos.get(i));
                PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(p1Nos.get(i));
                PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(p1Nos.get(i));
                p1List.add(pkfInformationEntity);
                p2List.add(pkfPjsxEntity);
                p3List.add(pkfDzbEntity);
                p4List.add(pkfFpbEntity);
            }
        }else if(p2Nos.size()==min){
            for(int i=0;i<p2Nos.size();i++){
                PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(p2Nos.get(i));
                PkfPjsxEntity pkfPjsxEntity = pkfPjsxDao.findByCardId(p2Nos.get(i));
                PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(p2Nos.get(i));
                PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(p2Nos.get(i));
                p1List.add(pkfInformationEntity);
                p2List.add(pkfPjsxEntity);
                p3List.add(pkfDzbEntity);
                p4List.add(pkfFpbEntity);
            }
        }else if(p3Nos.size()==min){
            for(int i=0;i<p3Nos.size();i++){
                PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(p3Nos.get(i));
                PkfPjsxEntity pkfPjsxEntity = pkfPjsxDao.findByCardId(p3Nos.get(i));
                PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(p3Nos.get(i));
                PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(p3Nos.get(i));
                p1List.add(pkfInformationEntity);
                p2List.add(pkfPjsxEntity);
                p3List.add(pkfDzbEntity);
                p4List.add(pkfFpbEntity);
            }
        }else if(p4Nos.size()==min){
            for(int i=0;i<p4Nos.size();i++){
                PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(p4Nos.get(i));
                PkfPjsxEntity pkfPjsxEntity = pkfPjsxDao.findByCardId(p4Nos.get(i));
                PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(p4Nos.get(i));
                PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(p4Nos.get(i));
                p1List.add(pkfInformationEntity);
                p2List.add(pkfPjsxEntity);
                p3List.add(pkfDzbEntity);
                p4List.add(pkfFpbEntity);
            }
        }
        map.put("p1List",p1List);
        map.put("p2List",p2List);
        map.put("p3List",p3List);
        map.put("p4List",p4List);
        return "admin/poor/fpxdtz/demo";
    }

    /**
     *判断某个类中是否存在这个二属性
     */
   public boolean isInside(Class cla,String param){
        Field[] fields=cla.getDeclaredFields();
        boolean b=false;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals(param)){
                b=true;
                break;
            }
        }
        return  b;
   }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
