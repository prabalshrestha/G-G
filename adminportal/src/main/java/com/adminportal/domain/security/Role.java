package com.adminportal.domain.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
public class Role {
	@Id
	 private int RoleId;
	 private String name;
	 
	 @OneToMany(mappedBy="role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 private Set<UserRole> userRoles=new HashSet<>();

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	 
	 

}
