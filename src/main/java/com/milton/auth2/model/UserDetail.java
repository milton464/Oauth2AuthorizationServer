package com.milton.auth2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public UserDetail(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		log.info("grantedAuthorities: "+grantedAuthorities+ "user: "+user);
		log.info("role: "+user.getRoles());
		
		grantedAuthorities = user.getRoles()
                .stream().map(roles -> new SimpleGrantedAuthority(roles.getRoleName()))
                .collect(Collectors.toList());

//		ga.forEach(	a->System.out.println(a.getAuthority()));

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
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
