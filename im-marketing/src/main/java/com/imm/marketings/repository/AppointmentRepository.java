package com.imm.marketings.repository;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imm.marketings.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	Set<Appointment> findByPerson_id(@Valid Long personId);

}
