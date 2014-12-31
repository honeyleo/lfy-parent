package cn.lfy.auth.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.pojo.Role;
import cn.lfy.common.page.dto.SearchDTO;

public interface RoleDao extends BaseDao<Role, Integer>{

	List<Role> rolePageDao(SearchDTO searchDTO);
	
	Map<String, Object> getRolePermissionDao(@Param("roleId") Long roleId);

	int deleteRolePermissionDao(Long roleId);

	int addRolePermissionDao(@Param("roleId") Long roleId, @Param("permissionId") Integer permissionId);
}
