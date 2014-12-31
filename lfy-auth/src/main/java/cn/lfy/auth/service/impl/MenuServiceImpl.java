package cn.lfy.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lfy.auth.dao.admin.MenuDao;
import cn.lfy.auth.dto.MenuDTO;
import cn.lfy.auth.dto.MenuVO;
import cn.lfy.auth.service.MenuService;
import cn.lfy.common.validator.Assert;

@Service(MenuService.SERVICE_NAME)
public class MenuServiceImpl implements MenuService{

	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<Map<String, Object>> firstMenuService() {
		return this.menuDao.queryFirstMenuDao();
	}
	
	@Override
	public List<Map<String, Object>> secondMenuService() {
		return this.menuDao.querySecondMenuDao();
	}
	
	@Override
	public List<Map<String, Object>> threeMenuService() {
		return this.menuDao.queryThreeMenuDao();
	}
	
	@Override
	public List<Map<String, Object>> threeMenuByUserIdService(Integer userId) {
		Assert.notNull(userId);
		return this.menuDao.queryThreeMenuByUserIdDao(userId);
	}
	
	@Override
	public List<Map<String, Object>> threeMenuByRoleIdService(Long roleId) {
		Assert.notNull(roleId);
		return this.menuDao.queryThreeMenuByRoleIdDao(roleId);
	}
	
	@Override
	public boolean newMenuService(MenuVO menuVO) {
		Assert.notNull(menuVO.getName(), menuVO.getLevel());
		
		switch (menuVO.getLevel()) {
		case 1:
			
			return this.menuDao.saveFirstMenuDao(menuVO) > 0;
			
		case 2:
			Assert.notNull(menuVO.getName(), menuVO.getLevel(), menuVO.getParentId(), menuVO.getUrl(), menuVO.getRel());
			return this.menuDao.saveSencondMenuDao(menuVO) > 0;
			
		case 3:
			Assert.notNull(menuVO.getName(), menuVO.getLevel(), menuVO.getParentId(), menuVO.getUrl());
			return this.menuDao.saveThreeMenuDao(menuVO) > 0;
			
		default:
			
			return false;
		}
	}
	
	@Override
	public boolean updateMenuService(MenuVO menuVO) {
		Assert.notNull(menuVO.getName(), menuVO.getLevel());
		
		switch (menuVO.getLevel()) {
		case 1:
			
			return this.menuDao.updateFirstMenuDao(menuVO) > 0;
			
		case 2:
			
			Assert.notNull(menuVO.getName(), menuVO.getLevel(), menuVO.getParentId(), menuVO.getUrl(), menuVO.getRel());
			return this.menuDao.updateSencondMenuDao(menuVO) > 0;
			
		case 3:
			
			Assert.notNull(menuVO.getName(), menuVO.getLevel(), menuVO.getParentId(), menuVO.getUrl());
			return this.menuDao.updateThreeMenuDao(menuVO) > 0;
			
		default:
			
			return false;
		}
	}
	
	@Override
	public MenuDTO menuDetailService(Integer id, Integer level) {
		return this.menuDao.menuDetailDao(id, level);
	}
	
	
	@Override
	public boolean deleteMenuService(Integer id, Integer level) {
		return this.menuDao.updateMenuStatusDao(id, level) > 0;
	}
	
	
	@Override
	public Map<String, List<MenuDTO>> getUserMenuService(Integer userId) {

		Map<String, List<MenuDTO>> resultMap = new HashMap<String, List<MenuDTO>>();
		List<MenuDTO> menu3List = new ArrayList<MenuDTO>();
		List<MenuDTO> menu2List = new ArrayList<MenuDTO>();
		List<MenuDTO> menu1List = new ArrayList<MenuDTO>();
		
		menu3List = this.menuDao.queryThreeMenuByUserDao(userId);
		String menu2Id= getPartnerId(menu3List);
		if(menu2Id != null && !menu2Id.isEmpty()){
			menu2List = this.menuDao.querySecondMenuByUserDao(menu2Id);
			String menu1Id = getPartnerId(menu2List);
			menu1List = this.menuDao.queryFirstMenuByUserDao(menu1Id);
		}
		resultMap.put("firstMenu", menu1List);
		resultMap.put("secondMenu", menu2List);
		resultMap.put("threeMenu", menu3List);
		return resultMap;
	}
	
	private String getPartnerId(List<MenuDTO> menuList){
		String partnerIdStr = "";
		for (MenuDTO menuDTO : menuList) {
			partnerIdStr += "," + menuDTO.getParentId();
		}
		
		if(partnerIdStr.startsWith(",")){
			partnerIdStr = partnerIdStr.replaceFirst(",", "");
		}
		
		return partnerIdStr;
	}
	
}
