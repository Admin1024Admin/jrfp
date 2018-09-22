package com.ky.ct.rzdj.controller.cyjzfpdk;

import com.ky.ct.rzdj.model.cyjzfpdk.BaseCyjzfpdk;
import com.ky.ct.rzdj.model.cyjzfpdk.BaseCyjzfpdkDdpkh;
import com.ky.ct.rzdj.service.cyjzfpdk.CyjzfpdkService;
import com.ky.ct.rzdj.util.Fields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cyjzfpdk")
public class CyjzfpdkController {
	@Autowired
	private CyjzfpdkService cyjzfpdkService;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/cyjzfpdk")
	public String cyjzfpdk(){
		return "admin/poor/cyjzfpdk/baseMessage";
	}
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/show")
	@ResponseBody
	public HashMap<Object, Object> show(HttpServletRequest request,
										@RequestParam(name="page",required = false,defaultValue = "1")int page,
										@RequestParam(name="limit",required = false,defaultValue = "10")int limit){
		Map<String, Object> condition = Fields.getParamsExceptPageAndLimit(request);
		List<BaseCyjzfpdk> list = cyjzfpdkService.showByCondition(condition, page, limit);
		HashMap<Object, Object> map = new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("count",cyjzfpdkService.getCount(condition));
		map.put("data", list);
		return map;
	}
	@RequestMapping("/getDaiDongMingDan")
	@ResponseBody
	public List<BaseCyjzfpdkDdpkh> getDaiDongMingDan(String agreementNo){
		System.out.println(agreementNo);
		List<BaseCyjzfpdkDdpkh> mingDan = cyjzfpdkService.getDaiDongMingDan(agreementNo);
		System.out.println(mingDan);
		return mingDan;
	}
}
