package cn.lfy.auth.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.dao.admin.AnnunciateDao;
import cn.lfy.auth.dto.AnnunciateVO;
import cn.lfy.auth.pojo.Annunciate;
import cn.lfy.auth.service.AnnunciateService;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.PageResolver;
import cn.lfy.common.page.dto.SearchDTO;
import cn.lfy.common.utils.ConstantsUtils;
import cn.lfy.common.validator.Assert;
@Service(AnnunciateService.SERVICE_NAME)
public class AnnunciateServiceImpl extends AbstractBaseService<Annunciate, Integer> implements AnnunciateService {
	
	  @Autowired
	  private AnnunciateDao annunciateDao;
	
	
	  @Override
	  public BaseDao<Annunciate, Integer> getBaseDao() {
	   	return this.annunciateDao;
	  }

	@Override
	public Page annunciatePageService(SearchDTO searchDTO) {
		List<Annunciate> resultlist=this.annunciateDao.annunciatePageDao(searchDTO);
		return PageResolver.getInstants().parseResult(resultlist);
	}

	@Override
	public boolean createAnnunciateService(AnnunciateVO annunciateVO) {
		Assert.notNull(annunciateVO.getTitle());
		return this.annunciateDao.save(annunciateVO.getAnnunciate()) > 0;
	}

	@Override
	public boolean updateAnnunciateService(AnnunciateVO annunciateVO) {
		Assert.notNull(annunciateVO.getTitle());
		return this.annunciateDao.update(annunciateVO.getAnnunciate()) > 0;
	}

	@Override
	public boolean updateStatusService(Integer id, String operation) {
		if (ConstantsUtils.ANNUNCIATE_FORBIDDEN.equals(operation)) {
			return this.annunciateDao.updateStatusDao(id, ConstantsUtils.ANNUNCIATE_STATUS_FORBIDDEN) > 0;
		}else if(ConstantsUtils.ANNUNCIATE_NORAML.equals(operation)){
            return this.annunciateDao.updateStatusDao(id, ConstantsUtils.ANNUNCIATE_STATUS_NORAML) > 0;			
		}
		return false;
	}

	@Override
	public List<Annunciate> getAnnunciateService() {
		List<Annunciate> resultlist=this.annunciateDao.getAnnunciateDao();
		return resultlist;
	}

	@Override
	public List<Annunciate> getAnnunciateListService(Integer id) {
		List<Annunciate> getResultList=this.annunciateDao.getAnnunciateListDao(id);
		return getResultList;
	}


}
