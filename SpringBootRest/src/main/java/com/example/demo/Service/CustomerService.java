package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.Entity.CustomerEntity;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	public List<CustomerEntity> getAllCustomer() {

		return custRepo.findAll();
	}

	public CustomerEntity getCustomer(int cid) {

		CustomerEntity searchedCustomer = new CustomerEntity();
		if (custRepo.existsById(cid)) {
			searchedCustomer = custRepo.findById(cid);
		} else {
			searchedCustomer.setCid(cid);
			searchedCustomer.setCname("Name Not found");
			searchedCustomer.setCjob("Job Title not found");

		}
		return searchedCustomer;
	}

	public CustomerEntity postCustomer(CustomerEntity cust) {
		custRepo.save(cust);

		return cust;
	}

	public String updateCustomer(CustomerEntity cust) {

		CustomerEntity searchedCust = new CustomerEntity();
		int flag = 0;
		if (custRepo.existsById(cust.getCid())) {
			searchedCust = custRepo.findById(cust.getCid());
			System.out.println(searchedCust);
			System.out.println(cust.getCname());

			custRepo.save(cust);

			flag = 1;
		}

		if (flag == 0) {
			custRepo.save(cust);
			return "User Not Found. New User Added";
		}

		return "User Information Updated";
	}

	public String deleteCustomer(int cid) {

		int flag = 0;

		if (custRepo.existsById(cid)) {
			custRepo.deleteById(cid);
			flag = 1;
		}

		if (flag == 0)
			return "Value Not Found";
		else
			return "Value successfully deleted";
	}

}
