package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.dao.PkfDzbDao;
import com.ky.ct.rzdj.dao.PkfInformationDao;
import com.ky.ct.rzdj.model.PkfDzbEntity;
import com.ky.ct.rzdj.model.PkfInformationEntity;
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

public class PkfDzbDaochu {
    //PkfDzb
    public Map<String,String> getPkfDzbField(){
        long startTime = System.currentTimeMillis(); //获取开始时间
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("uid","编号");
        fieldsMap.put("name","姓名");
        fieldsMap.put("address","地址");
        fieldsMap.put("baoXianJinE","保险金额");
        fieldsMap.put("baoFei","保费");
        fieldsMap.put("canBaoType","参保人员类型");
        fieldsMap.put("note","备注");
        fieldsMap.put("tianBaoDanWei","填报单位");
        fieldsMap.put("tianBaoDate","填报时间");
        fieldsMap.put("touBaoYear","投保年度");
        fieldsMap.put("importDate","导入时间");
        fieldsMap.put("note1","Note1");
        fieldsMap.put("note2","Note2");
        fieldsMap.put("note3","Note3");

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("fieldsMap程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
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
    public void Listdaochu(Sheet sheet,int page,int limit,List<String> fields,PkfDzbDao pkfDzbDao){

        System.out.println("page"+page);
        int y = 1;
        Row row1 = null;
        for(int pa = 1;pa<=page;pa++){
            long startTime3 = System.currentTimeMillis();    //获取开始时间
            System.out.println("pa的值:------"+pa);
            List<PkfDzbEntity> pkfDzbEntityList = pkfDzbDao.findPage(pa,limit);
            System.out.println("查询数据+"+pkfDzbEntityList);
            long endTime3 = System.currentTimeMillis();    //获取结束时间
            System.out.println("查询记录程序运行时间：" + (endTime3 - startTime3) + "ms");    //输出程序运行时间
            long startTime4 = System.currentTimeMillis();    //获取开始时间
            System.gc();
            for(PkfDzbEntity p:pkfDzbEntityList){
                row1  = sheet.createRow(y);
                for(int i=0;i<fields.size();i++){
                    switch (fields.get(i)){
                        case "uid":{
                            row1.createCell(i).setCellValue(p.getUid());
                            break;
                        }
                        case "name":{
                            row1.createCell(i).setCellValue(p.getName());
                            break;
                        }
                        case "address":{
                            row1.createCell(i).setCellValue(p.getAddress());
                            break;
                        }
                        case "cardID":{
                            row1.createCell(i).setCellValue(p.getCardId());
                            break;
                        }
                        case "baoXianJinE":{
                            row1.createCell(i).setCellValue(p.getBaoXianJinE());
                            break;
                        }
                        case "baoFei":{
                            row1.createCell(i).setCellValue(p.getBaoFei());
                            break;
                        }
                        case "canBaoType":{
                            row1.createCell(i).setCellValue(p.getCanBaoType());
                            break;
                        } case "note":{
                            row1.createCell(i).setCellValue(p.getNote());
                            break;
                        } case "tianBaoDanWei":{
                            row1.createCell(i).setCellValue(p.getTianBaoDanWei());
                            break;
                        }
                        case "tianBaoDate":{
                            row1.createCell(i).setCellValue(p.getTianBaoDate());
                            break;
                        }
                        case "touBaoYear":{
                            row1.createCell(i).setCellValue(p.getTouBaoYear());
                            break;
                        }
                        case "importDate":{
                            row1.createCell(i).setCellValue(p.getImportDate());
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
                    }
                }
                row1 = null;
                p=null;
                y++;
            }
//            //数据清理
            //fields.clear();
            pkfDzbEntityList.clear();
            //设置空引用
            pkfDzbEntityList= null;
            long endTime4 = System.currentTimeMillis();    //获取结束时间
            System.out.println("封装表格程序运行时间：" + (endTime4 - startTime4) + "ms");    //输出程序运行时间
        }
    }

    @Async
    public void Listdaochu2(Sheet sheet,List<String> fields,List<PkfDzbEntity> pkfDzbEntities){
    int y = 1;
    Row row1 = null;
        System.gc();
        for(PkfDzbEntity p:pkfDzbEntities){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                switch (fields.get(i)){
                    case "uid":{
                        row1.createCell(i).setCellValue(p.getUid());
                        break;
                    }
                    case "name":{
                        row1.createCell(i).setCellValue(p.getName());
                        break;
                    }
                    case "address":{
                        row1.createCell(i).setCellValue(p.getAddress());
                        break;
                    }
                    case "cardID":{
                        row1.createCell(i).setCellValue(p.getCardId());
                        break;
                    }
                    case "baoXianJinE":{
                        row1.createCell(i).setCellValue(p.getBaoXianJinE());
                        break;
                    }
                    case "baoFei":{
                        row1.createCell(i).setCellValue(p.getBaoFei());
                        break;
                    }
                    case "canBaoType":{
                        row1.createCell(i).setCellValue(p.getCanBaoType());
                        break;
                    } case "note":{
                        row1.createCell(i).setCellValue(p.getNote());
                        break;
                    } case "tianBaoDanWei":{
                        row1.createCell(i).setCellValue(p.getTianBaoDanWei());
                        break;
                    }
                    case "tianBaoDate":{
                        row1.createCell(i).setCellValue(p.getTianBaoDate());
                        break;
                    }
                    case "touBaoYear":{
                        row1.createCell(i).setCellValue(p.getTouBaoYear());
                        break;
                    }
                    case "importDate":{
                        row1.createCell(i).setCellValue(p.getImportDate());
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
                }
            }
            row1 = null;
            p=null;
            y++;
        }
//            //数据清理
        //fields.clear();
        pkfDzbEntities.clear();
        //设置空引用
        pkfDzbEntities= null;
    }

}
