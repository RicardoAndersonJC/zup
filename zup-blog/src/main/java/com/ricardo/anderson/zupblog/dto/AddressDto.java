package com.ricardo.anderson.zupblog.dto;

import javax.validation.constraints.NotBlank;

import com.ricardo.anderson.zupblog.entity.Address;
import com.ricardo.anderson.zupblog.entity.User;

public class AddressDto {
	private Long id;
	@NotBlank
	private String street;
	@NotBlank
	private String number;
	@NotBlank
	private String complement;
	@NotBlank
	private String district;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String zipCode;
	private User user;

	public static AddressDto fromEntity(Address address) {
		return new AddressDto(address.getId(), address.getStreet(), address.getNumber(), address.getComplement(),
				address.getDistrict(), address.getCity(), address.getState(), address.getZipCode(), address.getUser());
	}

	public AddressDto() {
		super();
	}

	public AddressDto(Long id, String street, String number, String complement, String district, String city,
			String state, String zipCode, User user) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.user = user;
	}

	public Address toEntity() {
		return new Address(this.id, this.street, this.number, this.complement, this.district, this.city, this.state,
				this.zipCode, this.user);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
