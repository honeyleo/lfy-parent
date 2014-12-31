package cn.lfy.auth.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lfy.auth.controller.system.InitComponent;
import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.dao.admin.RoleDao;
import cn.lfy.auth.dto.RoleVO;
import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.RoleService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.PageResolver;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.ParamUtils;
import cn.lfy.common.validator.Assert;

@Service(RoleService.SERVICE_NAME)
public class RoleServiceImpl extends AbstractBaseService<Role, Integer> implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private InitComponent initComponent;
	
	
	@Override
	public BaseDao<Role, Integer> getBaseDao() {
		return this.roleDao;
	}
	
	@Override
	public Page rolePageService(SearchDTO searchDTO) {
		List<Role> resultList = this.roleDao.rolePageDao(searchDTO);
		return PageResolver.getInstants().parseResult(resultList);
	}
	
	@Override
	public boolean createRoleService(RoleVO roleVO) {
		Assert.notNull(roleVO.getName(), roleVO.getType());
		if (this.roleDao.save(roleVO.getRole()) > 0) {
			this.initComponent.initRoleAction();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateRoleService(RoleVO roleVO) {
		Assert.notNull(roleVO.getName(), roleVO.getType());
		if (this.roleDao.update(roleVO.getRole())>0) {
			this.initComponent.initRoleAction();
			return true;
		}
		return false;
	}
	
	@Override
	public String getRolePermissionService(Long roleId) {
		Assert.notNull(roleId);
		Map<String, Object> permissionMap = this.roleDao.getRolePermissionDao(roleId);
		return ParamUtils.getValueByMap(permissionMap, "permissionIds", "");
	}
	
	@Override
	public boolean updateRolePermissionService(Long roleId, String threeMenuIds) {
		
		Assert.notNull(roleId);
		
		if(null == threeMenuIds){
			return false;
		}
		//先删除当前角色的所有权限
		this.roleDao.deleteRolePermissionDao(roleId);
		
		threeMenuIds = threeMenuIds.replaceAll("，", ",");
		if(threeMenuIds.startsWith(",")){
			threeMenuIds = threeMenuIds.replaceFirst(",", "");
		}
		String[] menuIds = threeMenuIds.split(",");
		for (String menuId : menuIds) {
			if(!menuId.isEmpty()){
				this.roleDao.addRolePermissionDao(roleId, Integer.valueOf(menuId));
			}
		}
		return true;
	}

	@Override
	public boolean deleteRole(Integer roleId) {
		Assert.notNull(roleId);
		if (this.roleDao.delete(roleId)>0) {
			this.initComponent.initRoleAction();
			return true;
		}
		return false;
	}
	
	
}
