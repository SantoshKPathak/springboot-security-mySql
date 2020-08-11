/**
 * 
 */
package com.santoshpathak.springsecurity.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author santoshpathak
 *
 */
@Entity
@Table(name="users", schema = "springsecuritydemo")
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8682456047235316615L;
	
	@Id
	@Column(nullable = false, length = 45)
	private String username;
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false)
	private boolean enabled;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="users_username",foreignKey = @ForeignKey(name = "fk_username"))
	private Set<Authorities> authorities;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", authorities=" + authorities + "]";
	}
}
