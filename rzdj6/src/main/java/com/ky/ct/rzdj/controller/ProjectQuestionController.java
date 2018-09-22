package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.AuditProjectDao;
import com.ky.ct.rzdj.dao.ProjectQuestionDao;
import com.ky.ct.rzdj.model.ProjectQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//项目问题controller

@Controller
@RequestMapping("/projectQuestion")
public class ProjectQuestionController {
	@Autowired
    private ProjectQuestionDao projectQuestionDao;
	@Autowired
    private AuditProjectDao auditProjectDao;
	
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		
		Integer projectId = Integer.parseInt(request.getParameter("projectId"));
		Map<String, Object> map = new HashMap<>();
		map.put("projectId", projectId);
	
		model.addAttribute("list", projectQuestionDao.findAll(map));
		model.addAttribute("count", projectQuestionDao.getCount(map));
		
		model.addAttribute("projectId", projectId);
		model.addAttribute("projectName", auditProjectDao.findById(projectId).getProjectName());

		return "projectQuestion/list";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		String idlist = request.getParameter("id") == null
				|| request.getParameter("id").isEmpty() ? "" : request
				.getParameter("id");
		boolean flag = true;

		if (!idlist.isEmpty()) {
			String[] idArray = idlist.split(",");
			for (String idString : idArray) {
				if (!projectQuestionDao.deleteById(Integer.parseInt(idString))) {
					flag = false;
				}
			}
			result.put("success", flag);
			result.put("msg", flag ? "删除成功" : "删除失败");
		} else {
			result.put("result", "不存在此参数");
		}
		return result;
	}

	@RequestMapping(value = { "/getData" })
	@ResponseBody
	private Map<String, Object> getData(HttpServletRequest request)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		Integer id = Integer.valueOf(request.getParameter("id"));
		ProjectQuestion model = projectQuestionDao.findById(id);

		result.put("success", true);
		result.put("msg", "查询成功");
		result.put("obj", model);

		return result;
	}
	
	@RequestMapping(value = { "/createOrUpdate" })
	@ResponseBody
	private Map<String, Object> createOrUpdate(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();

		ProjectQuestion model = null;
		if (request.getParameter("id") == null
				|| request.getParameter("id").isEmpty()) {
			model = new ProjectQuestion();
		} else {
			System.err.println(request.getParameter("id"));
			Integer id = Integer.valueOf(request.getParameter("id"));
			model = projectQuestionDao.findById(id);
		}
		
		model.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		model.setProjectName(request.getParameter("projectName"));
		model.setQuestionTitle(request.getParameter("questionTitle"));
		model.setContent(request.getParameter("content"));

		boolean flag = projectQuestionDao.saveOrUpdate(model); //更新
		result.put("success", flag);
		result.put("msg", "操作成功");

		return result;
	}
}
