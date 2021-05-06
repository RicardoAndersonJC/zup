package com.ricardo.anderson.zupblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.anderson.zupblog.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{
	boolean existsByStreet(String street);
	boolean existsByNumber(String number);
	boolean existsByComplement(String complement);
	boolean existsByDistrict(String district);
	boolean existsBCity(String city);
	boolean existsByState(String state);
	boolean existsByZipCode(String zipCode);
}
