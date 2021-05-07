package com.ricardo.anderson.zupblog.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ricardo.anderson.zupblog.entity.User;

public class UserDto {
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min = 11, max = 11)
	private String cpf;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate birthday;

	public static UserDto fromEntity(User user) {
		return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getCpf(), user.getBirthday());
	}

	public UserDto() {
		super();
	}

	public UserDto(Long id, String name, String email, String cpf, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

}
