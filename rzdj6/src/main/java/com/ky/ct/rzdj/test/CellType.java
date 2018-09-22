package com.ky.ct.rzdj.test;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import com.ky.ct.rzdj.util.FpxexdDaochu;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

public class CellType
{
    public static void main(String[] args)throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        sheet.autoSizeColumn(0, true);
        sheet.autoSizeColumn(1, true);
        sheet.autoSizeColumn(2, true);
        //设置单元格样式
        HSSFFont font = wb.createFont();
        HSSFFont font2 = wb.createFont();
        //设置字体大小
        font.setFontName("宋体");
        //设置斜体
        font.setItalic(true);
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 20);// 设置字体大小
        font2.setFontHeightInPoints((short) 16);// 设置字体大小
        HSSFCellStyle style = wb.createCellStyle();

        HSSFCellStyle style2 = wb.createCellStyle();
        //设置字体
        style.setFont(font);
        style2.setFont(font2);
        //设置居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
//        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
//        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
//        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
////        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
//        style.setBorderBottom(CellStyle.BORDER_THIN);
//        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//        style.setBorderLeft(CellStyle.BORDER_THIN);
//        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//        style.setBorderRight(CellStyle.BORDER_THIN);
//        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//        style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
//        style.setTopBorderColor(IndexedColors.BLACK.getIndex());


        //创建一行
        HSSFRow row = sheet.createRow(0);
        //设置这一行的行高
        row.setHeight((short)1000);
        //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
        CellRangeAddress region1 = new CellRangeAddress(0,0,0,75);
        sheet.addMergedRegion(region1);;
        //单元格添加内容
        Cell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("金融扶贫小额信贷");


        //创建第二行 基本情况
        HSSFRow row1 = sheet.createRow(1);
        CellRangeAddress region2 = new CellRangeAddress(1,1,(short)0,(short)10);
        sheet.addMergedRegion(region2);
        Cell cell1 = row1.createCell(0);
        cell1.setCellStyle(style);
        cell1.setCellValue("基本情况");

        //创建第二行 原贷款情况
        CellRangeAddress region3 = new CellRangeAddress(1,1,(short)11,(short)16);
        sheet.addMergedRegion(region3);
        Cell cell2 = row1.createCell(11);
        cell2.setCellStyle(style);
        cell2.setCellValue("原贷款情况");

        //创建第二行 扶贫小额信贷
        CellRangeAddress region4 = new CellRangeAddress(1,1,(short)17,(short)36);
        sheet.addMergedRegion(region4);
        Cell cell3 = row1.createCell(17);
        cell3.setCellStyle(style);
        cell3.setCellValue("扶贫小额信贷");

        //创建第二行 创业贷款
        CellRangeAddress region5 = new CellRangeAddress(1,1,(short)37,(short)49);
        sheet.addMergedRegion(region5);
        Cell cell4 = row1.createCell(37);
        cell4.setCellStyle(style);
        cell4.setCellValue("创业贷款");

        //创建第二行 生源地贷款
        CellRangeAddress region6 = new CellRangeAddress(1,1,(short)50,(short)61);
        sheet.addMergedRegion(region6);
        Cell cell5 = row1.createCell(50);
        cell5.setCellStyle(style);
        cell5.setCellValue("生源地贷款");

        //创建第二行 其他类型贷款
        CellRangeAddress region7 = new CellRangeAddress(1,1,(short)62,(short)75);
        sheet.addMergedRegion(region7);
        Cell cell6 = row1.createCell(62);
        cell6.setCellStyle(style);
        cell6.setCellValue("其他类型贷款");


        //创建第三行 表头
        Map<String,String> paramMap = FpxexdDaochu.getPkfDzbField();
        HSSFRow row2 = sheet.createRow(2);
        int i = 0;
        for(String key:paramMap.keySet()){
            sheet.setColumnWidth(i, 256*30);
            Cell cell7 = row2.createCell(i);
            cell7.setCellStyle(style2);
            cell7.setCellValue(paramMap.get(key));
            i++;
        }
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("g://workbook.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}