package com.example.bankingproject.controller;

import com.example.bankingproject.entity.Customer;
import com.example.bankingproject.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer record) { return service.create(record); }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        service.delete(id);
        return Map.of("message", "Customer deleted successfully");
    }
}
