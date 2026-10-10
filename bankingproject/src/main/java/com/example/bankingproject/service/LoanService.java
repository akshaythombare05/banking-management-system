package com.example.bankingproject.service;

import com.example.bankingproject.entity.Loan;
import com.example.bankingproject.repository.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> getAll() { return repository.findAll(); }

    public Loan getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Loan not found: " + id));
    }

    public Loan create(Loan record) {
        record.setId(null);
        return repository.save(record);
    }

    public Loan update(Long id, Loan updated) {
        Loan record = getById(id);
        record.setCustomerId(updated.getCustomerId());
        record.setLoanType(updated.getLoanType());
        record.setAmount(updated.getAmount());
        record.setInterestRate(updated.getInterestRate());
        record.setStatus(updated.getStatus());
        
        return repository.save(record);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
