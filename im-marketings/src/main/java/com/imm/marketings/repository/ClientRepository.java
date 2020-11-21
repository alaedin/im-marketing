package com.imm.marketings.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.imm.marketings.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value = "Select c from Client c where not exists( select a from c.appointment a )")
	Set<Client> findWhereNotExistsInAppointment();
}
