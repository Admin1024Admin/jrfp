package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.PermissionsEntity;
import com.ky.ct.rzdj.service.PermissionsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permissions")
public class PermissionsController {
    @Autowired
    private PermissionsService permissionsService;

    @RequestMapping(value="/auth")
    public String getPage() {
        return "/user/authority";
    }

    @RequestMapping(value="/addOrUpdate")
    public String addOrUpdate(PermissionsEntity bean, HttpSession session) {
        session.setAttribute("nowEdit",bean);
        return "user/padd";
    }
    @PostMapping("/addOrUpdate")
    @ResponseBody
    public String addOrUpdate(PermissionsEntity bean) {
        String re = permissionsService.saveOrUpdate(bean) == true ? "操作成功" : "操作失败";
        return re;
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(Integer page, Integer limit) {
        List<PermissionsEntity> list = permissionsService.get(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", permissionsService.getCount());
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @GetMapping("/search")
    @ResponseBody
    public String getSearch(String value, String column) {
        List<PermissionsEntity> list = permissionsService.search(value,column);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", permissionsService.getCount());
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @PostMapping("/del")
    @ResponseBody
    public String del(String value) {
//		System.out.println(value+"************************************");
        String re = permissionsService.del(value) == true ? "删除成功" : "删除失败";
        return re;
    }


}
