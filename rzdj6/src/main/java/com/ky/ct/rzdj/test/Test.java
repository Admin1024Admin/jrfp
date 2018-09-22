package com.ky.ct.rzdj.test;

public class Test {
	public static String getClassResource(Class<?> klass) {
		return klass.getClassLoader().getResource(klass.getName().replace('.', '/') + ".class").toString();
	}

	public static void main(String[] args) {
			int i=(int)(Math.random()*1000000+100000);
			String messageCode = String.valueOf(i);
			System.out.println(messageCode);	            
	}
}
