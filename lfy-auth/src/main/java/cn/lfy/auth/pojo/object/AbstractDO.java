package cn.lfy.auth.pojo.object;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @Description: 基础Data Object 类
 * @author: Niklaus.Xu  
 * @date: 2013年12月25日
 *
 */
public abstract class AbstractDO implements Serializable{

	private static final long serialVersionUID = 6717094607723401388L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public abstract Serializable getId();

}
