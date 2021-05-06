package com.ricardo.anderson.zupblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.anderson.zupblog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);

}
