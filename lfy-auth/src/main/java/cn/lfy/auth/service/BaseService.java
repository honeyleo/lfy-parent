package cn.lfy.auth.service;

import java.util.List;

import cn.lfy.auth.pojo.object.AbstractDO;

/**
 * 
 * @Description: 业务层抽象接口
 * @author: Niklaus.Xu  
 * @date: 2013年12月25日
 *
 */
public interface BaseService <T extends AbstractDO, PK>{

	int save(T entity);
	
	int delete(PK entityPK);
	
	int update(T entity);
	
	T getEntityById(PK entityPK);
	
	List<T> findAll();
	
	List<PK> findAllIds();
}
