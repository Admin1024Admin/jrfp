package com.ky.ct.rzdj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	private static String seed_user = "!@#$abc123.";
	private static String seed_manager = "!@#$a_123.";
	
	public static String getMD5(String str) {
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update((str + seed_user).getBytes());
		    return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			
		}
		return null;
	}
	
	public static String getMD5_m(String str) {
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update((str + seed_manager).getBytes());
		    return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			
		}
		return null;
	}
}
