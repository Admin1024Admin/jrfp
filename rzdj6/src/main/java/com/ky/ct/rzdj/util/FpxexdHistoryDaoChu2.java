package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.*;

public class FpxexdHistoryDaoChu2 {
    //计算表头每部分字段的个数
    public Map<String,Integer> getNumber(List<String> fields){
        //审核情况字段次数
        int shen = 0;
        //基本情况字段次数
        int j = 0;
        //原本贷款情况字段次数
        int y = 0;
        //扶贫小额贷款总字段次数
        int f = 0;
        //创业贷款总字段次数
        int c = 0;
        //生源地贷款总字段次数
        int s = 0;
        //其他贷款总字段次数
        int q = 0;
        for(String field:fields){
            switch (field){
				case "no":
				case "operation":
				case "operationPerson":
				case "operationDate":
				case "checkStatus":
				case "checkPerson":
				case "checkDate":
				case "reason":{
					shen++;
					break;
				}

                case "xiang":
                case "chun":
                case "zu":
                case "name":
                case "cardId":
                case "members":
                case "daiKuanRenXingMing":
                case "daiKuanRenCardId":
                case "familyRelation":
                case "tuoPinState":{
                    j++;
                    break;
                }
                case "yuanYouYuE":
                case "yuanYouIsYuQi":
                case "yuanYouYuQiJinE":
                case "yuanYouYuQiShiJian":
                case "yuanYouQianXiJinE":
                case "yuanYouQianXiShiJian":{
                    y++;
                    break;
                }
                case "fuPingivenStars":
                case "fuPinshouXinEDu":
                case "fuPinshouXinJiGou":
                case "fuPinshouxinData":
                case "fuPinXiaoDaidaiKuanJinE":
                case "fuPindaiKuanQiXian":
                case "fuPinfangKuanRiQi":
                case "fuPindaoQiRiQi":
                case "fuPinXiaoDaiDaiKuanLiLv":
                case "fuPindaiKuanJiGou":
                case "fuPinleiJiTieXi":
                case "fuPinchangHuanDaiKuanJInE":
                case "fuPinhuanKuanShiJian":
                case "fuPindaiKuanYuE":
                case "fuPinyuQiDaiKuanJinE":
                case "fuPinyuQiDaiKuanShiJian":
                case "fuPinqianXiJinE":
                case "fuPinqianXiShiJian":
                case "fuPinYingDaiWeiDaiShiBie":
                case "fuPinDaiKuanYongTu":{
                    f++;
                    break;
                }
                case "chuangYeJinE":
                case "chuangYeQiXian":
                case "chuangYeFangKuanRiQi":
                case "chuangYeDaoQiShiJian":
                case "chuangYeLiLv":
                case "chuangYeChangHuanJinE":
                case "changYeHuangKuanShiJian":
                case "chuangYeYuE":
                case "chuangYeYuQiJinE":
                case "chuangYeYuQiShiJian":
                case "chuangYeQianXiJinE":
                case "chuangYeQianXiShiJian":
                case "chuangYeYongTu":{
                    c++;
                    break;
                }
                case "shengYuanJinE":
                case "shengYuanQiXian":
                case "shengYuanFangKuanRiQi":
                case "shengYaunDaoQiRiQi":
                case "shengYaunLiLv":
                case "shengYaunChangHuanJinE":
                case "shengYuanHuanKuanShiJian":
                case "shengYuanYuE":
                case "shengYuanYuQiJinE":
                case "shengYuanYuQiShiJian":
                case "shengYuanQianXiJinE":
                case "shengYuanQianXiShiJian":{
                    s++;
                    break;
                }
                case "qiTaJinE":
                case "qiTaQiXian":
                case "qiTaFangKuanRiQi":
                case "qiTaDaoQiRiQi":
                case "qiTaLiLv":
                case "qiTaChangHuanJinE":
                case "qiTaChangHuangKuanShiJian":
                case "qiTaYuE":
                case "qiTaYuQiJinE":
                case "qiTaYuQiShiJian":
                case "qiTaQianXiJinE":
                case "qiTaQianXiShiJian":
                case "qiTaYongTu":
                case "note":{
                    q++;
                    break;
                }
            }
        }
        Map<String,Integer>numberMap = new HashMap<>();
        numberMap.put("shen",shen);
        numberMap.put("j",j);
        numberMap.put("y",y);
        numberMap.put("f",f);
        numberMap.put("c",c);
        numberMap.put("s",s);
        numberMap.put("q",q);
        return numberMap;
    }

