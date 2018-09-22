package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.FpxexdDao;
import com.ky.ct.rzdj.dao.FpxexdHistoryDao;
import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FpxexdService {
    @Autowired
    private FpxexdDao fpxexdDao;
    @Autowired
    private FpxexdHistoryDao fpxexdHistoryDao;

    private List<BaseFpxexd> baseFpxexdAll = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     *  分页查询扶贫小额信贷  根据单位来分页
     */
    public Map<String,Object> findFpxexdPage(int page,int limit){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        List<BaseFpxexd>  baseFpxexds = new ArrayList<>();
        if(user.getRole()==1){
            baseFpxexds = fpxexdDao.findPage(page,limit);
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("unit",user.getType());
            baseFpxexds = fpxexdDao.findPageByCondition(page,limit,paramMap);
        }
       Map<String,Object> map = new HashMap<>();
       map.put("data",baseFpxexds);
       return map;
    }

    /**
     * 获取数据的总条数  根据单位来分页
     */
    public long getCount(Map<String,Object> dataMap){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:dataMap.keySet()){
            if(dataMap.get(key)!=null&&!"".equals(dataMap.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,dataMap.get(key));
            }
        }
        long count = 0;
        if(user.getRole()==1){
            count  =(long) fpxexdDao.getCount(parmMap);
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("unit",user.getType());
            count = (long) fpxexdDao.getCount(paramMap);
        }
        return count;
    }

    /**
     * 在跳转到选择字段的同时就查询符合条件的所有数据
     */
    public void findWhereDate(Map<String,Object> dataMap){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:dataMap.keySet()){
            if(dataMap.get(key)!=null&&!"".equals(dataMap.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,dataMap.get(key));
            }
        }
        if(user.getRole()!=1){
            parmMap.put("unit",user.getType());
        }
        baseFpxexdAll = fpxexdDao.findByCondition(parmMap);
        System.out.println("baseFpxexdAll----->"+baseFpxexdAll);
    }

    /**
     * 按条件查询
     */
    public List<BaseFpxexd> findFpxexdWhere(Map<String,Object> map,int page,int limit){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:map.keySet()){
            if(map.get(key)!=null&&!"".equals(map.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,map.get(key));
            }
        }
        if(user.getRole()!=1){
            parmMap.put("unit",user.getType());
        }
        List<BaseFpxexd> baseFpxexds = fpxexdDao.findPageByCondition(page,limit,parmMap);
        return baseFpxexds;
    }

    /**
     * 根据选择的字段导出数据
     */
    public SXSSFWorkbook chooseFieldExport(List<String> fields){
        //将前端传递过来的字段排序
        Map<String,String> fieldsMap = FpxexdDaochu.getPkfDzbField();
        List<String> fiedsList = new ArrayList<>();
        for (String key : fieldsMap.keySet()) {
            for(String field:fields){
                if(field.equals(key)){
                    fiedsList.add(key);
                }
            }
        }
        System.out.println("排序后的字段---->"+fiedsList);
        //遍历按照条件查询好的数据封装表格
        //创建数据表
        // 内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        FpxexdDaoChu2 daoChu2 = new FpxexdDaoChu2();
        Map<String,Integer> numberMap = daoChu2.getNumber(fiedsList);
       // Sheet sheet = FpxexdDaochu.getSheet(fieldsMap,fiedsList,workbook);
        Sheet sheet = daoChu2.getSheet(fieldsMap,fiedsList,numberMap,workbook);
        if(baseFpxexdAll!=null&&baseFpxexdAll.size()>0){
//            FpxexdDaochu fpxexdDaochu = new FpxexdDaochu();
//            fpxexdDaochu.Listdaochu2(sheet,fiedsList,baseFpxexdAll);
            daoChu2.FpxexdDaoChu(sheet,fiedsList,baseFpxexdAll,workbook);
        }else{
            System.out.println("----结束-----");
        }
        return workbook;
    }
    /**
     * 导出一个案例excel
     */
    public SXSSFWorkbook demoExportFpxexd(){
        //获取全部字段
        Map<String,String> fieldsMap = FpxexdDaochu.getPkfDzbField();
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
         FpxexdDaoChu2 dc = new FpxexdDaoChu2();
        //获取所有字段
        List<String>names = new ArrayList<>();
        for(String key:fieldsMap.keySet()){
            names.add(key);
        }
        Map<String,Integer> numberMap = new HashMap<>();
        numberMap.put("j",11);
        numberMap.put("y",6);
        numberMap.put("f",20);
        numberMap.put("c",13);
        numberMap.put("s",12);
        numberMap.put("q",14);
        Sheet sheet = dc.getSheet(fieldsMap,names,numberMap,workbook);
        return workbook;
    }

    /**
     * 导出全部数据
     */
    public SXSSFWorkbook daoChuAll(){
        FpxexdDaoChu2 dc = new FpxexdDaoChu2();
        //获取全部字段
        Map<String,String> fieldsMap = FpxexdDaochu.getPkfDzbField();
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        //获取所有字段
        List<String>names = new ArrayList<>();
        for(String key:fieldsMap.keySet()){
            names.add(key);
        }
        System.out.println("names----->"+names);
        Map<String,Integer> numberMap = new HashMap<>();
        numberMap.put("j",11);
        numberMap.put("y",6);
        numberMap.put("f",20);
        numberMap.put("c",13);
        numberMap.put("s",12);
        numberMap.put("q",14);
        Sheet sheet = dc.getSheet(fieldsMap,names,numberMap,workbook);
        List<BaseFpxexd> baseFpxexds = fpxexdDao.findAll();
        dc.FpxexdDaoChu(sheet,names,baseFpxexds,workbook);
        return workbook;
    }
    /**
     * 选择字段录入
     */
    public Map<String,Object> getSortFields(List<String> fields){
        //将前端传递过来的字段排序
        Map<String,String> fieldsMap = FpxexdDaochu.getPkfDzbField();
        Map<String,Object> fiedsMap = new LinkedHashMap<>();
        for (String key : fieldsMap.keySet()) {
            for(String field:fields){
                if(field.equals(key)){
                    fiedsMap.put(key,fieldsMap.get(key));
                }
            }
        }
        return fiedsMap;
    }

    /**
     * 根据编号查看具体信息
     */
    public BaseFpxexd findByNo(int no){
        return fpxexdDao.findById(no);
    }

    /**
     * 根据贷款人身份证和放款时间判断是否该人是否存在
     */
