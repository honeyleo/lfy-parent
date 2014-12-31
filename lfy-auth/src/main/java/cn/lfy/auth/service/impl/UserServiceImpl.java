package cn.lfy.auth.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.dao.admin.RoleDao;
import cn.lfy.auth.dao.admin.UserDao;
import cn.lfy.auth.pojo.MemberUser;
import cn.lfy.auth.pojo.Role;
import cn.lfy.auth.service.UserService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.PageResolver;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.ConstantsUtils;
import cn.lfy.common.utils.ParamUtils;
import cn.lfy.common.validator.Assert;
import cn.lfy.common.validator.Validation;


@Service(UserService.SERVICE_NAME)
public class UserServiceImpl extends AbstractBaseService<MemberUser, Integer> implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public BaseDao<MemberUser, Integer> getBaseDao() {
		return this.userDao;
	}

	@Override
	public MemberUser getMemberUserByNameService(String userName) {
		Assert.notNull(userName);
		return this.userDao.queryMemberUserByNameDao(userName);
	}
	
	@Override
	public Page userPageService(SearchDTO searchDTO) {
		List<MemberUser> resultList = this.userDao.userPageDao(searchDTO);
		return PageResolver.getInstants().parseResult(resultList);
	}


	@Override
	public boolean updateUserService(MemberUser memberUser) {
		Assert.notNull(memberUser.getId(), memberUser.getUserName(), memberUser.getNickname());
		if(null != memberUser.getPasswd() && Validation.isNotNULL(memberUser.getPasswd())){
			memberUser.buildPasswd();
		}
		return this.userDao.update(memberUser) > 0;
	}

	@Override
	public String getUserPermissionService(Integer userId){
		
		Assert.notNull(userId);
		Map<String, Object> permissionMap = this.userDao.getUserPermissionDao(userId);
		return ParamUtils.getValueByMap(permissionMap, "permissionIds", "");
	}
	
	
	
	@Override
	public boolean updateUserStatusService(Integer userId, String operation) {
		
		Assert.notNull(userId, operation);
		if(ConstantsUtils.USER_FORBIDDEN.equals(operation)){
			return this.userDao.updateUserStatusDao(userId, ConstantsUtils.USER_STATUS_FORBIDDEN) > 0;
		}else if(ConstantsUtils.USER_NORMAL.equals(operation)){
			return this.userDao.updateUserStatusDao(userId, ConstantsUtils.USER_STATUS_NORMAL) > 0;
		}
		return false;
	}
	
	
	@Override
	public boolean updateUserPermissionService(Integer userId, String threeMenuIds) {
		
		Assert.notNull(userId);
		if(null == threeMenuIds){
			return false;
		}
		threeMenuIds = threeMenuIds.replaceAll("，", ",");
		if(threeMenuIds.startsWith(",")){
			threeMenuIds = threeMenuIds.replaceFirst(",", "");
		}
		String[] menuIds = threeMenuIds.split(",");
		
		//先删除当前用户的所有权限
		this.userDao.deleteUserPermissionDao(userId);
		for (String menuId : menuIds) {
			if(!menuId.isEmpty()){
				this.userDao.addUserPermissionDao(userId, Integer.valueOf(menuId));
			}
		}
		return true;
	}
	
	@Override
	public boolean addUserPermissionService(Integer userId, Long roleId) {
		Assert.notNull(userId, roleId);
		
		/*
		 * 验证角色权限级别
		 */
		Role role = this.roleDao.getEntityById(Integer.valueOf(roleId.toString()));
		if(role != null && ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(role.getType())){
			return true;
		}
		
		Map<String, Object> permissinoMap = this.roleDao.getRolePermissionDao(roleId);
		String permissionStr = ParamUtils.getValueByMap(permissinoMap, "permissionIds", "");
		String[] permission = StringUtils.split(permissionStr, ",");
		for (String permissionId : permission) {
			this.userDao.addUserPermissionDao(userId, Integer.valueOf(permissionId));
		}
		return true;
	}
	
	@Override
	public boolean deleteUserPermissionService(Integer userId) {
		
		Assert.notNull(userId);
		return this.userDao.deleteUserPermissionDao(userId) > 0;
	}
	
	@Override
	public String getUserBigQnService(Integer userId) {
		
		Assert.notNull(userId);
		Map<String, Object> userBigQnMap = this.userDao.queryUserBigQnDao(userId);
		return ParamUtils.getValueByMap(userBigQnMap, "bigqnId", "");
	}

	@Override
	public boolean addUserBigQnService(Integer userId, String bigqnIds) {
		
		Assert.notNull(userId);
		if(null == bigqnIds){
			return false;
		}
		
		bigqnIds = bigqnIds.replaceAll("，", ",");
		if(bigqnIds.startsWith(",")){
			bigqnIds = bigqnIds.replaceFirst(",", "");
		}
		String[] qnIds = bigqnIds.split(",");
		
		//先删除当前用户的所有关联合作渠道
		this.userDao.deleteUserQnDao(userId);
		for (String qnid : qnIds) {
			if(!qnid.isEmpty()){
				this.userDao.addUserQnDao(userId, Integer.valueOf(qnid));
			}
		}
		return true;
	}
	
}
