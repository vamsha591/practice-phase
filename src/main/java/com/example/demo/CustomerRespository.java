package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource(collectionResourceRel = "Customer",path = "Customer")
public interface CustomerRespository extends JpaRepository<Customer,Integer>  {

}
