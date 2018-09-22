package com.ky.ct.rzdj.util;

import com.ky.ct.rzdj.model.BaseFpxexd;
import com.ky.ct.rzdj.model.BaseFpxexdHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FpxexdLuRu {
//    public static BaseFpxexd luRu(BaseFpxexd f,String name, String value)  throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        switch (name){
//            case "xiang":{
//                f.setXiang(value);
//                break;
//            }
//            case "chun":{
//                f.setChun(value);
//                break;
//            }
//            case "zu":{
//                f.setZu(value);
//                break;
//            }
//            case "name":{
//                f.setName(value);
//                break;
//            }
//            case "cardId":{
//                f.setCardId(value);
//                break;
//            }
//            case "members":{
//                f.setMembers(value.length()<1?null:Integer.valueOf(value));
//                break;
//            }
//            case "daiKuanRenXingMing":{
//                f.setDaiKuanRenXingMing(value);
//                break;
//            }
//            case "daiKuanRenCardId":{
//                f.setDaiKuanRenCardId(value);
//                break;
//            }
//            case "familyRelation":{
//                f.setFamilyRelation(value);
//                break;
//            }
//            case "tuoPinState":{
//                f.setTuoPinState(value);
//                break;
//            }
//            case "yuanYouYuE":{
//                f.setYuanYouYuE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "yuanYouIsYuQi":{
//                f.setYuanYouIsYuQi(value);
//                break;
//            }
//            case "yuanYouYuQiJinE":{
//                f.setYuanYouYuQiJinE(value.length()<1?null:Double.parseDouble(value));
//                break;
//            }
//            case "yuanYouYuQiShiJian":{
//                f.setYuanYouYuQiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "yuanYouQianXiJinE":{
//                f.setYuanYouQianXiJinE(value.length()<1?null:Double.parseDouble(value));
//                break;
//            }
//            case "yuanYouQianXiShiJian":{
//                f.setYuanYouQianXiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPingivenStars":{
//                f.setFuPingivenStars(value);
//                break;
//            }
//            case "fuPinshouXinEDu":{
//                f.setFuPinshouXinEDu(value.length()<1?null:Double.parseDouble(value));
//                break;
//            }
//            case "fuPinshouXinJiGou":{
//                f.setFuPinshouXinJiGou(value);
//                break;
//            }
//            case "fuPinshouxinData":{
//                f.setFuPinshouxinData(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPinXiaoDaidaiKuanJinE":{
//                f.setFuPinXiaoDaidaiKuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPindaiKuanQiXian":{
//                f.setFuPindaiKuanQiXian(value);
//                break;
//            }
//            case "fuPinfangKuanRiQi":{
//                f.setFuPinfangKuanRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPindaoQiRiQi":{
//                f.setFuPindaoQiRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPinXiaoDaiDaiKuanLiLv":{
//                f.setFuPinXiaoDaiDaiKuanLiLv(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPindaiKuanJiGou":{
//                f.setFuPindaiKuanJiGou(value);
//                break;
//            }
//            case "fuPinleiJiTieXi":{
//                f.setFuPinleiJiTieXi(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPinchangHuanDaiKuanJInE":{
//                f.setFuPinchangHuanDaiKuanJInE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPinhuanKuanShiJian":{
//                f.setFuPinhuanKuanShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPindaiKuanYuE":{
//                f.setFuPindaiKuanYuE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPinyuQiDaiKuanJinE":{
//                f.setFuPinyuQiDaiKuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPinyuQiDaiKuanShiJian":{
//                f.setFuPinyuQiDaiKuanShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPinqianXiJinE":{
//                f.setFuPinqianXiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "fuPinqianXiShiJian":{
//                f.setFuPinqianXiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "fuPinYingDaiWeiDaiShiBie":{
//                f.setFuPinYingDaiWeiDaiShiBie(value);
//                break;
//            }
//            case "fuPinDaiKuanYongTu":{
//                f.setFuPinDaiKuanYongTu(value);
//                break;
//            }
//
//            case "chuangYeJinE":{
//                f.setChuangYeJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "chuangYeQiXian":{
//                f.setChuangYeQiXian(value);
//                break;
//            }
//            case "chuangYeFangKuanRiQi":{
//                f.setChuangYeFangKuanRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "chuangYeDaoQiShiJian":{
//                f.setChuangYeDaoQiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "chuangYeLiLv":{
//                f.setChuangYeLiLv(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "chuangYeChangHuanJinE":{
//                f.setChuangYeChangHuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "changYeHuangKuanShiJian":{
//                f.setChangYeHuangKuanShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "chuangYeYuE":{
//                f.setChuangYeYuE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "chuangYeYuQiJinE":{
//                f.setChuangYeYuQiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "chuangYeYuQiShiJian":{
//                f.setChuangYeYuQiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "chuangYeQianXiJinE":{
//                f.setChuangYeQianXiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "chuangYeQianXiShiJian":{
//                f.setChuangYeQianXiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "chuangYeYongTu":{
//                f.setChuangYeYongTu(value);
//                break;
//            }
//
//            case "shengYuanJinE":{
//                f.setShengYuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYuanQiXian":{
//                f.setShengYuanQiXian(value);
//                break;
//            }
//            case "shengYuanFangKuanRiQi":{
//                f.setShengYuanFangKuanRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "shengYaunDaoQiRiQi":{
//                f.setShengYaunDaoQiRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "shengYaunLiLv":{
//                f.setShengYaunLiLv(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYaunChangHuanJinE":{
//                f.setShengYaunChangHuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYuanHuanKuanShiJian":{
//                f.setShengYuanHuanKuanShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "shengYuanYuE":{
//                f.setShengYuanYuE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYuanYuQiJinE":{
//                f.setShengYuanYuQiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYuanYuQiShiJian":{
//                f.setShengYuanYuQiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "shengYuanQianXiJinE":{
//                f.setShengYuanQianXiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "shengYuanQianXiShiJian":{
//                f.setShengYuanQianXiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//
//            case "qiTaJinE":{
//                f.setQiTaJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaQiXian":{
//                f.setQiTaQiXian(value);
//                break;
//            }
//            case "qiTaFangKuanRiQi":{
//                f.setQiTaFangKuanRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "qiTaDaoQiRiQi":{
//                f.setQiTaDaoQiRiQi(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "qiTaLiLv":{
//                f.setQiTaLiLv(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaChangHuanJinE":{
//                f.setQiTaChangHuanJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaChangHuangKuanShiJian":{
//                f.setQiTaChangHuangKuanShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "qiTaYuE":{
//                f.setQiTaYuE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaYuQiJinE":{
//                f.setQiTaYuQiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaYuQiShiJian":{
//                f.setQiTaYuQiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "qiTaQianXiJinE":{
//                f.setQiTaQianXiJinE(value.length()<1?null:Double.valueOf(value));
//                break;
//            }
//            case "qiTaQianXiShiJian":{
//                f.setQiTaQianXiShiJian(value.length()<1?null:sdf.parse(value));
//                break;
//            }
//            case "qiTaYongTu":{
//                f.setQiTaYongTu(value);
//                break;
//            }
//            case "note":{
//                f.setNote(value);
//                break;
//            }
//        }
//        return f;
//    }
public static BaseFpxexdHistory luRu(BaseFpxexdHistory f, String name, String value)  throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    switch (name){
        case "xiang":{
            f.setXiang(value);
            break;
        }
        case "chun":{
            f.setChun(value);
            break;
        }
        case "zu":{
            f.setZu(value);
            break;
        }
        case "name":{
            f.setName(value);
            break;
        }
        case "cardId":{
            f.setCardId(value);
            break;
        }
        case "members":{
            f.setMembers(value.length()<1?null:Integer.valueOf(value));
            break;
        }
        case "daiKuanRenXingMing":{
            f.setDaiKuanRenXingMing(value);
            break;
        }
        case "daiKuanRenCardId":{
            f.setDaiKuanRenCardId(value);
            break;
        }
        case "familyRelation":{
            f.setFamilyRelation(value);
            break;
        }
        case "tuoPinState":{
            f.setTuoPinState(value);
            break;
        }
        case "yuanYouYuE":{
            f.setYuanYouYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "yuanYouIsYuQi":{
            f.setYuanYouIsYuQi(value);
            break;
        }
        case "yuanYouYuQiJinE":{
            f.setYuanYouYuQiJinE(value.length()<1?null:Double.parseDouble(value));
            break;
        }
        case "yuanYouYuQiShiJian":{
            f.setYuanYouYuQiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "yuanYouQianXiJinE":{
            f.setYuanYouQianXiJinE(value.length()<1?null:Double.parseDouble(value));
            break;
        }
        case "yuanYouQianXiShiJian":{
            f.setYuanYouQianXiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPingivenStars":{
            f.setFuPingivenStars(value);
            break;
        }
        case "fuPinshouXinEDu":{
            f.setFuPinshouXinEDu(value.length()<1?null:Double.parseDouble(value));
            break;
        }
        case "fuPinshouXinJiGou":{
            f.setFuPinshouXinJiGou(value);
            break;
        }
        case "fuPinshouxinData":{
            f.setFuPinshouxinData(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPinXiaoDaidaiKuanJinE":{
            f.setFuPinXiaoDaidaiKuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPindaiKuanQiXian":{
            f.setFuPindaiKuanQiXian(value);
            break;
        }
        case "fuPinfangKuanRiQi":{
            f.setFuPinfangKuanRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPindaoQiRiQi":{
            f.setFuPindaoQiRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPinXiaoDaiDaiKuanLiLv":{
            f.setFuPinXiaoDaiDaiKuanLiLv(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPindaiKuanJiGou":{
            f.setFuPindaiKuanJiGou(value);
            break;
        }
        case "fuPinleiJiTieXi":{
            f.setFuPinleiJiTieXi(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPinchangHuanDaiKuanJInE":{
            f.setFuPinchangHuanDaiKuanJInE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPinhuanKuanShiJian":{
            f.setFuPinhuanKuanShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPindaiKuanYuE":{
            f.setFuPindaiKuanYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPinyuQiDaiKuanJinE":{
            f.setFuPinyuQiDaiKuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPinyuQiDaiKuanShiJian":{
            f.setFuPinyuQiDaiKuanShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPinqianXiJinE":{
            f.setFuPinqianXiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "fuPinqianXiShiJian":{
            f.setFuPinqianXiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "fuPinYingDaiWeiDaiShiBie":{
            f.setFuPinYingDaiWeiDaiShiBie(value);
            break;
        }
        case "fuPinDaiKuanYongTu":{
            f.setFuPinDaiKuanYongTu(value);
            break;
        }

        case "chuangYeJinE":{
            f.setChuangYeJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "chuangYeQiXian":{
            f.setChuangYeQiXian(value);
            break;
        }
        case "chuangYeFangKuanRiQi":{
            f.setChuangYeFangKuanRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "chuangYeDaoQiShiJian":{
            f.setChuangYeDaoQiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "chuangYeLiLv":{
            f.setChuangYeLiLv(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "chuangYeChangHuanJinE":{
            f.setChuangYeChangHuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "changYeHuangKuanShiJian":{
            f.setChangYeHuangKuanShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "chuangYeYuE":{
            f.setChuangYeYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "chuangYeYuQiJinE":{
            f.setChuangYeYuQiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "chuangYeYuQiShiJian":{
            f.setChuangYeYuQiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "chuangYeQianXiJinE":{
            f.setChuangYeQianXiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "chuangYeQianXiShiJian":{
            f.setChuangYeQianXiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "chuangYeYongTu":{
            f.setChuangYeYongTu(value);
            break;
        }

        case "shengYuanJinE":{
            f.setShengYuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYuanQiXian":{
            f.setShengYuanQiXian(value);
            break;
        }
        case "shengYuanFangKuanRiQi":{
            f.setShengYuanFangKuanRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "shengYaunDaoQiRiQi":{
            f.setShengYaunDaoQiRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "shengYaunLiLv":{
            f.setShengYaunLiLv(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYaunChangHuanJinE":{
            f.setShengYaunChangHuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYuanHuanKuanShiJian":{
            f.setShengYuanHuanKuanShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "shengYuanYuE":{
            f.setShengYuanYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYuanYuQiJinE":{
            f.setShengYuanYuQiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYuanYuQiShiJian":{
            f.setShengYuanYuQiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "shengYuanQianXiJinE":{
            f.setShengYuanQianXiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "shengYuanQianXiShiJian":{
            f.setShengYuanQianXiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }

        case "qiTaJinE":{
            f.setQiTaJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaQiXian":{
            f.setQiTaQiXian(value);
            break;
        }
        case "qiTaFangKuanRiQi":{
            f.setQiTaFangKuanRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qiTaDaoQiRiQi":{
            f.setQiTaDaoQiRiQi(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qiTaLiLv":{
            f.setQiTaLiLv(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaChangHuanJinE":{
            f.setQiTaChangHuanJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaChangHuangKuanShiJian":{
            f.setQiTaChangHuangKuanShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qiTaYuE":{
            f.setQiTaYuE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaYuQiJinE":{
            f.setQiTaYuQiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaYuQiShiJian":{
            f.setQiTaYuQiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qiTaQianXiJinE":{
            f.setQiTaQianXiJinE(value.length()<1?null:Double.valueOf(value));
            break;
        }
        case "qiTaQianXiShiJian":{
            f.setQiTaQianXiShiJian(value.length()<1?null:sdf.parse(value));
            break;
        }
        case "qiTaYongTu":{
            f.setQiTaYongTu(value);
            break;
        }
        case "note":{
            f.setNote(value);
            break;
        }
    }
    return f;
}
}
