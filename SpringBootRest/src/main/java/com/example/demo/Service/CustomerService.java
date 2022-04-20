package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.Entity.CustomerEntity;
import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.NoSuchCustomerExistsException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	public List<CustomerEntity> getAllCustomer() {

		return custRepo.findAll(Sort.by(Sort.Direction.ASC,"cid"));
	}

	public CustomerEntity getCustomer(int cid) {

		CustomerEntity searchedCustomer = new CustomerEntity();
		if (custRepo.existsById(cid)) {
			searchedCustomer = custRepo.findById(cid);
		} else {
			searchedCustomer.setCid(cid);
			searchedCustomer.setCname("Name Not found");
			searchedCustomer.setCjob("Job Title not found");
			searchedCustomer.setGender("Not defined");

		}
		return searchedCustomer;
	}

	// Method to add new customer details to database.Throws
	// CustomerAlreadyExistsException when customer detail
	// already exist
	//@Transactional
	public CustomerEntity postCustomer(CustomerEntity cust) {
		
		CustomerEntity existingCustomer = custRepo.findByCustaadhar(cust.getCust_aadhar());
		
		if (existingCustomer == null) {
			custRepo.save(cust);
            return cust;
        }
        else
            throw new CustomerAlreadyExistsException(
                "Customer already exixts!!");
    }
		
		

		//return cust;

	public String updateCustomer(CustomerEntity cust) {
		
		if(custRepo.existsById(cust.getCid()))
		{
			custRepo.save(cust);
			return "User updated";
		}
		else {
			String str = "NoCustomer Exists with given Customer id " + cust.getCid();
			throw new NoSuchCustomerExistsException(str);
		}
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
