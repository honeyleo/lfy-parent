package cn.lfy.auth.interceptors;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.common.utils.ConstantsUtils;
import cn.lfy.common.validator.Validation;

public class LoginFilter extends OncePerRequestFilter {

	private Logger log = LoggerFactory.getLogger(OncePerRequestFilter.class);
	
	/** 忽略拦截请求的Url **/
	private static Set<String> ignoreUrl = new HashSet<String>();
	
	static{

		/*
		 * 放置忽略拦截请求的action名称
		 */
		ignoreUrl.add("/");
		ignoreUrl.add("/login/loginverify");
		ignoreUrl.add("/car/admin/login");
		ignoreUrl.add("/car/admin/query/orderquery/queryorder.json");
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String requestUrl = request.getRequestURI();
		log.info("请求url："+requestUrl);
		
		if(Validation.isNotNULL(requestUrl)){
			if(!(ignoreUrl.contains(requestUrl))){
				log.info("拦截url："+requestUrl);
				
				if(!LoginVerify(request)){
					String httpAjax=request.getHeader("X-Requested-With");
					if(httpAjax != null && "XMLHttpRequest".equals(httpAjax)){
						request.getRequestDispatcher("/ajaxtimeout").forward(request, response); 
					}else{
						request.getRequestDispatcher("/").forward(request, response); 
//						response.sendRedirect("/");
//						response.flushBuffer();
					}
					return;
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	
	private boolean LoginVerify(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		MemberUser user = (MemberUser) session.getAttribute(ConstantsUtils.USER_SESSION_KEY);
		if(null == user || user.getId() <= 0){
			return false;
		}
		return true;
	}
	
	
	
}
