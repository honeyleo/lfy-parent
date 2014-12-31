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
import cn.lfy.auth.dto.MenuDTO;
import cn.lfy.auth.dto.MenuVO;
import cn.lfy.auth.service.MenuService;
import cn.lfy.common.utils.MessagesKeyUtils;
import cn.lfy.common.utils.ParamUtils;

/**
 * 
 * @Description: 功能菜单管理控制器
 * @author: Niklaus.Xu  
 * @date: 2014年1月8日
 *
 */
@Controller(value="system.menuContoller")
@RequestMapping(value="/oper/admin/menu")
public class MenuController extends BaseController{
	
	private static final String BASE_VIEW_PACKAGE = "system/menu/menu-";

	@Autowired
	private MenuService menuService;
	
	/**
	 * 功能菜单列表
	 * @return
	 */
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView menuList(Model model){
		
		Map<String, Object> paraMap = ParamUtils.getParameterByRequest(request);
		String returnView = ParamUtils.getValueByMap(paraMap, "returnView", "");
		
		List<Map<String, Object>> me1List = this.menuService.firstMenuService();
		List<Map<String, Object>> me2List = this.menuService.secondMenuService();
		List<Map<String, Object>> me3List = this.menuService.threeMenuService();
		
		model.addAttribute("menu1", me1List);
		model.addAttribute("menu2", me2List);
		model.addAttribute("menu3", me3List);
		
		if("simple".equals(returnView)){
			return new ModelAndView(BASE_VIEW_PACKAGE.concat("simple-list"));
		}else{
			return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_LIST));
		}
	}
	
	
	/**
	 * 新增功能菜单
	 */
	@RequestMapping(value="/new", method={RequestMethod.GET})
	public ModelAndView newMenu(){
		
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_NEW));
	}
	
	@RequestMapping(value="/new", method={RequestMethod.POST})
	public ModelAndView createMenu(MenuVO menuVO){
		
		return this.menuService.newMenuService(menuVO) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 编辑功能菜单
	 */
	@RequestMapping(value="/edit", method={RequestMethod.GET})
	public ModelAndView editMenu(@RequestParam("menuId") Integer menuId, @RequestParam("level") Integer level, Model model){
		MenuDTO menuDTO = this.menuService.menuDetailService(menuId, level);
		if(level >= 2){
			MenuDTO menu = this.menuService.menuDetailService(menuDTO.getParentId(), level-1);
			model.addAttribute("parentName", menu.getName());
		}
		model.addAttribute("menu", menuDTO);
		model.addAttribute("level", level);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_EDIT));
	}
	
	@RequestMapping(value="/edit", method={RequestMethod.POST})
	public ModelAndView updateMenu(MenuVO menuVO){
		
		return this.menuService.updateMenuService(menuVO) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 删除菜单
	 */
	@RequestMapping(value="/delete", method={RequestMethod.POST})
	public ModelAndView deleteMenu(@RequestParam("menuId") Integer menuId, @RequestParam("level") Integer level){
		
		return this.menuService.deleteMenuService(menuId, level) 
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						:ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}

}
