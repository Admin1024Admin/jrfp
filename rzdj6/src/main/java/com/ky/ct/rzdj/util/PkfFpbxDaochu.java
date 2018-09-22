package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.dao.PkfDzbDao;
import com.ky.ct.rzdj.dao.PkfFpbxDao;
import com.ky.ct.rzdj.model.PkfDzbEntity;
import com.ky.ct.rzdj.model.PkfFpbEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PkfFpbxDaochu {
    //PkfDzb
    public Map<String,String> getPkfFpbxField(){
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("uid","编号");
        fieldsMap.put("touBaoRen","投保人");
        fieldsMap.put("beiBaoRen","被保险人");
        fieldsMap.put("gender","性别");
        fieldsMap.put("bornDate","出生日期");
        fieldsMap.put("zhiYeCode","职业代码");
        fieldsMap.put("cardIdType","证件类型");
        fieldsMap.put("cardId","身份证号");
        fieldsMap.put("shouYiRen","受益人");
        fieldsMap.put("zhiYeCode","职业代码");
        fieldsMap.put("beiBaoRenSign","受益人签字");
        fieldsMap.put("note","备注");
        fieldsMap.put("huiJiaoRen","汇交人");
        fieldsMap.put("touBaoCompany","投保公司");
        fieldsMap.put("touBaoYear","投保年度");
        fieldsMap.put("xianZhong","险种");
        fieldsMap.put("importDate","导入日期");
        fieldsMap.put("touBaoYear","投保单号");
        fieldsMap.put("billNo","投保单号");
        fieldsMap.put("baoE","保额");
        fieldsMap.put("baoFei","保费");
        fieldsMap.put("note1","note1");
        return fieldsMap;
    }

    public Sheet getSheet(Map<String,String> fieldsMap, List<String> fields, SXSSFWorkbook workbook){
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
    public void Listdaochu(Sheet sheet, int page, int limit, List<String> fields, PkfFpbxDao pkfFpbxDao){

        System.out.println("page"+page);
        int y = 1;
        Row row1 = null;
        for(int pa = 1;pa<=page;pa++){
            long startTime3 = System.currentTimeMillis();    //获取开始时间
            System.out.println("pa的值:------"+pa);
            List<PkfFpbEntity> pkfFpbEntityList = pkfFpbxDao.findPage(pa,limit);
            System.out.println("查询数据+"+pkfFpbEntityList);
            long endTime3 = System.currentTimeMillis();    //获取结束时间
            System.out.println("查询记录程序运行时间：" + (endTime3 - startTime3) + "ms");    //输出程序运行时间
            long startTime4 = System.currentTimeMillis();    //获取开始时间
            System.gc();
            for(PkfFpbEntity p:pkfFpbEntityList){
                row1  = sheet.createRow(y);
                for(int i=0;i<fields.size();i++){
                    switch (fields.get(i)){
                        case "uid":{
                            row1.createCell(i).setCellValue(p.getUid());
                            break;
                        }
                        case "touBaoRen":{
                            row1.createCell(i).setCellValue(p.getTouBaoRen());
                            break;
                        }
                        case "beiBaoRen":{
                            row1.createCell(i).setCellValue(p.getBeiBaoRen());
                            break;
                        }
                        case "gender":{
                            row1.createCell(i).setCellValue(p.getGender());
                            break;
                        }
                        case "bornDate":{
                            row1.createCell(i).setCellValue(p.getBornDate());
                            break;
                        }
                        case "zhiYeCode":{
                            row1.createCell(i).setCellValue(p.getZhiYeCode());
                            break;
                        } case "cardIdType":{
                            row1.createCell(i).setCellValue(p.getCardIdType());
                            break;
                        } case "cardId":{
                            row1.createCell(i).setCellValue(p.getCardId());
                            break;
                        }
                        case "shouYiRen":{
                            row1.createCell(i).setCellValue(p.getShouYiRen());
                            break;
                        }
                        case "beiBaoRenSign":{
                            row1.createCell(i).setCellValue(p.getBeiBaoRenSign());
                            break;
                        }
                        case "note":{
                            row1.createCell(i).setCellValue(p.getNote());
                            break;
                        }
                        case "huiJiaoRen":{
                            row1.createCell(i).setCellValue(p.getHuiJiaoRen());
                            break;
                        }
                        case "touBaoCompany":{
                            row1.createCell(i).setCellValue(p.getTouBaoCompany());
                            break;
                        }
                        case "touBaoYear":{
                            row1.createCell(i).setCellValue(p.getTouBaoYear());
                            break;
                        }
                        case "xianZhong":{
                            row1.createCell(i).setCellValue(p.getXianZhong());
                            break;
                        }
                        case "importDate":{
                            row1.createCell(i).setCellValue(p.getImportDate());
                            break;
                        }
                        case "billNo":{
                            row1.createCell(i).setCellValue(p.getBillNo());
                            break;
                        }
                        case "baoE":{
                            row1.createCell(i).setCellValue(p.getBaoE()+"");
                            break;
                        }
                        case "baoFei":{
                            row1.createCell(i).setCellValue(p.getBaoFei()+"");
                            break;
                        }
                        case "note1":{
                            row1.createCell(i).setCellValue(p.getNote1());
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
            pkfFpbEntityList.clear();
            //设置空引用
            pkfFpbEntityList= null;
            long endTime4 = System.currentTimeMillis();    //获取结束时间
            System.out.println("封装表格程序运行时间：" + (endTime4 - startTime4) + "ms");    //输出程序运行时间
        }
    }

    @Async
    public void Listdaochu2(Sheet sheet,List<String> fields,List<PkfFpbEntity> pkfFpbEntities){
    int y = 1;
    Row row1 = null;
        System.gc();
        for(PkfFpbEntity p:pkfFpbEntities){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                switch (fields.get(i)){
                    case "uid":{
                        row1.createCell(i).setCellValue(p.getUid());
                        break;
                    }
                    case "touBaoRen":{
                        row1.createCell(i).setCellValue(p.getTouBaoRen());
                        break;
                    }
                    case "beiBaoRen":{
                        row1.createCell(i).setCellValue(p.getBeiBaoRen());
                        break;
                    }
                    case "gender":{
                        row1.createCell(i).setCellValue(p.getGender());
                        break;
                    }
                    case "bornDate":{
                        row1.createCell(i).setCellValue(p.getBornDate());
                        break;
                    }
                    case "zhiYeCode":{
                        row1.createCell(i).setCellValue(p.getZhiYeCode());
                        break;
                    } case "cardIdType":{
                        row1.createCell(i).setCellValue(p.getCardIdType());
                        break;
                    } case "cardId":{
                        row1.createCell(i).setCellValue(p.getCardId());
                        break;
                    }
                    case "shouYiRen":{
                        row1.createCell(i).setCellValue(p.getShouYiRen());
                        break;
                    }
                    case "beiBaoRenSign":{
                        row1.createCell(i).setCellValue(p.getBeiBaoRenSign());
                        break;
                    }
                    case "note":{
                        row1.createCell(i).setCellValue(p.getNote());
                        break;
                    }
                    case "huiJiaoRen":{
                        row1.createCell(i).setCellValue(p.getHuiJiaoRen());
                        break;
                    }
                    case "touBaoCompany":{
                        row1.createCell(i).setCellValue(p.getTouBaoCompany());
                        break;
                    }
                    case "touBaoYear":{
                        row1.createCell(i).setCellValue(p.getTouBaoYear());
                        break;
                    }
                    case "xianZhong":{
                        row1.createCell(i).setCellValue(p.getXianZhong());
                        break;
                    }
                    case "importDate":{
                        row1.createCell(i).setCellValue(p.getImportDate());
                        break;
                    }
                    case "billNo":{
                        row1.createCell(i).setCellValue(p.getBillNo());
                        break;
                    }
                    case "baoE":{
                        row1.createCell(i).setCellValue(p.getBaoE()+"");
                        break;
                    }
                    case "baoFei":{
                        row1.createCell(i).setCellValue(p.getBaoFei()+"");
                        break;
                    }
                    case "note1":{
                        row1.createCell(i).setCellValue(p.getNote1());
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
        pkfFpbEntities.clear();
        //设置空引用
        pkfFpbEntities= null;
    }

}
