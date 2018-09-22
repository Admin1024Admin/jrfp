package com.ky.ct.rzdj.service.cyjzfpdk;

import com.ky.ct.rzdj.dao.cyjzfpdk.CyjzfpdkDao;
import com.ky.ct.rzdj.dao.cyjzfpdk.DdpkhDao;
import com.ky.ct.rzdj.model.cyjzfpdk.BaseCyjzfpdk;
import com.ky.ct.rzdj.model.cyjzfpdk.BaseCyjzfpdkDdpkh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CyjzfpdkService {
	@Autowired
	private CyjzfpdkDao cyjzfpdkDao;
	@Autowired
	private DdpkhDao ddpkhDao;

	/**
	 * 按条件分页查询
	 */
	public List<BaseCyjzfpdk> showByCondition(Map condition, int page, int limit) {
		List<BaseCyjzfpdk> list = cyjzfpdkDao.findPageByCondition(page, limit, condition);
		for (BaseCyjzfpdk cyjzfpdk : list) {
			//如果产业精准扶贫类别是其他类型主体精准扶贫贷款,那就设置一个值为是,便于展示到前端
			if ("其他类型主体精准扶贫贷款".equals(cyjzfpdk.getChanYeFuPinLeiBie())){
				cyjzfpdk.setQitaqita("是");
			}else if ("新型农业经营主体精准扶贫贷款".equals(cyjzfpdk.getChanYeFuPinLeiBie())){
				switch (cyjzfpdk.getZhuTiDaiKuanLeiBie()){
					case "农民专业合作贷款" :cyjzfpdk.setNmzy("是");break;
					case "农业产业化龙头企业贷款" :cyjzfpdk.setNycy("是");break;
					case "其他" :cyjzfpdk.setXxqt("是");break;
				}
			}

		}
		return list;
	}

	public long getCount(Map condition) {
		return (long) cyjzfpdkDao.getCount(condition);
	}

	public List<BaseCyjzfpdkDdpkh> getDaiDongMingDan(String agreementNo) {
		HashMap<String, Object> condition = new HashMap<>();
		condition.put("agreementNo", agreementNo);
		List<BaseCyjzfpdkDdpkh> ddpkh = ddpkhDao.findByCondition(condition);
		return ddpkh;
	}
}
