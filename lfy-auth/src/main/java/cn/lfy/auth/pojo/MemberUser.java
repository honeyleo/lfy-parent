package cn.lfy.auth.pojo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

@Alias("memberUser")
public class MemberUser extends User{
	

	private static final long serialVersionUID = 2792254762029951568L;

	private Integer id;
	
	private String nickname;
	
	private Integer status;
	
	private Long roleId;
	
	private Integer roleType;
	
	private Date createTime;
	
	private List<String> urlList;
	
	
	public MemberUser(){
		super();
	}
	
	public MemberUser(String _passwd, String _userName, String _nickname, Integer _status, Long _roleId){
		super();
		this.passwd = _passwd;
		this.userName = _userName;
		this.nickname = _nickname;
		this.status = _status;
		this.roleId = _roleId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
}
