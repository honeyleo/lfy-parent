package cn.lfy.auth.pojo;


import java.util.Date;

import cn.lfy.auth.pojo.object.AbstractDO;

public class Annunciate extends AbstractDO{

	private static final long serialVersionUID = 2065556806129393561L;
	
	
	private Integer id;
	
	private String title;
	
	private String context;
	
	private String outhre;
	
	private Integer state;
	
	private Date createTime;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getOuthre() {
		return outhre;
	}

	public void setOuthre(String outhre) {
		this.outhre = outhre;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

  
}
