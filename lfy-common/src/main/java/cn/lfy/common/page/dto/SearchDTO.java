package cn.lfy.common.page.dto;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class SearchDTO {

	/**
	 * 排序字段
	 */
	private String sortKey;
	
	/**
	 * 排序方式
	 */
	private String sortType;
	
	/**
	 * 查询条件
	 */
	private Map<String, Object> queryFilters = new HashMap<String, Object>();
	
	public SearchDTO(){}
	
	public SearchDTO(String _sortKey, String _sortType){
		this.sortKey = _sortKey;
		this.sortType = _sortType;
	}
	
	public SearchDTO(String _sortKey, String _sortType, Map<String, Object> _queryFilters){
		this.sortKey = _sortKey;
		this.sortType = _sortType;
		this.queryFilters = _queryFilters;
	}
	
	public Object get(String key){
		if(null == this.queryFilters){
			return null;
		}
		return this.queryFilters.get(key);
	}
	
	public void put(String key, Object value){
		if(null == this.queryFilters){
			this.queryFilters = new HashMap<String, Object>();
		}
		this.queryFilters.put(key, value);
	}
	
	public void remove(String key){
		if(null == this.queryFilters){
			this.queryFilters = new HashMap<String, Object>();
			return;
		}
		
		if(this.queryFilters.containsKey(key)){
			this.queryFilters.remove(key);
		}
	}
	
	public static SearchDTO getInstance(HttpServletRequest request){
		SearchDTO searchDTO = new SearchDTO();
		
		Enumeration<?> enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			String paraName = (String) enums.nextElement();
			
			if(ConstantsUtils.HTTP_PARAM_PAGE_SIZE.equals(paraName) || ConstantsUtils.HTTP_PARAM_PAGE.equals(paraName)){
				continue;
			}
			
			if(ConstantsUtils.HTTP_PARAM_SORT_KEY.equals(paraName)){
				searchDTO.setSortKey(request.getParameter(paraName));
				continue;
			}
			
			if(ConstantsUtils.HTTP_PARAM_SORT_TYPE.equals(paraName)){
				searchDTO.setSortKey(request.getParameter(paraName));
				continue;
			}
			
			String[] values = request.getParameterValues(paraName);
			if (values.length > 1) {
				searchDTO.put(paraName, values);
			} else if (values.length == 1 && null !=values && !"".equals(values[0])) {
				searchDTO.put(paraName, values[0].trim());
			}
			
		}
		
		return searchDTO;
	}
	

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public Map<String, Object> getQueryFilters() {
		return queryFilters;
	}

	public void setQueryFilters(Map<String, Object> queryFilters) {
		this.queryFilters = queryFilters;
	}
}


class ConstantsUtils{
	//分页相关
	public static final String HTTP_PARAM_PAGE_SIZE = "pageSize";
	public static final String HTTP_PARAM_PAGE = "page";
	public static final String HTTP_PARAM_SORT_KEY = "sortKey";
	public static final String HTTP_PARAM_SORT_TYPE = "sortType";
}
