package com.crux.micro.contact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crux.micro.contact.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
