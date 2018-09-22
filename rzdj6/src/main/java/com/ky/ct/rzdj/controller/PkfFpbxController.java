package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.PkfFpbxDao;
import com.ky.ct.rzdj.dto.Msg;
import com.ky.ct.rzdj.model.PkfDzbEntity;
import com.ky.ct.rzdj.model.PkfFpbEntity;
import com.ky.ct.rzdj.util.PkfDzbDaochu;
import com.ky.ct.rzdj.util.PkfFpbxDaochu;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class PkfFpbxController {
    @Autowired
    private PkfFpbxDao pkfFpbxDao;
    List<PkfFpbEntity> lists = null;
    /**
     * 跳转信息页面
     */
    @GetMapping("/pkfFpbx")
    public String pkfDzb(Map<String,Object> map){
        long count =(long) pkfFpbxDao.getCount();
        map.put("page",1);
        map.put("limit",15);
        map.put("count",count);
        return "admin/poor/fpbx/pkfFpbx";
    }
    /**
     * 分页查询
     */
    @GetMapping("/pkfFpbxPage")
    @ResponseBody
    public String findPkfInformationPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                         @RequestParam(name="limit",required = false,defaultValue = "15")int limit,Map<String,Object> map){
        //分页查询
        List<PkfFpbEntity> pkfFpbEntities= pkfFpbxDao.findPage(page,limit);
        //获取总数
        long count =(long) pkfFpbxDao.getCount();
        Map<String,Object> map2  = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pkfFpbEntities);
        JSONObject jsonObject = JSONObject.fromObject(map);
        map.put("page",page);
        map.put("limit",limit);
        map.put("count",count);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }
    /**
     * 根据id查看信息
     */
    @GetMapping("/getPkfFpbx")
    public String viewPoor(@RequestParam("uid")Long uid,
                           @RequestParam(name="cz",required = false,defaultValue = "1")int cz,Map<String,Object> map){
        System.out.println("uid:"+uid);
        PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findById(uid);
        System.out.println(pkfFpbEntity);
        map.put("pkfFpbx",pkfFpbEntity);
        if(cz==2){
            return "admin/poor/fpbx/updatePkfFpbx";
        }
        return "admin/poor/fpbx/viewPkfFpbx";
    }
    /**
     * 根据uid更新
     */
    @PostMapping("/updatePkfFpbx")
    public String updatePkfInformation(PkfFpbEntity pkfFpbEntity, Map<String,Object> map){
        System.out.println(pkfFpbEntity);
        boolean b = pkfFpbxDao.update(pkfFpbEntity);
        if(b){
            System.out.println("更新成功");
            return "redirect:pkfFpbx";
        }else{
            map.put("Msg",new Msg(0,"更新失败！！！请稍后重试！！！"));
            System.out.println("更新失败！！！");
            return "redirect:getPkfFpbx?uid="+pkfFpbEntity.getUid()+"&cz=2";
        }
    }
    /**
     * 根据id删除
     */
    @GetMapping("/delPkfFpbx")
    @ResponseBody
    public String del(@RequestParam("uid")Long uid,Map<String,Object> map){
        Boolean b = pkfFpbxDao.deleteById(uid);
        if(uid!=null){
            System.out.println("删除成功");
            return "删除成功！！！";
        }
        return "删除失败！！！";
    }
    /**
     * 条件查询
     */
    @ResponseBody
    @PostMapping("/findPkfFpbxWhere")
    public String findPkfDzbWhere(PkfFpbEntity p,@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                  @RequestParam(name="limit",required = false,defaultValue = "15")int limit,Map<String,Object> map3){
        String whereSql = null;
        System.out.println("p：--------"+p);
        Object count = null;
        if("".equals(p.getHuiJiaoRen())&&"".equals(p.getBeiBaoRen())&&"".equals(p.getCardId())){
            whereSql = "select * from pkf_fpb";
            String hql = "select * from pkf_fpb limit "+(page-1)*limit+","+limit;
            lists = pkfFpbxDao.findListBySql(hql);
            count = pkfFpbxDao.getCount();
        }else{
            String huiJiaoRen = p.getHuiJiaoRen();
            String beiBaoRen = p.getBeiBaoRen();
            String cardId = p.getCardId();

            Map<String,Object> map = new HashMap<>();
            if(huiJiaoRen!=null&&!"".equals(huiJiaoRen)){
                map.put("huiJiaoRen",huiJiaoRen);
            }
            if(beiBaoRen!=null&&!"".equals(beiBaoRen)){
                map.put("beiBaoRen",beiBaoRen);
            }
            if(cardId!=null&&!"".equals(cardId)){
                map.put("cardId",cardId);
            }

            StringBuffer sql = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            sql.append("select * from pkf_fpb where ");
            sb.append("select count(*) from pkf_fpb where ");
            Iterator<String> it = map.keySet().iterator(); // 迭代map
            while (it.hasNext()) {
                String key = it.next(); // 获取条件map中的key，即条件字段
                sql.append(key+"="+"'"+map.get(key)+"'"+" and ");
                sb.append(key+"="+"'"+map.get(key)+"'"+" and ");
            }
            String sql2 = sql.toString().substring(0,sql.length()-4);
            whereSql = sql2;
            String sql3 = sb.toString().substring(0,sb.length()-4);
            sql2+="limit "+(page-1)*limit+","+limit;
            System.out.println("sql:"+sql2);
            lists = pkfFpbxDao.findListBySql(sql2);
            count = pkfFpbxDao.findBySql2(sql3);
        }
        if(lists!=null&&lists.size()>0){
            Map<String,Object> map2  = new HashMap();
            map2.put("code",0);
            map2.put("msg","");
            map2.put("count",count);
            map2.put("data",lists);
            JSONObject jsonObject = JSONObject.fromObject(map2);
            System.out.println(jsonObject);
            map3.put("page",1);
            map3.put("limit",15);
            map3.put("count",lists.size());
            return jsonObject.toString();
        }
        map3.put("msg",new Msg(0,"没有相关的数据，请重新设置查询条件"));
        return null;
    }

    @GetMapping("/PkfFpbxField")
    public String field(){
        return "admin/poor/fpbx/field";
    }
    /**
     * 导出跳转到选择字段页面
     * @return
     */
    @PostMapping("/PkfFpbxField")
    public String field2(PkfFpbEntity p) {
        String whereSql = null;
        System.out.println("p：--------"+p);
        if("".equals(p.getHuiJiaoRen())&&"".equals(p.getBeiBaoRen())&&"".equals(p.getCardId())){
            whereSql = "select * from pkf_fpb";
            lists = pkfFpbxDao.findListBySql(whereSql);
        }else{
            String huiJiaoRen = p.getHuiJiaoRen();
            String beiBaoRen = p.getBeiBaoRen();
            String cardId = p.getCardId();

            Map<String,Object> map = new HashMap<>();
            if(huiJiaoRen!=null&&!"".equals(huiJiaoRen)){
                map.put("huiJiaoRen",huiJiaoRen);
            }
            if(beiBaoRen!=null&&!"".equals(beiBaoRen)){
                map.put("beiBaoRen",beiBaoRen);
            }
            if(cardId!=null&&!"".equals(cardId)){
                map.put("cardId",cardId);
            }

            StringBuffer sql = new StringBuffer();
            sql.append("select * from pkf_fpb where ");
            Iterator<String> it = map.keySet().iterator(); // 迭代map
            while (it.hasNext()) {
                String key = it.next(); // 获取条件map中的key，即条件字段
                sql.append(key+"="+"'"+map.get(key)+"'"+" and ");
            }
            String sql2 = sql.toString().substring(0,sql.length()-4);
            whereSql = sql2;
            System.out.println("sql:"+sql2);
            lists = pkfFpbxDao.findListBySql(sql2);
        }
        return "admin/poor/fpbx/field";
    }

    /**
     * 选择字段和条件导出
     */
    @ResponseBody
    @GetMapping("/daochuPkfFpbx")
    public void daochu2(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //获取字段表字段Map
        PkfFpbxDaochu daochu = new PkfFpbxDaochu();
        //获取前台传递过来的参数
        long startTime2 = System.currentTimeMillis();   //获取开始时间
        Enumeration enumeration = request.getParameterNames();
        Map<String,Object> map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String paramValue =request.getParameter(paramName);
            //形成键值对应的map
            map.put(paramName, paramValue);
        }
        List<String> fields = new ArrayList<>();
        for (String key : map.keySet()) {
            // System.out.println(key + ":" + map.get(key));
            fields.add(key);
        }
        long endTime2 = System.currentTimeMillis();    //获取结束时间

        System.out.println("前台获取参数程序运行时间：" + (endTime2 - startTime2) + "ms");    //输出程序运行时间'
        //设置表头
        Map<String,String> fieldsMap = daochu.getPkfFpbxField();
        List<String> fieds2 = new ArrayList<>();
        for (String key : fieldsMap.keySet()) {
            System.out.println("key"+key);
            for(String field:fields){
                if(field.equals(key)){
                    fieds2.add(key);
                }
            }
        }
        System.out.println("-----------------"+fieds2);
//        //创建数据表
        // 内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = daochu.getSheet(fieldsMap,fieds2,workbook);
        //1.先获取到记录的条数
        long count =(long)pkfFpbxDao.getCount();
        //2.每次查询1000条数据封装表格
        int y = 1;//代表创建的表格是第几行
        int page =(int)(count/5000)+1;
        if(lists!=null&&lists.size()>0){
            System.out.println("lists"+lists);
            daochu.Listdaochu2(sheet,fieds2,lists);
        }else {
            daochu.Listdaochu(sheet, page, 5000, fieds2, pkfFpbxDao);
        }
        //导出文件
        String fileName = "information"+ ".xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
