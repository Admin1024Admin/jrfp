package com.ky.ct.rzdj.util;

public class ObjToInter {
	public static int toInter(Object obj){
		int result;
		if(obj == null)  return 0;
		try {
			result = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			result = (int)Double.parseDouble(obj.toString());
		}
		return result;
	}
}
