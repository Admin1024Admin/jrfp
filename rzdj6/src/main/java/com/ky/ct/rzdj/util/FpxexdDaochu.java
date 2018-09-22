package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.dao.PkfDzbDao;
import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.PkfDzbEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.scheduling.annotation.Async;

import java.util.*;

public class FpxexdDaochu {
    //PkfDzb
    public static Map<String,String> getPkfDzbField(){
        Map<String,String> fieldsMap = new LinkedHashMap<>();
        fieldsMap.put("no","序号");
        fieldsMap.put("xiang","乡镇");
        fieldsMap.put("chun","行政村");
        fieldsMap.put("zu","组别");
        fieldsMap.put("name","户主姓名");
        fieldsMap.put("cardId","身份证号");
        fieldsMap.put("members","家庭人口数");
        fieldsMap.put("daiKuanRenXingMing","贷款人姓名");
        fieldsMap.put("daiKuanRenCardId","贷款人身份证");
        fieldsMap.put("familyRelation","与户主关系");
        fieldsMap.put("tuoPinState","脱贫属性");
        fieldsMap.put("yuanYouYuE","原有余额");
        fieldsMap.put("yuanYouIsYuQi","原有贷款是否逾期");
        fieldsMap.put("yuanYouYuQiJinE","原有逾期金额");
        fieldsMap.put("yuanYouYuQiShiJian","原有逾期时间");
        fieldsMap.put("yuanYouQianXiJinE","原有欠息金额");
        fieldsMap.put("yuanYouQianXiShiJian","原有欠息时间");
        fieldsMap.put("fuPingivenStars","信用等级评定");
        fieldsMap.put("fuPinshouXinEDu","授信额度");
        fieldsMap.put("fuPinshouXinJiGou","授信金融机构");
        fieldsMap.put("fuPinshouxinData","授信时间");
        fieldsMap.put("fuPinXiaoDaidaiKuanJinE","贷款金额");
        fieldsMap.put("fuPindaiKuanQiXian","贷款期限");
        fieldsMap.put("fuPinfangKuanRiQi","放款日期");
        fieldsMap.put("fuPindaoQiRiQi","到期日期");
        fieldsMap.put("fuPinXiaoDaiDaiKuanLiLv","贷款利率");
        fieldsMap.put("fuPindaiKuanJiGou","贷款金融机构");
        fieldsMap.put("fuPinleiJiTieXi","累计贴息金额（元）");
        fieldsMap.put("fuPinchangHuanDaiKuanJInE","偿还贷款金额");
        fieldsMap.put("fuPinhuanKuanShiJian","还款时间");
        fieldsMap.put("fuPindaiKuanYuE","贷款余额（万元）");
        fieldsMap.put("fuPinyuQiDaiKuanJinE","逾期贷款金额");
        fieldsMap.put("fuPinyuQiDaiKuanShiJian","贷款逾期时间");
        fieldsMap.put("fuPinqianXiJinE","欠息金额（元）");
        fieldsMap.put("fuPinqianXiShiJian","欠息时间");
        fieldsMap.put("fuPinYingDaiWeiDaiShiBie","应贷未贷识别");
        fieldsMap.put("fuPinDaiKuanYongTu","贷款用途");
        fieldsMap.put("chuangYeJinE","贷款金额");
        fieldsMap.put("chuangYeQiXian","贷款期限");
        fieldsMap.put("chuangYeFangKuanRiQi","放款日期");
        fieldsMap.put("chuangYeDaoQiShiJian","到期时间");
        fieldsMap.put("chuangYeLiLv","贷款利率");
        fieldsMap.put("chuangYeChangHuanJinE","偿还金额");
        fieldsMap.put("changYeHuangKuanShiJian","还款时间");
        fieldsMap.put("chuangYeYuE","贷款余额");
        fieldsMap.put("chuangYeYuQiJinE","逾期金额");
        fieldsMap.put("chuangYeYuQiShiJian","逾期时间");
        fieldsMap.put("chuangYeQianXiJinE","欠息金额");
        fieldsMap.put("chuangYeQianXiShiJian","欠息时间");
        fieldsMap.put("chuangYeYongTu","创业用途");
        fieldsMap.put("shengYuanJinE","贷款金额");
        fieldsMap.put("shengYuanQiXian","贷款期限");
        fieldsMap.put("shengYuanFangKuanRiQi","放款日期");
        fieldsMap.put("shengYaunDaoQiRiQi","到期时间");
        fieldsMap.put("shengYaunLiLv","贷款利率");
        fieldsMap.put("shengYaunChangHuanJinE","偿还金额");
        fieldsMap.put("shengYuanHuanKuanShiJian","还款时间");
        fieldsMap.put("shengYuanYuE","贷款余额");
        fieldsMap.put("shengYuanYuQiJinE","逾期金额");
        fieldsMap.put("shengYuanYuQiShiJian","逾期时间");
        fieldsMap.put("shengYuanQianXiJinE","欠息金额");
        fieldsMap.put("shengYuanQianXiShiJian","欠息时间");
        fieldsMap.put("qiTaJinE","贷款金额");
        fieldsMap.put("qiTaQiXian","贷款期限");
        fieldsMap.put("qiTaFangKuanRiQi","放款日期");
        fieldsMap.put("qiTaDaoQiRiQi","到期时间");
        fieldsMap.put("qiTaLiLv","贷款利率");
        fieldsMap.put("qiTaChangHuanJinE","偿还金额");
        fieldsMap.put("qiTaChangHuangKuanShiJian","还款时间");
        fieldsMap.put("qiTaYuE","贷款余额");
        fieldsMap.put("qiTaYuQiJinE","逾期金额");
        fieldsMap.put("qiTaYuQiShiJian","逾期时间");
        fieldsMap.put("qiTaQianXiJinE","欠息金额");
        fieldsMap.put("qiTaQianXiShiJian","欠息时间");
        fieldsMap.put("qiTaYongTu","贷款用途");
        fieldsMap.put("note","备注");
        return fieldsMap;
    }

