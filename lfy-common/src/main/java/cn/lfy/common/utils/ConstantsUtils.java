package cn.lfy.common.utils;
import java.util.HashMap;
import java.util.Map;
public class ConstantsUtils{


	public ConstantsUtils() {
		System.out.println("init......");
	}
	
	
	public static final String KEY = "0784ACF0840449FAA641799FF9820297";
	
	
	public static final String USER_SESSION_KEY = "_PAY_ADMIN_USER";
	
	
	
	public static final String ALL_CHANNEL = "ALL_CHANNEL";
	/*
	 * 用户交易统计面积
	 */
	public static final String USER_AREA_LAND= "LAND";
	public static final String USER_AREA_EUROPE= "EUROPE";
	public static final String USER_AREA_SOUTHEAST= "SOUTHEAST";
	public static final Integer USER_STATUS_LAND = 1;
	public static final Integer USER_STATUS_EUROPE = 2;
	public static final Integer USER_STATUS_SOUTHEAST = 3;
	

	/*
	 * 用户交易统计结果
	 */
	public static final String USER_RESULT_SUCCEED= "SUCCEED";
	public static final String USER_RESULT_FAIL= "FAIL";
	public static final String USER_RESULT_CANCEL= "CANCEL";
	public static final Integer USER_STATUS_SUCCEED = 0;
	public static final Integer USER_STATUS_FAIL = 1;
	public static final Integer USER_STATUS_CANCEL = 2;
	

	/*
	 * 支付订单支付类型标记
	 */
	public static final String ORDER_TYPE_CHINAMOBILE = "CHINAMOBILE";
	public static final String ORDER_TYPE_CHINAUNiCOM = "CHINAUNiCOM";
	public static final String ORDER_TYPE_CHINATELECOM= "CHINATELECOM";
	public static final String ORDER_TYPE_UNKNOWN = "UNKNOWN";
	public static final Integer ORDER_STATUS_MOVE = 1;
	public static final Integer ORDER_STATUS_LINK = 2;
	public static final Integer ORDER_STATUS_TELECOM = 3;
	public static final Integer ORDER_STATUS_UNKNOWN = -1;
	
	/*
	 * 角色权限级别标记
	 */
	public static final Integer ROLE_ALL_PERMISSION_TYPE = 1;
	
	
	/*
	 * 大渠道失效、正常标记
	 */
	public static final String BIG_CHANNEL_FORBIDDEN = "FORBIDDEN";
	public static final String BIG_CHANNEL_NORAML = "NORMAL";
	public static final Integer BIG_CHANNEL_STATUS_NORAML = 1;
	public static final Integer BIG_CHANNEL_STATUS_FORBIDDEN = 2;
	
	/*
	 * 渠道失效、正常标记
	 */
	public static final String CHANNEL_FORBIDDEN = "FORBIDDEN";
	public static final String CHANNEL_NORAML = "NORMAL";
	public static final Integer CHANNEL_STATUS_FORBIDDEN = 0;
	public static final Integer CHANNEL_STATUS_NORAML = 1;
	
	/*
	 * 用户禁用、可用标记
	 */
	public static final String USER_FORBIDDEN = "FORBIDDEN";
	public static final String USER_NORMAL = "NORMAL";
	public static final Integer USER_STATUS_NORMAL = 1;
	public static final Integer USER_STATUS_FORBIDDEN = 2;
	
	/*
	 * 支付渠道禁用、启用标记
	 */
	public static final String PAY_CHANNEL_FORBIDDEN = "FORBIDDEN";
	public static final String PAY_CHANNEL_NORMAL = "NORMAL";
	public static final Integer PAY_CHANNEL_STATUS_FORBIDDEN = 0;
	public static final Integer PAY_CHANNEL_STATUS_NORMAL = 1; 
	
