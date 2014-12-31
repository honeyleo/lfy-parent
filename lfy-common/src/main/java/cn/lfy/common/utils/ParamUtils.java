package cn.lfy.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class ParamUtils {

	/**
	 * 取出Map中的value
	 * @param map		参数Map
	 * @param key		value所对应的key
	 * @param defaultV	当key的值为null或空("")时,返回默认值
	 * @return			String 类型
	 */
	public static String getUTF8ValueByMap(Map<String, Object> map, String key, String defaultV){
		String value = defaultV;
		try {
			value = map != null && map.get(key) != null && !map.get(key.trim()).equals("") ? map.get(key.trim()).toString().trim() : defaultV;
		} catch (Exception e) {
			value = defaultV;
		}
		return getStrUTF8(value);
	}
	
	public static String getValueByMap(Map<String, Object> map, String key, String defaultV){
		try {
			return map != null && map.get(key) != null && !map.get(key.trim()).equals("") ? map.get(key.trim()).toString().trim() : defaultV;
		} catch (Exception e) {
			return defaultV;
		}
	}
	
	public static Integer getIntegerValueByMap(Map<String, Object> map, String key, Integer defaultV){
		try {
			return map != null && map.get(key) != null && !map.get(key.trim()).equals("") ? Integer.valueOf(map.get(key.trim()).toString().trim()) : defaultV;
		} catch (Exception e) {
			return defaultV;
		}
	}
	
	public static Long getLongValueByMap(Map<String, Object> map, String key, Long defaultV){
		try {
			return map != null && map.get(key) != null && !map.get(key.trim()).equals("") ? Long.valueOf(map.get(key.trim()).toString().trim()) : defaultV;
		} catch (Exception e) {
			return defaultV;
		}
	}	
	
	public static double getDoubleValueByMap(Map<String, Object> map, String key, double defaultV){
		try {
			return map != null && map.get(key) != null && !map.get(key.trim()).equals("") ? Double.valueOf(map.get(key.trim()).toString().trim()) : defaultV;
		} catch (Exception e) {
			return defaultV;
		}
	}
	
	public static String getStrByList(List<Object> list, int index){
		Iterator<Object> iterator = list.iterator();
		String value = "";
		while(iterator.hasNext()){
			Object[] object =  (Object[]) iterator.next();
			if(object[index] != null && !object[index].equals("") && !object[index].equals("null")){
				value += ","+object[index];
			}
		}
		if(value.startsWith(","))
			value = value.replaceFirst(",", "");
		return value;
	}
	
	public static String getStrUTF8(String str){
		try {
			str = !str.equals("") ? new String(str.getBytes("ISO-8859-1")) : "";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static Map<String, String> wrapMap(Object...obj){
		if(obj.length%2 > 0)
			return null;
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < obj.length; i += 2) {
			map.put(String.valueOf(obj[i]), String.valueOf(obj[i+1]));
		}
		return map;
	}
	
/*	@SuppressWarnings("unchecked")
	public static Map<String, String> wrapListOrderMap(Object...obj){
		if(obj.length%2 > 0)
			return null;
		Map<String, String> map = new ListOrderedMap();
		for (int i = 0; i < obj.length; i += 2) {
			map.put(String.valueOf(obj[i]), String.valueOf(obj[i+1]));
		}
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		//JSONObject json = JSONObject.fromObject(jsonStr);
		if(null != json){
			for (Object k : json.keySet()) {
				Object v = json.get(k);
				// 如果内层还是数组的话，继续解析
				if (v instanceof JSONArray) {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					Iterator<JSONObject> it = ((JSONArray) v).iterator();
					while (it.hasNext()) {
						JSONObject json2 = it.next();
						list.add(parseJSON2Map(json2));
					}
					map.put(k.toString(), list);
				} else {
					map.put(k.toString(), v);
				}
			}
		}
		return map;
	}*/
	 
	
	/**
	 * 将value为数组类型的map转换成普通Map
	 * @param map	Map<String, String[]>
	 * @return		Map<String, Object>
	 */
	public static Map<String, Object> conversionToGeneralMap(Map<String, String[]> map){
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String key = "";
		String value = "";
		for(Entry<String, String[]> entry : map.entrySet()){
			key = ""; value = "";
			key = entry.getKey();
			Object object = entry.getValue();
			if(object == null){
				value = "";
			}else if(object instanceof String[]){
				String[] array = (String[])object;
				for (int i = 0; i < array.length; i++) {
					value = array[i] + "";
				}
			}else{
				value = object.toString();
			}
			generalMap.put(key, value);
		}
		return generalMap;
	}
	
	public static Map<String, Object> getParameterByRequest(HttpServletRequest req){
		if(req != null){
			Map<String, String[]> paraMap = req.getParameterMap();
			Map<String, Object> paraMap_s = new HashMap<String, Object>();
			if(paraMap != null)
				paraMap_s = conversionToGeneralMap(paraMap);
			return paraMap_s;
		}
		return null;
		
	}
	
	/**
	 * 将指定字符串分割成二维数组
	 * @param str		要分割的字符
	 * @param oneSeg	第一维分割符
	 * @param twoSeg	第二维分割符
	 * @return			String [][]
	 */
	public static String[][] parseStrToArray(String str, String oneSeg, String twoSeg){
		if(null == str || "".equals(str))
			return null;
		String[] oneArray = str.split(oneSeg);
		String[][] twoArray = new String[oneArray.length][8];
		
		for (int i = 0; i < oneArray.length ; i++) {
			
			String[] tempArray = oneArray[i].split(twoSeg);
			
			for (int j = 0; j < tempArray.length; j++) {
				
				twoArray[i][j] = tempArray[j];
			}
		}
		return twoArray;
	}
	
	public static long getCompareDate(String startDate) throws ParseException {
	     SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	     Date date1=formatter.parse(startDate);    
	     long l = new Date().getTime() - date1.getTime();
	     long d = l/(24*60*60*1000);
	     return d;
	 }
	
	/**
	 * 随机生成指定长度的字符
	 * @param n		随机数长度
	 * @return		String
	 */
	public static String getRandomString(int n) {
		String[] s = {"a","b","c","d","e","f","g","h","i","j","" +
				"k","l","m","n","o","p","q","r","s","t","u","v","w","" +
						"x","y","z","0","1","2","3","4","5","6","7","8","9"};
		String rs = "";
		int i = 0;
		Random r = new Random();
		while (i < n) {
			int j = r.nextInt(s.length);
			rs += s[j];
			i++;
		}
		return rs;
	}
	
}
