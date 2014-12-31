package cn.lfy.auth.interceptors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.common.framework.exception.ServiceRuntimeException;
import cn.lfy.common.utils.Constants;
import cn.lfy.common.utils.ConstantsUtils;

public class PermissionInterceptor extends HandlerInterceptorAdapter{

	private Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);
	
	/** 忽略拦截请求的Url **/
	private static Set<String> ignoreUrl = new HashSet<String>();
	
	static{

		/*
		 * 放置忽略拦截请求的action名称
		 */
		ignoreUrl.add("/login/loginverify");	/*登录验证*/
		ignoreUrl.add("/car/admin/manage/channel/getchannel");	/*获取指定大渠道的列表*/
		ignoreUrl.add("/car/admin/manage/channel/validisexist");	/*验证渠道号ID是否已存在*/
		ignoreUrl.add("/car/admin/manage/bigchannel/validisexist");	/*验证大渠道名是否已存在*/
		ignoreUrl.add("/car/admin/query/player/edit");
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String requestUrl = request.getRequestURI();
		log.info("请求url："+requestUrl);
		
		
		if(!(ignoreUrl.contains(requestUrl))){
			
			if(!permissionVerify(request)){
				throw new ServiceRuntimeException(Constants.BADREQ_AUTHENTICATION_FAIL);
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	
	private boolean permissionVerify(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		MemberUser user = (MemberUser) session.getAttribute(ConstantsUtils.USER_SESSION_KEY);
		
		if(null !=user && ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(user.getRoleType())){
			return true;
		}
		
		String uri = request.getRequestURI();
		List<String> userUrlList = user.getUrlList();
		
		if(userUrlList.contains(uri) || "/car/admin/index".equals(uri) || "/car/query/player/edit".equals(uri)){
			return true;
		}
		return false;
	}
	
}
