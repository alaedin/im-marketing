package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
