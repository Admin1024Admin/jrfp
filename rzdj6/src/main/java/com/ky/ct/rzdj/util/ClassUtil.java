package com.ky.ct.rzdj.util;

import java.lang.reflect.Field;

//类反射工具
public class ClassUtil {
	private static String param = null;

	public static String loadField(Class<?> clazz) {
		try {
			// Class<?> clazz = Class.forName(className);//根据类名获得其对应的Class对象
			// 写上你想要的类名就是了 注意是全名 如果有包的话要加上 比如java.Lang.String
			Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
			param = "";
			for (Field f : fields) {
				if (f.getType().getSimpleName().equals("String")
						|| f.getType().getSimpleName().equals("int")
						|| f.getType().getSimpleName().equals("Integer")
						|| f.getType().getSimpleName().equals("float")
						|| f.getType().getSimpleName().equals("Double")) {
					// System.out.println(f.getType().getSimpleName());
					param += f.getName() + ",";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		param = param.substring(0, param.length() - 1);
		return param;
	}

}
