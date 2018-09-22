package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.BaseQtgrjzfpdk;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkhHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkHistory;
import com.ky.ct.rzdj.service.QtgrjzfpdkDdpkhHistoryService;
import com.ky.ct.rzdj.service.QtgrjzfpdkDdpkhService;
import com.ky.ct.rzdj.service.QtgrjzfpdkHistoryService;
import com.ky.ct.rzdj.service.QtgrjzfpdkService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/qtgrjzfpdkHistory")
public class QtgrjzfpdkHistoryController {
    @Autowired
    private QtgrjzfpdkHistoryService qtgrjzfpdkHistoryService;
    @Autowired
    private QtgrjzfpdkService qtgrjzfpdkService;
    @Autowired
    private QtgrjzfpdkDdpkhService qtgrjzfpdkDdpkhService;
    @Autowired
    private QtgrjzfpdkDdpkhHistoryService qtgrjzfpdkDdpkhHistoryService;
    private Map<String,Object> dateMap = new HashMap<>();
    /**
     * 跳转到信息页面
     * @return
     */
    @GetMapping("/historyBaseMessage")
    public String gotoBaseMessage(){
        return "admin/poor/qtgrjzfpdk/historyBaseMessage";
    }
    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/qtgrjzfpdkHistory")
    @ResponseBody
    public String findQtgrjzpfdkPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                     @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        Map<String,Object> map = qtgrjzfpdkHistoryService.findQtgrjzpfdkHistoryPage(page,limit);
        map.put("code",0);
        map.put("msg","");
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("checkStatus","未审核");
        map.put("count",qtgrjzfpdkHistoryService.getCount(paraMap));
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
        List<BaseQtgrjzfpdkDdpkhHistory> baseQtgrjzfpdkDdpkhHistories = qtgrjzfpdkDdpkhHistoryService.findByAgreementNo(agreementNo);
        System.out.println("和同编号---->"+baseQtgrjzfpdkDdpkhHistories);
        map.put("mds",baseQtgrjzfpdkDdpkhHistories);
        return "admin/poor/qtgrjzfpdk/mingDansHistory";
    }
    /**
     * 条件查询
     */
    @PostMapping("/findQtgrjzfpdkHistoryWhere")
    @ResponseBody
    public String findQtgrjzfpdkHistoryWhere(HttpServletRequest request, @RequestParam(name="page",required = false,defaultValue = "1")int page,
                                @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        dateMap = Fields.getParams(request);
        System.out.println("前端数据：--->"+dateMap);
        List<BaseQtgrjzfpdkHistory> baseQtgrjzfpdkHistories= qtgrjzfpdkHistoryService.findQtgrjzfpdkHistoryWhere(dateMap,page,limit);
        System.out.println("结果集L:---->"+baseQtgrjzfpdkHistories);
        Map resultMap = new HashMap();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",qtgrjzfpdkHistoryService.getCount(dateMap));
        resultMap.put("data",baseQtgrjzfpdkHistories);
        JSONObject jsonObject = JSONObject.fromObject(resultMap, JsonConfigUtil.getJsonConfig());
        return jsonObject.toString();
    }

    /**
     * 根据编号查看某一个详细数据
     */
    @GetMapping("/findByNo")
    public String findByCardId(@RequestParam("no")int no,
                               @RequestParam(name="cz",required = false,defaultValue = "ck")String cz,Map<String,Object> map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("查询的编号：------>"+no);
        BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory = qtgrjzfpdkHistoryService.findByNo(no);
        List<BaseQtgrjzfpdkDdpkhHistory> baseQtgrjzfpdkDdpkhs = qtgrjzfpdkDdpkhHistoryService.findByAgreementNo(baseQtgrjzfpdkHistory.getAgreementNo());
        System.out.println("------------>"+baseQtgrjzfpdkHistory);
        map.put("qt2",baseQtgrjzfpdkHistory);
        map.put("mds",baseQtgrjzfpdkDdpkhs);
        if("shenhe".equals(cz)){
            //审核有两种情况  更新和新增 返回的页面也不一致  String agreementNo,String daiKuanJinRongJiGou,String touFangDate,String changHuanDate
            BaseQtgrjzfpdk baseQtgrjzfpdk = qtgrjzfpdkService.fingByNoAndJiGouAndTouDateAndChangDate(baseQtgrjzfpdkHistory.getAgreementNo(),
                    baseQtgrjzfpdkHistory.getDaiKuanJinRongJiGou(),sdf.format(baseQtgrjzfpdkHistory.getTouFangDate()),
                    sdf.format(baseQtgrjzfpdkHistory.getChangHuanDate()));
            if(baseQtgrjzfpdk==null){
                System.out.println("新增审核");
                return "admin/poor/qtgrjzfpdk/addShenHeMessage";
            }else{
                System.out.println("更新审核");
                map.put("qt",baseQtgrjzfpdk);
                return "admin/poor/qtgrjzfpdk/updateShenHeMessage";
            }
        }else{
            return "admin/poor/qtgrjzfpdk/viewUserHistoryMessage";
        }
    }
    /**
     * 审核
     */
    @PostMapping("/audit")
    @ResponseBody
    public String audit(BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory,String[] agreementNo,Integer[] id,String[] huZhuName,String[] huZhuCardId,Integer[] familyMembers,
                        @RequestParam("cz")String cz,@RequestParam(name = "operation",required = false,defaultValue = "xz")String operation){

        for(int i = 0;i<agreementNo.length;i++){
            BaseQtgrjzfpdkDdpkh ddpkh  = new BaseQtgrjzfpdkDdpkh();
            ddpkh.setId(id[i]);
            ddpkh.setAgreementNo(agreementNo[i]);
            ddpkh.setHuZhuName(huZhuName[i]);
            ddpkh.setHuZhuCardId(huZhuCardId[i]);
            ddpkh.setFamilyMembers(familyMembers[i]);
            qtgrjzfpdkDdpkhService.saveQtgrjzfpdkDdpkh(ddpkh);
        }
        System.out.println("操作类型--->"+cz);
        System.out.println("审核内容----->"+baseQtgrjzfpdkHistory);
        //审核通过
        if("xz".equals(operation)){
            operation = "新增";
        }
        if("gx".equals(operation)){
            operation = "修改";
        }
        if("sucess".equals(cz)){
            boolean b = qtgrjzfpdkHistoryService.audit(baseQtgrjzfpdkHistory,operation);
            if(b){
                return "ok";
            }else{
                return "审核失败..请重新审核...";
            }
        }else{
            //审核不通过
            boolean b = qtgrjzfpdkHistoryService.noAudit(baseQtgrjzfpdkHistory,operation);
            if(b){
                return "ok";
            }else{
                return "审核失败..请重新审核...";
            }
        }
    }

    /**
     * 根据编号删除
     */
    @GetMapping("/delByNo")
    @ResponseBody
    public String delByCardId(@RequestParam("no")int no){
        System.out.println("删除的编号--->"+no);
        boolean b = qtgrjzfpdkHistoryService.delByNo(no);
        if(b){
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * 录入单条数据  记录表
     */
    @PostMapping("/saveSingle")
    @ResponseBody
    public String savaSingle(BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistory, BaseQtgrjzfpdkDdpkhHistory baseQtgrjzfpdkDdpkhHistory){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx"+baseQtgrjzfpdkDdpkhHistory);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("保存的新数据--->"+baseQtgrjzfpdkHistory);
        //根据贷款合同编号和贷款机构和投放日期和偿还贷款时间是否存在该用户
        String agreementNo = baseQtgrjzfpdkHistory.getAgreementNo();
        String daiKuanJinRongJiGou = baseQtgrjzfpdkHistory.getDaiKuanJinRongJiGou();
        Date touFangDate1 = baseQtgrjzfpdkHistory.getTouFangDate();
        String touFangDate = sdf.format(touFangDate1);
        Date changHuanDate1 = baseQtgrjzfpdkHistory.getChangHuanDate();
        String changHuanDate = sdf.format(changHuanDate1);
        //去数据库查询看是否存在数据
        BaseQtgrjzfpdkHistory baseQtgrjzfpdkHistoryDB = qtgrjzfpdkHistoryService.fingByNoAndJiGouAndTouDateAndChangDate(agreementNo,daiKuanJinRongJiGou,touFangDate,changHuanDate);
        System.out.println("-----------------------+++++");
        System.out.println("baseQtgrjzfpdkHistory在数据库存在--->"+(baseQtgrjzfpdkHistoryDB!=null)); //false
        boolean b = false;
        if(baseQtgrjzfpdkHistoryDB!=null){
            b = qtgrjzfpdkHistoryService.updateSingle(baseQtgrjzfpdkHistory,baseQtgrjzfpdkHistoryDB);
        }else{
            b = qtgrjzfpdkHistoryService.savaSingle(baseQtgrjzfpdkHistory,baseQtgrjzfpdkDdpkhHistory);
        }
        System.out.println("保存的结果----->"+b);
        if(b){
            return "ok";
        }
        return "no";
    }
}
