package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.dao.PkfInformationDao;
import com.ky.ct.rzdj.model.PkfInformationEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.*;

public class Daochu {
    public Map<String,String> getField(){
        long startTime = System.currentTimeMillis(); //获取开始时间
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("uid","编号");
        fieldsMap.put("no","序号");
        fieldsMap.put("shiQuQi","市区旗");
        fieldsMap.put("xiangZheng","乡镇");
        fieldsMap.put("chun","村");
        fieldsMap.put("she","社、组");
        fieldsMap.put("familyNo","户编号");
        fieldsMap.put("memberNo","人编号");
        fieldsMap.put("name","姓名");
        fieldsMap.put("cardID","身份证号");
        fieldsMap.put("members","家庭成员数");
        fieldsMap.put("familyRelation","与户主关系");
        fieldsMap.put("mz","民族");
        fieldsMap.put("xueLi","文化程度");
        fieldsMap.put("schoolState","在校生状况");
        fieldsMap.put("healthState","健康状况");
        fieldsMap.put("skill","劳动技能");
        fieldsMap.put("workState","务工状况");
        fieldsMap.put("workMonth","务工时间(月)");
        fieldsMap.put("isDaBinYiLiao","参加大病医疗");
        fieldsMap.put("tuoPinState","脱贫属性");
        fieldsMap.put("pinKunState","贫困户属性");
        fieldsMap.put("pinKunYuanYin","主要致贫原因");
        fieldsMap.put("isWeiFangHu","危房户");
        fieldsMap.put("isYinShuiAnQuan","饮水安全");
        fieldsMap.put("isYinShuiKunNan","饮水困难");
        fieldsMap.put("renJunChunShouRu","人均纯收入");
        fieldsMap.put("telephone","联系电话");
        fieldsMap.put("tongJiShiJian","统计时间");
        fieldsMap.put("note1","Note1");
        fieldsMap.put("note2","Note2");
        fieldsMap.put("note3","Note3");
        fieldsMap.put("note4","Note4");
        fieldsMap.put("note5","Note5");

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("fieldsMap程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        return fieldsMap;
    }

    public Sheet getSheet(Map<String,String> fieldsMap,List<String> fields,SXSSFWorkbook workbook){
        //创建数据表
        long startTime3 = System.currentTimeMillis();    //获取开始时间
        Sheet sheet =workbook.createSheet("信息表");
        //创建表头
        List<String> biaoTou = new ArrayList<>();
        for(String field:fields){
            biaoTou.add(fieldsMap.get(field));
        }
        //headers表示excel表中第一行的表头
        Row row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<biaoTou.size();i++){
            Cell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(biaoTou.get(i));
            cell.setCellValue(text);
        }
        return sheet;
    }
    @Async
    public void Listdaochu(Sheet sheet,int page,int limit,List<String> fields,PkfInformationDao pkfInformationDao){

        System.out.println("page"+page);
        int y = 1;
        Row row1 = null;
        for(int pa = 1;pa<=page;pa++){
            long startTime3 = System.currentTimeMillis();    //获取开始时间
            System.out.println("pa的值:------"+pa);
            List<PkfInformationEntity> pkfInformationEntities = pkfInformationDao.findPage(pa,limit);
            System.out.println("查询数据+"+pkfInformationEntities);
            long endTime3 = System.currentTimeMillis();    //获取结束时间
            System.out.println("查询记录程序运行时间：" + (endTime3 - startTime3) + "ms");    //输出程序运行时间
            long startTime4 = System.currentTimeMillis();    //获取开始时间
            System.gc();
            for(PkfInformationEntity p:pkfInformationEntities){
                row1  = sheet.createRow(y);
                for(int i=0;i<fields.size();i++){
                    switch (fields.get(i)){
                        case "uid":{
                            row1.createCell(i).setCellValue(p.getUid());
                            break;
                        }
                        case "no":{
                            row1.createCell(i).setCellValue(p.getNo());
                            break;
                        }
                        case "shiQuQi":{
                            row1.createCell(i).setCellValue(p.getShiQuQi());
                            break;
                        }
                        case "xiangZheng":{
                            row1.createCell(i).setCellValue(p.getXiangZheng());
                            break;
                        }
                        case "chun":{
                            row1.createCell(i).setCellValue(p.getChun());
                            break;
                        }
                        case "she":{
                            row1.createCell(i).setCellValue(p.getShe());
                            break;
                        }
                        case "familyNo":{
                            row1.createCell(i).setCellValue(p.getFamilyNo());
                            break;
                        } case "memberNo":{
                            row1.createCell(i).setCellValue(p.getMemberNo());
                            break;
                        } case "name":{
                            row1.createCell(i).setCellValue(p.getName());
                            break;
                        }
                        case "cardID":{
                            row1.createCell(i).setCellValue(p.getCardId());
                            break;
                        }
                        case "members":{
                            row1.createCell(i).setCellValue(p.getMembers());
                            break;
                        }
                        case "familyRelation":{
                            row1.createCell(i).setCellValue(p.getFamilyRelation());
                            break;
                        }
                        case "mz":{
                            row1.createCell(i).setCellValue(p.getMz());
                            break;
                        }
                        case "xueLi":{
                            row1.createCell(i).setCellValue(p.getXueLi());
                            break;
                        }
                        case "schoolState":{
                            row1.createCell(i).setCellValue(p.getSchoolState());
                            break;
                        }
                        case "healthState":{
                            row1.createCell(i).setCellValue(p.getHealthState());
                            break;
                        }
                        case "skill":{
                            row1.createCell(i).setCellValue(p.getSkill());
                            break;
                        }
                        case "workState":{
                            row1.createCell(i).setCellValue(p.getWorkState());
                            break;
                        }
                        case "workMonth":{
                            row1.createCell(i).setCellValue(p.getWorkMonth());
                            break;
                        }
                        case "isDaBinYiLiao":{
                            row1.createCell(i).setCellValue(p.getIsDaBinYiLiao());
                            break;
                        }
                        case "tuoPinState":{
                            row1.createCell(i).setCellValue(p.getTuoPinState());
                            break;
                        }
                        case "pinKunState":{
                            row1.createCell(i).setCellValue(p.getPinKunState());
                            break;
                        }
                        case "pinKunYuanYin":{
                            row1.createCell(i).setCellValue(p.getPinKunYuanYin());
                            break;
                        }
                        case "isWeiFangHu":{
                            row1.createCell(i).setCellValue(p.getIsWeiFangHu());
                            break;
                        }
                        case "isYinShuiAnQuan":{
                            row1.createCell(i).setCellValue(p.getIsYinShuiAnQuan());
                            break;
                        }
                        case "isYinShuiKunNan":{
                            row1.createCell(i).setCellValue(p.getIsYinShuiKunNan());
                            break;
                        }
                        case "renJunChunShouRu":{
                            row1.createCell(i).setCellValue(p.getRenJunChunShouRu());
                            break;
                        } case "telephone":{
                            row1.createCell(i).setCellValue(p.getTelephone());
                            break;
                        } case "tongJiShiJian":{
                            row1.createCell(i).setCellValue(p.getTongJiShiJian());
                            break;
                        }
                        case "note1":{
                            row1.createCell(i).setCellValue(p.getNote1());
                            break;
                        }
                        case "note2":{
                            row1.createCell(i).setCellValue(p.getNote2());
                            break;
                        }
                        case "note3":{
                            row1.createCell(i).setCellValue(p.getNote3());
                            break;
                        }
                        case "note4":{
                            row1.createCell(i).setCellValue(p.getNote4());
                            break;
                        }
                        case "note5":{
                            row1.createCell(i).setCellValue(p.getNote5());
                            break;
                        }
                    }
                }
                row1 = null;
                p=null;
                y++;
            }
//            //数据清理
            //fields.clear();
            pkfInformationEntities.clear();
            //设置空引用
            pkfInformationEntities= null;
            long endTime4 = System.currentTimeMillis();    //获取结束时间
            System.out.println("封装表格程序运行时间：" + (endTime4 - startTime4) + "ms");    //输出程序运行时间
        }
    }

