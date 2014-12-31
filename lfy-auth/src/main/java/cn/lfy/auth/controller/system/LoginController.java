package cn.lfy.auth.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.lfy.auth.controller.BaseController;
import cn.lfy.auth.dto.MenuDTO;
import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.MenuService;
import cn.lfy.auth.service.RoleService;
import cn.lfy.auth.service.UserService;
import cn.lfy.common.framework.exception.ServiceRuntimeException;
import cn.lfy.common.utils.Constants;
import cn.lfy.common.utils.ConstantsUtils;
import cn.lfy.common.validator.Validation;

@Controller("system.loginContoller")
@RequestMapping(value="/")
public class LoginController extends BaseController{

	private static final String VIEW_BASE_PACKAGE_INDEX = "system/";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 登录
	 */
	@RequestMapping(value={"","/login"}, method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(){
		return new ModelAndView(VIEW_BASE_PACKAGE_INDEX.concat("login"));
	}
	
	
	/**
	 * 登出
	 */
	@RequestMapping(value="/exit", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView exit(Model model){
		this.removeSession();
		return new ModelAndView(VIEW_BASE_PACKAGE_INDEX.concat("login"));
	}
	
	
	/**
	 * dialog 登录
	 */
	@RequestMapping(value="/dialoglogin", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView dialogLogin(){
		return new ModelAndView(VIEW_BASE_PACKAGE_INDEX.concat("login_dialog"));
	}
	
	
	/**
	 * ajax 登出
	 */
	@RequestMapping(value="/ajaxtimeout", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ajaxTimeout(){
		return new ModelAndView(VIEW_BASE_PACKAGE_INDEX.concat("ajaxTimeout"));
	}
	

	
	/**
	 * 登录验证
	 */
	@RequestMapping(value="/login/loginverify", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView loginVerify(String username, String password, String loginType, Model model){
		
		if(!(Validation.isNotNULL(username, password))){
			throw new ServiceRuntimeException(Constants.BADREQ_LOGIN_NAME_AND_PASSWORD_NOTNULL);
		}
		
		MemberUser user = this.userService.getMemberUserByNameService(username);
		
		if(null == user){
			throw new ServiceRuntimeException(Constants.BADREQ_LOGIN_USER_INEXISTENCE);
		}
		if(!(user.compare(password))){
			throw new ServiceRuntimeException(Constants.BADREQ_LOGIN_PASSWORD_ERROR);
		}
		
		this.initUserPermission(user);
		
		this.setValueToSession(ConstantsUtils.USER_SESSION_KEY, user);
		
		if("DIALOG".equals(loginType)){
			return ajaxDoneSuccess(null);
		}
		
		throw new ServiceRuntimeException(Constants.BADREQ_DIALOG_LOGIN_SUCCESS);
	}
	
	/**
	 * 初始化用户菜单权限
	 */
	public void initUserPermission(MemberUser user){
		
		Role role = this.roleService.getEntityById(Integer.valueOf(user.getRoleId().toString()));
		if(role == null){
			throw new ServiceRuntimeException(Constants.BADREQ_USER_LOGIN_FAIL);
		}
		user.setRoleType(role.getType());
		
		if(!(ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(role.getType())) ){
			
			Map<String, List<MenuDTO>> menuMap = this.menuService.getUserMenuService(user.getId());
			
			List<MenuDTO> permissionList =  menuMap.get("threeMenu");
			List<String> urlList = new ArrayList<String>();
			for (MenuDTO menuDTO : permissionList) {
				urlList.add(menuDTO.getUrl());
			}
			user.setUrlList(urlList);
		}
	}

	
	
}
