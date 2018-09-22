package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.CfgDao;
import com.ky.ct.rzdj.dao.UserDao;
import com.ky.ct.rzdj.dto.Msg;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private CfgDao cfgDao;

	@GetMapping("/")
	public String index(){
		return "login/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam("username")String name, @RequestParam("password") String password, HttpServletRequest request,Map<String,Object> map) {
		System.out.println("username:"+name+"password"+password);
		if(name==null&&password==null){
			Msg msg = new Msg(0,"用户名或者密码为空");
			map.put("msg",msg);
			return "login/login";
		}
		Subject subject = SecurityUtils.getSubject();
//		if(!subject.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(name,password);
			try{
				subject.login(token);
				request.getSession().setAttribute("username",name);
			}catch(UnknownAccountException e){
				return "login/login";
			}
			catch(UnauthorizedException e){
				return "login/login";
			}
			catch(Exception e){
				e.printStackTrace();
				return "login/login";
			}
//		}
		System.out.println("/ok");
		return "admin/admin";
	}
	@GetMapping("/unauthorized")
	public String unauthorizedUrl(){
		return "unauthorizedUrl";
	}
	@RequestMapping("/demo")
	public String demo() {
		System.out.println("Login Controller mapping .....demo......");
		return "/admin/poor/demo";
	}

	@RequestMapping(value = { "/checkLogin" })
	public String checkLogin(HttpServletRequest request) {
		if(request.getSession().getAttribute("currentUser") != null){
			return "redirect:/";
		}
		
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("pwd");
		if(loginId == null || pwd == null){
			return "redirect:/login";
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("LoginName", loginId);
		List<RzdjUserEntity> list2 = userDao.findAll(map);
		if(list2!=null && list2.size() > 0) {
			RzdjUserEntity user = list2.get(0);
			if(user.getValid() != 1) {
				return "redirect:/login";
			}
		}

		RzdjUserEntity user = userDao.checkLogin(loginId, pwd);
		if (user == null) {
			return "redirect:/login";
		} else {
			request.getSession().setAttribute("currentUser", user);
			/*List<Cfg> list = cfgDao.findAll();
			request.getSession().setAttribute("cfg", 
					list != null&&list.size() > 0 
					? list.get(0) 
					: null);*/
			
			return "redirect:/";
		}
	}

	@RequestMapping(value = { "/loginOut" })
	public String loginOut(HttpServletRequest request) {
		request.getSession().removeAttribute("currentUser");
		System.out.println("Login Controller mapping .....loginOut......");
		//request.getSession().removeAttribute("cfg");
		return "redirect:/login";
	}

//	@RequestMapping(value = { "/", "" })
//	public String defaultPublic(HttpServletRequest request,Map<String,Object> map) {
//		if(request.getSession().getAttribute("currentUser") == null){
//			return "redirect:/login";
//		}else{
//			System.out.println("管理员账号"+request.getSession().getAttribute("currentUser"));
//			map.put("adminName",request.getSession().getAttribute("currentUser"));
//		}
//		return "admin/admin";
//	}

//	@RequestMapping(value = { "/index" })
//	public String index() {
//		System.out.println("This is in index() method");
//		return "admin/poor/index";
//	}
}
