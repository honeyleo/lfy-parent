package cn.lfy.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lfy.auth.dao.admin.LogDao;
import cn.lfy.auth.pojo.UserLog;
import cn.lfy.auth.service.LogService;
@Service
public class LogServiceImpl implements LogService{
@Resource private LogDao logDao;
	@Override
	public Integer insertUserLog(UserLog log) {
		return logDao.insertUserLog(log);
	}

	@Override
	public List<UserLog> getUserLog(Integer userId) {
		return logDao.getUserLog(userId);
	}

}
