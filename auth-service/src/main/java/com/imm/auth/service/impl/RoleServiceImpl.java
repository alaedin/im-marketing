/**
 * 
 */
package com.imm.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imm.auth.entity.Role;
import com.imm.auth.entity.RoleName;
import com.imm.auth.repository.RoleRepository;
import com.imm.auth.service.RoleService;

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
	public Role findByName(RoleName roleName) {
		return roleRepository.findByRoleName(roleName)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	}

}
