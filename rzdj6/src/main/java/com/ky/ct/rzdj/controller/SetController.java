package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.CfgDao;
import com.ky.ct.rzdj.dao.UserDao;
import com.ky.ct.rzdj.model.Cfg;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//设置
@RestController
@RequestMapping("/set")
public class SetController {
	@Autowired
    private UserDao userDao;
	@Autowired
    private CfgDao cfgDao;
	
	@RequestMapping(value = { "/self" })
	private Map<String, Object> createOrUpdate(HttpServletRequest request, RzdjUserEntity user) {
		Map<String, Object> result = new HashMap<String, Object>();
//		User model = null;
//		Integer id = Integer.valueOf(request.getParameter("id"));
//		model = userDao.findById(id);
//		model.setName(request.getParameter("name"));
//		model.setLoginId(request.getParameter("loginId"));
//		model.setMobile(request.getParameter("mobile"));
//		model.setValid(Integer.valueOf(request.getParameter("valid")));
//		model.setType(Integer.valueOf(request.getParameter("type")));
		
		if(((Integer)user.getUid())!=null) {  // ??
			result.put("success", false);
			result.put("msg", "ID不能为空");
		}
		
		Integer id = user.getUid();

		RzdjUserEntity model = userDao.findById(id);
		user.setPwd(model.getPwd());
		user.setValid(model.getValid());
		
		boolean flag = userDao.update(user);
		
		if(flag){
			//更新session
			request.getSession().removeAttribute("currentUser");
			request.getSession().setAttribute("currentUser", user);
		}
	
		result.put("success", flag);
		result.put("msg", flag ? "更新成功" : "更新失败");
	
		return result;
	}
	
	@RequestMapping("/dpt")
	public Map<String, Object> setProjectName(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		int id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		String dptName = request.getParameter("dptName");
		int dptType = request.getParameter("dptType") == null ? 0 : Integer.valueOf(request.getParameter("dptType"));
		
		
		if(id == 0 || dptName.isEmpty() || dptType == 0){
			result.put("success", false);
			result.put("msg", "修改失败，获取不到数据");
			return result;
		}
		
		Cfg cfg = new Cfg();
		cfg.setId(id);
		cfg.setDptName((dptName));
		cfg.setDptType(dptType);
		cfg.setProjectName(dptName + "内审统计分析系统");
		
		boolean flag = cfgDao.update(cfg);
		
		if(flag){
			request.getSession().removeAttribute("cfg");
			request.getSession().setAttribute("cfg", cfg);
		}
	
		result.put("success", flag);
		result.put("msg", flag ? "修改成功" : "修改失败");
		
		return result;
	}

	@RequestMapping("/pwd")
	public Map<String, Object> setPwd(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		int id = request.getParameter("id") == null ? 0 : Integer.valueOf(request.getParameter("id"));
		System.err.println(id);
		String oldPwd = request.getParameter("oldPwd");
		String newPwd1 = request.getParameter("newPwd1");
		String newPwd2 = request.getParameter("newPwd2");
		if(id == 0 || oldPwd.isEmpty() || newPwd1.isEmpty() || newPwd2.isEmpty()){
			result.put("success", false);
			result.put("msg", "获取不到数据");
			return result;
		}

		RzdjUserEntity user = userDao.checkLogin(userDao.findById(id).getLoginName(), oldPwd);
		if(user == null){
			result.put("success", false);
			result.put("msg", "密码错误");
			return result;
		}
		
		if(!newPwd1.equals(newPwd2)){
			result.put("success", false);
			result.put("msg", "两次输入密码不一致");
			return result;
		}
		
		user.setPwd(Md5.getMD5_m(newPwd1)); //设置新密码
		boolean flag = 	userDao.update(user);
		if(flag){
			request.getSession().removeAttribute("currentUser");
			result.put("success", true);
			result.put("msg", "密码修改成功,请重新登陆");
		}
		
		return result;
	}

}
