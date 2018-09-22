package com.ky.ct.rzdj.util.qtgrjzfpdkDaoChu;

import com.ky.ct.rzdj.model.BaseFpxexdHistory;
import com.ky.ct.rzdj.model.BaseQtgrjzfpdkHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QtgrzjfpdkLuRu {
public static BaseQtgrjzfpdkHistory luRu(BaseQtgrjzfpdkHistory q, String name, String value)  throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    switch (name){
        case "name":{
            q.setName(value);
            break;
        }
        case "cardId":{
            q.setCardId(value);
            break;
        }
        case "address":{
            q.setAddress(value);
            break;
        }
        case "telephone":{
            q.setTelephone(value);
            break;
        }
        case "agreementNo":{
            q.setAgreementNo(value);
            break;
        }
        case "daiKuanJinE":{
            q.setDaiKuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "daiKuanQiXian":{
            q.setDaiKuanQiXian(value);
            break;
        }
        case "daiKuanDate":{
            q.setDaiKuanDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "daoQiDate":{
            q.setDaoQiDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "daiKuanLiLv":{
            q.setDaiKuanLiLv(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "daiKuanZhongLei":{
            q.setDaiKuanZhongLei(value);
            break;
        }
        case "daiKuanFangShi":{
            q.setDaiKuanFangShi(value);
            break;
        }
        case "daiKuanYongTu":{
            q.setDaiKuanYongTu(value);
            break;
        }
        case "shiYongDiYu":{
            q.setShiYongDiYu(value);
            break;
        }
        case "chanYeLeiBie":{
            q.setChanYeLeiBie(value);
            break;
        }
        case "fuPinDaiKuanLeiBie":{
            q.setFuPinDaiKuanLeiBie(value);
            break;
        }
        //新型农业经营主体精准扶贫贷款类别
        case "zhuTiDaiKuanLeiBie":{
            q.setZhuTiDaiKuanLeiBie(value);
            break;
        }
        case "daiKuanJinRongJiGou":{
            q.setDaiKuanJinRongJiGou(value);
            break;
        }
        case "touFangDate":{
            q.setTouFangDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "touFangJinE":{
            q.setTouFangJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "leiJiTouFangJinE":{
            q.setLeiJiTouFangJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "weiTouFangYuE":{
            q.setWeiChangHuanYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "changHuanJinE":{
            q.setChangHuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "changHuanDate":{
            q.setChangHuanDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "leiJiChangHuanJinE":{
            q.setLeiJiChangHuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "weiChangHuanYuE":{
            q.setWeiChangHuanYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "yuQiJinE":{
            q.setYuQiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "yuQiDate":{
           q.setYuQiDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qianXiDate":{
            q.setQianXiDate(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qianXiJinE":{
            q.setQianXiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "liYiLianJieFangShi":{
            q.setLiYiLianJieFangShi(value);
            break;
        }
        case "daiDongPkhMingDan":{
            q.setDaiDongPkhMingDan(value);
            break;
        }
        case "daiDongPkrenKouShu":{
            q.setDaiDongPkRenKouShu(value.length()<1?null:Integer.valueOf(value));
            break;
        }
        case "zhiJieDaiDongXiaoYi":{
            q.setZhiJieDaiDongXiaoYi(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "note":{
            q.setNote(value);
            break;
        }
    }
    return q;
}
}
