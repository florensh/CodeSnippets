package de.hhn.labswps.ouh.codesnippet.web.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table( name = "user" )
public class User implements UserDetails{
	

	private String username;
	private String password;
	private String roles;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		if(this.roles != null){
			for(String role : roles.split(",")){
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
				authorities.add(authority);
			}
			
		}
		return authorities;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	

}
