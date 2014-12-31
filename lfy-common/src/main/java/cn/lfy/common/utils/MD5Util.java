package cn.lfy.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MD5Util {

	private static final Logger log = LoggerFactory.getLogger(MD5Util.class);

	private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resSb.append(byteToHexString(b[i]));
		}
		return resSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String getMD5Str(String str) {
		String resStr = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resStr = byteArrayToHexString(md.digest(str.getBytes()));
		} catch (Exception ex) {
			log.error("md5 fail");
			ex.printStackTrace();
		}
		return resStr;
	}

	public static byte getMD5FirstByte(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = md.digest(str.getBytes());
			if ((b != null) && (b.length > 0))
				return b[0];
		} catch (Exception ex) {
			log.error("md5 fail");
			ex.printStackTrace();
		}
		return 0;
	}

	public static String getFileMD5(String fn) {
		return getFileMD5(new File(fn));
	}

	public static String getFileMD5(File file) {
		FileInputStream fis = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			fis = new FileInputStream(file);
			byte[] buffer = new byte[8192];
			int length = -1;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			fis.close();
			return byteArrayToHexString(md.digest());
		} catch (Exception ex) {
		}
		return null;
	}
	
	public static String getFileMD5(InputStream inputStream) {
		if(inputStream != null){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] buffer = new byte[8192];
				int length = -1;
				while ((length = inputStream.read(buffer)) != -1) {
					md.update(buffer, 0, length);
				}
				inputStream.close();
				return byteArrayToHexString(md.digest());
			} catch (Exception ex) {
			}
		}
		return null;
	}	

	public static void main(String[] args) {
		System.out.println("mohwst=" + getMD5Str("123"));
		System.out.println("mohwst=" + (getMD5FirstByte("123") & 0x7F));
	}
}
