package com.ky.ct.rzdj.util.fpbxDaoChu;

import com.ky.ct.rzdj.dao.FpbxDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhDao;
import com.ky.ct.rzdj.model.BaseFpb;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.*;

public class FpbxDaoChu2 {
    //计算表头每部分字段的个数
    public Map<String,Integer> getNumber(List<String> fields){
        //计算保费前面有多少字段
        int bf = 0;
        //保费有多少字段
        int b = 0;
        //
        boolean bfOff = true;
        //理赔有多少字段
        int l = 0;
        //计算理赔前面有多少字段
        int lp = 0;
        boolean lpOff = true;
        //计数
        int js = 0;
        for(String field:fields){
            switch (field){
                case "baoFeiZongE":
                case "baoFeiZiFu":
                case  "baoFeiBuTie":{
                    if("baoFeiZongE".equals(field)||"baoFeiZiFu".equals(field)||"baoFeiBuTie".equals(field)){
                        if(bfOff){
                            bf = js;
                            bfOff = false;
                        }
                    }
                    b++;
                    break;
                }
                case "liPeiShiXiang":
                case "liPeiDate":
                case "liPeiJinE":{
                    if("liPeiShiXiang".equals(field)||"liPeiDate".equals(field)||"liPeiJinE".equals(field)){
                        if(lpOff){
                            lp = js;
                            lpOff = false;
                        }
                    }
                    l++;
                    break;
                }
            }
            js++;
        }
        Map<String,Integer>numberMap = new HashMap<>();
        numberMap.put("b",b);
        numberMap.put("bf",bf);
        numberMap.put("l",l);
        numberMap.put("lp",lp);
        numberMap.put("js",js);
        System.out.println("numberMap---------->"+numberMap);
        return numberMap;
    }

    //制作表头
    public Sheet getSheet(Map<String,String> fieldsMap, List<String> fields, Map<String,Integer> numberMap, SXSSFWorkbook workbook){
        //创建数据表
        Sheet sheet =workbook.createSheet("信息表");
        //设置单元格样式
        Font font = workbook.createFont();
        Font font2 = workbook.createFont();
        //设置字体大小
        //font.setFontName("宋体");
        //设置斜体
        font.setItalic(true);
        font.setColor(HSSFColor.BLACK.index);
//        font.setFontHeightInPoints((short) 20);// 设置字体大小
//        font2.setFontHeightInPoints((short) 16);// 设置字体大小
        CellStyle style = workbook.createCellStyle();

        CellStyle style2 = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        style2.setFont(font2);
        //设置居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

        //计算一共有多少个字段
        //保费有多少字段
        int b  = numberMap.get("b");
        //理赔有多少字段
        int l = numberMap.get("l");
        int count = numberMap.get("js");
        System.out.println("count------>"+count);
        //headers表示excel表中第一行的表头
        Row row = sheet.createRow(0);
        //设置这一行的行高
        row.setHeight((short)1000);
        //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
        CellRangeAddress region1 = new CellRangeAddress(0,0,0,count);
        sheet.addMergedRegion(region1);
        //单元格添加内容
        Cell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("扶贫保险");

        //创建第二行
        //创建表头
        List<String> Bt = new ArrayList<>();
        boolean off = true;
        boolean off2 = true;
        //保费
        Map<String,Object> bfMap = new HashMap<>();
        //理赔
        Map<String,Object> lpMap = new HashMap<>();
        for(String field:fields){
            if("baoFeiZongE".equals(field)||"baoFeiZiFu".equals(field)||"baoFeiBuTie".equals(field)){
                if(off){
                    Bt.add("保费");
                    off = false;
                }
                bfMap.put(field,fieldsMap.get(field));
            }else if("liPeiShiXiang".equals(field)||"liPeiDate".equals(field)||"liPeiJinE".equals(field)){
                if(off2){
                    Bt.add("理赔");
                    off2 = false;
                }
                lpMap.put(field,fieldsMap.get(field));
            }else{
                Bt.add(fieldsMap.get(field));
            }
        }
        System.out.println("所有的表头字段------>"+Bt);
        //headers表示excel表中第一行的表头
        Row row1 = sheet.createRow(1);
        //在excel表中添加表头
        int cellNumber = 0;
        for(int i=0;i<Bt.size();i++){
           switch (Bt.get(i)){
               case "保费":{
                   System.out.println("保费------>"+i);
                   //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                   CellRangeAddress region2 = new CellRangeAddress(1,1,i+cellNumber,i+cellNumber+numberMap.get("b")-1);
                   sheet.addMergedRegion(region2);
                   //单元格添加内容
                   Cell dkTypecell = row1.createCell(i+cellNumber);
                   dkTypecell.setCellStyle(style);
                   dkTypecell.setCellValue("保费");
                   cellNumber=cellNumber+numberMap.get("b")-1;
                   break;
               }
               case "理赔":{
                   System.out.println("理赔------>"+i);
                   //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                   System.out.println();
                   CellRangeAddress region2 = new CellRangeAddress(1,1,i+cellNumber,i+cellNumber+numberMap.get("l")-1);
                   sheet.addMergedRegion(region2);
                   //单元格添加内容
                   Cell dkTypecell = row1.createCell(i+cellNumber);
                   dkTypecell.setCellStyle(style);
                   dkTypecell.setCellValue("理赔");
                   cellNumber=cellNumber+numberMap.get("l")-1;
                   break;
               }
              default:{
                  //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                  CellRangeAddress region2 = new CellRangeAddress(1,2,i+cellNumber,i+cellNumber);
                  sheet.addMergedRegion(region2);
                  //单元格添加内容
                  Cell dkTypecell = row1.createCell(i+cellNumber);
                  dkTypecell.setCellStyle(style);
                  dkTypecell.setCellValue(Bt.get(i));
                  break;
              }
           }
        }
        //headers表示excel表中第二行的表头
        Row row2 = sheet.createRow(2);
        int cellNumber2 = 0;
        if(numberMap.get("bf")!=0){
            int b1 = numberMap.get("bf");
            for(String key:bfMap.keySet()){
                //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                CellRangeAddress region4 = new CellRangeAddress(2,2,b1+cellNumber2,b1+cellNumber2);
                sheet.addMergedRegion(region4);
                //单元格添加内容
                Cell dkTypecell3 = row2.createCell(b1+cellNumber2);
                dkTypecell3.setCellStyle(style);
                dkTypecell3.setCellValue(bfMap.get(key)+" ");
                b1++;
            }
        }
        if(numberMap.get("lp")!=0){
            int l1 = numberMap.get("lp");
            for(String key:lpMap.keySet()){
                //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格  ch=23 number=6
                CellRangeAddress region4 = new CellRangeAddress(2,2,l1+cellNumber2,l1+cellNumber2);
                sheet.addMergedRegion(region4);
                //单元格添加内容
                Cell dkTypecell3 = row2.createCell(l1+cellNumber2);
                dkTypecell3.setCellStyle(style);
                dkTypecell3.setCellValue(lpMap.get(key)+" ");
                l1++;
            }
        }
        return sheet;
    }

