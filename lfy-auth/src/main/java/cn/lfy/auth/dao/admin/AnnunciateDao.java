package cn.lfy.auth.dao.admin;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lfy.auth.dao.BaseDao;
import cn.lfy.auth.pojo.Annunciate;
import cn.lfy.common.page.dto.SearchDTO;
public interface AnnunciateDao extends BaseDao<Annunciate, Integer> {
	
	List<Annunciate> annunciatePageDao(SearchDTO searchDTO);

	int updateStatusDao(@Param("id") Integer id, @Param("state") Integer state);

	List<Annunciate> getAnnunciateDao();

	List<Annunciate> getAnnunciateListDao(Integer id);
}
