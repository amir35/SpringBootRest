package com.example.demo.Service;

import java.util.List;

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

	public List<CustomerEntity> getAllCustomer(String sortBy) {
		
		//Sort sort = new Sort(sortBy)
		
		return custRepo.findAll(Sort.by(sortBy).ascending());

		//return custRepo.findAll(Sort.by(Sort.Direction.ASC,"cid"));
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
	public String postCustomer(CustomerEntity cust) throws CustomerAlreadyExistsException  {
		
		//CustomerEntity existingCustomer = custRepo.findByCustaadharAndCname(cust.getCust_aadhar(), cust.getCname());
		
		CustomerEntity existingCustomer = custRepo.findByCustaadhar(cust.getCustaadhar());
		
		System.out.println(existingCustomer);
		
		
		if (existingCustomer == null) {
			custRepo.save(cust);
            return "Hello " + cust.getCname() + ", You are added. Your Customer Id is " + cust.getCid();
        }
        else
           // throw new CustomerAlreadyExistsException("Customer already exixts!!");
        	return "Not Added";
    }
		

	public String updateCustomer(CustomerEntity cust) {
		
		if(custRepo.existsById(cust.getCid()))
		{
			System.out.println("User exist");
			custRepo.save(cust);
			return "User updated";
		}
		else {
			String str = "No Customer Exists with given Customer id " + cust.getCid();
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
