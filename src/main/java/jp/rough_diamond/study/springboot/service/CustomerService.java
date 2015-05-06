package jp.rough_diamond.study.springboot.service;

import java.util.List;

import jp.rough_diamond.study.springboot.domain.Customer;
import jp.rough_diamond.study.springboot.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
