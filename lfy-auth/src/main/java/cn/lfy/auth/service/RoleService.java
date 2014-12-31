package cn.lfy.auth.service;

import cn.lfy.auth.dto.RoleVO;
import cn.lfy.auth.pojo.Role;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;

public interface RoleService extends BaseService<Role, Integer>{

	String SERVICE_NAME = "roleService";
	
	Page rolePageService(SearchDTO searchDTO);
	
	boolean createRoleService(RoleVO roleVO);
	
	boolean updateRoleService(RoleVO roleVO);
	
	String getRolePermissionService(Long roleId);
	
	boolean updateRolePermissionService(Long roleId, String threeMenuIds);

	boolean deleteRole(Integer roleId);
	

}
