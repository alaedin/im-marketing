package com.imm.marketings.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Person;
import com.imm.marketings.entity.Role;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Set<Role> findByRoles( Role role);

}
