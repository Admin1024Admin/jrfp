package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.SysconfigDao;
import com.ky.ct.rzdj.model.Sysconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysConfig")
public class SysConfigController {
	@Autowired
    private SysconfigDao sysconfigDao;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		String sql = "select * from sysconfig ORDER BY itemType DESC, itemKey DESC";
		int type = request.getParameter("typeId") == null 
				   || request.getParameter("typeId").isEmpty() ? 0 :
				   Integer.valueOf(request.getParameter("typeId"));
		
		if(type == 1 || type == 0) {
			sql = "select * from sysconfig where itemType='内审人员' ORDER BY itemType DESC, itemKey DESC";
			model.addAttribute("type", 1);
		}
		
		if(type == 2) {
			sql = "select * from sysconfig where itemType='审计项目' ORDER BY itemType DESC, itemKey DESC";
			model.addAttribute("type", 2);
		}
	
		List<Sysconfig> list = sysconfigDao.findListBySql(sql);			
		model.addAttribute("list", list);
			
		return "/sysConfig/list";
	}
	
	//修改配置
	@RequestMapping("/createOrUpdate")
	@ResponseBody
	public Map<String, Object> createOrUpdate(@ModelAttribute Sysconfig sysConfig){
		Map<String, Object> result = new HashMap<>();
		boolean flag = true;
		try {
			flag = sysconfigDao.update(sysConfig);
		} catch (Exception e) {
			flag = false;
		}
		
		result.put("msg", flag ? "更新数据成功" : "更新数据失败");
	
		result.put("success", flag);		
		return result;
	}
	
	//添加
	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> createOrUpdate(HttpServletRequest request){
		int type = request.getParameter("type") == null 
				   || request.getParameter("type").isEmpty() ? 0 :
				   Integer.valueOf(request.getParameter("type"));
		
		Sysconfig sysconfig = new Sysconfig();
		if(type == 0 || type ==1) {
			sysconfig.setItemType("内审人员");
		}
		
		if(type == 2) {
			sysconfig.setItemType("审计项目");
		}
	
		Map<String, Object> result = new HashMap<>();
		boolean flag = sysconfigDao.add(sysconfig);
		result.put("msg", flag ? "新增成功，请在最下方单元格中输入数据" : "新增失败");
		result.put("success", flag);		
		return result;
	}
	
	//删除某一个配置
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		int id = Integer.valueOf(request.getParameter("id"));
		boolean flag = sysconfigDao.deleteById(id);
		
		result.put("success", flag);
		result.put("msg", flag ? "删除成功" : "删除失败");
		
		return result;
	}
	
	//查询数据
	@RequestMapping("/getData")
	@ResponseBody
	public Map<String, Object> getDate(HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		int id = Integer.valueOf(request.getParameter("id"));
		Sysconfig model = sysconfigDao.findById(id);		
		result.put("model", model);

		return result;
	}
	
	//根据key和type查询配置信息
	@RequestMapping("/getKey")
	@ResponseBody
	public Map<String, Object> getKey(HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		String itemType = request.getParameter("itemType");
		String itemKey = request.getParameter("itemKey");
		
		Map<String, Object> map = new HashMap<>();
		map.put("itemType", itemType);
		map.put("itemKey", itemKey);
		
		List<Sysconfig> list = sysconfigDao.findAll(map);
		result.put("success", list != null ? true : false);
		result.put("res", list);

		return result;
	}
	
}
