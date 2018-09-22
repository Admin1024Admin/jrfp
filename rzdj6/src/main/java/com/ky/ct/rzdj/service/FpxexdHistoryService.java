package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.FpxexdHistoryDao;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.FpxexdHistoryDaoChu2;
import com.ky.ct.rzdj.util.FpxexdHistoryDaochu;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FpxexdHistoryService {
	@Autowired
	private FpxexdHistoryDao fpxexdHistoryDao;

	/**
	 * 根据条件查数据并排序
	 */
	public List<BaseFpxexdHistory> searChAndOrder(Map<String, String[]> parameterMap, RzdjUserEntity user, int page, int limit) {
		StringBuffer sql = new StringBuffer("select * from base_fpxexd_history");
		boolean haveCondition = false;//是否有条件(0无,1有,>1有过了)
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue()[0];
			//默认查未审核,但是直接传中文会乱码
			if ("checkStatus".equals(key) && "1".equals(val)) {
				val = "未审核";
			}
			//有条件,而且不是分页参数
			if (!key.equals("limit") && !key.equals("page")) {
				//第一个条件
				if (!haveCondition && !"".equals(val)) {
					sql.append(" where");
					haveCondition = true;
					sql.append(" "+key + "='" + val+"'");
				}else if(haveCondition && !val.equals("")){
					sql.append(" and " + key + "='" + val+"'");
				}
			}
		}
		//是否为管理员,不是的话只能查到
		boolean isAdmin = false;
		if (user.getRole() == 1) {
			isAdmin = true;
		}
		if (haveCondition) {
			sql.append(" and delStatus='未删除'");
			if (!isAdmin) {
				sql.append(" and operationPerson ='" + user.getName() +"'");
			}
		}else {
			sql.append(" where delStatus='未删除'");
			if (!isAdmin) {
				sql.append(" and operationPerson ='" + user.getName() +"'");
			}
		}
		sql.append(" order by checkDate desc,no asc");
		sql.append(" limit " + (page - 1) * limit + "," + limit);
		return fpxexdHistoryDao.findListBySql(sql.toString());
	}

	/**
	 * 根据条件查个数
	 */
	public Object searChAndOrderCount(Map<String, String[]> parameterMap, RzdjUserEntity user){
		StringBuffer sql = new StringBuffer("select count(*) from base_fpxexd_history");
		boolean haveCondition = false;//是否有条件(0无,1有,>1有过了)
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue()[0];
			//默认查未审核,但是直接传中文会乱码
			if ("checkStatus".equals(key) && "1".equals(val)) {
				val = "未审核";
			}
			//有条件,而且不是分页参数
			if (!key.equals("limit") && !key.equals("page")) {
				//第一个条件
				if (!haveCondition && !"".equals(val)) {
					sql.append(" where");
					haveCondition = true;
					sql.append(" "+key + "='" + val+"'");
				}else if(haveCondition && !val.equals("")){
					sql.append(" and " + key + "='" + val+"'");
				}
			}
		}
		//是否为管理员,不是的话只能查到
		boolean isAdmin = false;
		if (user.getRole() == 1) {
			isAdmin = true;
		}
		if (haveCondition) {
			sql.append(" and delStatus='未删除'");
			if (!isAdmin) {
				sql.append(" and operationPerson ='" + user.getName() +"'");
			}
		}else {
			sql.append(" where delStatus='未删除'");
			if (!isAdmin) {
				sql.append(" and operationPerson ='" + user.getName() +"'");
			}
		}
		return fpxexdHistoryDao.countBySql(sql.toString());
	}

	/**
	 * 导出全部
	 */
	public SXSSFWorkbook daoChuAll(RzdjUserEntity user) {
		FpxexdHistoryDaoChu2 dc = new FpxexdHistoryDaoChu2();
		//获取全部字段
		Map<String,String> fieldsMap = FpxexdHistoryDaochu.getPkfDzbField();
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);
		//获取所有字段
		List<String>names = new ArrayList<>();
		for(String key:fieldsMap.keySet()){
			names.add(key);
		}
		System.out.println("names----->"+names);
		Map<String,Integer> numberMap = new HashMap<>();
		numberMap.put("shen",8);
		numberMap.put("j",10);
		numberMap.put("y",6);
		numberMap.put("f",20);
		numberMap.put("c",13);
		numberMap.put("s",12);
		numberMap.put("q",14);
		Sheet sheet = dc.getSheet(fieldsMap,names,numberMap,workbook);
		HashMap<String, Object> condition = new HashMap<>();
		condition.put("delStatus", "未删除");
		if (user.getRole() != 1) {
			condition.put("operationPerson", user.getName());
		}
		List<BaseFpxexdHistory> fpxexdHistories = fpxexdHistoryDao.findAll(condition);
		dc.FpxexdDaoChu(sheet,names,fpxexdHistories,workbook);
		return workbook;
	}
	/**
	 * 根据选择的字段导出数据
	 */
	public SXSSFWorkbook chooseFieldExport(List<String> fields,RzdjUserEntity user,String xiang,String chun,String cardId,
										   String name,String checkStatus){
		//将前端传递过来的字段排序
		Map<String,String> fieldsMap = FpxexdHistoryDaochu.getPkfDzbField();
		List<String> fiedsList = new ArrayList<>();
		for (String key : fieldsMap.keySet()) {
			for(String field:fields){
				if(field.equals(key)){
					fiedsList.add(key);
				}
			}
		}
		System.out.println("排序后的字段---->"+fiedsList);
		//遍历按照条件查询好的数据封装表格
		//创建数据表
		// 内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);
		FpxexdHistoryDaoChu2 daoChu2 = new FpxexdHistoryDaoChu2();
		Map<String,Integer> numberMap = daoChu2.getNumber(fiedsList);
		// Sheet sheet = FpxexdDaochu.getSheet(fieldsMap,fiedsList,workbook);
		Sheet sheet = daoChu2.getSheet(fieldsMap,fiedsList,numberMap,workbook);
		HashMap<String, Object> condition = new HashMap<>();
		if (user.getRole() != 1) {
			condition.put("operationPerson", user.getName());
		}
		if (!"".equals(xiang)){
			condition.put("xiang", xiang);
		}
		if (!"".equals(chun)){
			condition.put("chun", chun);
		}
		if (!"".equals(cardId)){
			condition.put("cardId", cardId);
		}
		if (!"".equals(name)){
			condition.put("name", name);
		}
		if (!"".equals(checkStatus)){
			condition.put("checkStatus", checkStatus);
		}
		condition.put("delStatus", "未删除");
		List<BaseFpxexdHistory> data = fpxexdHistoryDao.findAll(condition);
		daoChu2.FpxexdDaoChu(sheet,fiedsList,data,workbook);
		return workbook;
	}

	/**
	 * 根据编号查记录
	 */
	public BaseFpxexdHistory findOneByNo(int no) {
		return fpxexdHistoryDao.findById(no);
	}

	/**
	 * 保存或者更新一个记录
	 */
	public boolean saveOrUpdate(BaseFpxexdHistory baseFpxexdHistory) {
		return fpxexdHistoryDao.saveOrUpdate(baseFpxexdHistory);
	}

	/**
	 * 根据身份证号查数据
	 */
	public List<BaseFpxexdHistory> findBydaiKuanRenCardId(String daiKuanRenCardId) {
		String sql = "select * from base_fpxexd_history where delStatus='未删除' and daiKuanRenCardId='" +
				daiKuanRenCardId + "' order by fuPinfangKuanRiQi desc";
		return fpxexdHistoryDao.findListBySql(sql);
	}
}
