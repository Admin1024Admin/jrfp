package com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu;

import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhDao;
import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

public class QtgrzjfpdkDaoChu2 {
    //计算表头每部分字段的个数
    public Map<String,Integer> getNumber(List<String> fields){
        //贷款投放进度
        int t = 0;
        //贷款偿还进度
        int c = 0;
        //计算新型农业经营主体精准扶贫贷款前面有多少个字段
        int d = 0;
        //计算贷款投放进度前有多少个字段
        int tf = 0;
        boolean tfOff = true;
        //计算贷款偿还进度前面有多少个字段
        int ch = 0;
        boolean chOff = true;
        //计数
        int js = 0;
        for(String field:fields){
            if("zhuTiDaiKuanLeiBie".equals(field)){
                d=js;
            }
            if("touFangDate".equals(field)||"touFangJinE".equals(field)||"leiJiTouFangJinE".equals(field)||"weiTouFangYuE".equals(field)){
                if(tfOff){
                    tf = js;
                    tfOff = false;
                }
                t++;
            }
            if("changHuanJinE".equals(field)||"changHuanDate".equals(field)||"leiJiChangHuanJinE".equals(field)||"weiChangHuanYuE".equals(field)){
                if(chOff){
                    ch = js;
                    chOff = false;
                }
                c++;
            }
            js++;
        }
        Map<String,Integer>numberMap = new HashMap<>();
        numberMap.put("t",t);
        numberMap.put("c",c);
        numberMap.put("d",d);
        numberMap.put("tf",tf);
        numberMap.put("ch",ch);
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
        //贷款投放进度
        int t = numberMap.get("t");
        //贷款偿还进度
        int c = numberMap.get("c");
        int count = numberMap.get("d")>0?numberMap.get("js")+2:numberMap.get("js");
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
        cell.setCellValue("其他个人精准扶贫贷款");

        //创建第二行
        //创建表头
        List<String> Bt = new ArrayList<>();
        boolean off = true;
        boolean off2 = true;
        //贷款投放进度的Map
        Map<String,Object> tfMap = new HashMap<>();
        //贷款偿还进度Map
        Map<String,Object> chMap = new HashMap<>();
        for(String field:fields){
            if("touFangDate".equals(field)||"touFangJinE".equals(field)||"leiJiTouFangJinE".equals(field)||"weiTouFangYuE".equals(field)){
                if(off){
                    Bt.add("贷款投放进度");
                    off = false;
                }
                tfMap.put(field,fieldsMap.get(field));
            }else if("changHuanJinE".equals(field)||"changHuanDate".equals(field)||"leiJiChangHuanJinE".equals(field)||"weiChangHuanYuE".equals(field)){
                if(off2){
                    Bt.add("贷款偿还进度");
                    off2 = false;
                }
                chMap.put(field,fieldsMap.get(field));
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
               case "新型农业经营主体精准扶贫贷款类别":{
                   //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                   CellRangeAddress region2 = new CellRangeAddress(1,1,i,i+2);
                   sheet.addMergedRegion(region2);
                   //单元格添加内容
                   Cell dkTypecell = row1.createCell(i);
                   dkTypecell.setCellStyle(style);
                   dkTypecell.setCellValue("新型农业经营主体精准扶贫贷款类别");
                   cellNumber+=2;
                   break;
               }
               case "贷款投放进度":{
                   System.out.println("投放进度------>"+i);
                   //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                   CellRangeAddress region2 = new CellRangeAddress(1,1,i+cellNumber,i+cellNumber+numberMap.get("t")-1);
                   sheet.addMergedRegion(region2);
                   //单元格添加内容
                   Cell dkTypecell = row1.createCell(i+cellNumber);
                   dkTypecell.setCellStyle(style);
                   dkTypecell.setCellValue("贷款投放进度");
                   cellNumber=cellNumber+numberMap.get("t")-1;
                   break;
               }
               case "贷款偿还进度":{
                   System.out.println("贷款偿还进度------>"+i);
                   //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                   System.out.println();
                   CellRangeAddress region2 = new CellRangeAddress(1,1,i+cellNumber,i+cellNumber+numberMap.get("c")-1);
                   sheet.addMergedRegion(region2);
                   //单元格添加内容
                   Cell dkTypecell = row1.createCell(i+cellNumber);
                   dkTypecell.setCellStyle(style);
                   dkTypecell.setCellValue("贷款偿还进度");
                   cellNumber=cellNumber+numberMap.get("c")-1;
                   break;
               }
              default:{
                  //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                  CellRangeAddress region2 = new CellRangeAddress(1,3,i+cellNumber,i+cellNumber);
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
        if(numberMap.get("d")!=0){
            int d = numberMap.get("d");
            //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
            CellRangeAddress region2 = new CellRangeAddress(2,3,d,d);
            sheet.addMergedRegion(region2);
            //单元格添加内容
            Cell dkTypecell = row2.createCell(d);
            dkTypecell.setCellStyle(style);
            dkTypecell.setCellValue("家庭农场贷款");

            //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
            CellRangeAddress region3 = new CellRangeAddress(2,3,d+1,d+1);
            sheet.addMergedRegion(region3);
            //单元格添加内容
            Cell dkTypecell2 = row2.createCell(d+1);
            dkTypecell2.setCellStyle(style);
            dkTypecell2.setCellValue("农业专业大户贷款");

            //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
            CellRangeAddress region4 = new CellRangeAddress(2,3,d+2,d+2);
            sheet.addMergedRegion(region4);
            //单元格添加内容
            Cell dkTypecell3 = row2.createCell(d+2);
            dkTypecell3.setCellStyle(style);
            dkTypecell3.setCellValue("其他");
            cellNumber2+=2;
        }
        if(numberMap.get("tf")!=0){
            int tf = numberMap.get("tf");
            for(String key:tfMap.keySet()){
                //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
                CellRangeAddress region4 = new CellRangeAddress(2,3,tf+cellNumber2,tf+cellNumber2);
                sheet.addMergedRegion(region4);
                //单元格添加内容
                Cell dkTypecell3 = row2.createCell(tf+cellNumber2);
                dkTypecell3.setCellStyle(style);
                dkTypecell3.setCellValue(tfMap.get(key)+" ");
                tf++;
            }
        }
        if(numberMap.get("ch")!=0){
            int ch = numberMap.get("ch");
            System.out.println("----->caMap"+chMap);
            for(String key:chMap.keySet()){
                //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格  ch=23 number=6
                CellRangeAddress region4 = new CellRangeAddress(2,3,ch+cellNumber2,ch+cellNumber2);
                sheet.addMergedRegion(region4);
                //单元格添加内容
                Cell dkTypecell3 = row2.createCell(ch+cellNumber2);
                dkTypecell3.setCellStyle(style);
                dkTypecell3.setCellValue(chMap.get(key)+" ");
                ch++;
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
    public void EncapsulateData(Sheet sheet, List<String> fields, List<BaseQtgrjzfpdk> qtgrjzfpdks,SXSSFWorkbook workbook,QtgrjzfpdkDdpkhDao qtgrjzfpdkDdpkhDao){
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontName("宋体");

        CellStyle style = workbook.createCellStyle();
        //设置字体
        style.setFont(font);
        //设置居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        int y = 4;
        Row row1 = null;
        System.gc();
        int x = 1;
        for(BaseQtgrjzfpdk q:qtgrjzfpdks){
            Map<String,Object> whereMap = new HashMap<>();
            whereMap.put("agreementNo",q.getAgreementNo());
            List<BaseQtgrjzfpdkDdpkh> ddpkhs = qtgrjzfpdkDdpkhDao.findByCondition(whereMap);
            if(ddpkhs!=null&&ddpkhs.size()>0){
                for(BaseQtgrjzfpdkDdpkh d:ddpkhs) {
                    row1 = sheet.createRow(y);
                    int cellNumber = 0;
                    for (int i = 0; i < fields.size(); i++) {
                        Cell cell = row1.createCell(cellNumber);
                        sheet.setColumnWidth(cellNumber, 256 * 30);
                        cell.setCellStyle(style);
                        switch (fields.get(i)) {
                            case "uid": {
                                System.out.println("x的值为-->" + x);
                                cell.setCellValue(x + "");
                                x++;
                                break;
                            }
                            case "name": {
                                cell.setCellValue(q.getName() + " ");
                                break;
                            }
                            case "cardId": {
                                cell.setCellValue(q.getCardId() + " ");
                                break;
                            }
                            case "address": {
                                cell.setCellValue(q.getAddress() + " ");
                                break;
                            }
                            case "telephone": {
                                cell.setCellValue(q.getTelephone() + " ");
                                break;
                            }
                            case "agreementNo": {
                                cell.setCellValue(q.getAgreementNo() + " ");
                                break;
                            }
                            case "daiKuanJinE": {
                                cell.setCellValue(q.getDaiKuanJinE() + " ");
                                break;
                            }
                            case "daiKuanQiXian": {
                                cell.setCellValue(q.getDaiKuanQiXian() + " ");
                                break;
                            }
                            case "daiKuanDate": {
                                cell.setCellValue(formaDate(q.getDaiKuanDate()) + " ");
                                break;
                            }
                            case "daoQiDate": {
                                cell.setCellValue(formaDate(q.getDaoQiDate()) + " ");
                                break;
                            }
                            case "daiKuanLiLv": {
                                cell.setCellValue(q.getDaiKuanLiLv() + " ");
                                break;
                            }
                            case "daiKuanZhongLei": {
                                cell.setCellValue(q.getDaiKuanZhongLei() + " ");
                                break;
                            }
                            case "daiKuanFangShi": {
                                cell.setCellValue(q.getDaiKuanFangShi() + " ");
                                break;
                            }
                            case "daiKuanYongTu": {
                                cell.setCellValue(q.getDaiKuanYongTu() + " ");
                                break;
                            }
                            case "shiYongDiYu": {
                                cell.setCellValue(q.getShiYongDiYu() + " ");
                                break;
                            }
                            case "chanYeLeiBie": {
                                cell.setCellValue(q.getChanYeLeiBie() + " ");
                                break;
                            }
                            case "fuPinDaiKuanLeiBie": {
                                cell.setCellValue(q.getFuPinDaiKuanLeiBie() + " ");
                                break;
                            }
                            //类型
                            case "zhuTiDaiKuanLeiBie": {
                                switch (q.getZhuTiDaiKuanLeiBie()){
                                    case "家庭农场贷款":{
                                        cell.setCellValue(q.getZhuTiDaiKuanLeiBie() + " ");
                                        cellNumber+=2;
                                        break;
                                    }
                                    case "农业专业大户贷款":{
                                        cell.setCellValue(" ");
                                        Cell cell2 = row1.createCell(cellNumber+1);
                                        cell2.setCellValue(q.getZhuTiDaiKuanLeiBie() + " ");
                                        cellNumber+=2;
                                        break;
                                    }
                                    case "其他":{
                                        cell.setCellValue(" ");
                                        Cell cell2 = row1.createCell(cellNumber+1);
                                        cell2.setCellValue(" ");
                                        Cell cell3 = row1.createCell(cellNumber+2);
                                        cell3.setCellValue(q.getZhuTiDaiKuanLeiBie() + " ");
                                        cellNumber+=2;
                                        break;
                                    }
                                }
                                cell.setCellValue(q.getZhuTiDaiKuanLeiBie() + " ");
                                cellNumber+=2;
                                break;
                            }
                            case "daiKuanJinRongJiGou": {
                                cell.setCellValue(q.getDaiKuanJinRongJiGou() + " ");
                                break;
                            }
                            //贷款投放进度
                            case "touFangDate": {
                                cell.setCellValue(formaDate(q.getTouFangDate()) + " ");
                                break;
                            }
                            case "touFangJinE": {
                                cell.setCellValue(q.getTouFangJinE() + " ");
                                break;
                            }
                            case "leiJiTouFangJinE": {
                                cell.setCellValue(q.getLeiJiChangHuanJinE() + " ");
                                break;
                            }
                            case "weiTouFangYuE": {
                                cell.setCellValue(q.getWeiChangHuanYuE() + " ");
                                break;
                            }
                            //贷款偿还进度
                            case "changHuanJinE": {
                                cell.setCellValue(q.getChangHuanJinE() + " ");
                                break;
                            }
                            case "changHuanDate": {
                                cell.setCellValue(formaDate(q.getChangHuanDate()) + " ");
                                break;
                            }
                            case "leiJiChangHuanJinE": {
                                cell.setCellValue(q.getLeiJiChangHuanJinE() + " ");
                                break;
                            }
                            case "weiChangHuanYuE": {
                                cell.setCellValue(q.getWeiChangHuanYuE() + " ");
                                break;
                            }
                            //
                            case "yuQiJinE": {
                                cell.setCellValue(q.getYuQiJinE() + " ");
                                break;
                            }
                            case "yuQiDate": {
                                cell.setCellValue(formaDate(q.getYuQiDate()) + " ");
                                break;
                            }
                            case "qianXiDate": {
                                cell.setCellValue(formaDate(q.getQianXiDate()) + " ");
                                break;
                            }
                            case "qianXiJinE": {
                                cell.setCellValue(q.getQianXiJinE() + " ");
                                break;
                            }
                            case "liYiLianJieFangShi": {
                                cell.setCellValue(q.getLiYiLianJieFangShi() + " ");
                                break;
                            }
                            case "daiDongPkRenKouShu": {
                                cell.setCellValue(q.getDaiDongPkRenKouShu() + " ");
                                break;
                            }
                            case "zhiJieDaiDongXiaoYi": {
                                cell.setCellValue(q.getZhiJieDaiDongXiaoYi() + " ");
                                break;
                            }
                            case "note": {
                                cell.setCellValue(q.getNote() + " ");
                                break;
                            }
                            case "huZhuName": {
                                cell.setCellValue(d.getHuZhuName()+ " ");
                                break;
                            }
                            case "huZhuCardId": {
                                cell.setCellValue(d.getHuZhuCardId()+ " ");
                                break;
                            }
                            case "familyMembers": {
                                cell.setCellValue(d.getFamilyMembers()+ " ");
                                break;
                            }
                        }
                        cellNumber++;
                    }
                    y++;
                }
            }else{
                row1 = sheet.createRow(y);
                int cellNumber = 0;
                for (int i = 0; i < fields.size(); i++) {
                    Cell cell = row1.createCell(cellNumber);
                    sheet.setColumnWidth(cellNumber, 256 * 30);
                    cell.setCellStyle(style);
                    switch (fields.get(i)) {
                        case "uid": {
                            System.out.println("x的值为-->" + x);
                            cell.setCellValue(x + "");
                            x++;
                            break;
                        }
                        case "name": {
                            cell.setCellValue(q.getName() + " ");
                            break;
                        }
                        case "cardId": {
                            cell.setCellValue(q.getCardId() + " ");
                            break;
                        }
                        case "address": {
                            cell.setCellValue(q.getAddress() + " ");
                            break;
                        }
                        case "telephone": {
                            cell.setCellValue(q.getTelephone() + " ");
                            break;
                        }
                        case "agreementNo": {
                            cell.setCellValue(q.getAgreementNo() + " ");
                            break;
                        }
                        case "daiKuanJinE": {
                            cell.setCellValue(q.getDaiKuanJinE() + " ");
                            break;
                        }
                        case "daiKuanQiXian": {
                            cell.setCellValue(q.getDaiKuanQiXian() + " ");
                            break;
                        }
                        case "daiKuanDate": {
                            cell.setCellValue(formaDate(q.getDaiKuanDate()) + " ");
                            break;
                        }
                        case "daoQiDate": {
                            cell.setCellValue(formaDate(q.getDaoQiDate()) + " ");
                            break;
                        }
                        case "daiKuanLiLv": {
                            cell.setCellValue(q.getDaiKuanLiLv() + " ");
                            break;
                        }
                        case "daiKuanZhongLei": {
                            cell.setCellValue(q.getDaiKuanZhongLei() + " ");
                            break;
                        }
                        case "daiKuanFangShi": {
                            cell.setCellValue(q.getDaiKuanFangShi() + " ");
                            break;
                        }
                        case "daiKuanYongTu": {
                            cell.setCellValue(q.getDaiKuanYongTu() + " ");
                            break;
                        }
                        case "shiYongDiYu": {
                            cell.setCellValue(q.getShiYongDiYu() + " ");
                            break;
                        }
                        case "chanYeLeiBie": {
                            cell.setCellValue(q.getChanYeLeiBie() + " ");
                            break;
                        }
                        case "fuPinDaiKuanLeiBie": {
                            cell.setCellValue(q.getFuPinDaiKuanLeiBie() + " ");
                            break;
                        }
                        //类型
                        case "zhuTiDaiKuanLeiBie": {
                            cell.setCellValue(q.getZhuTiDaiKuanLeiBie() + " ");
                            cellNumber+=2;
                            break;
                        }
                        case "daiKuanJinRongJiGou": {
                            cell.setCellValue(q.getDaiKuanJinRongJiGou() + " ");
                            break;
                        }
                        //贷款投放进度
                        case "touFangDate": {
                            cell.setCellValue(formaDate(q.getTouFangDate()) + " ");
                            break;
                        }
                        case "touFangJinE": {
                            cell.setCellValue(q.getTouFangJinE() + " ");
                            break;
                        }
                        case "leiJiTouFangJinE": {
                            cell.setCellValue(q.getLeiJiChangHuanJinE() + " ");
                            break;
                        }
                        case "weiTouFangYuE": {
                            cell.setCellValue(q.getWeiChangHuanYuE() + " ");
                            break;
                        }
                        //贷款偿还进度
                        case "changHuanJinE": {
                            cell.setCellValue(q.getChangHuanJinE() + " ");
                            break;
                        }
                        case "changHuanDate": {
                            cell.setCellValue(formaDate(q.getChangHuanDate()) + " ");
                            break;
                        }
                        case "leiJiChangHuanJinE": {
                            cell.setCellValue(q.getLeiJiChangHuanJinE() + " ");
                            break;
                        }
                        case "weiChangHuanYuE": {
                            cell.setCellValue(q.getWeiChangHuanYuE() + " ");
                            break;
                        }
                        //
                        case "yuQiJinE": {
                            cell.setCellValue(q.getYuQiJinE() + " ");
                            break;
                        }
                        case "yuQiDate": {
                            cell.setCellValue(formaDate(q.getYuQiDate()) + " ");
                            break;
                        }
                        case "qianXiDate": {
                            cell.setCellValue(formaDate(q.getQianXiDate()) + " ");
                            break;
                        }
                        case "qianXiJinE": {
                            cell.setCellValue(q.getQianXiJinE() + " ");
                            break;
                        }
                        case "liYiLianJieFangShi": {
                            cell.setCellValue(q.getLiYiLianJieFangShi() + " ");
                            break;
                        }
                        case "daiDongPkRenKouShu": {
                            cell.setCellValue(q.getDaiDongPkRenKouShu() + " ");
                            break;
                        }
                        case "zhiJieDaiDongXiaoYi": {
                            cell.setCellValue(q.getZhiJieDaiDongXiaoYi() + " ");
                            break;
                        }
                        case "note": {
                            cell.setCellValue(q.getNote() + " ");
                            break;
                        }
                        case "huZhuName": {
                            cell.setCellValue(" ");
                            break;
                        }
                        case "huZhuCardId": {
                            cell.setCellValue(" ");
                            break;
                        }
                        case "familyMembers": {
                            cell.setCellValue(" ");
                            break;
                        }
                    }
                    cellNumber++;
                }
            }
            row1 = null;
            q=null;
            y++;
        }
        //数据清理
        //fields.clear();
        qtgrjzfpdks.clear();
        //设置空引用
        qtgrjzfpdks= null;
    }
}