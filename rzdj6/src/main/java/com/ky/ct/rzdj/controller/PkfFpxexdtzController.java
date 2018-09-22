package com.ky.ct.rzdj.controller;

import com.ky.ct.rzdj.dao.PkfFpxexdtzDao;
import com.ky.ct.rzdj.model.PkfFpxexdtzEntity;
import com.ky.ct.rzdj.model.PkfInformationEntity;
import com.ky.ct.rzdj.service.PkfFpxexdtzService;
import com.ky.ct.rzdj.util.Fields;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PkfFpxexdtzController {
    @Autowired
    private PkfFpxexdtzDao pkfFpxexdtzDao;
    @Autowired
    private PkfFpxexdtzService pkfFpxexdtzService;
    private Map<String,Object> paramMap = new HashMap<>();
    private Set<String> cardIds = new HashSet<>();
    /**
     * 信息表
     * @param map
     * @return
     */
    @GetMapping("/pkfFpxexdtz")
    public String peopleMessage(Map<String,Object> map){
        long count =(long) pkfFpxexdtzDao.getCount();
        map.put("page",1);
        map.put("limit",15);
        map.put("count",count);
        System.out.println("---");
        return "admin/poor/jrfp/fpxedk/fpxedk";
    }

    /**
     * 分页请求
     * @param page
     * @param limit
     * @param map2
     * @return
     */
    @GetMapping("/pkfFpxexdtzPage")
    @ResponseBody
    public String findPkfInformationPage(@RequestParam(name="page",required = false,defaultValue = "1")int page,
                                         @RequestParam(name="limit",required = false,defaultValue = "15")int limit,Map<String,Object> map2){
        List<PkfFpxexdtzEntity> pkfFpxexdtzEntityList =  pkfFpxexdtzDao.findPage(page,limit);
        long count =(long) pkfFpxexdtzDao.getCount();
        System.out.println("总有"+count);
        Map<String,Object> map  = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pkfFpxexdtzEntityList);
        JSONObject jsonObject = JSONObject.fromObject(map);
        map2.put("page",page);
        map2.put("limit",limit);
        map2.put("count",count);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }
    /**
     * 自定义选择查询条件
     */
    @PostMapping("/fpxexdChooseWhere")
    public String jrfpChooseWhere(HttpServletRequest request,Map<String,Object> map){
        paramMap = Fields.getParams(request);
        System.out.println("参数列表："+paramMap);
        cardIds = pkfFpxexdtzService.getCardId(paramMap);
        return "admin/poor/jrfp/fpxedk/fields";
    }
    /**
     *  自定义选择查看的字段
     */
    @PostMapping("/fpxexdChooseFields")
    @ResponseBody
    public String jrfpChooseFields(HttpServletRequest request,Map<String,Object> map){
        List<String> fields = Fields.getFields(request);
        System.out.println("字段列表："+fields);
        Map<String,Object> resultMap = new HashMap<>();
        if(paramMap!=null&&paramMap.size()>0){
            resultMap = pkfFpxexdtzService.findFieldsAndWhere(paramMap,cardIds,fields);
        }
        for(String key:resultMap.keySet()){
            map.put(key,resultMap.get(key));
        }
        List<Object[]>  pkfInformationList=(List<Object[]>) resultMap.get("pkfInformationList");
        List<Object[]>  pkfFpbxList= (List<Object[]>) resultMap.get("pkfFpbxList");
        List<Object[]>  pkfDzbList= (List<Object[]>) resultMap.get("pkfDzbList");
        List<Object[]>  pkfPjsxList= (List<Object[]>) resultMap.get("pkfPjsxList");
        List<Object[]>  pkfFpxexdtzList= (List<Object[]>) resultMap.get("pkfFpxexdtzList");
        List<String> pkfInformationField = (ArrayList<String>) resultMap.get("pkfInformationField");
        List<Map<String,Object>> allList = new ArrayList<>();
        for(int i =0;i<pkfInformationList.size();i++){
            Object[] o1 = pkfInformationList.get(i);
            Map<String,Object> pkfInformationMap = new HashMap<>();
            for(int x = 0;x<o1.length;x++){
                String key = pkfInformationField.get(x);
                System.out.println("key:"+key+"----value:"+o1[x]);
                pkfInformationMap.put(key,o1[x]);
            }
            allList.add(pkfInformationMap);
        }
//        System.out.println("map结果集"+map);
        map.put("code",0);
        map.put("msg","");
        map.put("count",100);
        map.put("data",allList);
        JSONObject  jsonObject= JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    /**
     * 录入添加数据
     */
//    @PostMapping("/addMessage")
//    public String addMessage(HttpServletRequest request){
//        Map<String,Object> msgMap = Fields.getParams(request);
//
//    }
    /**
     * 录入字段 luRuFpxexd
     */
    @PostMapping("/luRuFpxexd")
    public String luRuFpxexd(HttpServletRequest request,Map<String,Object> map){
       List<String> fields = Fields.getFields(request);
       Map<String,Object> fiedsMap = new HashMap<>();
       for(String field:fields){
            switch (field){
                case "uid":{
                    fiedsMap.put(field,"编号");
                    break;
                }
                case "shiQuQi":{
                    fiedsMap.put(field,"市区旗");
                    break;
                }
                case "xiangZheng":{
                    fiedsMap.put(field,"乡镇");
                    break;
                }
                case "chun":{
                    fiedsMap.put(field,"村");
                    break;
                }
                case "she":{
                    fiedsMap.put(field,"社、组");
                    break;
                }
                case "familyNo":{
                    fiedsMap.put(field,"户编号");
                    break;
                }
                case "memberNo":{
                    fiedsMap.put(field,"人编号");
                    break;
                }
                case "name":{
                    fiedsMap.put(field,"名字");
                    break;
                }
                case "cardId":{
                    fiedsMap.put(field,"身份证号");
                    break;
                }
                case "members":{
                    fiedsMap.put(field,"家庭成员数");
                    break;
                }
                case "familyRelation":{
                    fiedsMap.put(field,"与户主关系");
                    break;
                }case "mz":{
                    fiedsMap.put(field,"民族");
                    break;
                }case "xueLi":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }case "schoolState":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "healthState":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "skill":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "workState":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "workMonth":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "isDaBinYiLiao":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "tuoPinState":{
                    fiedsMap.put(field,"户脱贫属性");
                    break;
                }
                case "pinKunState":{
                    fiedsMap.put(field,"贫困户属性");
                    break;
                }
                case "pinKunYuanYin":{
                    fiedsMap.put(field,"主要致贫原因");
                    break;
                }
                case "isWeiFangHu":{
                    fiedsMap.put(field,"危房户");
                    break;
                }
                case "isYinShuiAnQuan":{
                    fiedsMap.put(field,"饮水安全");
                    break;
                }
                case "isYinShuiKunNan":{
                    fiedsMap.put(field,"饮水困难");
                    break;
                }
                case "renJunChunShouRu":{
                    fiedsMap.put(field,"人均纯收入");
                    break;
                }
                case "telephone":{
                    fiedsMap.put(field,"联系电话");
                    break;
                }
                case "tongJiShiJian":{
                    fiedsMap.put(field,"统计时间");
                    break;
                }
                case "familyMember":{
                    fiedsMap.put(field,"家庭成员");
                    break;
                }
                case "familyMemberCount":{
                    fiedsMap.put(field,"家庭人口数");
                    break;
                }
                case "zhiYeCode":{
                    fiedsMap.put(field,"职业代码");
                    break;
                }case "cardIdType":{
                    fiedsMap.put(field,"证件类型");
                    break;
                }case "shouYiRen":{
                    fiedsMap.put(field,"受益人");
                    break;
                }case "beiBaoRenSign":{
                    fiedsMap.put(field,"受益人签字");
                    break;
                }case "huiJiaoRen":{
                    fiedsMap.put(field,"汇交人");
                    break;
                }case "touBaoCompany":{
                    fiedsMap.put(field,"投保公司");
                    break;
                }case "touBaoYear":{
                    fiedsMap.put(field,"投保年度");
                    break;
                }
                case "xianZhong":{
                    fiedsMap.put(field,"险种");
                    break;
                }
                case "billNo":{
                    fiedsMap.put(field,"投保单号");
                    break;
                }
                case "bornDate":{
                    fiedsMap.put(field,"出生日期");
                    break;
                }
                case "baoE":{
                    fiedsMap.put(field,"保额");
                    break;
                }
                case "baoFei":{
                    fiedsMap.put(field,"保费");
                    break;
                }
                case "address":{
                    fiedsMap.put(field,"地址");
                    break;
                }
                case "baoXianJinE":{
                    fiedsMap.put(field,"保险金额");
                    break;
                }
                case "touBaoRen":{
                    fiedsMap.put(field,"投保人");
                    break;
                }
                case "beiBaoRen":{
                    fiedsMap.put(field,"被保险人");
                    break;
                }
                case "gender":{
                    fiedsMap.put(field,"性别");
                    break;
                }
                case "canBaoType":{
                    fiedsMap.put(field,"参保人员类型");
                    break;
                }
                case "tianBaoDanWei":{
                    fiedsMap.put(field,"填报单位");
                    break;
                }
                case "tianBaoDate":{
                    fiedsMap.put(field,"填报时间");
                    break;
                }
                case "huZhu":{
                    fiedsMap.put(field,"户主姓名");
                    break;
                }
                case "daiKuanRen":{
                    fiedsMap.put(field,"贷款人姓名");
                    break;
                }
                case "wenHuaChengDu":{
                    fiedsMap.put(field,"文化程度");
                    break;
                }
                case "laoDongNengLi":{
                    fiedsMap.put(field,"劳动能力");
                    break;
                }
                case "shouXinEDu":{
                    fiedsMap.put(field,"授信额度");
                    break;
                }
                case "contactPhone":{
                    fiedsMap.put(field,"联系电话");
                    break;
                }
                case "tianBiaoRen":{
                    fiedsMap.put(field,"填表人");
                    break;
                }
                case "tianBiaoRenLianXi":{
                    fiedsMap.put(field,"填表人联系");
                    break;
                }
                case "shenHeRen":{
                    fiedsMap.put(field,"审核人");
                    break;
                }
                case "givenStars":{
                    fiedsMap.put(field,"信用评定等级");
                    break;
                }
                case "pingJiJiGou":{
                    fiedsMap.put(field,"评级机构");
                    break;
                }
                case "shouXinDate":{
                    fiedsMap.put(field,"授信日期");
                    break;
                }
                case "isQueryZhengXin":{
                    fiedsMap.put(field,"征信查询情况");
                    break;
                }
                case "shouXinZiLiaoOk":{
                    fiedsMap.put(field,"评级授信资料是否规范");
                    break;
                }
                case "isHuZhu":{
                    fiedsMap.put(field,"与户主是否一致");
                    break;
                }
                case "daiKuanBenJin":{
                    fiedsMap.put(field,"贷款本金");
                    break;
                }case "daiKuanYuE":{
                    fiedsMap.put(field,"贷款余额");
                    break;
                }
                case "fangKuanDate":{
                    fiedsMap.put(field,"放款日期");
                    break;
                }case "daiKuanTimeLimit":{
                    fiedsMap.put(field,"贷款期限");
                    break;
                }
                case "huanKuanDate":{
                    fiedsMap.put(field,"还款日期");
                    break;
                }
                case "daiKuanLiLv":{
                    fiedsMap.put(field,"贷款利率");
                    break;
                }
                case "leiJiTieXi":{
                    fiedsMap.put(field,"还款日期");
                    break;
                }
                case "huanBenJinE":{
                    fiedsMap.put(field,"还本金额");
                    break;
                }case "huanBenDate":{
                    fiedsMap.put(field,"还本时间");
                    break;
                }
                case "benJinYuQiJinE":{
                    fiedsMap.put(field,"本金逾期金额");
                    break;
                }
                case "benJinYuQiDate":{
                    fiedsMap.put(field,"本金逾期时间");
                    break;
                }
                case "qianXiJinE":{
                    fiedsMap.put(field,"欠息金额（元）");
                    break;
                }
                case "qianXiDate":{
                    fiedsMap.put(field,"欠息日期");
                    break;
                }
                case "daiKuanZiLiaoOk":{
                    fiedsMap.put(field,"贷款资料是否规范");
                    break;
                }
                case "ziJinShiYongOk":{
                    fiedsMap.put(field,"资金使用是否规范");
                    break;
                }
                case "daiKuanJiGou":{
                    fiedsMap.put(field,"贷款机构");
                    break;
                }
            }
       }
       map.put("fieldNames",fiedsMap);
       return "admin/poor/jrfp/fpxedk/addFpxedk";
    }
}
