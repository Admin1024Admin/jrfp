package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.*;
import com.ky.ct.rzdj.service.BaseXmjzfpdkService;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xmjzfp")
public class BaseXmjzfpdkController {
    @Autowired
    BaseXmjzfpdkService baseXmjzfpdkService;

    @RequestMapping(value="/xmjzfp")
    public String xmjzfp() {
        return "admin/poor/xmjzfp/xmjzfp";
    }
    @RequestMapping(value="/xmjzfpSH")
    public String xmjzfpSH() {
        return "admin/poor/xmjzfp/xmjzfpSH";
    }
    @RequestMapping(value="/edit")
    public String xmjzfpEdit() {
        return "admin/poor/xmjzfp/edit";
    }
    @RequestMapping(value="/editSH")
    public String xmjzfpEditSH() {
        return "admin/poor/xmjzfp/editSH";
    }
    @PostMapping(value="/isAdSH")
    @ResponseBody
    public String isAdSH(HttpSession session) {
        return baseXmjzfpdkService.currentUserIsAdmin(baseXmjzfpdkService.getCurrentUser(session)).toString();
    }

    /**
     * 分页获取
     * @param page
     * @param limit
     * @param session
     * @return
     */
    @RequestMapping(value="/findPage")
    @ResponseBody
    public String findPage(Integer page, Integer limit, HttpSession session) {
//        System.out.println(baseXmjzfpdkService.getCurrentUser(session).getLoginName());
//        System.out.println(baseXmjzfpdkService.currentUserIsAdmin(baseXmjzfpdkService.getCurrentUser(session)));
        List<BaseXmjzfpdkBeanOut> list = baseXmjzfpdkService.findPage(page, limit, session);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", baseXmjzfpdkService.getCount(session));
        map.put("data", list);
        System.out.println(list);
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        return jsonObject.toString();
    }
    @RequestMapping(value="/findPageSH")
    @ResponseBody
    public String findPageSH(Integer page, Integer limit, HttpSession session) {
//        System.out.println(baseXmjzfpdkService.getCurrentUser(session).getLoginName());
//        System.out.println(baseXmjzfpdkService.currentUserIsAdmin(baseXmjzfpdkService.getCurrentUser(session)));
        List<BaseXmjzfpdkHistoryBeanOut> list = baseXmjzfpdkService.findPageSH(page, limit, session);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", baseXmjzfpdkService.getCountSH(session));
        map.put("data", list);
        System.out.println(list);
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        return jsonObject.toString();
    }

    /**
     * 单项搜索
     * @param value 搜索值
     * @param column 搜索列
     * @param session
     * @return
     */
    @GetMapping("/search")
    @ResponseBody
    public String getSearch(Integer page, Integer limit,String value, String column, HttpSession session) {
        List<BaseXmjzfpdkBeanOut> list = baseXmjzfpdkService.search(page,limit,value,column, session);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", baseXmjzfpdkService.getCount(session));
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @GetMapping("/searchSH")
    @ResponseBody
    public String getSearchSH(Integer page, Integer limit,String value, String column, HttpSession session) {
        List<BaseXmjzfpdkHistoryBeanOut> list = baseXmjzfpdkService.searchSH(page,limit,value,column, session);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", baseXmjzfpdkService.getCountSH(session));
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * 添加或修改
     * @param bean
     * @param session
     * @return
     */
    @PostMapping("/addOrUpdate")
    @ResponseBody
    public String addOrUpdate(BaseXmjzfpdkHistoryBean bean, HttpSession session) {

System.out.println("----------------------\n"+bean);
        return baseXmjzfpdkService.saveOrUpdateH(bean, session) ? "提交成功，请等待审核" : "提交失败";
    }

    @PostMapping("/del")
    @ResponseBody
    public String del(String value, HttpSession session) {
        String re = baseXmjzfpdkService.del(value, session)  ? "提交成功，请等待审核" : "提交失败";
        return re;
    }


    @PostMapping("/addOrUpdateSH")
    @ResponseBody
    public String addOrUpdateSH(BaseXmjzfpdkHistoryBean bean, HttpSession session) {
        System.out.println("----------------------\n"+bean);
        return baseXmjzfpdkService.saveOrUpdateHSH(bean, session) ? "操作成功" : "操作失败,可能已审核";
    }

    @PostMapping("/delSH")
    @ResponseBody
    public String delSH(String value, HttpSession session) {
        String re = baseXmjzfpdkService.delSH(value, session)  ? "操作成功" : "操作失败";
        return re;
    }
    @PostMapping("/passSH")
    @ResponseBody
    public String passSH(String value, HttpSession session) {
        String re = baseXmjzfpdkService.passSH(value, session)  ? "操作成功" : "操作失败";
        return re;
    }


}
