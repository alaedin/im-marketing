package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
