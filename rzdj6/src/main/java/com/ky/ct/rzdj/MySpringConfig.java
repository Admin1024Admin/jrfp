package com.ky.ct.rzdj;

import com.ky.ct.rzdj.filter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class MySpringConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main.html").setViewName("admin/main");
		registry.addViewController("/luRuFields.html").setViewName("/admin/poor/jrfp/fpxedk/luRuFields");
		registry.addViewController("/baseMessage").setViewName("/admin/poor/fpxdtz/baseMessage");
		registry.addViewController("/fpxexd/uploadExcel").setViewName("/admin/poor/fpxdtz/uploadExcel");
		registry.addViewController("/qtgrjzfpdk/uploadExcel").setViewName("/admin/poor/qtgrjzfpdk/uploadQtgrjzfpdkExcel");
		registry.addViewController("/main2.html").setViewName("admin/main2");
		registry.addViewController("/jrfp").setViewName("admin/poor/jrfp/pkfJrfp");
		registry.addViewController("/test").setViewName("admin/poor/test");
	}

	//配置静态资源文件路径
	//通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。我们访问自定义my文件夹中
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
//		interceptor.addPathPatterns("/**");
//
//		String[] list = new String[] {
//				"/login",				//登录页面
//				"/checkLogin",			//登录action
//				"/loginOut",			//登出action
//				"/upload/**",			//上传的资料
//				"/imaegs/**",			//管理端的静态资源
//				"/css/**",				//管理端的静态资源
//				"/js/**",				//管理端的静态资源
//				"/fonts/**",			//管理端的静态资源
//                "/hello",               // layUI 測試頁面
//				"/layui/**",
//				"/layui/css/**",
//				"/layui/font/**",
//				"/layui/images/**",
//				"/layui/images/face/**",
//				"/layui/lay/**",
//				"/layui/lay/modules/**",
//				"/"
//		};
//
//		for (String url : list) {
//			interceptor.excludePathPatterns(url);
//		}
//
//		super.addInterceptors(registry);
//	}
}
