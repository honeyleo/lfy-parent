package cn.lfy.auth.service.impl;
import java.util.List;

import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.pojo.object.AbstractDO;
import cn.lfy.auth.service.BaseService;
/**
 * 
 * @Description: 业务层抽象类
 * @author: Niklaus.Xu  
 * @date: 2013年12月25日
 *
 */
public abstract class AbstractBaseService <T extends AbstractDO, PK> implements BaseService<T, PK>{
	
	@Override
	public int save(T entity) {
		return this.getBaseDao().save(entity);
	}

	@Override
	public int delete(PK entityPK) {
		return this.getBaseDao().delete(entityPK);
	}


	@Override
	public int update(T entity) {
		return this.getBaseDao().update(entity);
	}

	@Override
	public T getEntityById(PK entityPK) {
		return this.getBaseDao().getEntityById(entityPK);
	}


	@Override
	public List<T> findAll() {
		return this.getBaseDao().findAll();
	}


	@Override
	public List<PK> findAllIds() {
		return this.getBaseDao().findAllIds();
	}
	
	abstract public BaseDao<T, PK> getBaseDao();
}
