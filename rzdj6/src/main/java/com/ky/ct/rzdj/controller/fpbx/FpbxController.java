package com.ky.ct.rzdj.controller.fpbx;

import com.ky.ct.rzdj.model.BaseFpb;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import com.ky.ct.rzdj.service.FpbxService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fpbx")
public class FpbxController {
    @Autowired
    private FpbxService fpbxService;
    private Map<String,Object> dateMap = new HashMap<>();
    /**
     * 跳转到信息页面
     * @return
     */
    @GetMapping("/baseMessage")
    public String gotoBaseMessage(){
        return "admin/poor/fpbx/baseMessage";
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/fpbx")
    @ResponseBody
    public String findQtgrjzpfdkPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                     @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        Map<String,Object> map = fpbxService.findFpbxPage(page,limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",fpbxService.getCount());
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     * 条件查询
     */
    @PostMapping("/findFpbxWhere")
    @ResponseBody
    public String findFpxdWhere(HttpServletRequest request, @RequestParam(name="page",required = false,defaultValue = "1")int page,
                                @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        dateMap = Fields.getParams(request);
        System.out.println("前端数据：--->"+dateMap);
        List<BaseFpb> baseFpbs= fpbxService.findFpbxWhere(dateMap,page,limit);
        System.out.println("结果集L:---->"+baseFpbs);
        Map resultMap = new HashMap();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",fpbxService.getCount());
        resultMap.put("data",baseFpbs);
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
        BaseFpb baseFpb = fpbxService.findByNo(no);
        System.out.println("------------>"+baseFpb);
        map.put("fpb",baseFpb);
        if("update".equals(cz)){
            return "admin/poor/fpbx/updateUserMessage";
        }else{
            return "admin/poor/fpbx/viewUserMessage";
        }
    }

    /**
     * 根据编号删除
     */
    @GetMapping("/delByNo")
    @ResponseBody
    public String delByCardId(@RequestParam("no")int no){
        System.out.println("删除的编号--->"+no);
        boolean b = fpbxService.delByNo(no);
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
    public String updateSingle(BaseFpb baseFpb){
        System.out.println("保存的新数据--->"+baseFpb);
        boolean b = false;
        if(baseFpb!=null&&!"".equals(baseFpb.getId())){
            b = fpbxService.updateSingle(baseFpb);
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
            return "admin/poor/fpbx/entryFields";
        }
        if(dateMap!=null&&dateMap.size()>0){
            fpbxService.findWhereDate(dateMap);
        }
        return "admin/poor/fpbx/fields";
    }

    /**
     * 选择字段单条录入记录表
     */
    @PostMapping("/chooseFieldEntry")
    public String chooseFieldEntry(HttpServletRequest request,Map<String,Object> map){
        //获取前端传递过来的字段
        List<String> fields = Fields.getFields(request);
        map.put("fields",fields);
        return "admin/poor/fpbx/singleEntry";
    }
    /**
     * 获取前端选择的字段并导出相关数据excel
     */
    @PostMapping("/chooseFieldExportFpbx")
    public void chooseFieldExport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> fields = Fields.getFields(request);
        fields.add("id");
        System.out.println("选择的字段----->"+fields);
        SXSSFWorkbook workbook = fpbxService.chooseFieldExport(fields);
        //导出文件
        String fileName = "information"+ ".xlsx";
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
        SXSSFWorkbook workbook = fpbxService.daoChuAll();
        //导出文件
        String fileName = "All"+ ".xlsx";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
