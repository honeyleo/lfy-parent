package cn.lfy.auth.controller.manage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.lfy.auth.controller.BaseController;
import cn.lfy.auth.dto.AnnunciateVO;
import cn.lfy.auth.pojo.Annunciate;
import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.auth.service.AnnunciateService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.MessagesKeyUtils;

/**
 * 
 * @Description: 通告管理
 * @author: tanjihua  
 * @date: 2014年3月17日
 *
 */
@Controller("manage.annunciateController")
@RequestMapping("/oper/admin/manage/annunciate")
public class AnnunciateController extends BaseController{
    
	private static final String BASE_VIEW_PACKAGE="/manage/annunciate/annunciate-";
	
	@Autowired AnnunciateService annunciateService;
	
	/**
	 * 通告列表
	 */
	@RequestMapping(value="/list.page", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView annunciateList(Model model){
		SearchDTO searchDTO=SearchDTO.getInstance(request);
		Page resultPage=this.annunciateService.annunciatePageService(searchDTO);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("param", searchDTO.getQueryFilters());
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_LIST));
	}


	/**
	 * 新增通告
	 */
	@RequestMapping(value="/new",method={RequestMethod.GET})
	public ModelAndView newAnnunciatePage(){
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_NEW));
	}
	@RequestMapping(value="/new",method={RequestMethod.POST})
	public ModelAndView createAnnunciatePage(AnnunciateVO annunciateVO){
		MemberUser memberUser = getMemberUserBySession();
		annunciateVO.setOuthre(memberUser.getNickname());
		return this.annunciateService.createAnnunciateService(annunciateVO)
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS))
				    : ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 编辑通告
	 */
	@RequestMapping(value = "/edit",method = {RequestMethod.GET})
	public ModelAndView editAnnunciate(@RequestParam("annunciateid") Integer annunciateid, Model model) {
		Assert.notNull(annunciateid);
		Annunciate annunciate = this.annunciateService.getEntityById(annunciateid);
		model.addAttribute("annunciate", annunciate);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat(VIEW_EDIT));
	}
	@RequestMapping(value = "/edit",method = {RequestMethod.POST})
	public ModelAndView updateAnnunciate(AnnunciateVO annunciateVO){
		Assert.notNull(annunciateVO.getTitle());
		return this.annunciateService.updateAnnunciateService(annunciateVO)
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS)) 
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 通告有效、无效状态
	 */
	@RequestMapping(value="/updatestatus",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updatestatus(@RequestParam("id") Integer id,@RequestParam("operation") String operation){
		return this.annunciateService.updateStatusService(id,operation)
				? ajaxDoneSuccess(getMessage(MessagesKeyUtils.OPERATION_SUCCESS))
						: ajaxDoneError(getMessage(MessagesKeyUtils.OPERATION_FAILURE));
	}
	
	
	/**
	 * 查看通告
	 */
	@RequestMapping(value = "/view",method = {RequestMethod.GET})
	public ModelAndView viewAnnunciate(@RequestParam("annunciateid") Integer annunciateid, Model model) {
		Assert.notNull(annunciateid);
		Annunciate annunciate = this.annunciateService.getEntityById(annunciateid);
		model.addAttribute("annunciate", annunciate);
		return new ModelAndView(BASE_VIEW_PACKAGE.concat("view"));
	}
	
}
