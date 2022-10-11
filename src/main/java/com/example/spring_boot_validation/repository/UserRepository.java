package com.example.spring_boot_validation.repository;

         import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_validation.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