    //制作表头
    public Sheet getSheet(Map<String,String> fieldsMap, List<String> fields,Map<String,Integer> numberMap,SXSSFWorkbook workbook){
        //创建数据表
        Sheet sheet =workbook.createSheet("信息表");
        //设置单元格样式
        Font font = workbook.createFont();
        Font font2 = workbook.createFont();
        //设置字体大小
        font.setFontName("宋体");
        //设置斜体
        font.setItalic(true);
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 20);// 设置字体大小
        font2.setFontHeightInPoints((short) 16);// 设置字体大小
        CellStyle style = workbook.createCellStyle();

       CellStyle style2 = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        style2.setFont(font2);
        //设置居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

        //计算一共有多少个字段
        //审核情况字段次数
        int shen = numberMap.get("shen");
        //基本情况字段次数
        int j = numberMap.get("j");
        //原本贷款情况字段次数
        int y = numberMap.get("y");
        //扶贫小额贷款总字段次数
        int f = numberMap.get("f");
        //创业贷款总字段次数
        int c = numberMap.get("c");
        //生源地贷款总字段次数
        int s = numberMap.get("s");
        //其他贷款总字段次数
        int q = numberMap.get("q");
        int count = shen+j+y+f+c+s+q-1;
        System.out.println("shen--->"+shen);
        System.out.println("j--->"+j);
        System.out.println("y--->"+y);
        System.out.println("f--->"+f);
        System.out.println("c--->"+c);
        System.out.println("s--->"+s);
        System.out.println("q--->"+q);
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
        cell.setCellValue("金融扶贫小额信贷审核");

        //创建第二行
        Row row1 = sheet.createRow(1);
        // 审核情况字段
        if(shen!=0){
            CellRangeAddress region1_5 = new CellRangeAddress(1,1,(short)0,(short)(shen-1));
            sheet.addMergedRegion(region1_5);
            Cell cell1 = row1.createCell(0);
            cell1.setCellStyle(style);
            cell1.setCellValue("审核情况");
        }
        // 基本情况字段
        if(j!=0){
            CellRangeAddress region2 = new CellRangeAddress(1,1,(short)shen,(short)(shen+j-1));
            sheet.addMergedRegion(region2);
            Cell cell1 = row1.createCell(0);
            cell1.setCellStyle(style);
            cell1.setCellValue("基本情况");
        }
        //原贷款情况
        if(y!=0){
            CellRangeAddress region3 = new CellRangeAddress(1,1,(short)shen+j,(short)(shen+j+y-1));
            sheet.addMergedRegion(region3);
            Cell cell2 = row1.createCell(j);
            cell2.setCellStyle(style);
            cell2.setCellValue("原贷款情况");
        }
        //创建第二行 扶贫小额信贷
        if(f!=0){
            CellRangeAddress region4 = new CellRangeAddress(1,1,(short)(shen+j+y),(short)(shen+j+y+f-1));
            sheet.addMergedRegion(region4);
            Cell cell3 = row1.createCell(j+y);
            cell3.setCellStyle(style);
            cell3.setCellValue("扶贫小额信贷");
        }
        //创建第二行 创业贷款
        if(c!=0){
            CellRangeAddress region5 = new CellRangeAddress(1,1,(short)(shen+j+y+f),(short)(shen+j+y+f+c-1));
            sheet.addMergedRegion(region5);
            Cell cell4 = row1.createCell(j+y+f);
            cell4.setCellStyle(style);
            cell4.setCellValue("创业贷款");
        }
        //创建第二行 生源地贷款
        if(s!=0){
            CellRangeAddress region6 = new CellRangeAddress(1,1,(short)(shen+j+y+f+c),(short)(shen+j+y+f+c+s-1));
            sheet.addMergedRegion(region6);
            Cell cell5 = row1.createCell(j+y+f+c);
            cell5.setCellStyle(style);
            cell5.setCellValue("生源地贷款");
        }
        //创建第二行 其他类型贷款
        if(q!=0){
            CellRangeAddress region7 = new CellRangeAddress(1,1,(short)(shen+j+y+f+c+s),(short)(shen+j+y+f+c+s+q-1));
            sheet.addMergedRegion(region7);
            Cell cell6 = row1.createCell(j+y+f+c+s);
            cell6.setCellStyle(style);
            cell6.setCellValue("其他类型贷款");
        }

