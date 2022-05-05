package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.Entity.CustomerEntity;
import com.example.demo.Service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	private CustomerService custService;
	
	@MockBean
	private CustomerRepository custRepo;
	
	@Test
	public void getCustomerTest()
	{
		
		when(custRepo.findAll()).thenReturn(Stream.of(new CustomerEntity(1122,"Amir","Engineer","Male","A234jdhjd"),
				new CustomerEntity(1123,"Adil","software Engineer","Male","B234dedhjd")).collect(Collectors.toList()));
		
		String sortBy = "cname";
		assertEquals(2, custService.getAllCustomer(sortBy ).size());
	}

}
