package com.gc.test.hibernate.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER")
public class UserDetails {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	private String description;

	/*@Embedded
	private Address address;
	@Embedded
	@AttributeOverrides(
			{ 
				@AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
				@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")), 
				@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
				@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PIN_CODE")) 
			})
	private Address officeAddress;*/
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS", //table where collection will be stored
		joinColumns=@JoinColumn(name="USER_ID"))
	@CollectionId(columns = { @Column(name="COLL_ID") }, //add primary key for collection
		generator = "hilo-gen", 
		type = @Type(type="long"))
	@GenericGenerator(name="hilo-gen", strategy="hilo") //generator for PK
	private Collection<Address> addresses=new ArrayList<Address>(); //list should be here for collection with id!

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Collection<Address> getAdrresses() {
		return addresses;
	}

	public UserDetails setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public UserDetails setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public UserDetails setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public UserDetails setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public UserDetails setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName
				+ ", joinDate=" + joinDate + ", description=" + description
				+ ", addresses=" + addresses + "]";
	}

	

}
