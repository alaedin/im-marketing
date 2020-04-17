package com.imm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.entity.HouseType;

@Repository
public interface HouseTypeRepository extends JpaRepository<HouseType, Long> {

}
