package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.FpbxDao;
import com.ky.ct.rzdj.model.BaseFpb;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.fpbxDaoChu.FpbxDaoChu;
import com.ky.ct.rzdj.util.fpbxDaoChu.FpbxDaoChu2;
import com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu.QtgrzjfpdkDaoChu;
import com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu.QtgrzjfpdkDaoChu2;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FpbxService {
    @Autowired
    private FpbxDao fpbxDao;
    private List<BaseFpb> baseFpbs = new ArrayList<>();
    /**
     *  分页扶贫保险
     */
    public Map<String,Object> findFpbxPage(int page, int limit){
        List<BaseFpb> baseFpbs = new ArrayList<>();
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(user.getRole()==1){
            baseFpbs = fpbxDao.findPage(page,limit);
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("shuJuWeiHuDanWei",user.getType());
            baseFpbs = fpbxDao.findPageByCondition(page,limit,paramMap);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("data",baseFpbs);
        return map;
    }

    /**
     * 获取数据的总条数
     */
    public long getCount(){
        RzdjUserEntity user = (RzdjUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        long count = 0;
        if(user.getRole()==1){
            count  =(long) fpbxDao.getCount();
        }else{
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("shuJuWeiHuDanWei",user.getType());
            count = (long) fpbxDao.getCount(paramMap);
        }
        return count;
    }

    /**
     * 按条件查询
     */
    public List<BaseFpb> findFpbxWhere(Map<String,Object> map,int page,int limit){
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
        List<BaseFpb> baseFpbs = fpbxDao.findPageByCondition(page,limit,parmMap);
        return baseFpbs;
    }

    /**
     * 根据编号查看具体信息
     */
    public BaseFpb findByNo(int no){
        return fpbxDao.findById(no);
    }

    /**
     * 根据cardId删除
     */
    public boolean delByNo(int no){
        return fpbxDao.deleteById(no);
    }

    /**
     * 更新数据
     */
    public boolean updateSingle(BaseFpb baseFpb){
        boolean b = fpbxDao.update(baseFpb);
        return b;
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
        baseFpbs = fpbxDao.findByCondition(parmMap);
        System.out.println("baseQtgrjzfpxkdAll----->"+baseFpbs);
    }

    /**
     * 根据选择的字段导出数据
     */
    public SXSSFWorkbook chooseFieldExport(List<String> fields){
        //将前端传递过来的字段排序
        Map<String,String> fieldsMap = FpbxDaoChu.getFpbxField();
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
        FpbxDaoChu2 daoChu2 = new FpbxDaoChu2();
        Map<String,Integer> numberMap = daoChu2.getNumber(fiedsList);
        Sheet sheet = daoChu2.getSheet(fieldsMap,fiedsList,numberMap,workbook);
        if(baseFpbs!=null&&baseFpbs.size()>0){
            daoChu2.EncapsulateData(sheet,fiedsList,baseFpbs,workbook);
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
        Map<String,String> fieldsMap = FpbxDaoChu.getFpbxField();
        FpbxDaoChu2 daoChu2 = new FpbxDaoChu2();
        //获取所有字段
        List<String>names = new ArrayList<>();
        for(String key:fieldsMap.keySet()){
            names.add(key);
        }
        System.out.println("names----->"+names);
        Map<String,Integer> numberMap = new HashMap<>();
        numberMap.put("b",3);
        numberMap.put("bf",9);
        numberMap.put("lp",16);
        numberMap.put("js",23);
        numberMap.put("l",3);
        Sheet sheet = daoChu2.getSheet(fieldsMap,names,numberMap,workbook);
        List<BaseFpb> baseFpbs = fpbxDao.findAll();
        daoChu2.EncapsulateData(sheet,names,baseFpbs,workbook);
        return workbook;
    }
}