    public static Sheet getSheet(Map<String,String> fieldsMap, List<String> fields, SXSSFWorkbook workbook){
        //创建数据表
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
    public void Listdaochu2(Sheet sheet,List<String> fields,List<BaseFpxexd> fpxexds){
    int y = 1;
    int x = 1;
    Row row1 = null;
        System.gc();
        for(BaseFpxexd f:fpxexds){
            row1  = sheet.createRow(y);
            for(int i=0;i<fields.size();i++){
                Cell cell = row1.createCell(i);
                switch (fields.get(i)){
                    case "no":{
                        System.out.println("x的值为-->"+x);
                        cell.setCellValue(x+"");
                        x++;
                        break;
                    }
                    case "xiang":{
                        cell.setCellValue(f.getXiang());
                        break;
                    }
                    case "chun":{
                        cell.setCellValue(f.getChun());
                        break;
                    }
                    case "zu":{
                        cell.setCellValue(f.getZu());
                        break;
                    }
                    case "name":{
                        cell.setCellValue(f.getName());
                        break;
                    }
                    case "cardId":{
                        cell.setCellValue(f.getCardId());
                        break;
                    }
                    case "members":{
                        cell.setCellType(f.getMembers());
                        break;
                    }
                    case "daiKuanRenXingMing":{
                        cell.setCellValue(f.getDaiKuanRenXingMing());
                        break;
                    } case "daiKuanRenCardId":{
                        cell.setCellValue(f.getDaiKuanRenCardId());
                        break;
                    } case "familyRelation":{
                        cell.setCellValue(f.getFamilyRelation());
                        break;
                    }
                    case "tuoPinState":{
                        cell.setCellValue(f.getTuoPinState());
                        break;
                    }
                    case "yuanYouYuE":{
                        cell.setCellValue(f.getYuanYouYuE());
                        break;
                    }
                    case "yuanYouIsYuQi":{
                        cell.setCellValue(f.getYuanYouIsYuQi());
                        break;
                    }
                    case "yuanYouYuQiJinE":{
                        cell.setCellValue(f.getYuanYouYuQiJinE());
                        break;
                    }
                    case "yuanYouYuQiShiJian":{
                        cell.setCellValue(f.getYuanYouYuQiShiJian().toString());
                        break;
                    }
                    case "yuanYouQianXiJinE":{
                        cell.setCellValue(f.getYuanYouQianXiJinE());
                        break;
                    }
                    case "yuanYouQianXiShiJian":{
                        cell.setCellValue(f.getYuanYouYuQiShiJian().toString());
                        break;
                    }
                    case "fuPingivenStars":{
                        cell.setCellValue(f.getFuPingivenStars());
                        break;
                    }
                    case "fuPinshouXinEDu":{
                        cell.setCellValue(f.getFuPinshouXinEDu());
                        break;
                    }
                    case "fuPinshouXinJiGou":{
                        cell.setCellValue(f.getFuPinshouXinJiGou().toString());
                        break;
                    }
                    case "fuPinshouxinData":{
                        cell.setCellValue(f.getFuPinshouxinData().toString());
                        break;
                    }
                    case "fuPinXiaoDaidaiKuanJinE":{
                        cell.setCellValue(f.getFuPinXiaoDaidaiKuanJinE());
                        break;
                    }
                    case "fuPindaiKuanQiXian":{
                        cell.setCellValue(f.getFuPindaiKuanQiXian().toString());
                        break;
                    }
                    case "fuPinfangKuanRiQi":{
                        cell.setCellValue(f.getFuPinfangKuanRiQi().toString());
                        break;
                    }
                    case "fuPindaoQiRiQi":{
                        cell.setCellValue(f.getFuPindaoQiRiQi().toString());
                        break;
                    }
                    case "fuPinXiaoDaiDaiKuanLiLv":{
                        cell.setCellValue(f.getFuPinXiaoDaiDaiKuanLiLv());
                        break;
                    }
                    case "fuPindaiKuanJiGou":{
                        cell.setCellValue(f.getFuPindaiKuanJiGou());
                        break;
                    }
                    case "fuPinleiJiTieXi":{
                        cell.setCellValue(f.getFuPinleiJiTieXi());
                        break;
                    }
                    case "fuPinchangHuanDaiKuanJInE":{
                        cell.setCellValue(f.getFuPinchangHuanDaiKuanJInE());
                        break;
                    }
                    case "fuPinhuanKuanShiJian":{
                        cell.setCellValue(f.getFuPinhuanKuanShiJian().toString());
                        break;
                    }
                    case "fuPindaiKuanYuE":{
                        cell.setCellValue(f.getFuPindaiKuanYuE());
                        break;
                    }
                    case "fuPinyuQiDaiKuanJinE":{
                        cell.setCellValue(f.getFuPinyuQiDaiKuanJinE());
                        break;
                    }
                    case "fuPinyuQiDaiKuanShiJian":{
                        cell.setCellValue(f.getFuPinyuQiDaiKuanShiJian().toString());
                        break;
                    }
                    case "fuPinqianXiJinE":{
                        cell.setCellValue(f.getFuPinqianXiJinE());
                        break;
                    }
                    case "fuPinqianXiShiJian":{
                        cell.setCellValue(f.getFuPinqianXiShiJian().toString());
                        break;
                    }
                    case "fuPinYingDaiWeiDaiShiBie":{
                        cell.setCellValue(f.getFuPinYingDaiWeiDaiShiBie());
                        break;
                    }
                    case "fuPinDaiKuanYongTu":{
                        cell.setCellValue(f.getFuPinDaiKuanYongTu());
                        break;
                    }
                    case "chuangYeJinE":{
                        cell.setCellValue(f.getChuangYeJinE());
                        break;
                    }
                    case "chuangYeQiXian":{
                        cell.setCellValue(f.getChuangYeQiXian().toString());
                        break;
                    }
                    case "chuangYeFangKuanRiQi":{
                        cell.setCellValue(f.getChuangYeFangKuanRiQi().toString());
                        break;
                    }
                    case "chuangYeDaoQiShiJian":{
                        cell.setCellValue(f.getChuangYeDaoQiShiJian().toString());
                        break;
                    }
                    case "chuangYeLiLv":{
                        cell.setCellValue(f.getChuangYeLiLv());
                        break;
                    }
                    case "chuangYeChangHuanJinE":{
                        cell.setCellValue(f.getChuangYeChangHuanJinE());
                        break;
                    }
                    case "changYeHuangKuanShiJian":{
                        cell.setCellValue(f.getChangYeHuangKuanShiJian().toString());
                        break;
                    }
                    case "chuangYeYuE":{
                        cell.setCellValue(f.getChuangYeYuE());
                        break;
                    }
                    case "chuangYeYuQiJinE":{
                        cell.setCellValue(f.getChuangYeYuQiJinE());
                        break;
                    }
                    case "chuangYeYuQiShiJian":{
                        cell.setCellValue(f.getChuangYeYuQiShiJian().toString());
                        break;
                    }
                    case "chuangYeQianXiJinE":{
                        cell.setCellValue(f.getChuangYeQianXiJinE());
                        break;
                    }
                    case "chuangYeQianXiShiJian":{
                        cell.setCellValue(f.getChuangYeQianXiShiJian().toString());
                        break;
                    }
                    case "chuangYeYongTu":{
                        cell.setCellValue(f.getChuangYeYongTu());
                        break;
                    }
                    case "shengYuanJinE":{
                        cell.setCellValue(f.getShengYuanJinE());
                        break;
                    }
                    case "shengYuanQiXian":{
                        cell.setCellValue(f.getShengYuanQiXian().toString());
                        break;
                    }
                    case "shengYuanFangKuanRiQi":{
                        cell.setCellValue(f.getShengYuanFangKuanRiQi().toString());
                        break;
                    }
                    case "shengYaunDaoQiRiQi":{
                        cell.setCellValue(f.getShengYaunDaoQiRiQi().toString());
                        break;
                    }
                    case "shengYaunLiLv":{
                        cell.setCellValue(f.getShengYaunLiLv());
                        break;
                    }
                    case "shengYaunChangHuanJinE":{
                        cell.setCellValue(f.getShengYaunChangHuanJinE());
                        break;
                    }
                    case "shengYuanHuanKuanShiJian":{
                        cell.setCellValue(f.getShengYuanHuanKuanShiJian().toString());
                        break;
                    }
                    case "shengYuanYuE":{
                        cell.setCellValue(f.getShengYuanYuE());
                        break;
                    }
                    case "shengYuanYuQiJinE":{
                        cell.setCellValue(f.getShengYuanYuQiJinE());
                        break;
                    }
                    case "shengYuanYuQiShiJian":{
                        cell.setCellValue(f.getShengYuanYuQiShiJian().toString());
                        break;
                    }
                    case "shengYuanQianXiJinE":{
                        cell.setCellValue(f.getShengYuanQianXiJinE());
                        break;
                    }
                    case "shengYuanQianXiShiJian":{
                        cell.setCellValue(f.getShengYuanQianXiShiJian().toString());
                        break;
                    }
                    case "qiTaJinE":{
                        cell.setCellValue(f.getQiTaJinE());
                        break;
                    }
                    case "qiTaQiXian":{
                        cell.setCellValue(f.getQiTaQiXian().toString());
                        break;
                    }
                    case "qiTaFangKuanRiQi":{
                        cell.setCellValue(f.getQiTaFangKuanRiQi().toString());
                        break;
                    }

                    case "qiTaDaoQiRiQi":{
                        cell.setCellValue(f.getQiTaDaoQiRiQi().toString());
                        break;
                    }
                    case "qiTaLiLv":{
                        cell.setCellValue(f.getQiTaLiLv());
                        break;
                    }
                    case "qiTaChangHuanJinE":{
                        cell.setCellValue(f.getQiTaChangHuanJinE());
                        break;
                    }
                    case "qiTaChangHuangKuanShiJian":{
                        cell.setCellValue(f.getQiTaChangHuangKuanShiJian().toString());
                        break;
                    }
                    case "qiTaYuE":{
                        cell.setCellValue(f.getQiTaYuE());
                        break;
                    }
                    case "qiTaYuQiJinE":{
                        cell.setCellValue(f.getQiTaYuQiJinE());
                        break;
                    }
                    case "qiTaYuQiShiJian":{
                        cell.setCellValue(f.getQiTaYuQiShiJian().toString());
                        break;
                    }
                    case "qiTaQianXiJinE":{
                        cell.setCellValue(f.getQiTaQianXiJinE());
                        break;
                    }
                    case "qiTaQianXiShiJian":{
                        cell.setCellValue(f.getQiTaQianXiShiJian().toString());
                        break;
                    }
                    case "qiTaYongTu":{
                        cell.setCellValue(f.getQiTaYongTu());
                        break;
                    }
                    case "note":{
                        cell.setCellValue(f.getNote());
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
