package com.ky.ct.rzdj.controller.fpbx;

import com.ky.ct.rzdj.model.BaseFpbHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkDdpkhHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkHistory;
import com.ky.ct.rzdj.service.FpbxHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FpbxHistoryController {
    @Autowired
    private FpbxHistoryService fpbxHistoryService;

    /**
     * 录入单条数据  记录表
     */
    @PostMapping("/saveSingle")
    @ResponseBody
    public String savaSingle(BaseFpbHistory baseFpbHistory){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("保存的新数据--->"+baseFpbHistory);
        //根据贷款合同编号和贷款机构和投放日期和偿还贷款时间是否存在该用户
        String cardId = baseFpbHistory.getCardId();
        //去数据库查询看是否存在数据
        BaseFpbHistory fpbHistory = fpbxHistoryService.findByCardId(cardId);
        System.out.println("fpbHistory在数据库存在--->"+(fpbHistory!=null)); //false
        boolean b = false;
        if(fpbHistory!=null){
            b = fpbxHistoryService.updateSingle(baseFpbHistory,fpbHistory);
        }else{
            b = fpbxHistoryService.savaSingle(baseFpbHistory);
        }
        System.out.println("保存的结果----->"+b);
        if(b){
            return "ok";
        }
        return "no";
    }
}
