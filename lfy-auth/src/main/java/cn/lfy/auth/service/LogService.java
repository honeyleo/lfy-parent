package cn.lfy.auth.service;

import java.util.List;

import cn.lfy.auth.pojo.UserLog;

public interface LogService {

	Integer insertUserLog(UserLog log);
	
	List<UserLog>getUserLog(Integer userId);
}
