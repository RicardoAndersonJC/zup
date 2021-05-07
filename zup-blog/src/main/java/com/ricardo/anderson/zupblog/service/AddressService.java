package com.ricardo.anderson.zupblog.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.anderson.zupblog.entity.Address;
import com.ricardo.anderson.zupblog.entity.User;
import com.ricardo.anderson.zupblog.repository.AddressRepository;

@Service
public class AddressService {
	public AddressRepository AddressRepository;
	public UserService userService;

	@Autowired
	public AddressService(AddressRepository addressRepository , UserService userService) {
		super();
		this.AddressRepository = addressRepository;
		this.userService = userService; 
	}

	public List<Address> findAll() {
		return AddressRepository.findAll();
	}

	public Address findById(Long id) {
		return AddressRepository.findById(id).get();
	}

	public Address saveAddress(Address address) {
		User user = userService.findById(address.getUser().getId());
		address.setUser(user);
		return AddressRepository.save(address);
	}

	public void delUser(Long id) {
		AddressRepository.deleteById(id);
	}

	public Address putAddress(Long id, Address AddressBody) {
		Address addressBd = AddressRepository.findById(id).get();
		BeanUtils.copyProperties(AddressBody, addressBd, "id");
		return this.saveAddress(addressBd);
	}
}