    /**
     * 日期格式化  处理日期取出来后面加上了00:00:00
     */
    public String formaDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(date!=null&&date.toString().length()>0){
            return sdf.format(date);
        }
        return "";
    }
    /**
     * 封装数据。
     */
    @Async
    public void EncapsulateData(Sheet sheet, List<String> fields, List<BaseFpb> fpbs, SXSSFWorkbook workbook){
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontName("宋体");

        CellStyle style = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        //设置居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        int y = 3;
        Row row1 = null;
        System.gc();
        int x = 1;
        for(BaseFpb f:fpbs){
            row1 = sheet.createRow(y);
            for (int i = 0; i < fields.size(); i++) {
                Cell cell = row1.createCell(i);
                sheet.setColumnWidth(i, 256 * 30);
                cell.setCellStyle(style);
                switch (fields.get(i)) {
                    case "id": {
                        System.out.println("x的值为-->" + x);
                        cell.setCellValue(x + "");
                        x++;
                        break;
                    }
                    case "xiang": {
                        cell.setCellValue(f.getXiang() + " ");
                        break;
                    }
                    case "chun": {
                        cell.setCellValue(f.getChun() + " ");
                        break;
                    }
                    case "zu": {
                        cell.setCellValue(f.getZu() + " ");
                        break;
                    }
                    case "huZhuName": {
                        cell.setCellValue(f.getHuZhuName() + " ");
                        break;
                    }
                    case "familyMemberName": {
                        cell.setCellValue(f.getFamilyMemberName() + " ");
                        break;
                    }
                    case "cardId": {
                        cell.setCellValue(f.getCardId() + " ");
                        break;
                    }
                    case "familyRelation": {
                        cell.setCellValue(f.getFamilyRelation() + " ");
                        break;
                    }
                    case "familyMemberCount": {
                        cell.setCellValue(f.getFamilyMemberCount() + " ");
                        break;
                    }
                    case "baoFeiZongE": {
                        cell.setCellValue(f.getBaoFeiZongE() + " ");
                        break;
                    }
                    case "baoFeiZiFu": {
                        cell.setCellValue(f.getBaoFeiZiFu() + " ");
                        break;
                    }
                    case "baoFeiBuTie": {
                        cell.setCellValue(f.getBaoFeiBuTie() + " ");
                        break;
                    }
                    case "baoZhangJinE": {
                        cell.setCellValue(f.getBaoZhangJinE() + " ");
                        break;
                    }
                    case "baoZhangQiJian": {
                        cell.setCellValue(f.getBaoZhangQiJian() + " ");
                        break;
                    }
                    case "touBaoDate": {
                        cell.setCellValue(formaDate(f.getTouBaoDate()) + " ");
                        break;
                    }
                    case "daoQiDate": {
                        cell.setCellValue(formaDate(f.getDaoQiDate()) + " ");
                        break;
                    }
                    case "liPeiShiXiang": {
                        cell.setCellValue(f.getLiPeiShiXiang() + " ");
                        break;
                    }
                    //类型
                    case "liPeiDate": {
                        cell.setCellValue(formaDate(f.getLiPeiDate()) + " ");
                        break;
                    }
                    case "liPeiJinE": {
                        cell.setCellValue(f.getLiPeiJinE() + " ");
                        break;
                    }
                    //贷款投放进度
                    case "liPeiShouYiRen": {
                        cell.setCellValue(f.getLiPeiShouYiRen() + " ");
                        break;
                    }
                    case "chengBaoJiGou": {
                        cell.setCellValue(f.getChengBaoJiGou() + " ");
                        break;
                    }
                    case "touPinYear": {
                        cell.setCellValue(f.getTouPinYear() + " ");
                        break;
                    }
                    case "note": {
                        cell.setCellValue(f.getNote() + " ");
                        break;
                    }
                }
            }
            row1 = null;
            f=null;
            y++;
        }
        //数据清理
        //fields.clear();
        fpbs.clear();
        //设置空引用
        fpbs= null;
    }
}