package com.ky.ct.rzdj.controller;


import com.ky.ct.rzdj.dao.PkfDzbDao;
import com.ky.ct.rzdj.dao.PkfFpbxDao;
import com.ky.ct.rzdj.dao.PkfInformationDao;
import com.ky.ct.rzdj.dao.PkfPjsxDao;
import com.ky.ct.rzdj.dto.Msg;

import com.ky.ct.rzdj.model.PkfDzbEntity;
import com.ky.ct.rzdj.model.PkfFpbEntity;
import com.ky.ct.rzdj.model.PkfInformationEntity;
import com.ky.ct.rzdj.model.PkfPjsxEntity;
import com.ky.ct.rzdj.util.Daochu;
import com.ky.ct.rzdj.util.Fields;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

@Controller
public class PkfInformationController {

    @Autowired
    private PkfInformationDao pkfInformationDao;
    @Autowired
    private PkfDzbDao pkfDzbDao;
    @Autowired
    private PkfFpbxDao pkfFpbxDao;
    @Autowired
    private PkfPjsxDao pkfPjsxDao;
    private String loadSql="";
    List<PkfInformationEntity> tiaoJianDaoChuInfoList=null;
    /**
     * 信息表
     * @param map
     * @return
     */
    @GetMapping("/pkfInformation")
    public String peopleMessage(Map<String,Object> map){
        long count =(long) pkfInformationDao.getCount();
        map.put("page",1);
        map.put("limit",15);
        map.put("count",count);
        return "admin/poor/infor/pkfInformation";
    }

