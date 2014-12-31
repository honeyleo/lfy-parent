package cn.lfy.common.utils;

import java.util.Map;

import com.google.common.collect.Maps;



public class ConstanceUtils {

	
	/**
	 * 汽车单项属性的等级间隔(各个单项属性满5级后才可进行汽车强化)
	 */
	public static final int CAR_ITEM_GRADE_INTERVAL = 5;
	
	/**
	 * 标识汽车不可被购买
	 */
	public static final int CAR_CANNOT_BUY = 2;
	
	
	/**
	 * 1 就是金币、2 就是钻石
	 */
	public static final int PRICE_TYPE_GOLD = 1;
	public static final int PRICE_TYPE_DIAMOND = 2;
	
	/**
	 * 汽车一键升级金币转换钻石
	 */
	public static final int FAST_UP_CAR_GOLD = 10000;
	public static final int FAST_UP_CAR_DIAMOND = 100;
	
	
	/**
	 * 0 表示玩家没有该车、1 表示拥有
	 */
	public static final int PLAYER_HAVE_CAR = 1;
	public static final int PLAYER_HAVE_NO_CAR = 0;
	
	/**
	 * 0 表示玩家没有该角色、1 表示拥有
	 */
	public static final int PLAYER_HAVE_ROLE = 1;
	public static final int PLAYER_HAVE_NO_ROLE = 0;
	
	
	/**
	 * 活动类型
	 */
	public static final int ACTIVITY_FIRST_PAY = 1;
	
	
	/**
	 * 卡应用操作类型: 装配、取下、替换
	 */
	public static final int CARD_APPLY_OPERATION_FITTING = 0;
	public static final int CARD_APPLY_OPERATION_TAKEDOWN = 1;
	public static final int CARD_APPLY_OPERATION_REPLACE = 2;
	
	/**
	 * 卡最多使用个数
	 */
	public static final int CARD_APPLY_SKILL_FULL = 3;
	
	
	/**
	 * 道具使用状态: 1 正在使用、0 未使用
	 */
	public static final int PLAYER_PROPS_USRSD = 1;
	public static final int PLAYER_PROPS_UNUSED = 0;
	
	
	/**
	 * 商城物品类型：0 是金币、1 是钻石、2 是赛车
	 */
	public static final int STORE_GOODS_GOLDEN = 2;
	public static final int STORE_GOODS_DIAMOND = 3;
	public static final int STORE_GOODS_CAR = 6;
	
	
	/**
	 * 升级玩家汽车属性等级
	 */
	public static final int PROP_UPGRADE_SPEED = 0;	/*最高速度*/
	public static final int PROP_UPGRADE_ACC = 1;	/*加速度*/
	public static final int PROP_UPGRADE_OIL =2;	/*节油*/
	public static final int PROP_UPGRADE_SHOT = 3;	/*武器*/
	
	/**
	 * 汽车属性强化返回值类型
	 */
	public static final int UP_PROP_SUCCESS = 0;	/*成功*/
	public static final int UP_PROP_MONEY_NO_ENOUGH = 1;	/*钱不够*/
	public static final int UP_PROP_TOP_LEVEL = 2;		/*表示到顶级*/
	
	/**
	 * 汽车强化返回值类型
	 */
	public static final int UP_CAR_MONEY_NO_ENOUGH = 0;	/*钱不够*/
	public static final int UP_CAR_SUCCESS = 1;			/*成功*/
	public static final int UP_CAR_TOP_LEVEL = 2;		/*到顶级*/
	
	/**
	 * 选定汽车返回值类型
	 */
	public static final int CONFIRM_CAR_FAIL = 0;	/*失败*/
	public static final int CONFIRM_CAR_SUCCESS = 1;	/*成功*/
	
	/**
	 * 商品兑换返回值类型
	 */
	public static final int GOODS_CONVERT_RESULT_DIAMOND = 0;	/*钻石*/
	public static final int GOODS_CONVERT_RESULT_RMB = 1;	/*人民币*/
	
	
	/**
	 * 好友排行和世界排行默认每页大小
	 */
	public static final int DEFAULT_RANK_PAGESIZE = 12;
	
	/**
	 * 推荐好友记录条数
	 */
	public static final int RECOMMEND_FRIENDS_LIMIT = 13;
	
	/**
	 * 是否为好友：1 是好友、0 不是好友
	 */
	public static final int IS_FRIEND = 1;
	public static final int IS_NOT_FRIEND = 0;
	
	/**
	 * 道具列表每页记录条数
	 */
	public static final int PROPS_PAGE_LIMIT = 16;
	
	/**
	 * 改装汽车（汽车强化内容）每页记录条数
	 */
	public static final int CARUP_PAGE_LIMIT = 8;
	
	/**
	 * 汽车初始化等级
	 */
	public static Map<Integer, Integer> CAR_INIT_GRADE = Maps.newHashMap();
	
	/**
	 * 支付成功
	 */
	public static final int PAY_SUCCESS = 1;
	/**
	 * 支付失败
	 */
	public static final int PAY_FAIL = -1;
	
}
