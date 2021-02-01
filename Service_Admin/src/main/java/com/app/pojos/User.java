package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "email_id", nullable = false, unique = true, length = 25)
	private String emailId;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "person_role")
	private Role personRole;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String emailId, String password, Role personRole) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.personRole = personRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getPersonRole() {
		return personRole;
	}

	public void setPersonRole(Role personRole) {
		this.personRole = personRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailId=" + emailId + ", password=" + password + ", personRole="
				+ personRole + "]";
	}

}
