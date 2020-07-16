package com.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user_20181126", schema = "pratice") // We can use this annotation to create a table as
													// "user_table_20181116".
													// If no annotation is added in the beginning, then application will
													// create table and named as "user" (name of the entity)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	TABLE：使用一个特定的数据库表格来保存主键。
//	SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
//	IDENTITY：主键由数据库自动生成（主要是自动增长型）。
//	AUTO：主键由程序控制。
	private int userId;

	@Column(name = "username", nullable = false, columnDefinition = "VARCHAR(10)")
	private String username;

	@Column(name = "password", nullable = false, columnDefinition = "VARCHAR(10)")
	private String password;

	@Column(name = "firstname", columnDefinition = "VARCHAR(10)")
	private String firstname;

	@Column(name = "lastname", columnDefinition = "VARCHAR(10)") // nullable = false, if do not
																	// mention
																	// it, will be nullable by default
	private String lastname;

	@Column(name = "email", columnDefinition = "VARCHAR(45)")
	private String email;

	@Column(name = "career", columnDefinition = "VARCHAR(45)")
	private String career;

	@Column(name = "sex", columnDefinition = "char(1)") // We can define column by adding "columnDefinition = "char(1)""
	private String sex;

	@Column(name = "created_date", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdDate;

	@Column(name = "updated_date", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedDate;

	@JoinColumn(name = "body_id", nullable = false)
	@OneToOne
	private BodyInfo bodyInfo;

	protected User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", userId, firstname, lastname);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public BodyInfo getBodyInfo() {
		return bodyInfo;
	}

	public void setBodyInfo(BodyInfo bodyInfo) {
		this.bodyInfo = bodyInfo;
	}

}