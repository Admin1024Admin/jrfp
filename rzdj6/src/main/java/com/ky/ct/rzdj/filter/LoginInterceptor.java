package com.ky.ct.rzdj.filter;

import com.ky.ct.rzdj.model.RzdjUserEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截未登录用户
@Component
public class LoginInterceptor implements HandlerInterceptor {

	private final String ADMINSESSION = "currentUser";
	private final String CFG = "cfg";

	// 拦截前处理
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object obj) throws Exception {
		RzdjUserEntity user = null;
		Object userObject = request.getSession().getAttribute(ADMINSESSION);
		//Object cfgObject = request.getSession().getAttribute(CFG);
		
		// 请求的路径
		String url = request.getServletPath().toString();
		
		//操作员不能访问的界面
		String[] list = new String[] {
				"/user",				//用户管理
				"/user/",				//用户管理
				"/sysConfig/list"           //单位管理
		};
		
		//管理员不能访问的界面
		String[] list2 = new String[] {
				"/user/list2/",				//用户管理
				"/user/list3/",				//用户管理
				"/set/dpt/"                 //单位设置
		};
		
		//未登录
		/*if (StringUtils.isEmpty(userObject) || StringUtils.isEmpty(cfgObject)) {
			response.sendRedirect("/login");
			return false;
		}*/
		if (StringUtils.isEmpty(userObject)) {
			response.sendRedirect("/login");
			return false;
		}
		
		user = (RzdjUserEntity) userObject;
		
		if(Integer.parseInt(user.getType()) == 1){
			for(String urls : list){
				if(url.indexOf(urls) > -1){
					response.sendRedirect("/login");
					return false;
				}
			}
		}
		
		if(Integer.parseInt(user.getType()) == 2){
			for(String urls : list2){
				if(url.indexOf(urls) > -1){
					response.sendRedirect("/login");
					return false;
				}
			}
		}

		return true;
	}

	// 拦截后处理
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	// 全部完成后处理
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

}