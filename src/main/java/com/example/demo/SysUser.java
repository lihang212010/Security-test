package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class SysUser implements UserDetails{

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List< SysRole> roles;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
		List<SysRole> roles=this.getRoles();
		for(SysRole role:roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
   public void setPassword(String password) {
	  this.password = password;
}  
   public void setId(Long id) {
	  this.id = id;
   }
   public Long getId() {
	   return id;
    }
   public void setRoles(List<SysRole> roles) {
	this.roles = roles;
   }
   public List<SysRole> getRoles() {
	  return roles;
    }
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
public void  setUsername(String username) {
	this.username = username;
}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