    /**
     * 分页请求
     * @param page
     * @param limit
     * @param map2
     * @return
     */
    @GetMapping("/pkfInformationPage")
    @ResponseBody
    public String findPkfInformationPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                         @RequestParam(name="limit",required = false,defaultValue = "15")int limit,Map<String,Object> map2){
        List<PkfInformationEntity> pkfInformationEntities =  pkfInformationDao.findPage(page,limit);
        long count =(long) pkfInformationDao.getCount();
        System.out.println("总有"+count);
        Map<String,Object> map  = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pkfInformationEntities);
        JSONObject jsonObject = JSONObject.fromObject(map);
        map2.put("page",page);
        map2.put("limit",limit);
        map2.put("count",count);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }

    /**
     * 导出跳转到选择字段页面
     * @return
     */
    @GetMapping("/field")
    public String field(){
        return "admin/poor/infor/field";
    }

    @GetMapping("/fields")
    public String fields(@RequestParam("cardId") String cardId,Map<String,Object> map){
        System.out.println("身份证号："+cardId);
        map.put("cardId",cardId);
        return "admin/poor/jrfp/fields";
    }
    /**
     * 导出跳转到选择字段页面
     * @return
     */
    @PostMapping("/field")
    public String field2(PkfInformationEntity p) {
        String loadSql2 = "";
        System.out.println("pkfInformationEntityS" + p);
        List<PkfInformationEntity> lists = null;
        if ("".equals(p.getXiangZheng()) && "".equals(p.getChun()) && "".equals(p.getShe()) && "".equals(p.getName()) &&
                "".equals(p.getCardId()) && "".equals(p.getTelephone()) && "".equals(p.getXueLi()) && "".equals(p.getSchoolState()) &&
                "".equals(p.getHealthState()) && "".equals(p.getSkill()) && "".equals(p.getWorkState()) && "".equals(p.getWorkMonth()) &&
                "".equals(p.getPinKunState()) && "".equals(p.getPinKunYuanYin()) && "".equals(p.getTuoPinState())) {
            loadSql2 = "select * from pkf_information";
            tiaoJianDaoChuInfoList = pkfInformationDao.findListBySql(loadSql2);
        } else {
            String xiangZheng = p.getXiangZheng();
            String chun = p.getChun();
            String she = p.getShe();
            String name = p.getName();
            String cardId = p.getCardId();
            String telephone = p.getTelephone();
            String xueLi = p.getXueLi();
            String schoolState = p.getSchoolState();
            String healthState = p.getHealthState();
            String skill = p.getSkill();
            String workState = p.getWorkState();
            String workMonth = p.getWorkMonth();
            String pinKunState = p.getPinKunState();
            String tuoPinState = p.getTuoPinState();
            String pinKunYuanYin = p.getPinKunYuanYin();

            Map<String, Object> map = new HashMap<>();
            if (xiangZheng != null && !"".equals(xiangZheng)) {
                map.put("xiangZheng", xiangZheng);
            }
            if (chun != null && !"".equals(chun)) {
                map.put("chun", chun);
            }
            if (she != null && !"".equals(she)) {
                map.put("she", she);
            }
            if (name != null && !"".equals(name)) {
                map.put("name", name);
            }
            if (cardId != null && !"".equals(cardId)) {
                map.put("cardId", cardId);
            }
            if (telephone != null && !"".equals(telephone)) {
                map.put("telephone", telephone);
            }
            if (xueLi != null && !"".equals(xueLi)) {
                map.put("xueLi", xueLi);
            }
            if (schoolState != null && !"".equals(schoolState)) {
                map.put("schoolState", schoolState);
            }
            if (healthState != null && !"".equals(healthState)) {
                map.put("healthState", healthState);
            }
            if (skill != null && !"".equals(skill)) {
                map.put("skill", skill);
            }
            if (workState != null && !"".equals(workState)) {
                map.put("workState", workState);
            }
            if (workMonth != null && !"".equals(workMonth)) {
                map.put("workMonth", workMonth);
            }
            if (pinKunState != null && !"".equals(pinKunState)) {
                map.put("pinKunState", pinKunState);
            }
            if (tuoPinState != null && !"".equals(tuoPinState)) {
                map.put("tuoPinState", tuoPinState);
            }
            if (pinKunYuanYin != null && !"".equals(pinKunYuanYin)) {
                map.put("pinKunYuanYin", pinKunYuanYin);
            }

            StringBuffer sql = new StringBuffer();
            sql.append("select * from pkf_information where ");
            Iterator<String> it = map.keySet().iterator(); // 迭代map
            while (it.hasNext()) {
                String key = it.next(); // 获取条件map中的key，即条件字段
                sql.append(key + "=" + "'" + map.get(key) + "'" + "and ");
            }
            String sql2 = sql.toString().substring(0, sql.length() - 4);
            System.out.println("sql:" + sql2);
            tiaoJianDaoChuInfoList = pkfInformationDao.findListBySql(sql2);
            System.out.println("===="+tiaoJianDaoChuInfoList);
            return "admin/poor/infor/field";
        }
        return  "";
    }

    /**
     * 跳转到查看页面
     * 根据uid查询
     * @return
     */
    @GetMapping("/getPkfInformation")
    public String viewPoor(@RequestParam("uid")Long uid,
                           @RequestParam(name="cz",required = false,defaultValue = "1")int cz,Map<String,Object> map){
        System.out.println("uid:"+uid);
        PkfInformationEntity pkfInformationEntity = pkfInformationDao.findById(uid);
        System.out.println(pkfInformationEntity);
        map.put("pkfInformation",pkfInformationEntity);
        if(cz==2){
            return "admin/poor/updatePkfInformation";
        }
        return "admin/poor/infor/view_poor";
    }

    /**
     * 根据uid更新
     */
    @PostMapping("/updatePkfInformation")
    public String updatePkfInformation(PkfInformationEntity pkfInformationEntity, Map<String,Object> map){
//        System.out.println("==========================");
//        System.out.println(pkfInformationEntity);
//        System.out.println("==========================");
        boolean b = pkfInformationDao.update(pkfInformationEntity);
        if(b){
            System.out.println("更新成功");
            return "redirect:pkfInformation";
        }else{
            map.put("Msg",new Msg(0,"更新失败！！！请稍后重试！！！"));
            System.out.println("更新失败！！！");
          return "redirect:getPkfInformation?uid="+pkfInformationEntity.getUid()+"&cz=2";
        }
    }

    /**
     * 根据uid删除
     */
    @GetMapping("/delPkfInformation")
    @ResponseBody
    public String del(@RequestParam("uid")Long uid,Map<String,Object> map){
        Boolean b = pkfInformationDao.deleteById(uid);
        if(uid!=null){
            System.out.println("删除成功");
            return "删除成功！！！";
        }
        return "删除失败！！！";
    }

    /**
     * 获取所有村名
     * @return
     */
    @GetMapping("/getChun")
    @ResponseBody
    public String findAllChun(){
       List chuns =  pkfInformationDao.findListBySql2("select distinct Chun from pkf_information");
       JSONArray jsonObject = JSONArray.fromObject(chuns);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }

    /**
     * 根据条件查询
     */
    @ResponseBody
    @PostMapping("/findWhere")
    public String findWhere(PkfInformationEntity p,@RequestParam(name="page",required = false,defaultValue = "1")int page,
                            @RequestParam(name="limit",required = false,defaultValue = "15")int limit,Map<String,Object> map3){
        System.out.println("p：--------"+p);
        Object count = null;
        List<PkfInformationEntity> lists = null;
        if("".equals(p.getXiangZheng())&&"".equals(p.getChun())&&"".equals(p.getShe())&&"".equals(p.getName())&&
            "".equals(p.getCardId())&&"".equals(p.getTelephone())&&"".equals(p.getXueLi())&&"".equals(p.getSchoolState())&&
            "".equals(p.getHealthState())&&"".equals(p.getSkill())&&"".equals(p.getWorkState())&&"".equals(p.getWorkMonth())&&
            "".equals(p.getPinKunState())&&"".equals(p.getPinKunYuanYin())&&"".equals(p.getTuoPinState())){
            loadSql = "select * from pkf_information";
            String hql = "select * from pkf_information limit "+(page-1)*limit+","+limit;
            lists = pkfInformationDao.findListBySql(hql);
            count = pkfInformationDao.getCount();
        }else{
            String xiangZheng = p.getXiangZheng();
            String chun = p.getChun();
            String she = p.getShe();
            String name = p.getName();
            String cardId = p.getCardId();
            String telephone = p.getTelephone();
            String xueLi = p.getXueLi();
            String schoolState = p.getSchoolState();
            String healthState = p.getHealthState();
            String skill = p.getSkill();
            String workState = p.getWorkState();
            String workMonth = p.getWorkMonth();
            String pinKunState = p.getPinKunState();
            String tuoPinState = p.getTuoPinState();
            String pinKunYuanYin = p.getPinKunYuanYin();

            Map<String,Object> map = new HashMap<>();
            if(xiangZheng!=null&&!"".equals(xiangZheng)){
                map.put("xiangZheng",xiangZheng);
            }
            if(chun!=null&&!"".equals(chun)){
                map.put("chun",chun);
            }
            if(she!=null&&!"".equals(she)){
                map.put("she",she);
            }
            if(name!=null&&!"".equals(name)){
                map.put("name",name);
            }
            if(cardId!=null&&!"".equals(cardId)){
                map.put("cardId",cardId);
            }
            if(telephone!=null&&!"".equals(telephone)){
                map.put("telephone",telephone);
            }
            if(xueLi!=null&&!"".equals(xueLi)){
                map.put("xueLi",xueLi);
            }
            if(schoolState!=null&&!"".equals(schoolState)){
                map.put("schoolState",schoolState);
            }
            if(healthState!=null&&!"".equals(healthState)){
                map.put("healthState",healthState);
            }
            if(skill!=null&&!"".equals(skill)){
                map.put("skill",skill);
            }
            if(workState!=null&&!"".equals(workState)){
                map.put("workState",workState);
            }
            if(workMonth!=null&&!"".equals(workMonth)){
                map.put("workMonth",workMonth);
            }
            if(pinKunState!=null&&!"".equals(pinKunState)){
                map.put("pinKunState",pinKunState);
            }
            if(tuoPinState!=null&&!"".equals(tuoPinState)){
                map.put("tuoPinState",tuoPinState);
            }
            if(pinKunYuanYin!=null&&!"".equals(pinKunYuanYin)){
                map.put("pinKunYuanYin",pinKunYuanYin);
            }

            StringBuffer sql = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            sql.append("select * from pkf_information where ");
            sb.append("select count(*) from pkf_information where ");
            Iterator<String> it = map.keySet().iterator(); // 迭代map
            while (it.hasNext()) {
                String key = it.next(); // 获取条件map中的key，即条件字段
                sql.append(key+"="+"'"+map.get(key)+"'"+"and ");
                sb.append(key+"="+"'"+map.get(key)+"'"+"and ");
            }
            String sql2 = sql.toString().substring(0,sql.length()-4);
            loadSql = sql2;
            String sql3 = sb.toString().substring(0,sb.length()-4);
            sql2+="limit "+(page-1)*limit+","+limit;
            System.out.println("sql:"+sql2);
            lists = pkfInformationDao.findListBySql(sql2);
            count = pkfInformationDao.findBySql2(sql3);
            System.out.println(lists.size());
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

    /**
     * 按条件查询导出
     */
    @ResponseBody
    @GetMapping("/load")
    public void load(HttpServletResponse response)throws IOException {
        if("".equals(loadSql)&&loadSql.length()<1){
            response.getWriter().print("<script>alert('请选择条件查询后才可以导出！！！');window.history.go(-1);</script>");
        }else{
            List<PkfInformationEntity> pkfInformationEntityList= pkfInformationDao.findListBySql(loadSql);
            if(pkfInformationEntityList!=null&&pkfInformationEntityList.size()>0){
                XSSFWorkbook workbook = getBook(pkfInformationEntityList);
                //设置要导出的文件的名字
                String fileName = "information"+ ".xls";
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment;filename=" + fileName);
                response.flushBuffer();
                workbook.write(response.getOutputStream());
                response.flushBuffer();
            }else{
                response.getWriter().print("<script>alert('没有任何数据可以导出！！！');window.history.go(-1);</script>");
            }
        }
    }
    @ResponseBody
    @GetMapping("/daochu2")
    public void daochu2(HttpServletRequest request,HttpServletResponse response)throws IOException {
        //获取字段表字段Map
        Daochu daochu = new Daochu();
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
        Map<String,String> fieldsMap = daochu.getField();
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
        long count =(long)pkfInformationDao.getCount();
        //2.每次查询1000条数据封装表格
        int y = 1;//代表创建的表格是第几行
        int page =(int)(count/5000)+1;
        if(tiaoJianDaoChuInfoList!=null&&tiaoJianDaoChuInfoList.size()>0){
            daochu.Listdaochu2(sheet,fieds2,tiaoJianDaoChuInfoList);
        }else {
            daochu.Listdaochu(sheet, page, 5000, fieds2, pkfInformationDao);
        }
        //导出文件
        String fileName = "information"+ ".xls";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 选择字段查看
     */
    @PostMapping("/chooseField")
    public String chooseField(HttpServletRequest request,Map<String,Object> map){
        String sfz = request.getParameter("sfz");
        System.out.println("身份证号码"+sfz);
        List<String> fields = Fields.getFields(request);
        fields.remove("sfz");
        System.out.println("选中的字段"+fields);
//        List<String> p1 = new ArrayList<>();
//        List<String> p2 = new ArrayList<>();
//        List<String> p3 = new ArrayList<>();
//        List<String> p4 = new ArrayList<>();
//        for(String field:fields){
//            if(isInside(PkfInformationEntity.class,field)){
//                p1.add(field);
//            }
//            if(isInside(PkfPjsxEntity.class,field)){
//                p2.add(field);
//            }
//            if(isInside(PkfDzbEntity.class,field)){
//                p3.add(field);
//            }
//            if(isInside(PkfFpbEntity.class,field)){
//                p4.add(field);
//            }
//        }
//        if(p1!=null){
//            StringBuffer sb = new StringBuffer();
//            sb.append("select ");
//            for(String field:p1){
//                sb.append(field+",");
//            }
//            sb = sb.delete(sb.length()-2,sb.length());
//            sb.append(" from pkf_information where CardID=");
//            sb.append("'");
//            sb.append(sfz);
//            sb.append("'");
//            System.out.println("sql+"+sb.toString());
//            Object x = pkfInformationDao.findBySql2(sb.toString());
//            System.out.println("------------------------"+x);
//        }

        //查询所有
        PkfInformationEntity pkfInformationEntity =  pkfInformationDao.findByCardId(sfz);
        PkfPjsxEntity pkfPjsxEntity = pkfPjsxDao.findByCardId(sfz);
        PkfDzbEntity pkfDzbEntity = pkfDzbDao.findByCardId(sfz);
        PkfFpbEntity pkfFpbEntity = pkfFpbxDao.findByCardId(sfz);
        map.put("pkfInformation",pkfInformationEntity);
        map.put("pkfPjsxEntity",pkfPjsxEntity);
        map.put("pkfDzbEntity",pkfDzbEntity);
        map.put("pkfFpbEntity",pkfFpbEntity);
        map.put("fields",fields);

        System.out.println("/返回页面");
        return "admin/poor/infor/view";
    }
    /**
     * 将数据封装成数据表
     */
    public XSSFWorkbook getBook(List<PkfInformationEntity> pkfInformationEntityList){
        //从头开始创建一个新的XSSFworkbook对象。
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("信息表");
        //新增数据行，并且设置单元格数据
        String[] headers = { "编号", "市区旗", "乡镇", "村","社、组","户编号","人编号","姓名","身份证号","家庭成员数","与户主关系","民族"
                ,"文化程度","在校生状况","健康状况","劳动技能","务工状况","务工时间(月)","参加大病医疗","脱贫属性","贫困户属性","主要致贫原因","危房户"
                ,"饮水安全","饮水困难","人均纯收入","联系电话","统计时间","Note1","Note2","Note3","Note4","Note5"};
        //headers表示excel表中第一行的表头
        Row row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            Cell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        int i = 1;

        for(PkfInformationEntity p:pkfInformationEntityList){
            Row row1 = sheet.createRow(i);
            row1.createCell(0).setCellValue(p.getUid());
            row1.createCell(1).setCellValue(p.getShiQuQi());
            row1.createCell(2).setCellValue(p.getXiangZheng());
            row1.createCell(3).setCellValue(p.getChun());
            row1.createCell(4).setCellValue(p.getShe());
            row1.createCell(5).setCellValue(p.getFamilyNo());
            row1.createCell(6).setCellValue(p.getMemberNo());
            row1.createCell(7).setCellValue(p.getName());
            row1.createCell(8).setCellValue(p.getCardId());
            row1.createCell(9).setCellValue(p.getMembers());
            row1.createCell(10).setCellValue(p.getFamilyRelation());
            row1.createCell(11).setCellValue(p.getMz());
            row1.createCell(12).setCellValue(p.getXueLi());
            row1.createCell(13).setCellValue(p.getSchoolState());
            row1.createCell(14).setCellValue(p.getHealthState());
            row1.createCell(15).setCellValue(p.getSkill());
            row1.createCell(16).setCellValue(p.getWorkState());
            row1.createCell(17).setCellValue(p.getWorkMonth());
            row1.createCell(18).setCellValue(p.getIsDaBinYiLiao());
            row1.createCell(19).setCellValue(p.getTuoPinState());
            row1.createCell(20).setCellValue(p.getPinKunState());
            row1.createCell(21).setCellValue(p.getPinKunYuanYin());
            row1.createCell(22).setCellValue(p.getIsWeiFangHu());
            row1.createCell(23).setCellValue(p.getIsYinShuiAnQuan());
            row1.createCell(24).setCellValue(p.getIsYinShuiKunNan());
            row1.createCell(25).setCellValue(p.getRenJunChunShouRu());
            row1.createCell(26).setCellValue(p.getTelephone());
            row1.createCell(27).setCellValue(p.getTongJiShiJian());
            row1.createCell(28).setCellValue(p.getNote1());
            row1.createCell(29).setCellValue(p.getNote2());
            row1.createCell(30).setCellValue(p.getNote3());
            row1.createCell(31).setCellValue(p.getNote4());
            row1.createCell(32).setCellValue(p.getNote5());
            i++;
        }
        return workbook;
    }
    /**
     *判断某个类中是否存在这个二属性
     */
    public boolean isInside(Class cla,String param){
        Field[] fields=cla.getDeclaredFields();
        boolean b=false;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals(param)){
                b=true;
                break;
            }
        }
        return  b;
    }
}
