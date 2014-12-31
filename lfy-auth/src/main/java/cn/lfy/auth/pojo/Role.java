package cn.lfy.auth.pojo;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import cn.lfy.auth.pojo.object.AbstractDO;


public class Role extends AbstractDO{

	private static final long serialVersionUID = -9043849091611356721L;

	private Long id;
	
	private Integer type;
	
	private String name;
	
	private String description;

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Role))
			return false;
		Role role = (Role) obj;
		return this.id != null ? this.id.equals(role.id) : role.id == null;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
