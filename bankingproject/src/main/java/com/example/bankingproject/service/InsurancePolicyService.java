package com.example.bankingproject.service;

import com.example.bankingproject.entity.InsurancePolicy;
import com.example.bankingproject.repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsurancePolicyService {
    private final InsurancePolicyRepository repository;

    public InsurancePolicyService(InsurancePolicyRepository repository) {
        this.repository = repository;
    }

    public List<InsurancePolicy> getAll() { return repository.findAll(); }

    public InsurancePolicy getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("InsurancePolicy not found: " + id));
    }

    public InsurancePolicy create(InsurancePolicy record) {
        record.setId(null);
        return repository.save(record);
    }

    public InsurancePolicy update(Long id, InsurancePolicy updated) {
        InsurancePolicy record = getById(id);
        record.setCustomerId(updated.getCustomerId());
        record.setPolicyType(updated.getPolicyType());
        record.setPolicyNumber(updated.getPolicyNumber());
        record.setPremiumAmount(updated.getPremiumAmount());
        record.setCoverageAmount(updated.getCoverageAmount());
        record.setStatus(updated.getStatus());
        
        return repository.save(record);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
