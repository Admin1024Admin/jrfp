package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.UserDao;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.service.UserService;
import com.ky.ct.rzdj.util.Md5;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping(value="/user")
	public String user() {
//		return "admin/poor/fpxdtz/baseMessage";
		return "user/user";
	}


	@RequestMapping(value="/addUser")
	public String addUser(RzdjUserEntity bean, HttpSession session) {
		session.setAttribute("nowEdit",bean);
		return "user/add";
	}

	@RequestMapping(value="/nowEdit")
	@ResponseBody
	public String nowEdit(HttpSession session) {
		Object bean = session.getAttribute("nowEdit");
		JSONObject jsonObject = JSONObject.fromObject(bean);
		return jsonObject.toString();
	}

	@PostMapping("/addUser")
	@ResponseBody
	public String addUserPost(RzdjUserEntity bean) {
//		System.out.println(bean.getLoginName()+"\n"+bean.getPwd()+"\n"+bean.getName()+"\n"+bean.getType()+"\n"+bean.getRole()+"\n"+bean.getMobile()+"\n"+bean.getWeiXinOpenId()+"\n"+bean.getValid());

		String re = userService.saveOrUpdate(bean) == true ? "操作成功" : "操作失败";
		return re;
	}
	@GetMapping("/getUser")
	@ResponseBody
	public String getUser(Integer page, Integer limit) {
		List<RzdjUserEntity> list = userService.getUser(page, limit);
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", userService.getCount());
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}

	@GetMapping("/searchUser")
	@ResponseBody
	public String getSearch(String value, String column) {
		List<RzdjUserEntity> list = userService.searchUser(value,column);
		Map<String, Object> map = new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", userService.getCount());
		map.put("data", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}

	@PostMapping("/delUser")
	@ResponseBody
	public String delUser(String value) {
//		System.out.println(value+"************************************");
		String re = userService.delUser(value)  ? "删除成功" : "删除失败";
		return re;
	}


//	@Autowired
//	private UserDao userDao;
//
//	@RequestMapping(value="/list1")
//	public String userList(HttpServletRequest request, Model model) {
//		int size = request.getParameter("size") == null
//				|| request.getParameter("size").isEmpty() ? 20 : Integer
//				.parseInt(request.getParameter("size"));
//
//		int page = request.getParameter("page") == null
//				|| request.getParameter("size").isEmpty() ? 1 : Integer
//				.parseInt(request.getParameter("page"));
//
//		String pram = request.getParameter("pram") == null
//				|| request.getParameter("pram").isEmpty() ? "" : request
//				.getParameter("pram");
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("type", 1);
//		List<RzdjUserEntity> list = userDao.findAll(map);
//		model.addAttribute("list", list);
//		model.addAttribute("size", size);
//		model.addAttribute("page", page);
//		model.addAttribute("pram", pram);
//		model.addAttribute("count", userDao.getCount());
//
//		return "/user/list";
//	}
//
//	@RequestMapping("/list2")
//	public String userList2(HttpServletRequest request, Model model) {
//
//		int size = request.getParameter("size") == null
//				|| request.getParameter("size").isEmpty() ? 20 : Integer
//				.parseInt(request.getParameter("size"));
//
//		int page = request.getParameter("page") == null
//				|| request.getParameter("size").isEmpty() ? 1 : Integer
//				.parseInt(request.getParameter("page"));
//
//		String pram = request.getParameter("pram") == null
//				|| request.getParameter("pram").isEmpty() ? "" : request
//				.getParameter("pram");
//
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("type", 2);
//		List<RzdjUserEntity> list = userDao.findAll(map);
//		model.addAttribute("list", list);
//		model.addAttribute("size", size);
//		model.addAttribute("page", page);
//		model.addAttribute("pram", pram);
//		model.addAttribute("count", userDao.getCount());
//
//		return "/user/list2";
//	}
//
//
//	@RequestMapping("/list3")
//	public String userList3(HttpServletRequest request, Model model) {
//		int size = request.getParameter("size") == null
//				|| request.getParameter("size").isEmpty() ? 20 : Integer
//				.parseInt(request.getParameter("size"));
//
//		int page = request.getParameter("page") == null
//				|| request.getParameter("size").isEmpty() ? 1 : Integer
//				.parseInt(request.getParameter("page"));
//
//		String pram = request.getParameter("pram") == null
//				|| request.getParameter("pram").isEmpty() ? "" : request
//				.getParameter("pram");
//
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("type", 3);
//		List<RzdjUserEntity> list = userDao.findAll(map);
//		model.addAttribute("list", list);
//		model.addAttribute("size", size);
//		model.addAttribute("page", page);
//		model.addAttribute("pram", pram);
//		model.addAttribute("count", userDao.getCount());
//
//		return "/user/list3";
//	}
//
//
//	@RequestMapping("/delete")
//	@ResponseBody
//	public Map<String, Object> delete(HttpServletRequest request) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		String idlist = request.getParameter("id") == null
//				|| request.getParameter("id").isEmpty() ? "" : request
//				.getParameter("id");
//		boolean flag = true;
//
//		if (!idlist.isEmpty()) {
//			String[] idArray = idlist.split(",");
//			for (String idString : idArray) {
//				if (!userDao.deleteById(Integer.parseInt(idString))) {
//					flag = false;
//				}
//			}
//
//			result.put("success", flag);
//			result.put("msg", flag ? "删除成功" : "删除失败");
//		} else {
//			result.put("result", "不存在此参数");
//		}
//		return result;
//	}
//
//	@RequestMapping(value = { "/createOrUpdate" })
//	@ResponseBody
//	private Map<String, Object> createOrUpdate(HttpServletRequest request) {
//		Map<String, Object> result = new HashMap<String, Object>();
//
//		RzdjUserEntity model = null;
//		if (request.getParameter("id") == null
//				|| request.getParameter("id").isEmpty()) {
//			model = new RzdjUserEntity();
//		} else {
//			System.err.println(request.getParameter("id"));
//			Integer id = Integer.valueOf(request.getParameter("id"));
//			model = userDao.findById(id);
//		}
//
//		model.setName(request.getParameter("name"));
//		model.setLoginName(request.getParameter("loginId"));
//		model.setMobile(request.getParameter("mobile"));
//		model.setValid(Integer.valueOf(request.getParameter("valid")));
//		model.setType(String.valueOf(request.getParameter("type")));
//
//		if ((Integer)model.getUid() == null) {
//			int i=(int)(Math.random()*1000000+100000);
//			String messageCode = String.valueOf(i);
//			model.setPwd(Md5.getMD5_m(messageCode));
//		}
//		Map<String, Object> map1 = new HashMap<>();
//		Map<String, Object> map2 = new HashMap<>();
//		Map<String, Object> map3 = new HashMap<>();
//
//		map1.put("loginId",model.getLoginName());
//		map2.put("name",model.getName());
//		map3.put("mobile",model.getMobile());
//		List<RzdjUserEntity> list1 = userDao.findAll(map1);
//		List<RzdjUserEntity> list2 = userDao.findAll(map2);
//		List<RzdjUserEntity> list3 = userDao.findAll(map3);
//
//
//		if (request.getParameter("id") != null
//				&& !request.getParameter("id").isEmpty()) {
//
//			RzdjUserEntity oldUser = userDao.findById(Integer.valueOf(request.getParameter("id")));
//
//			if((list1!=null && list1.size()>0) && !oldUser.getLoginName().equals(model.getLoginName())) {
//				result.put("msg", "此登录名已存在");
//				return result;
//			}
//			if((list2!=null && list2.size()>0) &&!oldUser.getName().equals(model.getName())) {
//				result.put("msg", "此姓名已存在");
//				return result;
//			}
//			if((list3!=null && list3.size()>0) &&!oldUser.getMobile().equals(model.getMobile())) {
//				result.put("msg", "此手机号已存在");
//				return result;
//			}
//
//		}else {
//			if((list1!=null && list1.size()>0)) {
//				result.put("msg", "此登录名已存在");
//				return result;
//			}
//			if((list2!=null && list2.size()>0) ) {
//				result.put("msg", "此姓名已存在");
//				return result;
//			}
//			if((list3!=null && list3.size()>0)) {
//				result.put("msg", "此手机号已存在");
//				return result;
//			}
//		}
//
//		userDao.saveOrUpdate(model);
//
//		result.put("success", true);
//		if (request.getParameter("id") == null
//				|| request.getParameter("id").isEmpty()) {
//			result.put("msg", "新增成功,用户密码随机。");
//
//		} else {
//			result.put("msg", "更新成功");
//			RzdjUserEntity user = (RzdjUserEntity) request.getSession().getAttribute("currentUser");
//			//用户修改自己的信息
//			if(model.getUid() == user.getUid()){
//				//更新session
//				request.getSession().removeAttribute("currentUser");
//				request.getSession().setAttribute("currentUser", model);
//				System.err.println("更新session");
//			}
//		}
//
//		return result;
//	}
//
//	@RequestMapping(value = { "/getData" })
//	@ResponseBody
//	private Map<String, Object> getData(HttpServletRequest request)
//			throws Exception {
//		Map<String, Object> result = new HashMap<String, Object>();
//
//		Integer id = Integer.valueOf(request.getParameter("id"));
//		RzdjUserEntity model = userDao.findById(id);
//
//		result.put("success", true);
//		result.put("msg", "查询成功");
//		result.put("obj", model);
//
//		return result;
//	}
//
//	@RequestMapping(value={"/resetPwd"})
//	@ResponseBody
//	private Map<String, Object> resetPwd(HttpServletRequest request) {
//		Map<String, Object> result = new HashMap<>();
//
//		RzdjUserEntity model = null;
//		Integer id = Integer.valueOf(request.getParameter("id1"));
//		model = userDao.findById(id);
//
//		String pwd = request.getParameter("pwd");
//		String pwd1 = request.getParameter("pwd1");
//		Pattern p1 = Pattern.compile("\\d");
//		Pattern p2 = Pattern.compile("[a-z]");
//		Pattern p3 = Pattern.compile("[A-Z]");
//		if (pwd.length() < 8) {
//			result.put("success", false);
//			result.put("msg", "密码长度小于8位");
//			return result;
//		}
//
//		if (!p1.matcher(pwd).find()) {
//			result.put("success", false);
//			result.put("msg", "密码中至少需要一位数字");
//			return result;
//		}
//
//		if (!p2.matcher(pwd).find()) {
//			result.put("success", false);
//			result.put("msg", "密码中至少需要一位小写字母");
//			return result;
//		}
//
//		if (!p3.matcher(pwd).find()) {
//			result.put("success", false);
//			result.put("msg", "密码中至少需要一位大写字母");
//			return result;
//		}
//
//		if (!pwd.equals(pwd1)) {
//			result.put("success", false);
//			result.put("msg", "两次输入的密码不同");
//			return result;
//
//		}
//
//		model.setPwd(Md5.getMD5_m(pwd));
//		userDao.saveOrUpdate(model);
//
//		result.put("success", true);
//		result.put("msg", "修改密码成功");
//
//		return result;
//	}

}
