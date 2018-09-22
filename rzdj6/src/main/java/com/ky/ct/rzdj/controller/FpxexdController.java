package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.service.FpxexdHistoryService;
import com.ky.ct.rzdj.service.FpxexdService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import com.sun.deploy.net.HttpResponse;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/fpxexd")
public class FpxexdController {
    @Autowired
    private FpxexdService fpxexdService;
    private Map<String,Object> dateMap = new HashMap<>();
    /**
     * 跳转到信息页面
     * @return
     */
    @GetMapping("/baseMessage")
    public String gotoBaseMessage(){
        return "admin/poor/fpxdtz/baseMessage";
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/fpxexd")
    @ResponseBody
    public String findFpxexdPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                 @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        Map<String,Object> map = fpxexdService.findFpxexdPage(page,limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",fpxexdService.getCount(new HashMap<>()));
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     * 条件查询
     */
    @PostMapping("/findFpxexdWhere")
    @ResponseBody
    public String findFpxdWhere(HttpServletRequest request,@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        dateMap = Fields.getParams(request);
        System.out.println("前端数据：--->"+dateMap);
        List<BaseFpxexd>  baseFpxexds= fpxexdService.findFpxexdWhere(dateMap,page,limit);
        System.out.println("结果集L:---->"+baseFpxexds);
        Map resultMap = new HashMap();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",fpxexdService.getCount(dateMap));
        resultMap.put("data",baseFpxexds);
        JSONObject jsonObject = JSONObject.fromObject(resultMap, JsonConfigUtil.getJsonConfig());
        return jsonObject.toString();
    }

    /**
     * 跳转到选择字段
     */
    @GetMapping("/gotoFpxexdFields")
    public String gotoFields(@RequestParam(name="cz",required = false)String cz){
        if(cz!=null&&"dtlr".equals(cz)){
            return "admin/poor/fpxdtz/entryFields";
        }
        if(dateMap!=null&&dateMap.size()>0){
            fpxexdService.findWhereDate(dateMap);
        }
        return "admin/poor/fpxdtz/fields";
    }

    /**
     * 获取前端选择的字段并导出相关数据excel
     */
    @PostMapping("/chooseFieldExportFpxexd")
    public void chooseFieldExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> fields = Fields.getFields(request);
        fields.add("no");
        System.out.println("选择的字段----->"+fields);
        SXSSFWorkbook workbook = fpxexdService.chooseFieldExport(fields);
        //导出文件
        String fileName = "information"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 导出一个案例excel
     */
    @GetMapping("/demoExportFpxexd")
    public void demoExportFpxexd(HttpServletResponse response) throws IOException {
        SXSSFWorkbook workbook = fpxexdService.demoExportFpxexd();
        //导出文件
        String fileName = "demo"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    /**
     * 导出全部数据
     */
    @GetMapping("/daoChuAll")
    public void daoChuAll(HttpServletResponse response) throws IOException{
        SXSSFWorkbook workbook = fpxexdService.daoChuAll();
        //导出文件
        String fileName = "All"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /**
     * 选择字段单条录入
     */
    @PostMapping("/chooseFieldEntry")
    public String chooseFieldEntry(HttpServletRequest request,Map<String,Object> map){
        //获取前端传递过来的字段
        List<String> fields = Fields.getFields(request);
        map.put("fields",fields);
        return "admin/poor/fpxdtz/singleEntry";
    }

    /**
     * 录入单条数据
     */
//    @PostMapping("/saveSingle")
//    @ResponseBody
//    public String savaSingle(BaseFpxexd baseFpxexd){
//        System.out.println("保存的新数据--->"+baseFpxexd);
//        //根据贷款人身份证和放款日期判断是否存在该用户
//        String daiKuangRenCardId = baseFpxexd.getDaiKuanRenCardId();
//        Date fangKuanRiQi = baseFpxexd.getFuPinfangKuanRiQi();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("放款日期---->"+sdf.format(fangKuanRiQi));
//        BaseFpxexd baseFpxexd1 = fpxexdService.findByCardIdAndRiQi(daiKuangRenCardId,sdf.format(fangKuanRiQi));
//        boolean b = false;
//        System.out.println("baseFpxexd是否不为空--->"+(baseFpxexd1!=null));
//        if(baseFpxexd1!=null){
//            b = fpxexdService.updateSingle(baseFpxexd,baseFpxexd1);
//        }else{
//            b = fpxexdService.savaSingle(baseFpxexd);
//        }
//        System.out.println("保存的结果----->"+b);
//        if(b){
//            return "ok";
//        }
//        return "no";
//    }

    /**
     * 录入单条数据  记录表
     */
    @PostMapping("/saveSingle")
    @ResponseBody
    public String savaSingle(BaseFpxexdHistory baseFpxexdHistory){
        System.out.println("保存的新数据--->"+baseFpxexdHistory);
        //根据贷款人身份证和放款日期判断是否存在该用户
        String daiKuangRenCardId = baseFpxexdHistory.getDaiKuanRenCardId();
        Date fangKuanRiQi = baseFpxexdHistory.getFuPinfangKuanRiQi();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("放款日期---->"+sdf.format(fangKuanRiQi));
        BaseFpxexdHistory baseFpxexdHistory1 = fpxexdService.findByCardIdAndRiQi(daiKuangRenCardId,sdf.format(fangKuanRiQi));
        boolean b = false;
        System.out.println("baseFpxexd是否不为空--->"+(baseFpxexdHistory1!=null)); //false
        if(baseFpxexdHistory1!=null){
            b = fpxexdService.updateSingle(baseFpxexdHistory,baseFpxexdHistory1);
        }else{
            b = fpxexdService.savaSingle(baseFpxexdHistory);
        }
        System.out.println("保存的结果----->"+b);
        if(b){
            return "ok";
        }
        return "no";
    }

    /**
     * 根据编号查看某一个详细数据
     */
    @GetMapping("/findByNo")
    public String findByCardId(@RequestParam("no")int no,
                               @RequestParam(name="cz",required = false,defaultValue = "ck")String cz,Map<String,Object> map){
        System.out.println("查询的编号：------>"+no);
        BaseFpxexd baseFpxexd = fpxexdService.findByNo(no);
        System.out.println("------------>"+baseFpxexd);
        map.put("fpxexd",baseFpxexd);
        if("update".equals(cz)){
            return "admin/poor/fpxdtz/updateUserMessage";
        }else{
            return "admin/poor/fpxdtz/viewUserMessage";
        }
    }

    /**
     * 根据编号删除
     */
    @GetMapping("/delByNo")
    @ResponseBody
    public String delByCardId(@RequestParam("no")int no){
        System.out.println("删除的编号--->"+no);
        boolean b = fpxexdService.delByNo(no);
        if(b){
            return "ok";
        }
        return "no";
    }

    /**
     * 上传Excel文件录入
     */
    @PostMapping("/loadExcel")
    @ResponseBody
    public String loadExcel(MultipartHttpServletRequest request){
        List <MultipartFile> files = request.getFiles("file");
        for(MultipartFile file:files){
            String fileTYpe = file.getContentType();
            String fileName = file.getOriginalFilename();
            System.out.println("类型:"+fileTYpe+"名字："+fileName);
            boolean b = fpxexdService.loadExcel(file,fileName);
            System.out.println("录入"+fileName+"结果------>"+b);
        }
        //注意！！！layui上传成功必须返回的是json数据
        JSONObject resObj = new JSONObject();
        resObj.put("code", "0");
        resObj.put("msg", "");
        resObj.put("code", "0");
        resObj.put("data", "");
        return resObj.toString();
    }
    /**
     * 统计功能 前端显示表格
     */
    private Date beginDate1 = null;
    private Date endDate1 = null;
    @PostMapping("/statistical")
    public String statistical(@RequestParam("beginDate")Date beginDate,@RequestParam("endDate")Date endDate,HttpServletResponse response,Map<String,Object> map){
        beginDate1 = beginDate;
        endDate1 = endDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("查询的时间段------>"+sdf.format(beginDate)+"-----"+sdf.format(endDate));
        Map<String,Object> resultMap= fpxexdService.statistical(sdf.format(beginDate),sdf.format(endDate));
        map.put("resultMap",resultMap);
        System.out.println("resultMap------------->"+resultMap);
        return "admin/poor/fpxdtz/tongJi";
    }
    /**
     * 统计功能 导出excel
     */
    @GetMapping("/exportStatistical")
    @ResponseBody
    public void exportStatistical(HttpServletResponse response)throws IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("导出的时间段------>"+sdf.format(beginDate1)+"-----"+sdf.format(endDate1));
        SXSSFWorkbook workbook =  fpxexdService.exportStatistical(sdf.format(beginDate1),sdf.format(endDate1));
        //导出文件
        String fileName = "All"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /**
     * 测试
     */
    @GetMapping("/test1")
    public String test(Map<String,Object> map){
        List<String> testList = new ArrayList<>();
        testList.add("t1");
        testList.add("t2");
        map.put("test",testList);
        return "admin/poor/fpxdtz/test";
    }
}

