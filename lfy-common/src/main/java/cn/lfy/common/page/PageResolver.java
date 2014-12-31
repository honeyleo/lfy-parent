package cn.lfy.common.page;

import java.util.List;

import org.noo.pagination.page.PageContext;
import org.noo.pagination.page.Pagination;

public class PageResolver {

	private PageResolver(){}
	
	public static PageResolver getInstants(){
		return PageResolverInstants.resolver;
	}
	
	public Page parseResult(List<?> resultList){
		Pagination pagination = PageContext.getPageContext();
		Page page = new Page(pagination.getCurrentPage(), pagination.getPageSize(), 
				pagination.getTotalPages(), pagination.getTotalRows(), resultList);
		return page;
	}
	
	static class PageResolverInstants{
		private static PageResolver resolver = new PageResolver();
	}
}
