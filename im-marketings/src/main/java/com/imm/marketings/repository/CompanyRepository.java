package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
