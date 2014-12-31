package cn.lfy.auth.dto;
import java.util.Date;

import cn.lfy.auth.pojo.Annunciate;
public class AnnunciateVO {

	private Annunciate annunciate;
	
	public Annunciate getAnnunciate(){
         return this.annunciate;		
	}
	
	public AnnunciateVO(){
		this.annunciate = new Annunciate();
	}
	
	public AnnunciateVO(Annunciate channelHelp){
		this.annunciate = channelHelp;
	}
	
	public Integer getId() {
		return this.annunciate.getId();
	}

	public void setId(Integer id) {
		this.annunciate.setId(id);
	}

	public String getTitle() {
		return this.annunciate.getTitle();
	}

	public void setTitle(String title) {
		this.annunciate.setTitle(title);
	}

	public String getContext() {
		return this.annunciate.getContext();
	}

	public void setContext(String context) {
		this.annunciate.setContext(context);
	}

	public String getOuthre() {
		return this.annunciate.getOuthre();
	}

	public void setOuthre(String outhre) {
		this.annunciate.setOuthre(outhre);
	}

	public Integer getState() {
		return this.annunciate.getState();
	}

	public void setState(Integer state) {
		this.annunciate.setState(state);
	}

	public Date getCreateTime() {
		return this.annunciate.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		this.annunciate.setCreateTime(createTime);
	}
}
