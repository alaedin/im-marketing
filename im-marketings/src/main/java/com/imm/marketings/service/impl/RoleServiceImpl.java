/**
 * 
 */
package com.imm.marketings.service.impl;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imm.marketings.entity.Role;
import com.imm.marketings.repository.RoleRepository;
import com.imm.marketings.service.RoleService;

/**
 * @author alaeddine
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(long id) {
		return roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	}

	@Override
	public boolean existsById(Long id) {
		return roleRepository.existsById(id);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}


	@Override
	public Role findByRoleName(@Valid String roleName) {
		return findByRoleName(roleName);
	}

	@Override
	public Set<Role> findByPersons_id(int personId) {
		return roleRepository.findByPersons_id(personId);
	}


}
