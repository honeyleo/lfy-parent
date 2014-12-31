package cn.lfy.auth.service;
import java.util.List;

import cn.lfy.auth.dto.AnnunciateVO;
import cn.lfy.auth.pojo.Annunciate;
import cn.lfy.common.page.Page;
import cn.lfy.common.page.dto.SearchDTO;
public interface AnnunciateService extends BaseService<Annunciate, Integer>{

	String SERVICE_NAME="annunciateService";
	
	Page annunciatePageService(SearchDTO searchDTO);

	boolean createAnnunciateService(AnnunciateVO annunciateVO);

	boolean updateAnnunciateService(AnnunciateVO annunciateVO);

	boolean updateStatusService(Integer id, String operation);

	List<Annunciate> getAnnunciateService();

	List<Annunciate> getAnnunciateListService(Integer id);

	
	
}
