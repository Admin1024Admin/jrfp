package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.PermissionsEntity;
import com.ky.ct.rzdj.model.RoleEntity;
import com.ky.ct.rzdj.model.RolePermissionsEntity;
import com.ky.ct.rzdj.service.RoleService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    /**
     * 跳转到信息页面
     * @return
     */
    @GetMapping("/roleMessage")
    public String gotoBaseMessage(){
        return "admin/roles";
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/roles")
    @ResponseBody
    public String findFpxexdPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                 @RequestParam(name="limit",required = false,defaultValue = "10")int limit){
        Map<String,Object> map = roleService.findRolePage(page,limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",roleService.getCount());
        JSONObject jsonObject = JSONObject.fromObject(map, JsonConfigUtil.getJsonConfig());
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     * 获取所有权限
     */
    @GetMapping("/getPermissions")
    public String getPermissions(@RequestParam("rid")Integer rid, Map<String,Object> map){
        System.out.println("rid---->"+rid);
        List<PermissionsEntity> permissionsEntityList = roleService.getAllPermisssinos();
        map.put("permissionsList",permissionsEntityList);
        map.put("rid",rid);
        return "admin/permissions";
    }
    /**
     * 添加角色的权限
     */
    @PostMapping("/addRolePermissions")
    @ResponseBody
    public String addRolePermissions(HttpServletRequest request){
        Map<String,Object> paramMap = Fields.getParams(request);
        boolean b = roleService.addRolePermissions(paramMap);
        if(b){
            return "添加成功";
        }
        else{
            return "添加失败";
        }
    }

    
    @RequestMapping(value="/getAll")
    @ResponseBody
    public String getAll() {
        List<RoleEntity> list = roleService.getRole();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }


    @RequestMapping(value="/role")
    public String getPage() {
        return "/user/role";
    }

    @RequestMapping(value="/addOrUpdate")
    public String addOrUpdate(RoleEntity bean, HttpSession session) {
        session.setAttribute("nowEdit",bean);
        return "user/radd";
    }
    @PostMapping("/addOrUpdate")
    @ResponseBody
    public String addOrUpdate(RoleEntity bean) {
        String re = roleService.saveOrUpdate(bean);
        return re;
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(Integer page, Integer limit) {
        List<RoleEntity> list = roleService.get(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", roleService.getCount());
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @GetMapping("/search")
    @ResponseBody
    public String getSearch(String value, String column) {
        List<RoleEntity> list = roleService.search(value,column);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", roleService.getCount());
        map.put("data", list);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }
    @PostMapping("/del")
    @ResponseBody
    public String del(String value) {
//      System.out.println(value+"************************************");
        String re = roleService.del(value) == true ? "删除成功" : "删除失败";
        return re;
    }

    @GetMapping("/getAllPer")
    @ResponseBody
    public String getAllPer() {
        List<PermissionsEntity> list = roleService.getAll();
        JSONArray jsonObject = JSONArray.fromObject(list);
        return jsonObject.toString();
    }


    @GetMapping("/getPer")
    @ResponseBody
    public String getPer(Integer rid){
        List<RolePermissionsEntity> list = roleService.getPer(rid);
        JSONArray jsonObject = JSONArray.fromObject(list);
        return jsonObject.toString();
    }

    @PostMapping("/addOrUpdatePer")
    @ResponseBody
    public String addOrUpdatePer(Integer rid, String pid){
        return roleService.addOrUpdatePer(rid,pid)?"操作成功": "操作失败";
    }
}
