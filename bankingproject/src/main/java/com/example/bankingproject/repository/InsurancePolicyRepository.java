package com.example.bankingproject.repository;

import com.example.bankingproject.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
}
