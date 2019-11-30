package com.mt.mp.myuniversity.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mt.mp.myuniversity.entities.Role;
import com.mt.mp.myuniversity.entities.User;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 5226787207064024624L;

	private User user;

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		Collection<Role> roles = user.getRoles();
		if (roles != null && !roles.isEmpty()) {
			roles.forEach(role -> {
				list.add(new SimpleGrantedAuthority(role.getName()));
			});
		}
		return list;
	}

	@Override
	public String getPassword() {
		return "{noop}"+user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
		return user.isActive();
	}

}
