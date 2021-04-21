package com.joshua.app.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "userprofile")
public class UserProfile implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "idnumber")
	private Long idNumber;

	@Column(name = "phoneNumber")
	private Long phoneNumber;
	
	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled = true;

	@Column(name = "locked")
	private boolean locked = false;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private UserRole role;

	public UserProfile() {
	}

	public UserProfile(String userName, String email, Long idNumber, Long phoneNumber, String password, UserRole role) {
		this.userName = userName;
		this.email = email;
		this.idNumber =idNumber;
		this.phoneNumber=phoneNumber;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return !locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name().toString());
		return Collections.singleton(authority);
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userName=" + userName + ", email=" + email + ", idNumber=" + idNumber
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", enabled=" + enabled + ", locked="
				+ locked + ", role=" + role + "]";
	}
	
	
}
