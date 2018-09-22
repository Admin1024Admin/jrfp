package com.ky.ct.rzdj.dao;

import com.ky.ct.rzdj.model.RzdjUserEntity;
import com.ky.ct.rzdj.util.Md5;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao extends BaseDaoImpl<RzdjUserEntity> {
	public RzdjUserEntity checkLogin(String loginId, String pwd) {
		String sql = "select * from rzdj_user where LoginName = :loginId";
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("loginId", loginId);
		RzdjUserEntity user = findBySql(sql, condition);

		if (user == null)
			return null;
		String md5 = Md5.getMD5_m(pwd);
		if (user.getPwd().equals(md5)) {
			return user;
		} else {
			return null;
		}
	}
}
