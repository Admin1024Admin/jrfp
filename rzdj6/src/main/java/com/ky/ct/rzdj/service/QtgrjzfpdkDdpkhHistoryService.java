package com.ky.ct.rzdj.service;

import com.ky.ct.rzdj.dao.QtgrjzfpdkDdpkhHistoryDao;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkh;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkhHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QtgrjzfpdkDdpkhHistoryService {
    @Autowired
    private QtgrjzfpdkDdpkhHistoryDao qtgrjzfpdkDdpkhHistoryDao;
    /**
     * 根据合同编号查询
     */
    public List<BaseQtgrjzfpdkDdpkhHistory> findByAgreementNo(String agreementNo){
        Map<String,Object> map = new HashMap<>();
        map.put("agreementNo",agreementNo);
        List<BaseQtgrjzfpdkDdpkhHistory> qtgrjzfpdkDdpkhHistories = qtgrjzfpdkDdpkhHistoryDao.findByCondition(map);
        return qtgrjzfpdkDdpkhHistories;
    }
}
