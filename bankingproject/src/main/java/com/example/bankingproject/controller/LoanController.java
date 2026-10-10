package com.example.bankingproject.controller;

import com.example.bankingproject.entity.Loan;
import com.example.bankingproject.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loan")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan create(@RequestBody Loan record) { return service.create(record); }

    @PutMapping("/{id}")
    public Loan update(@PathVariable Long id, @RequestBody Loan record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        service.delete(id);
        return Map.of("message", "Loan deleted successfully");
    }
}
