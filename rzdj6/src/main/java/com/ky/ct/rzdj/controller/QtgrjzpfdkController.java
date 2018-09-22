package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import com.ky.ct.rzdj.service.QtgrjzfpdkDdpkhService;
import com.ky.ct.rzdj.service.QtgrjzfpdkService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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
@RequestMapping("/qtgrjzfpdk")
public class QtgrjzpfdkController {
    @Autowired
    private QtgrjzfpdkService qtgrjzfpdkService;
    @Autowired
    private QtgrjzfpdkDdpkhService qtgrjzfpdkDdpkhService;
    private Map<String,Object> dateMap = new HashMap<>();
    /**
     * 跳转到信息页面
     * @return
     */
    @GetMapping("/baseMessage")
    public String gotoBaseMessage(){
        return "admin/poor/qtgrjzfpdk/baseMessage";
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/qtgrjzfpdk")
    @ResponseBody
    public String findQtgrjzpfdkPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                 @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        Map<String,Object> map = qtgrjzfpdkService.findQtgrjzpfdkPage(page,limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",qtgrjzfpdkService.getCount());
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     *带动贫困户名单
     */
    @GetMapping("/md")
    public String findMd(@RequestParam("agreementNo")String agreementNo, Map<String,Object>map){
        System.out.println("合同编号--->"+agreementNo);
        List<BaseQtgrjzfpdkDdpkh> baseQtgrjzfpdkDdpkhs = qtgrjzfpdkDdpkhService.findByAgreementNo(agreementNo);
        System.out.println("和同编号---->"+baseQtgrjzfpdkDdpkhs);
        map.put("mds",baseQtgrjzfpdkDdpkhs);
        return "admin/poor/qtgrjzfpdk/mingDans";
    }
    /**
     * 条件查询
     */
    @PostMapping("/findQtgrjzfpdkWhere")
    @ResponseBody
    public String findFpxdWhere(HttpServletRequest request, @RequestParam(name="page",required = false,defaultValue = "1")int page,
                                @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        dateMap = Fields.getParams(request);
        System.out.println("前端数据：--->"+dateMap);
        List<BaseQtgrjzfpdk> baseQtgrjzfpdk= qtgrjzfpdkService.findFpxexdWhere(dateMap,page,limit);
        System.out.println("结果集L:---->"+baseQtgrjzfpdk);
        Map resultMap = new HashMap();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",qtgrjzfpdkService.getCount());
        resultMap.put("data",baseQtgrjzfpdk);
        JSONObject jsonObject = JSONObject.fromObject(resultMap, JsonConfigUtil.getJsonConfig());
        return jsonObject.toString();
    }

    /**
     * 根据编号查看某一个详细数据
     */
    @GetMapping("/findByNo")
    public String findByCardId(@RequestParam("no")int no,
                               @RequestParam(name="cz",required = false,defaultValue = "ck")String cz,Map<String,Object> map){
        System.out.println("查询的编号：------>"+no);
        BaseQtgrjzfpdk baseQtgrjzfpdk = qtgrjzfpdkService.findByNo(no);
        List<BaseQtgrjzfpdkDdpkh> baseQtgrjzfpdkDdpkhs = qtgrjzfpdkDdpkhService.findByAgreementNo(baseQtgrjzfpdk.getAgreementNo());
        System.out.println("------------>"+baseQtgrjzfpdk);
        map.put("qt",baseQtgrjzfpdk);
        map.put("mds",baseQtgrjzfpdkDdpkhs);
        if("update".equals(cz)){
            return "admin/poor/qtgrjzfpdk/updateUserMessage";
        }else{
            return "admin/poor/qtgrjzfpdk/viewUserMessage";
        }
    }

    /**
     * 根据编号删除
     */
    @GetMapping("/delByNo")
    @ResponseBody
    public String delByCardId(@RequestParam("no")int no){
        System.out.println("删除的编号--->"+no);
        boolean b = qtgrjzfpdkService.delByNo(no);
        if(b){
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * 更新
     */
    @PostMapping("/updateSingle")
    @ResponseBody
    public String savaSingle(BaseQtgrjzfpdk baseQtgrjzfpdk,String[] agreementNo,Integer[] id,String[] huZhuName,String[] huZhuCardId,Integer[] familyMembers){

        List<BaseQtgrjzfpdkDdpkh> qtgrjzfpdkDdpkhs = new ArrayList<>();
        for(int i = 0;i<agreementNo.length;i++){
            BaseQtgrjzfpdkDdpkh ddpkh  = new BaseQtgrjzfpdkDdpkh();
            ddpkh.setId(id[i]);
            ddpkh.setAgreementNo(agreementNo[i]);
            ddpkh.setHuZhuName(huZhuName[i]);
            ddpkh.setHuZhuCardId(huZhuCardId[i]);
            ddpkh.setFamilyMembers(familyMembers[i]);
            qtgrjzfpdkDdpkhs.add(ddpkh);
        }
        System.out.println("名单--->"+qtgrjzfpdkDdpkhs.size());
        System.out.println("保存的新数据--->"+baseQtgrjzfpdk);
        boolean b = false;
        if(baseQtgrjzfpdk!=null&&!"".equals(baseQtgrjzfpdk.getUid())){
            b = qtgrjzfpdkService.updateSingle(baseQtgrjzfpdk);
        }
       if(b){
            return "ok";
       }
        return "no";
    }

    /**
     * 跳转到选择字段  单挑录入选择字段和导出选择字段
     */
    @GetMapping("/gotoFpxexdFields")
    public String gotoFields(@RequestParam(name="cz",required = false)String cz){
        if(cz!=null&&"dtlr".equals(cz)){
            return "admin/poor/qtgrjzfpdk/entryFields";
        }
        if(dateMap!=null&&dateMap.size()>0){
            qtgrjzfpdkService.findWhereDate(dateMap);
        }
        return "admin/poor/qtgrjzfpdk/fields";
    }

    /**
     * 获取前端选择的字段并导出相关数据excel
     */
    @PostMapping("/chooseFieldExportQtgrjzfpdk")
    public void chooseFieldExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> fields = Fields.getFields(request);
        fields.add("uid");
        System.out.println("选择的字段----->"+fields);
        SXSSFWorkbook workbook = qtgrjzfpdkService.chooseFieldExport(fields);
        //导出文件
        String fileName = "information"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
    /**
     * 选择字段单条录入记录表
     */
    @PostMapping("/chooseFieldEntry")
    public String chooseFieldEntry(HttpServletRequest request,Map<String,Object> map){
        //获取前端传递过来的字段
        List<String> fields = Fields.getFields(request);
        map.put("fields",fields);
        return "admin/poor/qtgrjzfpdk/singleEntry";
    }

    /**
     * 导出全部数据
     */
    @GetMapping("/daoChuAll")
    public void daoChuAll(HttpServletResponse response) throws IOException{
        SXSSFWorkbook workbook = qtgrjzfpdkService.daoChuAll();
        //导出文件
        String fileName = "All"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
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
            boolean b = qtgrjzfpdkService.loadExcel(file,fileName);
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

}
