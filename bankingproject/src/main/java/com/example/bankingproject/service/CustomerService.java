package com.example.bankingproject.service;

import com.example.bankingproject.entity.Customer;
import com.example.bankingproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll() { return repository.findAll(); }

    public Customer getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found: " + id));
    }

    public Customer create(Customer record) {
        record.setId(null);
        return repository.save(record);
    }

    public Customer update(Long id, Customer updated) {
        Customer record = getById(id);
        record.setName(updated.getName());
        record.setCity(updated.getCity());
        record.setPhone(updated.getPhone());
        record.setEmail(updated.getEmail());
        
        return repository.save(record);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
