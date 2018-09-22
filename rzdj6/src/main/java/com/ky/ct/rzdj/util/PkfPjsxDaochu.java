package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.dao.PkfFpbxDao;
import com.ky.ct.rzdj.dao.PkfPjsxDao;
import com.ky.ct.rzdj.model.PkfFpbEntity;
import com.ky.ct.rzdj.model.PkfPjsxEntity;
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

public class PkfPjsxDaochu {
    //PkfDzb
    public Map<String,String> getPkfPjsxField(){
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("uid","编号");
        fieldsMap.put("xiangZhen","乡镇");
        fieldsMap.put("chunZu","村组");
        fieldsMap.put("huZhu","户主姓名");
        fieldsMap.put("daiKuanRen","贷款人姓名");
        fieldsMap.put("cardId","证件号码");
        fieldsMap.put("healthState","健康状况");
        fieldsMap.put("wenHuaChengDu","文化程度");
        fieldsMap.put("laoDongNengLi","劳动能力");
        fieldsMap.put("givenStars","信用评定等级");
        fieldsMap.put("shouXinEDu","授信额度");
        fieldsMap.put("contactPhone","联系电话");
        fieldsMap.put("note","备注");
        fieldsMap.put("tianBaoDanWei","填报单位");
        fieldsMap.put("tianBiaoRen","填表人");
        fieldsMap.put("tianBiaoRenLianXi","填表人联系");
        fieldsMap.put("shenHeRen","审核人");
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
    public void Listdaochu(Sheet sheet, int page, int limit, List<String> fields, PkfPjsxDao pkfPjsxDao){

        System.out.println("page"+page);
        int y = 1;
        Row row1 = null;
        for(int pa = 1;pa<=page;pa++){
            long startTime3 = System.currentTimeMillis();    //获取开始时间
            System.out.println("pa的值:------"+pa);
            List<PkfPjsxEntity> pkfPjsxEntities = pkfPjsxDao.findPage(pa,limit);
            System.out.println("查询数据+"+pkfPjsxEntities);
            long endTime3 = System.currentTimeMillis();    //获取结束时间
            System.out.println("查询记录程序运行时间：" + (endTime3 - startTime3) + "ms");    //输出程序运行时间
            long startTime4 = System.currentTimeMillis();    //获取开始时间
            System.gc();
            for(PkfPjsxEntity p:pkfPjsxEntities){
                row1  = sheet.createRow(y);
                for(int i=0;i<fields.size();i++){
                    switch (fields.get(i)){
                        case "uid":{
                            row1.createCell(i).setCellValue(p.getUid());
                            break;
                        }
                        case "xiangZhen":{
                            row1.createCell(i).setCellValue(p.getXiangZhen());
                            break;
                        }
                        case "chunZu":{
                            row1.createCell(i).setCellValue(p.getChunZu());
                            break;
                        }
                        case "huZhu":{
                            row1.createCell(i).setCellValue(p.getHuZhu());
                            break;
                        }
                        case "daiKuanRen":{
                            row1.createCell(i).setCellValue(p.getDaiKuanRen());
                            break;
                        }
                        case "cardId":{
                            row1.createCell(i).setCellValue(p.getCardId());
                            break;
                        } case "healthState":{
                            row1.createCell(i).setCellValue(p.getHealthState());
                            break;
                        } case "wenHuaChengDu":{
                            row1.createCell(i).setCellValue(p.getWenHuaChengDu());
                            break;
                        }
                        case "laoDongNengLi":{
                            row1.createCell(i).setCellValue(p.getLaoDongNengLi());
                            break;
                        }
                        case "givenStars":{
                            row1.createCell(i).setCellValue(p.getGivenStars());
                            break;
                        }
                        case "shouXinEDu":{
                            row1.createCell(i).setCellValue(p.getShouXinEDu());
                            break;
                        }
                        case "contactPhone":{
                            row1.createCell(i).setCellValue(p.getContactPhone());
                            break;
                        }
                        case "note":{
                            row1.createCell(i).setCellValue(p.getNote());
                            break;
                        }
                        case "tianBaoDanWei":{
                            row1.createCell(i).setCellValue(p.getTianBaoDanWei());
                            break;
                        }
                        case "tianBiaoRen":{
                            row1.createCell(i).setCellValue(p.getTianBiaoRen());
                            break;
                        }
                        case "tianBiaoRenLianXi":{
                            row1.createCell(i).setCellValue(p.getTianBiaoRenLianXi());
                            break;
                        }
                        case "shenHeRen":{
                            row1.createCell(i).setCellValue(p.getShenHeRen());
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
            pkfPjsxEntities.clear();
            //设置空引用
            pkfPjsxEntities= null;
            long endTime4 = System.currentTimeMillis();    //获取结束时间
            System.out.println("封装表格程序运行时间：" + (endTime4 - startTime4) + "ms");    //输出程序运行时间
        }
    }

    @Async
    public void Listdaochu2(Sheet sheet,List<String> fields,List<PkfPjsxEntity> pkfPjsxEntities){
    int y = 1;
    Row row1 = null;
        System.gc();
        for(PkfPjsxEntity p:pkfPjsxEntities){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                switch (fields.get(i)){
                    case "uid":{
                        row1.createCell(i).setCellValue(p.getUid());
                        break;
                    }
                    case "xiangZhen":{
                        row1.createCell(i).setCellValue(p.getXiangZhen());
                        break;
                    }
                    case "chunZu":{
                        row1.createCell(i).setCellValue(p.getChunZu());
                        break;
                    }
                    case "huZhu":{
                        row1.createCell(i).setCellValue(p.getHuZhu());
                        break;
                    }
                    case "daiKuanRen":{
                        row1.createCell(i).setCellValue(p.getDaiKuanRen());
                        break;
                    }
                    case "cardId":{
                        row1.createCell(i).setCellValue(p.getCardId());
                        break;
                    } case "healthState":{
                        row1.createCell(i).setCellValue(p.getHealthState());
                        break;
                    } case "wenHuaChengDu":{
                        row1.createCell(i).setCellValue(p.getWenHuaChengDu());
                        break;
                    }
                    case "laoDongNengLi":{
                        row1.createCell(i).setCellValue(p.getLaoDongNengLi());
                        break;
                    }
                    case "givenStars":{
                        row1.createCell(i).setCellValue(p.getGivenStars());
                        break;
                    }
                    case "shouXinEDu":{
                        row1.createCell(i).setCellValue(p.getShouXinEDu());
                        break;
                    }
                    case "contactPhone":{
                        row1.createCell(i).setCellValue(p.getContactPhone());
                        break;
                    }
                    case "note":{
                        row1.createCell(i).setCellValue(p.getNote());
                        break;
                    }
                    case "tianBaoDanWei":{
                        row1.createCell(i).setCellValue(p.getTianBaoDanWei());
                        break;
                    }
                    case "tianBiaoRen":{
                        row1.createCell(i).setCellValue(p.getTianBiaoRen());
                        break;
                    }
                    case "tianBiaoRenLianXi":{
                        row1.createCell(i).setCellValue(p.getTianBiaoRenLianXi());
                        break;
                    }
                    case "shenHeRen":{
                        row1.createCell(i).setCellValue(p.getShenHeRen());
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
        pkfPjsxEntities.clear();
        //设置空引用
        pkfPjsxEntities= null;
    }

}
