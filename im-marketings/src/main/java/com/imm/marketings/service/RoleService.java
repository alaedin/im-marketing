/**
 * 
 */
package com.imm.marketings.service;

import java.util.List;
import java.util.Set;

import com.imm.marketings.entity.Role;

/**
 * @author alaeddine
 *
 */
public interface RoleService{

	void delete(Role role);

	void save(Role role);

	boolean existsById(Long id);

	Role findById(long id);

	List<Role> findAll();

	Role findByRoleName(String roleName);
	
	Set<Role> findByPersons_id(int personId);

}
