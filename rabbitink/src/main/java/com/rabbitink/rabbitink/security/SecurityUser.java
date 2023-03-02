package com.rabbitink.rabbitink.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.rabbitink.rabbitink.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 821320911666648387L;

	public SecurityUser() {
	}

	public SecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
		this.setPassword(user.getPassword());
		this.setEmail(user.getEmail());
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

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
