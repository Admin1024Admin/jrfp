package com.ky.ct.rzdj.dao;

import com.ky.ct.rzdj.model.ProjectQuestion;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProjectQuestionDao extends BaseDaoImpl<ProjectQuestion>{	
	public List<ProjectQuestion> findListByPid(Integer pid){
		Map<String, Object> map = new HashMap<>(); //根据项目id找到问题
		map.put("projectId", pid); //父id
		return this.findAll(map); //问题集合
	}
}
