package cn.lfy.auth.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lfy.auth.dto.MenuDTO;
import cn.lfy.auth.dto.MenuVO;

public interface MenuDao {

	List<Map<String, Object>> queryFirstMenuDao();
	
	List<Map<String, Object>> querySecondMenuDao();
	
	List<Map<String, Object>> queryThreeMenuDao();
	
	List<Map<String, Object>> queryThreeMenuByUserIdDao(@Param("userId") Integer userId);
	
	List<Map<String, Object>> queryThreeMenuByRoleIdDao(@Param("roleId") Long roleId);

	int saveFirstMenuDao(MenuVO menuVO);
	
	int saveSencondMenuDao(MenuVO menuVO);
	
	int saveThreeMenuDao(MenuVO menuVO);
	
	int updateFirstMenuDao(MenuVO menuVO);
	
	int updateSencondMenuDao(MenuVO menuVO);
	
	int updateThreeMenuDao(MenuVO menuVO);
	
	MenuDTO menuDetailDao(@Param("id") Integer id, @Param("level") Integer level);
	
	int updateMenuStatusDao(@Param("id") Integer id, @Param("level") Integer level);

	List<MenuDTO> queryThreeMenuByUserDao(@Param("userId") Integer userId);
	
	List<MenuDTO> querySecondMenuByUserDao(@Param("menu2Id") String menu2Id);

	List<MenuDTO> queryFirstMenuByUserDao(@Param("menu1Id") String menu1Id);
}
