package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.PersonAppointment;

@Repository
public interface PersonAppointmentRepository extends JpaRepository<PersonAppointment, Long> {

}
