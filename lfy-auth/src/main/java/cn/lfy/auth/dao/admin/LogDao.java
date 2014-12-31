package cn.lfy.auth.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lfy.auth.pojo.UserLog;

public interface LogDao {
	Integer insertUserLog(UserLog log);
	
	List<UserLog>getUserLog(@Param("userId")Integer userId);
}
