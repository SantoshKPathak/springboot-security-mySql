/**
 * 
 */
package com.santoshpathak.springsecurity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author santoshpathak
 *
 */
@Entity
@Table(name="authorities", schema = "springsecuritydemo",indexes = {@Index(name = "idx_username_authority",unique = true,columnList = "users_username,authority")})
public class Authorities implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8477160509613264533L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 45)
	//@JoinColumn(foreignKey = @ForeignKey(name = "fk_username"), name = "username", referencedColumnName = "username")
	private String users_username;
	
	@Column(nullable = false, length = 45)
	private String authority;
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsers_username() {
		return users_username;
	}
	public void setUsers_username(String users_username) {
		this.users_username = users_username;
	}
	@Override
	public String toString() {
		return "Authorities [id=" + id + ", users_username=" + users_username + ", authority=" + authority + "]";
	}
	
	
}