	/*
	 * 通告失效、有效标记
	 * 
	 */
	public static final String ANNUNCIATE_FORBIDDEN="FORBIDDEN";
	public static final String ANNUNCIATE_NORAML = "NORMAL";
	public static final Integer ANNUNCIATE_STATUS_NORAML=1;
	public static final Integer ANNUNCIATE_STATUS_FORBIDDEN=2;
	
	/*
	 * 	 用户交易统计面积
	 */
	public static Map<Integer, String> USERAREA_TYPE_MAP = new HashMap<Integer, String>();
	
	
	/*
	 * 	用户交易统计结果
	 */
	public static Map<Integer, String> USERTRANSACTION_TYPE_MAP = new HashMap<Integer, String>();
	
	
	/*
	 * 	支付订单支付类型
	 */
	public static Map<Integer, String> ORDER_TYPE_MAP = new HashMap<Integer, String>();
	
	/*
	 * 大渠道状态
	 */
	public static Map<Integer, String> BIG_CHANNEL_STATUS_MAP = new HashMap<Integer, String>();

	/*
	 * 支付渠道状态
	 */
	public static Map<Integer, String> PAY_CHANNEL_STATUS_MAP = new HashMap<Integer, String>();

	/*
	 * 加密类型
	 */
	public static Map<Integer, String> ENCRYPT_TYPE_MAP = new HashMap<Integer, String>();

	/*
	 * 支付模式
	 */
	public static Map<Integer, String> PAY_MODE_MAP = new HashMap<Integer, String>();
	
	/*
	 * 渠道状态
	 */
	public static Map<Integer, String> CHANNEL_STATUS_MAP = new HashMap<Integer, String>();
	
	/*
	 * 订单交易状态
	 */
	public static Map<Integer, String> ORDER_STATUS_MAP = new HashMap<Integer, String>();
	

	/*
	 * 应用列表
	 */
	public static Map<Long, String> APP_MAP = new HashMap<Long, String>();
	
	/*
	 * 支付渠道列表
	 */
	public static Map<Long, String> PAY_CHANNEL_MAP = new HashMap<Long, String>();
	
	/*
	 * 渠道列表
	 */
	public static Map<Integer, String> CHANNEL_MAP = new HashMap<Integer, String>();
	
	/*
	 * 用户角色
	 */
	public static Map<Long, String> ROLE_MAP = new HashMap<Long, String>();

	
	/*
	 * 用户状态
	 */
	public static Map<Integer, String> USER_STATUS_MAP = new HashMap<Integer, String>();
	

	/*
	 * 角色权限类型
	 */
	public static Map<Integer, String> ROLE_TYPE_MAP = new HashMap<Integer, String>();
	

	/*
	 * 通告状态
	 */
	public static Map<Integer,String> ANNUNCIATE_STATUS_MAP = new HashMap<Integer,String>();
	
	/*
	 * 运营商类型：1-移动；2-联通；3-电信
	 */
	public static Map<Integer, String> SP_TYPE_MAP = new HashMap<Integer, String>();
	
	
	public static Map<Integer, String> spTypeMap() {
		return SP_TYPE_MAP;
	}

	
	public static Map<Integer,String> userAreaTypeMap(){
		return USERAREA_TYPE_MAP;
	}
	

	public static Map<Integer, String> getORDER_TYPE_MAP() {
		return ORDER_TYPE_MAP;
	}
	
	public static Map<Integer, String > usertransactionTypeMap(){
		return USERTRANSACTION_TYPE_MAP;
	}
	
	
	public static Map<Integer, String> orderTypeMap(){
		return ORDER_TYPE_MAP;
	}
	
	public static Map<Integer, String> channelStatusMap(){
		return CHANNEL_STATUS_MAP;
	}
	
	public static Map<Integer, String> orderStatusMap(){
		return ORDER_STATUS_MAP;
	}

	public static Map<Long, String> payChannelMap(){
		return PAY_CHANNEL_MAP;
	}
	
