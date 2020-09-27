package com.imm.marketings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imm.marketings.entity.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
