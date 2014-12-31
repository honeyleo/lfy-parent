package cn.lfy.common.utils;

public class JqplotArrUtils {

	public static String makeJqArr(String sb){
		StringBuffer sbstr = new StringBuffer();
		sbstr.append("[").append(sb);
		String str = sbstr.toString();
		str = str.substring(0, str.length()-1);
		return str+"]";
	}
}
