package com.ky.ct.rzdj.util;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.*;

public class Fields {
    /**
     * 获取前台传递过来的选中字段的参数 封装在一个数组中
     * @param request
     * @return
     */
    public static List<String> getFields(HttpServletRequest request){
        List<String> fields = new ArrayList<>();
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            //形成键值对应的map
            fields.add(paramName);
        }
        return fields;
    }
    /**
     * 获取前台传递过来的所有数据
     * @param request
     * @return
     */
    public static Map<String,Object> getParams(HttpServletRequest request){
        Enumeration enumeration = request.getParameterNames();
        Map<String,Object> map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String paramValue =request.getParameter(paramName);
            //形成键值对应的map
            if(paramValue!=null&&paramValue.length()>0){
                map.put(paramName, paramValue);
            }
        }
        return map;
    }
    /**
     * 获取前台传递过来的所有数据(除了page和limit)
     * @param request
     * @return
     */
    public static Map<String,Object> getParamsExceptPageAndLimit(HttpServletRequest request){
        Enumeration enumeration = request.getParameterNames();
        Map<String,Object> map = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String paramValue =request.getParameter(paramName);
            //形成键值对应的map
            if(paramValue!=null&&paramValue.length()>0 && !"page".equals(paramName) && !"limit".equals(paramName)){
                map.put(paramName, paramValue);
            }
        }
        return map;
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //加上引号
    public static  String toQuotes(String str){
        return "'"+str+"'";
    }

    /**
     *判断某个类中是否存在这个二属性
     */
    public static boolean isInside(Class cla,String param){
        Field[] fields=cla.getDeclaredFields();
        boolean b=false;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals(param)){
                b=true;
                break;
            }
        }
        return  b;
    }
}
