package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.AuditProjectDao;
import com.ky.ct.rzdj.dao.AuditProjectReportDao;
import com.ky.ct.rzdj.dao.ProjectQuestionDao;
import com.ky.ct.rzdj.model.AuditProject;
import com.ky.ct.rzdj.model.AuditProjectReport;
import com.ky.ct.rzdj.model.ProjectQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auditProject")
public class AuditProjectController {
	@Autowired
	private AuditProjectDao auditProjectDao;
	
	@Autowired
	private ProjectQuestionDao projectQuestionDao;
	
	@Autowired
	private AuditProjectReportDao auditProjectReportDao;

	@RequestMapping("/list")
	public String userList(HttpServletRequest request, Model model) {
		int size = request.getParameter("size") == null
				|| request.getParameter("size").isEmpty() ? 20 : Integer
				.parseInt(request.getParameter("size"));

		int page = request.getParameter("page") == null
				|| request.getParameter("size").isEmpty() ? 1 : Integer
				.parseInt(request.getParameter("page"));

		String key = request.getParameter("key") == null
				|| request.getParameter("key").isEmpty() ? "" : request
				.getParameter("key");
		
		String value = request.getParameter("value") == null
				|| request.getParameter("value").isEmpty() ? "" : request
				.getParameter("value");
		
		Map<String, Object> conditaions = new HashMap<>();
		if(!key.isEmpty() && !value.isEmpty()) {
			conditaions.put(key, value);
		}
		
		List<AuditProject> list = auditProjectDao.findPage(page, size, conditaions);
		
		model.addAttribute("list", list);
		model.addAttribute("size", size);
		model.addAttribute("page", page);
		model.addAttribute("key", key);
		model.addAttribute("value", value);
		
		model.addAttribute("count", auditProjectDao.getCount());

		return "/auditProject/list";
	}

	@RequestMapping(value = { "/getData" })
	@ResponseBody
	private Map<String, Object> getData(HttpServletRequest request)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		Integer id = Integer.valueOf(request.getParameter("id"));
		AuditProject model = auditProjectDao.findById(id);

		result.put("success", true);
		result.put("msg", "查询成功");
		result.put("obj", model);

		return result;
	}

	@RequestMapping(value = { "/createOrUpdate" })
	@ResponseBody
	private Map<String, Object> createOrUpdate(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		Map<String, Object> map2 = new HashMap<>();
		
		AuditProject model = null;
		if (request.getParameter("id") == null
				|| request.getParameter("id").isEmpty()) {
			model = new AuditProject();
		} else {
			Integer id = Integer.valueOf(request.getParameter("id"));
			model = auditProjectDao.findById(id);
			int year = model.getYear(); //项目年度
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("year", year);
			List<AuditProjectReport> list = auditProjectReportDao.findAll(map);
			if(list != null && list.size() >0){
				AuditProjectReport auditProjectReport = list.get(0);
				if(auditProjectReport.getState() != 0 && auditProjectReport.getState() != 3){
					result.put("success", false);
					result.put("msg", "该项目年度报表已经提交,不允许更改操作");
					return result;
				}
			}
	
		}

		model.setStart(request.getParameter("start"));
		model.setEnd(request.getParameter("end"));
		model.setYear(request.getParameter("year") == null ? model.getYear() : Integer.valueOf(request.getParameter("year")));
		model.setProjectCy(request.getParameter("projectCY"));
		model.setProjectDpt(request.getParameter("projectDpt"));
		model.setProjectKz(request.getParameter("projectKZ"));
		model.setProjectName(request.getParameter("projectName"));
		model.setProjectZs(request.getParameter("projectZS"));
		model.setRemark(request.getParameter("remark"));
		model.setType(request.getParameter("type"));
		model.setWorkDays(Integer.valueOf(request.getParameter("workDays")));
		
		map2.put("projectName", model.getProjectName());
		List<AuditProject> list2 = auditProjectDao.findAll(map2);
		
		if (request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty()) {
			AuditProject oldAudit = auditProjectDao.findById(Integer.valueOf(request.getParameter("id")));
			
			if((list2!=null && list2.size()>0) &&!oldAudit.getProjectName().equals(model.getProjectName())){
				result.put("success", false);
				result.put("msg", "此项目名已存在");
				return result;
			}
			
		}else {

			if(list2!=null && list2.size()>0){
				result.put("success", false);
				result.put("msg", "此项目名已存在");
				return result;
			}
			
		}
		
		boolean flag1 = auditProjectDao.saveOrUpdate(model);

		if (request.getParameter("id") == null && flag1) {
			result.put("success", flag1);
			result.put("msg", "新增成功");
		} else {
			
//			//修改项目问题表中的 项目名称
//			String sql = "update projectquestion set projectName='" +model.getProjectName() + "' where projectId='" + model.getId() + "'"  ;
//			Object flag = projectQuestionDao.exec(sql)
			boolean flag = true;
			List<ProjectQuestion> list = projectQuestionDao.findListByPid(model.getId());
			for(ProjectQuestion projectQuestion : list) {
				projectQuestion.setProjectName(model.getProjectName());
				flag = projectQuestionDao.update(projectQuestion);
			}
			
			result.put("success", flag);
			result.put("msg", "更新成功");
		}

		return result;
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
				AuditProject model = auditProjectDao.findById(Integer.parseInt(idString));
				int year = model.getYear(); //项目年度
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("year", year);
				List<AuditProjectReport> list = auditProjectReportDao.findAll(map);
				if(list != null && list.size() >0){
					AuditProjectReport auditProjectReport = list.get(0);
					if(auditProjectReport.getState() != 0 && auditProjectReport.getState() != 3){
						result.put("success", false);
						result.put("msg", "该项目年度报表已经提交,不允许删除操作");
						return result;
					}
				}
				if (!auditProjectDao.deleteById(Integer.parseInt(idString))) {
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

}
