package io.bkr.movieflix.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Users.getAllUser", query = "SELECT u FROM Users u WHERE u.role=:pRole "),
	@NamedQuery(name = "Users.getUser", query = "SELECT u FROM Users u WHERE u.userName=:pUName AND  u.password=:password AND u.role='USER' "),
	@NamedQuery(name = "Users.getAdmin", query = "SELECT u FROM Users u WHERE u.userName=:pUName AND  u.password=:password AND u.role='ADMIN' "), 
	@NamedQuery(name = "Users.getUserByName", query = "SELECT u FROM Users u WHERE u.userName=:pUName"),
	@NamedQuery(name = "Users.getUserById", query = "SELECT u FROM Users u WHERE u.userId=:pId")
	
})

public class Users {

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", LastName=" + LastName + "]";
	}

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	String userId;

	@Column(unique = true)
	String email;

	@Column(unique = true)
	String userName;
	String password;
	String firstName;
	String LastName;
	String role;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
