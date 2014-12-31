package cn.lfy.auth.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.auth.service.UserService;
import cn.lfy.common.framework.editor.DateEditor;
import cn.lfy.common.framework.editor.DoubleEditor;
import cn.lfy.common.framework.editor.IntegerEditor;
import cn.lfy.common.framework.editor.LongEditor;
import cn.lfy.common.utils.ConstantsUtils;

public abstract class BaseController {

	protected static final String VIEW_LIST = "list";
	protected static final String VIEW_EDIT = "edit";
	protected static final String VIEW_NEW = "new";
	
	@Autowired
	protected HttpServletRequest request;
	
	/*@Autowired
	private BigChannelService bigChannelService;*/
	
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private ChannelService channelService;*/
	
	@Autowired
	private ResourceBundleMessageSource _res;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	protected HttpSession getSession(){
		return this.request.getSession();
	}
	
	protected void setValueToSession(String key, Object value){
		getSession().setAttribute(key, value);
	}
	
	
	protected Object getValueBySession(String key){
		return getSession().getAttribute(key);
	}
	
	protected MemberUser getMemberUserBySession(){
		return (MemberUser) getValueBySession(ConstantsUtils.USER_SESSION_KEY);
	}
	
	protected void removeSession(){
		HttpSession session = getSession();
		session.removeAttribute(ConstantsUtils.USER_SESSION_KEY);
	}
	
	
	/*protected Map<Integer, String> getBigQn(){
		MemberUser user = this.getMemberUserBySession();
		
		if(user == null)
			return null;
		
		Map<Integer, String> bigqnMap = new ListOrderedMap();
		if(ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(user.getRoleType())){
			
			List<BigChannel> resultList = this.bigChannelService.findAll();
			if(resultList != null){
				for (BigChannel bigChannel : resultList) {
					bigqnMap.put(bigChannel.getId(), bigChannel.getName());
				}
			}
		}else{
			String bigcnIds = this.userService.getUserBigQnService(user.getId());
			List<BigChannel> resultList = this.bigChannelService.getBigChannelListByIdService(bigcnIds);
			if(resultList != null){
				for (BigChannel bigChannel : resultList) {
					bigqnMap.put(bigChannel.getId(), bigChannel.getName());
				}
			}
		}
		return bigqnMap;
	}*/
	
	/*protected List<BigChannel> getUserBigQn(){
		MemberUser user = this.getMemberUserBySession();
		
		if(user == null)
			return null;
		
		List<BigChannel> resultList = new ArrayList<BigChannel>();
		if(ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(user.getRoleType())){
			
			resultList = this.bigChannelService.findAll();
		}else{
			String bigcnIds = this.userService.getUserBigQnService(user.getId());
			resultList = this.bigChannelService.getBigChannelListByIdService(bigcnIds);
		}
		return resultList;
	}	*/
	
	/*protected String getUserBigQnIdStr(){
		
		MemberUser user = this.getMemberUserBySession();
		if(user == null){
			throw new ServiceRuntimeException(ExceptionEnums.NONE);	
		}
		
		String idStr = "";
		if(ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(user.getRoleType())){
			return ConstantsUtils.ALL_CHANNEL;
		}else{
			String bigcnIds = this.userService.getUserBigQnService(user.getId());
			bigcnIds = bigcnIds == null || bigcnIds.isEmpty() ? "0" : bigcnIds;
			List<BigChannel> resultList = this.bigChannelService.getBigChannelListByIdService(bigcnIds);
			if(resultList != null){
				for (BigChannel bigChannel : resultList) {
					idStr += "," + bigChannel.getId();
				}
				if(idStr.startsWith(",")){
					idStr = idStr.replaceFirst(",", "");
				}
			}
		}
		return idStr;
	}*/
	
	
	protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
		ModelAndView mav = new ModelAndView("common/ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
	}
	
	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message, "");
	}

	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message, "");
	}
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}
	
	protected String getMessage(String code, Object[] args) {
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);

		return _res.getMessage(code, args, locale);
	}
	
	
	/*
	protected void checkChannelParam(SearchDTO searchDTO){
		
		List<Integer> cList =  new ArrayList<Integer>();
		String kwBigqnId = (String) searchDTO.get("kwBigqnId");
		if(Validation.isNotNULL(kwBigqnId) && Integer.valueOf(kwBigqnId) > 0 && !Validation.isNotNULL(searchDTO.get("kwChannel"))){
			
			this.getChannelListByBigQn(kwBigqnId, cList);
			if(cList.size() <= 0)
				throw new ServiceRuntimeException(ExceptionEnums.BADREQ_CHANNEL_DATA_ISNULL);

		}else if(Validation.isNotNULL(searchDTO.get("kwChannel"))){
			cList.add(Integer.valueOf(searchDTO.get("kwChannel").toString()));
		}else{
			String idStr = this.getUserBigQnIdStr();
			if(!ConstantsUtils.ALL_CHANNEL.equals(idStr) && (idStr == null || idStr.isEmpty())){
				throw new ServiceRuntimeException(ExceptionEnums.BADREQ_USER_NOT_RELATE_BIGQN);
			}else if(!ConstantsUtils.ALL_CHANNEL.equals(idStr)){
				this.getChannelListByBigQn(idStr, cList);
			}
		}
		Integer[] str = new Integer[cList.size()];
		cList.toArray(str);
		searchDTO.put("channelIdStr", StringUtils.join(cList, ","));
	}*/
	
	/*protected void getChannelListByBigQn(String bigqnStr, List<Integer> cList){
		List<Channel> channelList = this.channelService.getChannelByBigQnService(bigqnStr);
		for (Channel channel : channelList) {
			cList.add(channel.getId());
		}
	}*/
}
