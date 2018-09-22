package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.service.PkfJrfpService;
import com.ky.ct.rzdj.util.Fields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PkfJrfpController {
    @Autowired
    private PkfJrfpService jrfpService;
    private Map<String,Object> paramMap = new HashMap<>();
    private Set<String> cardIds = new HashSet<>();
    /**
     * 自定义选择查询条件
     */
    @PostMapping("/jrfpChooseWhere")
    public String jrfpChooseWhere(HttpServletRequest request){
        paramMap = Fields.getParams(request);
        System.out.println("参数列表："+paramMap);
        cardIds = jrfpService.getCardId(paramMap);
        return "admin/poor/jrfp/fields";
    }

    /**
     *  自定义选择查看的字段
     */
    @PostMapping("/jrfpChooseFields")
    @ResponseBody
    public String jrfpChooseFields(HttpServletRequest request,Map<String,Object> map){
        List<String> fields = Fields.getFields(request);
        System.out.println("字段列表："+fields);
        Map<String,Object> resultMap = new HashMap<>();
        if(paramMap!=null&&paramMap.size()>0){
            resultMap = jrfpService.findFieldsAndWhere(paramMap,cardIds,fields);
        }
        for(String key:resultMap.keySet()){
            map.put(key,resultMap.get(key));
        }
//        System.out.println("map结果集"+map);
        return "xxxxxxxx";
    }
}
