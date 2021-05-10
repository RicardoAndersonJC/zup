package com.ricardo.anderson.zupblog.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.ricardo.anderson.zupblog.controller.util.UtilController;
import com.ricardo.anderson.zupblog.dto.AddressDto;
import com.ricardo.anderson.zupblog.entity.Address;
import com.ricardo.anderson.zupblog.service.AddressService;

@RestController
@RequestMapping("/api/v1/adresses")
@Validated
public class AddressController {

	public AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@GetMapping
	public ResponseEntity<List<AddressDto>> index() {
		List<Address> address = addressService.findAll();
		return ResponseEntity.ok(address.stream().map(AddressDto::fromEntity).collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<AddressDto> show(@PathVariable Long id) {
		Address address = addressService.findById(id);
		return ResponseEntity.ok(AddressDto.fromEntity(address));
	}

	@PostMapping
	public ResponseEntity<AddressDto> store(@RequestBody @Validated AddressDto addressDto) {
		Address address = addressService.saveAddress(addressDto.toEntity());
		return ResponseEntity.created(UtilController.generatedUri(address.getId()))
				.body(AddressDto.fromEntity(address));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delAddress(@PathVariable Long id) {
		addressService.delUser(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("{id}")
	public ResponseEntity<AddressDto> putAdress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		Address address = addressService.putAddress(id, addressDto.toEntity());
		return ResponseEntity.ok(AddressDto.fromEntity(address));
	}
}
