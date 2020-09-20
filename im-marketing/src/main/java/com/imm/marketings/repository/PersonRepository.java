package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
