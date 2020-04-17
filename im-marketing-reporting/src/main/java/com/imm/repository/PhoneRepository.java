package com.imm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
