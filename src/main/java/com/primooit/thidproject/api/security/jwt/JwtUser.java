package com.primooit.thidproject.api.security.jwt;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private final String id;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;
	
	private final String phone;
	private final String cpf;
	private final String adress;
	private final Date expiration;
	private final String salesman;

	
	

	/*public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}*/


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public JwtUser(String id, String username, String password, Collection<? extends GrantedAuthority> authorities,
			String phone, String cpf, String adress, Date expiration, String salesman) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.phone = phone;
		this.cpf = cpf;
		this.adress = adress;
		this.expiration = expiration;
		this.salesman = salesman;
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getCpf() {
		return cpf;
	}

	public String getAdress() {
		return adress;
	}

	public Date getExpiration() {
		return expiration;
	}

	public String getSalesman() {
		return salesman;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}