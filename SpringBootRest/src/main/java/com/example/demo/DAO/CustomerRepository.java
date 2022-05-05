package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

	//@Query("select s from CustomerEntity s where s.custaadhar = ?1 order by cname")
	public CustomerEntity findById(int id);
	
	public CustomerEntity findByCustaadharAndCname(String cust_aadhaar, String cname);
	
	public CustomerEntity findByCustaadhar(String cust_aadhaar);
	
}
