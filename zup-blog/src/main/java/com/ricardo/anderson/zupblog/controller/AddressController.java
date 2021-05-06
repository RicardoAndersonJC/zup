package com.ricardo.anderson.zupblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.anderson.zupblog.entity.Address;
import com.ricardo.anderson.zupblog.service.AddressService;

@RestController
@RequestMapping("/api/v1/adresses")
@Validated
public class AddressController {

	public AddressService AddressService;

	@Autowired
		public AddressController(AddressService AddressService) {
			super();
			this.AddressService = AddressService;
		}

	@GetMapping
	public List<Address> index() {
		return AddressService.findAll();
	}

	@GetMapping("{id}")
	public Address getAddress(@PathVariable Long id) {

		return AddressService.findById(id);
	}

	@PostMapping
	public Address postAddress(@RequestBody @Validated Address address) {
		return AddressService.saveAddress(address);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delAddress(@PathVariable Long id) {
		AddressService.delUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public Address putAdress(@PathVariable Long id, @RequestBody Address address) {

		return AddressService.putAddress(id, address);
	}
}
