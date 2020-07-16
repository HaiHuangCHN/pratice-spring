package com.demo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserReq {
	// @NotNull normally used in Integer
	// @NotBlank normally used in String
	// @NotEmpty normally used in List
	@NotNull(message = "id is missing")
	private Integer id;
	@NotBlank(message = "firstName is missing")
	private String firstName;
	@NotBlank(message = "lastName is missing")
	private String lastName;
	@NotBlank(message = "email is missing")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
