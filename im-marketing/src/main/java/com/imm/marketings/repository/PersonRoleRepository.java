package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.PersonRole;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Long> {

}
