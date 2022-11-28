package com.example.assessment3.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment3.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByAccountnumber(long accountnumber);
	
}