    @Async
    public void Listdaochu2(Sheet sheet,List<String> fields,List<PkfInformationEntity> pkfInformationEntityList){

        Row row1 = null;
        int y = 1;

        System.gc();
        for(PkfInformationEntity p:pkfInformationEntityList){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                switch (fields.get(i)){
                    case "uid":{
                        row1.createCell(i).setCellValue(p.getUid());
                        break;
                    }
                    case "no":{
                        row1.createCell(i).setCellValue(p.getNo());
                        break;
                    }
                    case "shiQuQi":{
                        row1.createCell(i).setCellValue(p.getShiQuQi());
                        break;
                    }
                    case "xiangZheng":{
                        row1.createCell(i).setCellValue(p.getXiangZheng());
                        break;
                    }
                    case "chun":{
                        row1.createCell(i).setCellValue(p.getChun());
                        break;
                    }
                    case "she":{
                        row1.createCell(i).setCellValue(p.getShe());
                        break;
                    }
                    case "familyNo":{
                        row1.createCell(i).setCellValue(p.getFamilyNo());
                        break;
                    } case "memberNo":{
                        row1.createCell(i).setCellValue(p.getMemberNo());
                        break;
                    } case "name":{
                        row1.createCell(i).setCellValue(p.getName());
                        break;
                    }
                    case "cardID":{
                        row1.createCell(i).setCellValue(p.getCardId());
                        break;
                    }
                    case "members":{
                        row1.createCell(i).setCellValue(p.getMembers());
                        break;
                    }
                    case "familyRelation":{
                        row1.createCell(i).setCellValue(p.getFamilyRelation());
                        break;
                    }
                    case "mz":{
                        row1.createCell(i).setCellValue(p.getMz());
                        break;
                    }
                    case "xueLi":{
                        row1.createCell(i).setCellValue(p.getXueLi());
                        break;
                    }
                    case "schoolState":{
                        row1.createCell(i).setCellValue(p.getSchoolState());
                        break;
                    }
                    case "healthState":{
                        row1.createCell(i).setCellValue(p.getHealthState());
                        break;
                    }
                    case "skill":{
                        row1.createCell(i).setCellValue(p.getSkill());
                        break;
                    }
                    case "workState":{
                        row1.createCell(i).setCellValue(p.getWorkState());
                        break;
                    }
                    case "workMonth":{
                        row1.createCell(i).setCellValue(p.getWorkMonth());
                        break;
                    }
                    case "isDaBinYiLiao":{
                        row1.createCell(i).setCellValue(p.getIsDaBinYiLiao());
                        break;
                    }
                    case "tuoPinState":{
                        row1.createCell(i).setCellValue(p.getTuoPinState());
                        break;
                    }
                    case "pinKunState":{
                        row1.createCell(i).setCellValue(p.getPinKunState());
                        break;
                    }
                    case "pinKunYuanYin":{
                        row1.createCell(i).setCellValue(p.getPinKunYuanYin());
                        break;
                    }
                    case "isWeiFangHu":{
                        row1.createCell(i).setCellValue(p.getIsWeiFangHu());
                        break;
                    }
                    case "isYinShuiAnQuan":{
                        row1.createCell(i).setCellValue(p.getIsYinShuiAnQuan());
                        break;
                    }
                    case "isYinShuiKunNan":{
                        row1.createCell(i).setCellValue(p.getIsYinShuiKunNan());
                        break;
                    }
                    case "renJunChunShouRu":{
                        row1.createCell(i).setCellValue(p.getRenJunChunShouRu());
                        break;
                    } case "telephone":{
                        row1.createCell(i).setCellValue(p.getTelephone());
                        break;
                    } case "tongJiShiJian":{
                        row1.createCell(i).setCellValue(p.getTongJiShiJian());
                        break;
                    }
                    case "note1":{
                        row1.createCell(i).setCellValue(p.getNote1());
                        break;
                    }
                    case "note2":{
                        row1.createCell(i).setCellValue(p.getNote2());
                        break;
                    }
                    case "note3":{
                        row1.createCell(i).setCellValue(p.getNote3());
                        break;
                    }
                    case "note4":{
                        row1.createCell(i).setCellValue(p.getNote4());
                        break;
                    }
                    case "note5":{
                        row1.createCell(i).setCellValue(p.getNote5());
                        break;
                    }
                }
            }
            row1 = null;
            p=null;
            y++;
        }
        //数据清理
        //fields.clear();
        pkfInformationEntityList.clear();
        //设置空引用
        pkfInformationEntityList= null;
    }
}
