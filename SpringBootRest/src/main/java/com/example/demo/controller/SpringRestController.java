package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Service.CustomerService;
import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.ErrorResponse;

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
	public Iterable<CustomerEntity> getCustomer() {
		return custServ.getAllCustomer();
	}

	@GetMapping("/customer/{cid}")
	@CrossOrigin
	public CustomerEntity getCustomer(@PathVariable String cid) {

		return custServ.getCustomer(Integer.parseInt(cid));
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	@PostMapping("/customer")
	@CrossOrigin
	public String postCustomer(@RequestBody CustomerEntity cust) {
		custServ.postCustomer(cust);
		return "Hello " + cust.getCname() + ", You are added. Your Customer Id is " + cust.getCid();
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
