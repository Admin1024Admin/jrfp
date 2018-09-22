package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhHistoryDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkHistoryDao;
import com.ky.ct.rzdj.dao.QtgrjzpfdkDao;
import com.ky.ct.rzdj.model.*;
import com.ky.ct.rzdj.util.*;
import com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu.QtgrzjfpdkDaoChu;
import com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu.QtgrzjfpdkDaoChu2;
import com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu.QtgrzjfpdkLuRu;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class QtgrjzfpdkService {
    @Autowired
    private QtgrjzpfdkDao qtgrjzpfdkDao;
    @Autowired
    private QtgrjzfpdkDdpkhDao qtgrjzfpdkDdpkhDao;
    @Autowired
    private QtgrjzfpdkHistoryService qtgrjzfpdkHistoryService;
    @Autowired
    private QtgrjzfpdkHistoryDao qtgrjzfpdkHistoryDao;
    private List<BaseQtgrjzfpdk> baseQtgrjzfpxkdAll = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *  分页个人精准扶贫
     */
    public Map<String,Object> findQtgrjzpfdkPage(int page, int limit){
        List<BaseQtgrjzfpdk> baseQtgrjzfpdks = new ArrayList<>();
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(user.getRole()==1){
            baseQtgrjzfpdks = qtgrjzpfdkDao.findPage(page,limit);
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("shuJuWeiHuDanWei",user.getType());
            baseQtgrjzfpdks = qtgrjzpfdkDao.findPageByCondition(page,limit,paramMap);
        }
        for(BaseQtgrjzfpdk b:baseQtgrjzfpdks){
            switch(b.getZhuTiDaiKuanLeiBie()){
                case "家庭农场贷款":{
                    b.setT1("√");
                    b.setT2("");
                    b.setT3("");
                    break;
                }
                case "农业专业大户贷款":{
                    b.setT1("");
                    b.setT2("√");
                    b.setT3("");
                    break;
                }
                case "其他":{
                    b.setT1("");
                    b.setT2("");
                    b.setT3("√");
                    break;
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",baseQtgrjzfpdks);
        return map;
    }

    /**
     * 获取数据的总条数
     */
    public long getCount(){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        long count = 0;
        if(user.getRole()==1){
            count  =(long) qtgrjzpfdkDao.getCount();
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("shuJuWeiHuDanWei",user.getType());
            count = (long) qtgrjzpfdkDao.getCount(paramMap);
        }
        return count;
    }

    /**
     * 按条件查询
     */
    public List<BaseQtgrjzfpdk> findFpxexdWhere(Map<String,Object> map,int page,int limit){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        Map<String,Object> parmMap = new HashMap<>();
        for(String key:map.keySet()){
            if(map.get(key)!=null&&!"".equals(map.get(key))&&!"page".equals(key)&&!"limit".equals(key)){
                parmMap.put(key,map.get(key));
            }
        }
        if(user.getRole()!=1){
            parmMap.put("shuJuWeiHuDanWei",user.getType());
        }
        List<BaseQtgrjzfpdk> baseQtgrjzfpdk = qtgrjzpfdkDao.findPageByCondition(page,limit,parmMap);
        return baseQtgrjzfpdk;
    }

    /**
     * 根据编号查看具体信息
     */
    public BaseQtgrjzfpdk findByNo(int no){
        return qtgrjzpfdkDao.findById(no);
    }

    /**
     * 根据cardId删除
     */
    public boolean delByNo(int no){
        return qtgrjzpfdkDao.deleteById(no);
    }

    /**
     * 更新数据
     */
    public boolean updateSingle(BaseQtgrjzfpdk baseQtgrjzfpdk){
        boolean b = qtgrjzpfdkDao.update(baseQtgrjzfpdk);
        return b;
    }

    /**
     * 据贷款合同编号和贷款机构和投放日期和偿还贷款时间是否存在该用户
     */
    public BaseQtgrjzfpdk fingByNoAndJiGouAndTouDateAndChangDate(String agreementNo, String daiKuanJinRongJiGou, String touFangDate, String changHuanDate ){
        Map<String,Object> whereMap = new HashMap<>();
        whereMap.put("agreementNo",agreementNo);
        whereMap.put("daiKuanJinRongJiGou",daiKuanJinRongJiGou);
        whereMap.put("touFangDate",touFangDate);
        whereMap.put("changHuanDate",changHuanDate);
        List<BaseQtgrjzfpdk> list = qtgrjzpfdkDao.findByCondition(whereMap);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
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
        baseQtgrjzfpxkdAll = qtgrjzpfdkDao.findByCondition(parmMap);
        System.out.println("baseQtgrjzfpxkdAll----->"+baseQtgrjzfpxkdAll);
    }

    /**
     * 根据选择的字段导出数据
     */
    public SXSSFWorkbook chooseFieldExport(List<String> fields){
        //将前端传递过来的字段排序
        Map<String,String> fieldsMap = QtgrzjfpdkDaoChu.getPkfDzbField();
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
       QtgrzjfpdkDaoChu2 daoChu2 = new QtgrzjfpdkDaoChu2();
        Map<String,Integer> numberMap = daoChu2.getNumber(fiedsList);
        Sheet sheet = daoChu2.getSheet(fieldsMap,fiedsList,numberMap,workbook);
        if(baseQtgrjzfpxkdAll!=null&&baseQtgrjzfpxkdAll.size()>0){
            daoChu2.EncapsulateData(sheet,fiedsList,baseQtgrjzfpxkdAll,workbook,qtgrjzfpdkDdpkhDao);
        }else{
            System.out.println("----结束-----");
        }
        return workbook;
    }
    /**
     * 导出全部数据
     */
    public SXSSFWorkbook daoChuAll(){
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        //获取全部字段
        Map<String,String> fieldsMap = QtgrzjfpdkDaoChu.getPkfDzbField();
        QtgrzjfpdkDaoChu2 daoChu2 = new QtgrzjfpdkDaoChu2();
        //获取所有字段
        List<String>names = new ArrayList<>();
        for(String key:fieldsMap.keySet()){
            names.add(key);
        }
        System.out.println("names----->"+names);
        Map<String,Integer> numberMap = new HashMap<>();
        numberMap.put("t",4);
        numberMap.put("c",4);
        numberMap.put("d",16);
        numberMap.put("tf",19);
        numberMap.put("ch",23);
        numberMap.put("js",39);
        Sheet sheet = daoChu2.getSheet(fieldsMap,names,numberMap,workbook);
        List<BaseQtgrjzfpdk> baseQtgrjzfpdks = qtgrjzpfdkDao.findAll();
        daoChu2.EncapsulateData(sheet,names,baseQtgrjzfpdks,workbook,qtgrjzfpdkDdpkhDao);
        return workbook;
    }

    /**
     *  上传Excel导入数据
     */
    public boolean loadExcel(MultipartFile file, String fileName){
        //从session中获取用户对象
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        boolean b = false;
        Workbook wb = null;
        List<BaseQtgrjzfpdkHistory> histories = new ArrayList<>();
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
                    Row r = sheet.getRow(1);
                    Row r2 = sheet.getRow(2);
                    //getPhysicalNumberOfCells 是获取不为空的列个数。
                    //getLastCellNum 是获取最后一个不为空的列是第几个。
                    System.out.println("第二行不为空的列数----->"+r.getPhysicalNumberOfCells());
                    System.out.println("第三行行不为空的列数----->"+r2.getPhysicalNumberOfCells());
                    //获取字段在数据库的字段名和在excel中的中文名的Map.
                    Map<String,String> fields=QtgrzjfpdkDaoChu.getPkfDzbField();
                    //遍历获取单元格数据并比较excel中的字段以及对应的数据库字段名是什么
                    List<String> fieldNames = new ArrayList<>();
                    //第二行单元格内容
                    for(int i=0;i<r.getLastCellNum();i++){
                        if(r.getCell(i)==null){
                            continue;
                        }
                        String name = r.getCell(i).getStringCellValue();
                        System.out.println("表格列的名字------>"+name);
                        //.将对应的数据库字段名放入list集合，为了解决表头列名有重复的情况
                        Map<String,String> copyFields = fields;
                        copyFields.remove("uid");
                        for(String key:copyFields.keySet()){
                            if(fields.get(key).equals(name.trim())){
                                System.out.println("name----->"+name+"   key------>"+key);
                                fieldNames.add(key);
                                copyFields.remove(key);
                                break;
                            }
                        }
                    }
                    //第三行单元格内容
                    for(int i=0;i<r2.getLastCellNum();i++){
                        if(r2.getCell(i)==null){
                            continue;
                        }
                        String name = r2.getCell(i).getStringCellValue();
                        System.out.println("第三行表格列的名字------>"+name);
                        //.将对应的数据库字段名放入list集合，为了解决表头列名有重复的情况
                        Map<String,String> copyFields = fields;
                        copyFields.remove("uid");
                        for(String key:copyFields.keySet()){
                            if(fields.get(key).equals(name.trim())){
                                System.out.println("name----->"+name+"   key------>"+key);
                                fieldNames.add(key);
                                copyFields.remove(key);
                                break;
                            }
                        }
                    }
                    System.out.println("excel上传过来的字段有------>"+fieldNames);

                    //将表头的字段传递过来的字段排序
                    Map<String,String> fieldsMap = QtgrzjfpdkDaoChu.getPkfDzbField();
                    List<String> fiedsList = new ArrayList<>();
                    for (String key : fieldsMap.keySet()) {
                        for(String field:fieldNames){
                            if(field.equals(key)){
                                fiedsList.add(key);
                            }
                        }
                    }
                    System.out.println("排序后的字段---->"+fiedsList);

                    //获取excel数据  从第三列开始。。第三列才是数据的开始
                    //将excel数据封装为一个BaseFpxexd对象 放入一个List集合
                    //List<BaseFpxexd> baseFpxexds = new ArrayList<>();
                    List<BaseQtgrjzfpdkHistory> qtgrjzfpdkHistories = new ArrayList<>();
                    System.out.println("表格的行数有---->"+sheet.getLastRowNum());
                    int rows = sheet.getLastRowNum();
                    for (int rs = 4; rs < rows; rs++) {
                        Row row = sheet.getRow(rs);
                        if (row == null){
                            continue;
                        }
                        BaseQtgrjzfpdkHistory q = new BaseQtgrjzfpdkHistory();
                        System.out.println("字段个数--------->"+fiedsList.size());
                        int number = 0;
                        for(int i=1;i<fiedsList.size();i++){
                            String value = "";
                            if(row.getCell(i)!=null){
                                if(row.getCell(i).getCellType()== Cell.CELL_TYPE_NUMERIC){
                                    if (XSSFDateUtil.isCellDateFormatted(row.getCell(i))) {  //判断日期类型
                                        value = new SimpleDateFormat("yyyy-MM-dd").format(XSSFDateUtil.getJavaDate(row.getCell(i).getNumericCellValue()));
                                    }else{
                                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                                        value = row.getCell(i).getStringCellValue();
                                    }
                                }else{
                                    if("zhuTiDaiKuanLeiBie".equals(fiedsList.get(number))){
                                        System.out.println("进来啦...........");
                                        if(row.getCell(number)!=null){
                                            value = row.getCell(number).getStringCellValue();
                                        }
                                        if( row.getCell(number+1)!=null){
                                            value = row.getCell(number+1).getStringCellValue();
                                        }
                                        if( row.getCell(number+2)!=null){
                                            value = row.getCell(number+2).getStringCellValue();
                                        }
                                        i+=2;
                                    }else{
                                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                                        value = row.getCell(i).getStringCellValue();
                                    }
                                }
                            }else{
                                value="";
                            }
                            System.out.println("第"+rs+"行第"+i+"个单元格"+fiedsList.get(number)+"数据value---->"+value);
                            q = QtgrzjfpdkLuRu.luRu(q,fiedsList.get(number),value);
                            number++;
                        }
                        System.out.println("q------->"+q);
                        //baseFpxexds.add(f);
                        qtgrjzfpdkHistories.add(q);
                    }
                    for(BaseQtgrjzfpdkHistory history:qtgrjzfpdkHistories){
                        BaseQtgrjzfpdkHistory qh = qtgrjzfpdkHistoryService.fingByNoAndJiGouAndTouDateAndChangDate(history.getAgreementNo(),history.getDaiKuanJinRongJiGou(),sdf.format(history.getTouFangDate()),sdf.format(history.getChangHuanDate()));
                        if(qh!=null){
                            BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory = (BaseQtgrjzfpdkHistory) TwoObjectUtil.copyToFpxexdNotEmpty(history,qh);
                            baseQtgrjzfpdkHistory.setUid(qh.getUid());
                            b = qtgrjzfpdkHistoryDao.update(baseQtgrjzfpdkHistory);
                            System.out.println("更新单条结果---->"+b);
                        }else{
                            //设置默认的操作
                            history.setOperationPerson(user.getName());
                            history.setCheckStatus("未审核");
                            history.setOperation("新增");
                            history.setDelStatus("未删除");
                            history.setShuJuWeiHuDanWei(user.getType());
                            b = qtgrjzfpdkHistoryDao.add(history);
                            System.out.println("录入单条结果---->"+b);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

}