        //创建第三行
        //创建表头
        List<String> Bt = new ArrayList<>();
        for(String field:fields){
            Bt.add(fieldsMap.get(field));
        }
        //headers表示excel表中第一行的表头
        Row row2 = sheet.createRow(2);
        //在excel表中添加表头
        for(int i=0;i<Bt.size();i++){
            sheet.setColumnWidth(i, 256*30);
            Cell cell7 = row2.createCell(i);
            cell7.setCellStyle(style2);
            cell7.setCellValue(Bt.get(i));
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
    public void FpxexdDaoChu(Sheet sheet, List<String> fields, List<BaseFpxexdHistory> fpxexds, SXSSFWorkbook workbook){
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
        for(BaseFpxexdHistory f:fpxexds){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                Cell cell = row1.createCell(i);
                sheet.setColumnWidth(i, 256*30);
                cell.setCellStyle(style);
                switch (fields.get(i)){
                    case "no":{
                        System.out.println("x的值为-->"+x);
                        cell.setCellValue(x+"");
                        x++;
                        break;
                    }
                    case "operation":{
                        cell.setCellValue(f.getOperation()+" ");
                        break;
                    }
                    case "operationPerson":{
                        cell.setCellValue(f.getOperationPerson()+" ");
                        break;
                    }
                    case "operationDate":{
                        cell.setCellValue(formaDate(f.getOperationDate())+" ");
                        break;
                    }
                    case "checkStatus":{
                        cell.setCellValue(f.getCheckStatus()+" ");
                        break;
                    }
                    case "checkPerson":{
                        cell.setCellValue(f.getCheckPerson()+" ");
                        break;
                    }
                    case "checkDate":{
                        cell.setCellValue(formaDate(f.getCheckDate())+" ");
                        break;
                    }
                    case "xiang":{
                        cell.setCellValue(f.getXiang()+" ");
                        break;
                    }
                    case "chun":{
                        cell.setCellValue(f.getChun()+" ");
                        break;
                    }
                    case "zu":{
                        cell.setCellValue(f.getZu()+" ");
                        break;
                    }
                    case "name":{
                        cell.setCellValue(f.getName()+" ");
                        break;
                    }
                    case "cardId":{
                        cell.setCellValue(f.getCardId()+" ");
                        break;
                    }
                    case "members":{
                        cell.setCellValue(f.getMembers()+" ");
                        break;
                    }
                    case "daiKuanRenXingMing":{
                        cell.setCellValue(f.getDaiKuanRenXingMing()+" ");
                        break;
                    } case "daiKuanRenCardId":{
                        cell.setCellValue(f.getDaiKuanRenCardId()+" ");
                        break;
                    } case "familyRelation":{
                        cell.setCellValue(f.getFamilyRelation()+" ");
                        break;
                    }
                    case "tuoPinState":{
                        cell.setCellValue(f.getTuoPinState()+" ");
                        break;
                    }
                    case "yuanYouYuE":{
                        cell.setCellValue(f.getYuanYouYuE()+" ");
                        break;
                    }
                    case "yuanYouIsYuQi":{
                        cell.setCellValue(f.getYuanYouIsYuQi()+" ");
                        break;
                    }
                    case "yuanYouYuQiJinE":{
                        cell.setCellValue(f.getYuanYouYuQiJinE()+" ");
                        break;
                    }
                    case "yuanYouYuQiShiJian":{
                        cell.setCellValue(formaDate(f.getYuanYouYuQiShiJian())+" ");
                        break;
                    }
                    case "yuanYouQianXiJinE":{
                        cell.setCellValue(f.getYuanYouQianXiJinE()+" ");
                        break;
                    }
                    case "yuanYouQianXiShiJian":{
                        cell.setCellValue(formaDate(f.getYuanYouYuQiShiJian())+" ");
                        break;
                    }
                    case "fuPingivenStars":{
                        cell.setCellValue(f.getFuPingivenStars()+" ");
                        break;
                    }
                    case "fuPinshouXinEDu":{
                        cell.setCellValue(f.getFuPinshouXinEDu()+" ");
                        break;
                    }
                    case "fuPinshouXinJiGou":{
                        cell.setCellValue(f.getFuPinshouXinJiGou()+" ");
                        break;
                    }
                    case "fuPinshouxinData":{
                        cell.setCellValue(formaDate(f.getFuPinshouxinData())+" ");
                        break;
                    }
                    case "fuPinXiaoDaidaiKuanJinE":{
                        cell.setCellValue(f.getFuPinXiaoDaidaiKuanJinE()+" ");
                        break;
                    }
                    case "fuPindaiKuanQiXian":{
                        cell.setCellValue(f.getFuPindaiKuanQiXian()+" ");
                        break;
                    }
                    case "fuPinfangKuanRiQi":{
                        cell.setCellValue(formaDate(f.getFuPinfangKuanRiQi())+" ");
                        break;
                    }
                    case "fuPindaoQiRiQi":{
                        cell.setCellValue(formaDate(f.getFuPindaoQiRiQi())+" ");
                        break;
                    }
                    case "fuPinXiaoDaiDaiKuanLiLv":{
                        cell.setCellValue(f.getFuPinXiaoDaiDaiKuanLiLv()+" ");
                        break;
                    }
                    case "fuPindaiKuanJiGou":{
                        cell.setCellValue(f.getFuPindaiKuanJiGou()+" ");
                        break;
                    }
                    case "fuPinleiJiTieXi":{
                        cell.setCellValue(f.getFuPinleiJiTieXi()+" ");
                        break;
                    }
                    case "fuPinchangHuanDaiKuanJInE":{
                        cell.setCellValue(f.getFuPinchangHuanDaiKuanJInE()+" ");
                        break;
                    }
                    case "fuPinhuanKuanShiJian":{
                        cell.setCellValue(formaDate(f.getFuPinhuanKuanShiJian())+" ");
                        break;
                    }
                    case "fuPindaiKuanYuE":{
                        cell.setCellValue(f.getFuPindaiKuanYuE()+" ");
                        break;
                    }
                    case "fuPinyuQiDaiKuanJinE":{
                        cell.setCellValue(f.getFuPinyuQiDaiKuanJinE()+" ");
                        break;
                    }
                    case "fuPinyuQiDaiKuanShiJian":{
                        cell.setCellValue((f.getFuPinyuQiDaiKuanShiJian())+" ");
                        break;
                    }
                    case "fuPinqianXiJinE":{
                        cell.setCellValue(f.getFuPinqianXiJinE()+" ");
                        break;
                    }
                    case "fuPinqianXiShiJian":{
                        cell.setCellValue((f.getFuPinqianXiShiJian())+" ");
                        break;
                    }
                    case "fuPinYingDaiWeiDaiShiBie":{
                        cell.setCellValue(f.getFuPinYingDaiWeiDaiShiBie()+" ");
                        break;
                    }
                    case "fuPinDaiKuanYongTu":{
                        cell.setCellValue(f.getFuPinDaiKuanYongTu()+" ");
                        break;
                    }
                    case "chuangYeJinE":{
                        cell.setCellValue(f.getChuangYeJinE()+" ");
                        break;
                    }
                    case "chuangYeQiXian":{
                        cell.setCellValue(f.getChuangYeQiXian()+" ");
                        break;
                    }
                    case "chuangYeFangKuanRiQi":{
                        cell.setCellValue(formaDate(f.getChuangYeFangKuanRiQi())+" ");
                        break;
                    }
                    case "chuangYeDaoQiShiJian":{
                        cell.setCellValue(formaDate(f.getChuangYeDaoQiShiJian())+" ");
                        break;
                    }
                    case "chuangYeLiLv":{
                        cell.setCellValue(f.getChuangYeLiLv()+" ");
                        break;
                    }
                    case "chuangYeChangHuanJinE":{
                        cell.setCellValue(f.getChuangYeChangHuanJinE()+" ");
                        break;
                    }
                    case "changYeHuangKuanShiJian":{
                        cell.setCellValue(formaDate(f.getChangYeHuangKuanShiJian())+" ");
                        break;
                    }
                    case "chuangYeYuE":{
                        cell.setCellValue(f.getChuangYeYuE()+" ");
                        break;
                    }
                    case "chuangYeYuQiJinE":{
                        cell.setCellValue(f.getChuangYeYuQiJinE()+" ");
                        break;
                    }
                    case "chuangYeYuQiShiJian":{
                        cell.setCellValue(formaDate(f.getChuangYeYuQiShiJian())+" ");
                        break;
                    }
                    case "chuangYeQianXiJinE":{
                        cell.setCellValue(f.getChuangYeQianXiJinE()+" ");
                        break;
                    }
                    case "chuangYeQianXiShiJian":{
                        cell.setCellValue(formaDate(f.getChuangYeQianXiShiJian())+" ");
                        break;
                    }
                    case "chuangYeYongTu":{
                        cell.setCellValue(f.getChuangYeYongTu()+" ");
                        break;
                    }
                    case "shengYuanJinE":{
                        cell.setCellValue(f.getShengYuanJinE()+" ");
                        break;
                    }
                    case "shengYuanQiXian":{
                        cell.setCellValue(f.getShengYuanQiXian()+" ");
                        break;
                    }
                    case "shengYuanFangKuanRiQi":{
                        cell.setCellValue(formaDate(f.getShengYuanFangKuanRiQi())+" ");
                        break;
                    }
                    case "shengYaunDaoQiRiQi":{
                        cell.setCellValue(formaDate(f.getShengYaunDaoQiRiQi())+" ");
                        break;
                    }
                    case "shengYaunLiLv":{
                        cell.setCellValue(f.getShengYaunLiLv()+" ");
                        break;
                    }
                    case "shengYaunChangHuanJinE":{
                        cell.setCellValue(f.getShengYaunChangHuanJinE()+" ");
                        break;
                    }
                    case "shengYuanHuanKuanShiJian":{
                        cell.setCellValue(formaDate(f.getShengYuanHuanKuanShiJian())+" ");
                        break;
                    }
                    case "shengYuanYuE":{
                        cell.setCellValue(f.getShengYuanYuE()+" ");
                        break;
                    }
                    case "shengYuanYuQiJinE":{
                        cell.setCellValue(f.getShengYuanYuQiJinE()+" ");
                        break;
                    }
                    case "shengYuanYuQiShiJian":{
                        cell.setCellValue(formaDate(f.getShengYuanYuQiShiJian())+" ");
                        break;
                    }
                    case "shengYuanQianXiJinE":{
                        cell.setCellValue(f.getShengYuanQianXiJinE()+" ");
                        break;
                    }
                    case "shengYuanQianXiShiJian":{
                        cell.setCellValue(formaDate(f.getShengYuanQianXiShiJian())+" ");
                        break;
                    }
                    case "qiTaJinE":{
                        cell.setCellValue(f.getQiTaJinE()+" ");
                        break;
                    }
                    case "qiTaQiXian":{
                        cell.setCellValue(f.getQiTaQiXian()+" ");
                        break;
                    }
                    case "qiTaFangKuanRiQi":{
                        cell.setCellValue(formaDate(f.getQiTaFangKuanRiQi())+" ");
                        break;
                    }

                    case "qiTaDaoQiRiQi":{
                        cell.setCellValue(formaDate(f.getQiTaDaoQiRiQi())+" ");
                        break;
                    }
                    case "qiTaLiLv":{
                        cell.setCellValue(f.getQiTaLiLv()+" ");
                        break;
                    }
                    case "qiTaChangHuanJinE":{
                        cell.setCellValue(f.getQiTaChangHuanJinE()+" ");
                        break;
                    }
                    case "qiTaChangHuangKuanShiJian":{
                        cell.setCellValue(formaDate(f.getQiTaChangHuangKuanShiJian())+" ");
                        break;
                    }
                    case "qiTaYuE":{
                        cell.setCellValue(f.getQiTaYuE()+" ");
                        break;
                    }
                    case "qiTaYuQiJinE":{
                        cell.setCellValue(f.getQiTaYuQiJinE()+" ");
                        break;
                    }
                    case "qiTaYuQiShiJian":{
                        cell.setCellValue(formaDate(f.getQiTaYuQiShiJian())+" ");
                        break;
                    }
                    case "qiTaQianXiJinE":{
                        cell.setCellValue(f.getQiTaQianXiJinE()+" ");
                        break;
                    }
                    case "qiTaQianXiShiJian":{
                        cell.setCellValue(formaDate(f.getQiTaQianXiShiJian())+" ");
                        break;
                    }
                    case "qiTaYongTu":{
                        cell.setCellValue(f.getQiTaYongTu()+" ");
                        break;
                    }
                    case "note":{
                        cell.setCellValue(f.getNote()+" ");
                        break;
                    }
                }
            }
            row1 = null;
            f=null;
            y++;
        }
//            //数据清理
        //fields.clear();
        fpxexds.clear();
        //设置空引用
        fpxexds= null;
    }
}
