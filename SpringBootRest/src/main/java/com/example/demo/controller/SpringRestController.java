package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Service.CustomerService;

@RestController
@CrossOrigin
public class SpringRestController {

	@Autowired
	private CustomerService custServ;

	@GetMapping("/home")
	public String getMessage() {
		return "Welcome to Spring Boot Rest....";
	}

	@GetMapping("/customer")
	@CrossOrigin
	public List<CustomerEntity> getCustomers(
			@RequestParam(value = "sortBy" , defaultValue = "cname", required = false) String sortBy )
	{

		HttpStatus c = HttpStatus.NOT_FOUND;
		
		System.out.println(c);
		
		return custServ.getAllCustomer(sortBy);
	}

	@GetMapping("/customer/{cid}")
	@CrossOrigin
	public CustomerEntity getCustomer(@PathVariable String cid) {

		HttpStatus c = HttpStatus.FOUND;
		
		System.out.println(c);
		return custServ.getCustomer(Integer.parseInt(cid));
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	@PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public String postCustomer(@RequestBody CustomerEntity cust) {
		
		return custServ.postCustomer(cust);
	}

	@PutMapping("/customer")
	@CrossOrigin
	public String updateCustomer(@RequestBody CustomerEntity cust) {
		
		return custServ.updateCustomer(cust);
	}

	@DeleteMapping("/customer/{cid}")
	@CrossOrigin
	public String deleteCustomer(@PathVariable String cid) {
		return custServ.deleteCustomer(Integer.parseInt(cid));
	}

	
}
