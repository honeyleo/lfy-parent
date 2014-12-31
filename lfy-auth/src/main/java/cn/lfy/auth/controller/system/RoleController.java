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
import cn.lfy.auth.dto.RoleVO;
import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.MenuService;
import cn.lfy.auth.service.RoleService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.MessagesKeyUtils;
import cn.lfy.common.utils.ParamUtils;
import cn.lfy.common.validator.Assert;

/**
 * 
 * @Description: 角色管理控制器
 * @author: Niklaus.Xu  
 * @date: 2014年1月8日
 *
 */
@Controller(value="system.roleController")
@RequestMapping(value="/oper/admin/role")
public class RoleController extends BaseController{

	private static final String BASE_VIEW_PACKAGE = "system/role/role-";
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;

	
	/**
	 * 角色列表
	 */
	@RequestMapping(value="/list.page", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView roleList(Model model){
		
		SearchDTO searchDTO = SearchDTO.getInstance(request);
		Page resultPage = this.roleService.rolePageService(searchDTO);
		
		model.addAttribute("resultPage", resultPage);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_LIST));
	}
	
	
	/**
	 * 新增角色
	 */
	@RequestMapping(value="/new", method={RequestMethod.GET})
	public ModelAndView newRole(){
		
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_NEW));
	}
	
	@RequestMapping(value="/new", method={RequestMethod.POST})
	public ModelAndView createRole(RoleVO roleVO){
		
		return this.roleService.createRoleService(roleVO) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 编辑角色
	 */
	@RequestMapping(value="/edit", method={RequestMethod.GET})
	public ModelAndView editRole(@RequestParam("roleId") Integer roleId, Model model){
		
		Assert.notNull(roleId);
		Role role = this.roleService.getEntityById(roleId);
		model.addAttribute("role", role);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_EDIT));
	}
	
	@RequestMapping(value="/edit", method={RequestMethod.POST})
	public ModelAndView updateRole(RoleVO roleVO){
		
		return this.roleService.updateRoleService(roleVO) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
		
	}
	
	
	/**
	 * 删除角色
	 */
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public ModelAndView delete(@RequestParam("roleId") Integer roleId){
		Assert.notNull(roleId);
		return this.roleService.deleteRole(roleId)
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS))
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 角色权限列表
	 */
	@RequestMapping(value="/rolepermission", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView rolePermissionList(@RequestParam("roleId") Long roleId, Model model){
		
		List<Map<String, Object>> me1List = this.menuService.firstMenuService();
		List<Map<String, Object>> me2List = this.menuService.secondMenuService();
		List<Map<String, Object>> me3List = this.menuService.threeMenuByRoleIdService(roleId);
		
		String rolePermissionStr = this.roleService.getRolePermissionService(roleId);
		
		model.addAttribute("menu1", me1List);
		model.addAttribute("menu2", me2List);
		model.addAttribute("menu3", me3List);
		model.addAttribute("roleId", roleId);
		model.addAttribute("rolePermissionStr", rolePermissionStr);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat("permission-list"));
	}
	
	
	/**
	 * 添加角色权限
	 */
	@RequestMapping(value="/addrolepermission", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addRolePermission(){
		Map<String, Object> paraMap = ParamUtils.getParameterByRequest(request);
		Long roleId = ParamUtils.getLongValueByMap(paraMap, "roleId", null);
		String threeMenuIds = ParamUtils.getValueByMap(paraMap, "threeMenuIds", "");
				
		return this.roleService.updateRolePermissionService(roleId, threeMenuIds) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
}
