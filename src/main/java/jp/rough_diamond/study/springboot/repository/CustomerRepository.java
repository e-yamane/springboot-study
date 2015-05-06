package jp.rough_diamond.study.springboot.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import jp.rough_diamond.study.springboot.domain.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
	private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>();
	
	public List<Customer> findAll() {
		return new ArrayList<>(customerMap.values());
	}
	
	public Customer findOne(Integer customerId) {
		return customerMap.get(customerId);
	}
	
	public Customer save(Customer customer) {
		return customerMap.put(customer.getId(), customer);
	}
	
	public void delete(Integer customerId) {
		customerMap.remove(customerId);
	}
}