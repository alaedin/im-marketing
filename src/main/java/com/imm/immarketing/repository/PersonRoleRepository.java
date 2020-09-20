package com.imm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.entity.PersonRole;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Long> {

}
