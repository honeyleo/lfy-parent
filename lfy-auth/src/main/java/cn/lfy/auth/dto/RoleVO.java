package cn.lfy.auth.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import cn.lfy.auth.pojo.Role;

public class RoleVO {
	
	private Role role;
	
	
	public RoleVO(){
		this.role = new Role();
	}
	
	public RoleVO(Role role){
		this.role = role;
	}
	
	public Role getRole(){
		return this.role;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Long getId() {
		return this.role.getId();
	}

	public void setId(Long id) {
		this.role.setId(id);
	}

	public String getName() {
		return this.role.getName();
	}

	public void setName(String name) {
		this.role.setName(name);
	}

	public String getDescription() {
		return this.role.getDescription();
	}

	public void setDescription(String description) {
		this.role.setDescription(description);
	}

	public Integer getType() {
		return this.role.getType();
	}

	public void setType(Integer type) {
		this.role.setType(type);
	}
}