	public static Map<Integer, String> channelMap(){
		return CHANNEL_MAP;
	}
	
	public static Map<Long, String> appMap(){
		return APP_MAP;
	}
	
	public static Map<Long, String> roleMap(){
		return ROLE_MAP;
	}
	
	public static Map<Integer, String> userStatusMap(){
		return USER_STATUS_MAP;
	}
	
	public static Map<Integer, String> roleTypeMap() {
		return ROLE_TYPE_MAP;
	}
	
	public static Map<Integer, String> payModeMap(){
		return PAY_MODE_MAP;
	}
	
	public static Map<Integer, String> encryptTypeMap(){
		return ENCRYPT_TYPE_MAP;
	}
	
	public static Map<Integer, String> payChannelStatusMap(){
		return PAY_CHANNEL_STATUS_MAP;
	}
	
	public static Map<Integer, String> bigChannelStatusMap(){
		return BIG_CHANNEL_STATUS_MAP;
	}
	
	public static Map<Integer, String> annunciateStatusMap(){
		return ANNUNCIATE_STATUS_MAP;
	}
	
	


	public static void setSP_TYPE_MAP(Map<Integer, String> sP_TYPE_MAP) {
		SP_TYPE_MAP = sP_TYPE_MAP;
	}
	
	public static void setORDER_TYPE_MAP( Map<Integer, String> oRDER_TYPE_MAP) {
		ORDER_TYPE_MAP = oRDER_TYPE_MAP;
	}


	public void setCHANNEL_STATUS_MAP( Map<Integer, String> cHANNEL_STATUS_MAP) {
		CHANNEL_STATUS_MAP = cHANNEL_STATUS_MAP;
	}
	
	public void setUSER_STATUS_MAP( Map<Integer, String> uSER_STATUS_MAP) {
		USER_STATUS_MAP = uSER_STATUS_MAP;
	}


	public static void setANNUNCIATE_STATUS_MAP( Map<Integer, String> aNNUNCIATE_STATUS_MAP) {
		ANNUNCIATE_STATUS_MAP = aNNUNCIATE_STATUS_MAP;
	}

	public void setROLE_TYPE_MAP( Map<Integer, String> rOLE_TYPE_MAP) {
		ROLE_TYPE_MAP = rOLE_TYPE_MAP;
	}	
	
	public void setORDER_STATUS_MAP( Map<Integer, String> oRDER_STATUS_MAP) {
		ORDER_STATUS_MAP = oRDER_STATUS_MAP;
	}
	
	public void setPAY_MODE_MAP( Map<Integer, String> pAY_MODE_MAP){
		PAY_MODE_MAP = pAY_MODE_MAP;
	}
	
	public static void setENCRYPT_TYPE_MAP( Map<Integer, String> eNCRYPT_TYPE_MAP) {
		ENCRYPT_TYPE_MAP = eNCRYPT_TYPE_MAP;
	}
	
	public static void setPAY_CHANNEL_STATUS_MAP( Map<Integer, String> pAY_CHANNEL_STATUS_MAP) {
		PAY_CHANNEL_STATUS_MAP = pAY_CHANNEL_STATUS_MAP;
	}
	
	public static void setBIG_CHANNEL_STATUS_MAP( Map<Integer, String> bIG_CHANNEL_STATUS_MAP) {
		BIG_CHANNEL_STATUS_MAP = bIG_CHANNEL_STATUS_MAP;
	}
	public static void setUSERTRANSACTION_TYPE_MAP( Map<Integer, String> uSERTRANSACTION_TYPE_MAP) {
		USERTRANSACTION_TYPE_MAP = uSERTRANSACTION_TYPE_MAP;
	}
	
	public static void setUSERAREA_TYPE_MAP(Map<Integer, String> uSERAREA_TYPE_MAP) {
		USERAREA_TYPE_MAP = uSERAREA_TYPE_MAP;
	}


	
}
