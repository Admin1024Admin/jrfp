package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.service.FpxexdHistoryService;
import com.ky.ct.rzdj.service.FpxexdService;
import com.ky.ct.rzdj.util.Fields;
import com.ky.ct.rzdj.util.JsonConfigUtil;
import com.ky.ct.rzdj.util.TwoObjectUtil;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fpxexdHistory")
public class FpxexdHistoryController {
	@Autowired
	private FpxexdHistoryService fpxexdHistoryService;
	@Autowired
	private FpxexdService fpxexdService;

	/**
	 * 页面跳转
	 */

	@RequestMapping("/checkFpxexd")
	public String checkFpxexd() {
		return "admin/poor/check/check";
	}

	/**
	 * 查询未审核数据
	 */
	@RequestMapping("/fpxexdCheckList")
	@ResponseBody
	public String list(HttpServletRequest HttpServletRequest,
					   @RequestParam(defaultValue = "1") int page,
					   @RequestParam(defaultValue = "10") int limit,String checkStatus) {
		RzdjUserEntity user = (RzdjUserEntity) HttpServletRequest.getSession().getAttribute("currentUser");
		List<BaseFpxexdHistory> result = fpxexdHistoryService.searChAndOrder(HttpServletRequest.getParameterMap(), user, page, limit);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", fpxexdHistoryService.searChAndOrderCount(HttpServletRequest.getParameterMap(), user));
		resultMap.put("data", result);

		JSONObject jsonObject = JSONObject.fromObject(resultMap, JsonConfigUtil.getJsonConfig());
		return jsonObject.toString();
	}

	/**
	 * 导出全部数据
	 */
	@RequestMapping("/daoChuAll")
	public void daochuAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RzdjUserEntity user = (RzdjUserEntity) request.getSession().getAttribute("currentUser");
		SXSSFWorkbook workbook = fpxexdHistoryService.daoChuAll(user);
		//导出文件
		String fileName = "All" + ".xlsx";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	/**
	 * 显示导出时的字段弹出层
	 */
	@RequestMapping("/gotoFields")
	public String gotoFields(String xiang, String chun, String cardId, String name, String checkStatus, Model model) {
		model.addAttribute("xiang", xiang);
		model.addAttribute("chun", chun);
		model.addAttribute("cardId", cardId);
		model.addAttribute("name", name);
		model.addAttribute("checkStatus", checkStatus);
		return "admin/poor/check/fields";
	}

	/**
	 * 选择导出
	 */
	@RequestMapping("/chooseField")
	public void chooseField(HttpServletRequest request, HttpServletResponse response, String xiang1, String chun1
			, String cardId1, String name1, String checkStatus1) throws Exception {
		List<String> fields = Fields.getFields(request);
		fields.add("no");
		System.out.println("选择的字段----->" + fields);
		RzdjUserEntity user = (RzdjUserEntity) request.getSession().getAttribute("currentUser");
		SXSSFWorkbook workbook = fpxexdHistoryService.chooseFieldExport(fields,user, xiang1, chun1, cardId1, name1, checkStatus1);
		//导出文件
		String fileName = "information" + ".xlsx";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		response.flushBuffer();
		workbook.write(response.getOutputStream());
	}

	@RequestMapping("/focusOne")
	public String focusOne(int no, String daiKuanRenCardId, Map<String, Object> map, String update) {
		//得到这条记录
		BaseFpxexdHistory historyNow = fpxexdHistoryService.findOneByNo(no);
		map.put("fpxexd", historyNow);
		//只是查看信息
		if (update == null) {
			return "admin/poor/check/viewOne";
		} else {
			//对比是否是已存在
			List<BaseFpxexdHistory> lists = fpxexdHistoryService.findBydaiKuanRenCardId(daiKuanRenCardId);
			if (lists.size() == 1) {
				//没有旧数据,直接新增
				return "admin/poor/check/updateOne";
			}else {
				//需要进行对比字段
				//得到上一次的记录
				BaseFpxexdHistory historyOld = lists.get(0);
				map.put("fpxexdOld", historyOld);
				System.out.println(historyOld);
				List<String> list = null;
				//得到不同的数据
				try {
					list = TwoObjectUtil.compareFpxexdAndHistory(historyNow, historyOld);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				map.put("diff", list);
				return "admin/poor/check/FieldCompare";
			}
		}
	}

	//更新或者新增数据
	@RequestMapping(value = "/saveOne")
	@ResponseBody
	@Transactional
	public String saveOne(HttpServletRequest req, BaseFpxexdHistory baseFpxexdHistory) {
		BaseFpxexdHistory database = fpxexdHistoryService.findOneByNo(baseFpxexdHistory.getNo());
		database = (BaseFpxexdHistory) TwoObjectUtil.copyToFpxexdNotEmpty(baseFpxexdHistory, database);
		Date date = new Date();
		HttpSession session = req.getSession();
		RzdjUserEntity user = (RzdjUserEntity) session.getAttribute("currentUser");
		database.setCheckDate(date);
		database.setCheckPerson(user.getName());
		boolean b = fpxexdHistoryService.saveOrUpdate(database);

		if ("通过".equals(database.getCheckStatus())) {
			//审核通过的话往向另一张表添加数据
			BaseFpxexd fpxexd = new BaseFpxexd();
			BaseFpxexd baseFpxexd;
			baseFpxexd = (BaseFpxexd) TwoObjectUtil.copyToFpxexd(database, fpxexd);
			baseFpxexd.setHistoryNo(database.getNo());
			b = b && fpxexdService.savaSingle(baseFpxexd);
		}

		return b ? "ok" : "no";
	}

	@RequestMapping("/delByNo")
	@ResponseBody
	public String delByNo(int no) {
		BaseFpxexdHistory one = fpxexdHistoryService.findOneByNo(no);
		one.setDelDate(new Date());
		one.setDelStatus("已删除");
		boolean b = fpxexdHistoryService.saveOrUpdate(one);
		return b ? "删除成功" : "删除失败";
	}
}
