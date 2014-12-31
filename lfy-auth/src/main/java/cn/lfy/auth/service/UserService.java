package cn.lfy.auth.service;

import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;

public interface UserService extends BaseService<MemberUser, Integer>{

	String SERVICE_NAME = "adminService";
	
	Page userPageService(SearchDTO searchDTO);
	
	MemberUser getMemberUserByNameService(String userName);
	
	boolean updateUserService(MemberUser memberUser);
	
	boolean updateUserStatusService(Integer userId, String operation);
	
	boolean updateUserPermissionService(Integer userId, String threeMenuIds);
	
	String getUserPermissionService(Integer userId);
	
	boolean addUserPermissionService(Integer userId, Long roleId);
	
	boolean deleteUserPermissionService(Integer userId);
	
	boolean addUserBigQnService(Integer userId, String bigqnIds);
	
	String getUserBigQnService(Integer userId);
}
