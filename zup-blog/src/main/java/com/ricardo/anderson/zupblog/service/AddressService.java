package com.ricardo.anderson.zupblog.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.anderson.zupblog.entity.Address;
import com.ricardo.anderson.zupblog.repository.AddressRepository;

@Service
public class AddressService {
	public AddressRepository AddressRepository;

	@Autowired
	public AddressService(AddressRepository addressRepository) {
		super();
		this.AddressRepository = addressRepository;
	}

	public List<Address> findAll() {
		return AddressRepository.findAll();
	}

	public Address findById(Long id) {
		return AddressRepository.findById(id).get();
	}

	public Address saveAddress(Address address) {
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
