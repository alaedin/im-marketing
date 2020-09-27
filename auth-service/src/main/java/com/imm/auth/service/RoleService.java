/**
 * 
 */
package com.imm.auth.service;

import java.util.List;

import com.imm.auth.entity.Role;

/**
 * @author alaeddine
 *
 */
public interface RoleService {

	void delete(Role role);

	void save(Role role);

	boolean existsById(Long id);

	Role findById(long id);

	List<Role> findAll();

	Role findByName(String roleAdmin);

}
