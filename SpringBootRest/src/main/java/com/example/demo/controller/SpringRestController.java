package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Service.CustomerService;

@RestController
@CrossOrigin
public class SpringRestController {

	@Autowired
	private CustomerService custServ;
	
	@GetMapping("/home")
	public String getMessage()
	{
		return "Welcome to Spring Boot Rest";
	}
	
	@GetMapping("/customer")
	@CrossOrigin
	public Iterable<CustomerEntity> getCustomer()
	{
		return  custServ.getAllCustomer();
	}
	
	
	  @GetMapping("/customer/{cid}") 
	  @CrossOrigin
	  public CustomerEntity getCustomer(@PathVariable String cid) { 
		  

				/*
				 * else { Optional<CustomerEntity> custEntity = Optional.ofNullable(new
				 * CustomerEntity()); custEntity.setCid(Integer.parseInt(cid));
				 * custEntity.setCname("Not Found"); custEntity.setCjob("Not found"); return
				 * custEntity; } return "Record Not found";
				 */
		  return custServ.getCustomer(Integer.parseInt(cid));
		  	  }
	  

	  
	 @PostMapping("/customer") 
	 @CrossOrigin
	 public String postCustomer(@RequestBody CustomerEntity cust) 
	 { 
		 custServ.postCustomer(cust); 
		 return "Hello " + cust.getCname() + ", You are added. Your Customer Id is "+ cust.getCid();
		 }
	  
	 
	  @PutMapping("/customer") 
	  @CrossOrigin
	  public String updateCustomer(@RequestBody CustomerEntity cust) 
	  { 
		  return custServ.updateCustomer(cust); 
		  }
	 
	  
	  @DeleteMapping("/customer/{cid}") 
	  public String deleteCustomer(@PathVariable String cid) 
	  { 
		  return this.custServ.deleteCustomer(Integer.parseInt(cid)); }
	 }
