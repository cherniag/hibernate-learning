package com.gc.test.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="userDetails.byId", query="from UserDetails where userId = ?"),
})
@NamedNativeQueries({
	@NamedNativeQuery(name="userdetails.byName", query="select * from USERDETAILS where USERNAME = ?",
					  resultClass=UserDetails.class)
})
public class UserDetails {
	@Id
	@GeneratedValue
	private int userId;

	private String userName;

	public UserDetails() {
	}

	public UserDetails(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserDetails setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