//    public BaseFpxexd findByCardIdAndRiQi(String daiKuanRenCardId,String fangKuanRiQi){
//        String hql = "select * from base_fpxexd where daiKuanRenCardId='"+daiKuanRenCardId+"' and fuPinfangKuanRiQi='"+fangKuanRiQi+"'";
//        System.out.println("hql-------->"+hql);
//        BaseFpxexd baseFpxexd =  fpxexdDao.findBySql(hql);
//        return baseFpxexd;
//    }
    /**
     * 根据贷款人身份证和放款时间判断是否该人是否存在
     */
    public BaseFpxexdHistory findByCardIdAndRiQi(String daiKuanRenCardId, String fangKuanRiQi){
        String hql = "select * from base_fpxexd_history where daiKuanRenCardId='"+daiKuanRenCardId+"' and fuPinfangKuanRiQi='"+fangKuanRiQi+"'";
        System.out.println("hql-------->"+hql);
        BaseFpxexdHistory baseFpxexdHistory = fpxexdHistoryDao.findBySql(hql);
        return baseFpxexdHistory;
    }
    /**
     * 保存单条数据到审核过的表
     */
    public boolean savaSingle(BaseFpxexd baseFpxexd){
        boolean b = false;
        if(baseFpxexd!=null&&baseFpxexd.getCardId()!=null&&baseFpxexd.getCardId().length()>0){
           b =  fpxexdDao.saveOrUpdate(baseFpxexd);
        }
        return b;
    }
    /**
     * 保存单条数据
     */
    public boolean savaSingle(BaseFpxexdHistory baseFpxexdHistory){
        //将角色id保存到session 后期录入的时候查询到单位
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        RzdjUserEntity user = (RzdjUserEntity) request.getSession().getAttribute("currentUser");
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        System.out.println("添加--------->"+user);
        boolean b = false;
        if(baseFpxexdHistory!=null&&baseFpxexdHistory.getCardId()!=null&&baseFpxexdHistory.getCardId().length()>0){
            baseFpxexdHistory.setOperationDate(new Date());
            baseFpxexdHistory.setOperationPerson(user.getName());
            baseFpxexdHistory.setOperation("新增");
            baseFpxexdHistory.setCheckStatus("未审核");
            baseFpxexdHistory.setUnit(user.getType());
            baseFpxexdHistory.setDelStatus("未删除");
            b =  fpxexdHistoryDao.add(baseFpxexdHistory);
        }
        return b;
    }
    /**
     * 录入判断该用户存在后更新数据
     */
