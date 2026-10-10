package com.example.bankingproject.controller;

import com.example.bankingproject.entity.InsurancePolicy;
import com.example.bankingproject.service.InsurancePolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/insurance-policies")
public class InsurancePolicyController {
    private final InsurancePolicyService service;

    public InsurancePolicyController(InsurancePolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<InsurancePolicy> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public InsurancePolicy getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InsurancePolicy create(@RequestBody InsurancePolicy record) { return service.create(record); }

    @PutMapping("/{id}")
    public InsurancePolicy update(@PathVariable Long id, @RequestBody InsurancePolicy record) {
        return service.update(id, record);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        service.delete(id);
        return Map.of("message", "InsurancePolicy deleted successfully");
    }
}
