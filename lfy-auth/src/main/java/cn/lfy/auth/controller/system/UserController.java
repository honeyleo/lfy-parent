package cn.lfy.auth.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.lfy.auth.controller.BaseController;
import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.auth.service.MenuService;
import cn.lfy.auth.service.RoleService;
import cn.lfy.auth.service.UserService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.MessagesKeyUtils;
import cn.lfy.common.utils.ParamUtils;
import cn.lfy.common.validator.Assert;

/**
 * 
 * @Description: 用户管理控制器
 * @author: Niklaus.Xu  
 * @date: 2014年1月8日
 *
 */
@Controller("system.userController")
@RequestMapping(value="/oper/admin/user")
public class UserController extends BaseController{

	private static final String BASE_VIEW_PACKAGE = "system/user/user-";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
/*	@Autowired
	private BigChannelService bigChannelService;*/
	
	
	/**
	 * 用户列表
	 */
	@RequestMapping(value="/list.page", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userList(Model model){
		
		SearchDTO searchDTO = SearchDTO.getInstance(request);
		Page resultPage = this.userService.userPageService(searchDTO);
		
		model.addAttribute("resultPage", resultPage);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_LIST));
	}
	
	
	/**
	 * 新增用户
	 */
	@RequestMapping(value="/new", method={RequestMethod.GET})
	public ModelAndView newUser(){
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_NEW));
	}
	
	@RequestMapping(value="/new", method={RequestMethod.POST})
	public ModelAndView createUser(MemberUser memberUser){
		
		Assert.notNull(memberUser.getUserName(), memberUser.getNickname(), memberUser.getPasswd(), memberUser.getRoleId());
		memberUser.buildPasswd();
		
		Integer userId = this.userService.save(memberUser);
		/*
		 * 添加用户默认权限
		 */
		this.userService.addUserPermissionService(memberUser.getId(), memberUser.getRoleId());
		
		return userId > 0 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						:ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
				
	}
	
	
	/**
	 * 编辑用户
	 */
	@RequestMapping(value="/edit", method={RequestMethod.GET})
	public ModelAndView editUser(@RequestParam("userId") Integer userId, Model model){
		
		Assert.notNull(userId);
		MemberUser memberUser = this.userService.getEntityById(userId);
		model.addAttribute("user", memberUser);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_EDIT));
	}
	
	@RequestMapping(value="/edit", method={RequestMethod.POST})
	public ModelAndView updateUser(MemberUser memberUser, Long oldRoleId){
		
		if(memberUser != null && !(memberUser.getRoleId().equals(oldRoleId)) && this.userService.deleteUserPermissionService(memberUser.getId())){
			this.userService.addUserPermissionService(memberUser.getId(), memberUser.getRoleId());
		}
		
		return this.userService.updateUserService(memberUser) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 更新用户状态 
	 */
	@RequestMapping(value="/updatestatus", method={RequestMethod.POST})
	public ModelAndView updateStatus(@RequestParam("userId") Integer userId, @RequestParam("operation") String operation){
		
		return this.userService.updateUserStatusService(userId, operation) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 用户权限列表
	 */
	@RequestMapping(value="/userpermission", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userPermissionList(@RequestParam("userId") Integer userId, Model model){
		
		List<Map<String, Object>> me1List = this.menuService.firstMenuService();
		List<Map<String, Object>> me2List = this.menuService.secondMenuService();
		List<Map<String, Object>> me3List = this.menuService.threeMenuByUserIdService(userId);
		String userPermissionStr = this.userService.getUserPermissionService(userId);
		
		model.addAttribute("menu1", me1List);
		model.addAttribute("menu2", me2List);
		model.addAttribute("menu3", me3List);
		model.addAttribute("userId", userId);
		model.addAttribute("userPermissionStr", userPermissionStr);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat("permission-list"));
	}
	
	
	/**
	 * 添加用户权限
	 */
	@RequestMapping(value="/adduserpermission", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addUserPermission(){
		Map<String, Object> paraMap = ParamUtils.getParameterByRequest(request);
		Integer userId = ParamUtils.getIntegerValueByMap(paraMap, "userId", null);
		String threeMenuIds = ParamUtils.getValueByMap(paraMap, "threeMenuIds", "");
		
		return this.userService.updateUserPermissionService(userId, threeMenuIds) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
/*	*//**
	 * 用户合作渠道列表
	 *//*
	@RequestMapping(value="/userbigqn", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userBigQnList(@RequestParam("userId") Integer userId, Model model){
		List<BigChannel> resultList = this.bigChannelService.findAll();
		String userBiganStr = this.userService.getUserBigQnService(userId);
		
		model.addAttribute("userBiganStr", userBiganStr);
		model.addAttribute("userBigan", StringUtils.split(userBiganStr, ","));
		model.addAttribute("resultList", resultList);
		model.addAttribute("userId", userId);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat("bigchannel-list"));
	}*/
	
	
	/**
	 * 添加用户合作渠道关联
	 */
	@RequestMapping(value="/adduserbigqn", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addUserBigqn(@RequestParam("bigqnids") String bigqnids, @RequestParam("userId") Integer userId){
		
		return this.userService.addUserBigQnService(userId, bigqnids) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	
}
