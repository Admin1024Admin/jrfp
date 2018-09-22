package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhDao;
import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhHistoryDao;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QtgrjzfpdkDdpkhService {
    @Autowired
    private QtgrjzfpdkDdpkhDao qtgrjzfpdkDdpkhDao;
    /**
     * 根据合同编号查询
     */
    public List<BaseQtgrjzfpdkDdpkh> findByAgreementNo(String agreementNo){
        Map<String,Object> map = new HashMap<>();
        map.put("agreementNo",agreementNo);
        List<BaseQtgrjzfpdkDdpkh> qtgrjzfpdkDdpkhs = qtgrjzfpdkDdpkhDao.findByCondition(map);
        return qtgrjzfpdkDdpkhs;
    }

    /**
     * 保存合同
     */
    public boolean saveQtgrjzfpdkDdpkh(BaseQtgrjzfpdkDdpkh qtgrjzfpdkDdpkh){
        return qtgrjzfpdkDdpkhDao.add(qtgrjzfpdkDdpkh);
    }
}