//    public boolean updateSingle(BaseFpxexd f1,BaseFpxexd f2){
//        BaseFpxexd baseFpxexd = UpdateFpxexd.updateSingle(f1,f2);
//        boolean b  = fpxexdDao.update(baseFpxexd);
//        return b;
//    }

    /**
     * 录入判断该用户存在后更新数据
     */
    public boolean updateSingle(BaseFpxexdHistory f1,BaseFpxexdHistory f2){
        BaseFpxexdHistory baseFpxexd = UpdateFpxexd.updateSingle(f1,f2);
        boolean b  = fpxexdHistoryDao.update(baseFpxexd);
        return b;
    }

    /**
     * 根据cardId删除
     */
    public boolean delByNo(int no){
        return fpxexdDao.deleteById(no);
    }
    /**
     *  上传Excel导入数据
     */
    public boolean loadExcel(MultipartFile file,String fileName){
        boolean b = false;
        Workbook wb = null;
        List<BaseFpxexd> userList = new ArrayList<>();
        //截取后缀名
        String xlsSuffix = fileName.substring(fileName.length()-4,fileName.length());
        String xlsxSuffix = fileName.substring(fileName.length()-5,fileName.length());
        try {
            InputStream is = file.getInputStream();
            //判断是否是excel文件
            if (".xls".equals(xlsSuffix) || ".xlsx".equals(xlsxSuffix)) {
                wb = new XSSFWorkbook(is);
                Sheet sheet = wb.getSheetAt(0);
                if (sheet != null) {
                    Row r = sheet.getRow(2);
                    //getPhysicalNumberOfCells 是获取不为空的列个数。
                    //getLastCellNum 是获取最后一个不为空的列是第几个。
                    System.out.println("不为空的列数----->"+r.getPhysicalNumberOfCells());
                    //获取字段在数据库的字段名和在excel中的中文名的Map.
                    Map<String,String> fields=FpxexdDaochu.getPkfDzbField();
                    //遍历获取单元格数据并比较excel中的字段以及对应的数据库字段名是什么
                    List<String> fieldNames = new ArrayList<>();
                    for(int i=0;i<r.getPhysicalNumberOfCells();i++){
                        String name = r.getCell(i).getStringCellValue();
                        System.out.println("表格列的名字------>"+name);
                        Map<String,String> copyFields = fields;
                        copyFields.remove("no");
                        //.将对应的数据库字段名放入list集合
                        for(String key:copyFields.keySet()){
                            if(fields.get(key).equals(name)){
                                System.out.println("name----->"+name+"   key------>"+key);
                                fieldNames.add(key);
                                copyFields.remove(key);
                                break;
                            }
                        }
                    }
                    System.out.println("excel上传过来的字段有------>"+fieldNames);
                    //获取excel数据  从第三列开始。。第三列才是数据的开始
                    //将excel数据封装为一个BaseFpxexd对象 放入一个List集合
                    //List<BaseFpxexd> baseFpxexds = new ArrayList<>();
                    List<BaseFpxexdHistory> baseFpxexdHistories = new ArrayList<>();
                    System.out.println("表格的行数有---->"+sheet.getLastRowNum());
                    int rows = sheet.getLastRowNum();
                    for (int rs = 3; rs <= rows; rs++) {
                        Row row = sheet.getRow(rs);
                        if (row == null){
                            continue;
                        }
                        BaseFpxexdHistory f = new BaseFpxexdHistory();
                        System.out.println("字段个数--------->"+fieldNames.size());
                        for(int i=0;i<fieldNames.size();i++){
                            String value = null;
                            if(row.getCell(i)!=null){
                                if(row.getCell(i).getCellType()==Cell.CELL_TYPE_NUMERIC){
                                    if (XSSFDateUtil.isCellDateFormatted(row.getCell(i))) {  //判断日期类型
                                        value = new SimpleDateFormat("yyyy-MM-dd").format(XSSFDateUtil.getJavaDate(row.getCell(i).getNumericCellValue()));
                                    }else{
                                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                                        value = row.getCell(i).getStringCellValue();
                                    }
                                }else{
                                    row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                                    value = row.getCell(i).getStringCellValue();
                                }
                            }else{
                                value="";
                            }

                            System.out.println("第"+rs+"行第"+i+"个单元格数据value---->"+value);
                            f = FpxexdLuRu.luRu(f,fieldNames.get(i),value);
                        }
                        //baseFpxexds.add(f);
                        baseFpxexdHistories.add(f);
                    }
                    //遍历封装好的BasePfxexd集合 判断是新数据还有原有数据 进行更新或者添加
//                    for(BaseFpxexd fpxexd:baseFpxexds){
//                        BaseFpxexd bf = findByCardIdAndRiQi(fpxexd.getDaiKuanRenCardId(),sdf.format(fpxexd.getFuPinfangKuanRiQi()));
//                        if(bf!=null){
//                            b = updateSingle(fpxexd,bf);
//                            //System.out.println("更新单条结果---->"+b);
//                        }else{
//                            b = fpxexdDao.add(fpxexd);
//                            //System.out.println("录入单条结果---->"+b);
//                        }
//                    }
                    for(BaseFpxexdHistory fpxexd:baseFpxexdHistories){
                        BaseFpxexdHistory bf = findByCardIdAndRiQi(fpxexd.getDaiKuanRenCardId(),sdf.format(fpxexd.getFuPinfangKuanRiQi()));
                        if(bf!=null){
                            b = updateSingle(fpxexd,bf);
                            //System.out.println("更新单条结果---->"+b);
                        }else{
                            fpxexd.setOperationDate(new Date());
                            fpxexd.setOperationPerson("xxxx");
                            fpxexd.setOperation("新增");
                            b = fpxexdHistoryDao.add(fpxexd);
                            //System.out.println("录入单条结果---->"+b);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 统计功能
     */
    public Map<String,Object> statistical(String beginDate,String endDate){
        Map<String,Object> resultMap= new LinkedHashMap<>();
        resultMap.put("no",1);
        //-- 1. 新增投放额度 净增额
        String sql1 = "select sum(fuPinXiaoDaidaiKuanJinE),sum(fuPindaiKuanYuE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        System.out.println(sql1);
        //--1累计投放额
        String beginDate_1 = Integer.valueOf(beginDate.substring(0,4))+"-01-01";
        //String sql_1 = "select sum(fuPinXiaoDaidaiKuanJinE),sum(fuPindaiKuanYuE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate_1+"' and '"+endDate+"'";
        String sql_1 = "select sum(fuPinXiaoDaidaiKuanJinE),sum(fuPindaiKuanYuE) from base_fpxexd";
        System.out.println(sql_1);
        List<Object[]> object = fpxexdDao.findByCustomSql(sql1);
        List<Object[]> object_1 = fpxexdDao.findByCustomSql(sql_1);
        Object[] result = object.get(0);
        Object[] result_1 = object_1.get(0);
        System.out.println("查询结果 累计投放额:------>"+result_1[0]);
        System.out.println("查询结果 新增投放额度:------>"+result[0]);
        System.out.println("查询结果 净增额:------>"+(double)result[1]);
        resultMap.put("leiJiTouFangE",(double)result_1[0]);
        resultMap.put("xinZengTouFangE",(double)result[0]);
        resultMap.put("jingZengE",(double)result[1]);

        //4.贷款余额比较去年同期增减额
        int year = Integer.valueOf(beginDate.substring(0,4))-1;
        String beginDate2 = year+beginDate.substring(4,beginDate.length());
        String endDate2 = year+endDate.substring(4,beginDate.length());
        String sql2 = "select sum(fuPindaiKuanYuE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate2+"' and '"+endDate2+"'";
        System.out.println(sql2);
        List<Object[]> object2 = fpxexdDao.findByCustomSql(sql2);
        Object result2 =object2.get(0);
        System.out.println("查询结果 贷款余额较比去年同期增减额:------>"+((double)result[1]-(double)result2));
        resultMap.put("tongQiZengJianE",(double)result[1]-(double)result2);
        //5.贷款余额同比增速
        double tongBiZengSu = ((double)result[1]-(double)result2)/(double)result2;
        System.out.println("同比增速----->"+tongBiZengSu);
        resultMap.put("tongBiZengSu",tongBiZengSu);

        //6.较年初增减额
        String beginDate3 = endDate.substring(0,4)+"-01-01";
        String sql3="select sum(fuPindaiKuanYuE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate3+"' and '"+endDate+"'";
        System.out.println(sql3);
        List<Object[]> object3 = fpxexdDao.findByCustomSql(sql3);
        Object result3 =object3.get(0);
        System.out.println("查询结果 较年初增减额:------>"+result3);
        resultMap.put("nianChuZengJianE",result3);

        //6.1,较比年初增速
        String sql3_1 ="select sum(fuPindaiKuanYuE) from base_fpxexd where fuPinfangKuanRiQi <= '"+beginDate3+"'";
        System.out.println(sql3_1);
        List<Object[]> object3_1 = fpxexdDao.findByCustomSql(sql3_1);
        Object result3_1 =object3_1.get(0);
        System.out.println("查询结果 较年初增减率:------>"+((double)result3/(double)result3_1));
        resultMap.put("nianChuZengSu",((double)result3/(double)result3_1));
        //7.贷款笔数
        String sql4 = "select count(*) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"' and fuPinXiaoDaidaiKuanJinE>0";
        System.out.println(sql4);
        List<Object[]> object4 = fpxexdDao.findByCustomSql(sql4);
        Object result4 =object4.get(0);
        System.out.println("查询结果 贷款笔数:------>"+result4);
        resultMap.put("daiKuanBiShu",result4);

        //8.贷款加权平均利率
        String sql11 = "select sum(fuPinXiaoDaidaiKuanJinE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"' GROUP BY fuPinXiaoDaiDaiKuanLiLv\n";
        String sql12="select fuPinXiaoDaiDaiKuanLiLv from base_fpxexd  where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"' GROUP BY fuPinXiaoDaiDaiKuanLiLv";
        List<Object[]> object11 = fpxexdDao.findByCustomSql(sql11);
        List<Object[]> object12 = fpxexdDao.findByCustomSql(sql12);
        double sum = 0;
        for(int i =0;i<object11.size();i++){
            sum += Double.valueOf((object11.get(i)+""))*Double.valueOf(object12.get(i)+"");
        }
        System.out.println("贷款加权平均利率"+(sum/(double)result[0]));
        resultMap.put("daiKuanPingJunLiLv",(sum/(double)result[0]));
        //9.支持带动贫困人口数 (已经贷款了的)
        String sql5 = "select count(distinct daiKuanRenCardId) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        System.out.println(sql5);
        List<Object[]> object5 = fpxexdDao.findByCustomSql(sql5);
        Object result5 =object5.get(0);
        System.out.println("查询结果 支持带动贫困人口数:------>"+result5);
        resultMap.put("pinKunRenShu",result5);
        //10.户均授信额度（所有）(double)result[0]
        String sql6 ="select count(DISTINCT familyNo) from base_information where cardId in(select DISTINCT daiKuanRenCardId from base_fpxexd)";
        String sql7 = "select sum(fuPinshouXinEDu) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        System.out.println(sql6);
        System.out.println(sql7);
        List<Object[]> object6 = fpxexdDao.findByCustomSql(sql6);
        Object result6 =object6.get(0);
        List<Object[]> object7 = fpxexdDao.findByCustomSql(sql7);
        Object result7 =object7.get(0);
        System.out.println("查询结果 户均授信额度:------>"+((double)result7/Integer.valueOf(result6.toString())));
        resultMap.put("huJunShouXinEDu",(double)result7/Integer.valueOf(result6.toString()));
        //11.户均贷款额度(所有)
        String sql8 = "select sum(fuPinXiaoDaidaiKuanJinE) from base_fpxexd where fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        List<Object[]> object8 = fpxexdDao.findByCustomSql(sql8);
        Object result8 =object8.get(0);
        System.out.println("查询结果 户均贷款余额----->"+((double)result8/Integer.valueOf(result6.toString())));
        resultMap.put("huJunDaiKuanYuE",(double)result8/Integer.valueOf(result6.toString()));
        //12.逾期笔数(时间内)
        String sql9="select count(fuPinyuQiDaiKuanJinE) from base_fpxexd where fuPinyuQiDaiKuanJinE>0 and fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        List<Object[]> object9 = fpxexdDao.findByCustomSql(sql9);
        Object result9 =object9.get(0);
        System.out.println("查询结果 预期笔数---->"+result9);
        resultMap.put("yuQiBiShu",result9);
        //13.欠息笔数  (时间内)
        String sql10="select count(fuPinqianXiJinE) from base_fpxexd where fuPinqianXiJinE>0 and fuPinfangKuanRiQi BETWEEN '"+beginDate+"' and '"+endDate+"'";
        List<Object[]> object10 = fpxexdDao.findByCustomSql(sql10);
        Object result10 =object10.get(0);
        System.out.println("查询结果 欠息笔数---->"+result10);
        resultMap.put("qianXiBiShu",result10);
        resultMap.put("note"," ");
        return resultMap;
    }

    /**
     * 将统计好的数据封装成电子表格导出
     */
    public SXSSFWorkbook exportStatistical(String beginDate,String endDate){
        Map<String,Object> map = statistical(beginDate,endDate);
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet =workbook.createSheet("信息表");
        List<String> bt = new ArrayList<>();
        bt.add("序号");
        bt.add("累计投放额度");
        bt.add("新增投放额");
        bt.add("净增额");
        bt.add("较去同期增减");
        bt.add("同比增速");
        bt.add("较年初增减");
        bt.add("较年初增速");
        bt.add("贷款笔数");
        bt.add("贷款加权平均利率");
        bt.add("支持带动贫困人口数");
        bt.add("户均授信额度");
        bt.add("户均贷款额度");
        bt.add("逾期笔数");
        bt.add("欠息笔数");
        bt.add("备注");
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        Row row = sheet.createRow(0);
        //设置这一行的行高
        row.setHeight((short)1000);
        //单元格合并 firstRow 开始行数 结束行数   开始单元格  结束单元格
        CellRangeAddress region1 = new CellRangeAddress(0,0,0,15);
        sheet.addMergedRegion(region1);;
        //单元格添加内容
        Cell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue(beginDate+"-"+endDate+"金融扶贫小额信贷统计表");
        Row row2 = sheet.createRow(1);
        for(int i=0;i<bt.size();i++){
            Cell cell2 = row2.createCell(i);
            sheet.setColumnWidth(i, 256*30);
            cell2.setCellStyle(style);
            cell2.setCellValue(bt.get(i));
        }
        Row row3 = sheet.createRow(2);
        int number =0;
        for(String key:map.keySet()){
            Cell cell3 = row3.createCell(number);
            cell3.setCellStyle(style);
            cell3.setCellValue(map.get(key)+"");
            number++;
        }
        return workbook;
    }
}
