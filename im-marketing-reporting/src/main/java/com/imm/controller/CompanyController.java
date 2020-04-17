package com.imm.controller;

import static com.imm.utility.ConstantUtils.ADD;
import static com.imm.utility.ConstantUtils.DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_DELETE;
import static com.imm.utility.ConstantUtils.SUCCESS_GET;
import static com.imm.utility.ConstantUtils.SUCCESS_SAVE;
import static com.imm.utility.ConstantUtils.SUCCESS_UPDATE;
import static com.imm.utility.ConstantUtils.UPDATE;
import static com.imm.utility.Utils.successMessage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imm.entity.Company;
import com.imm.repository.CompanyRepository;
import com.imm.utility.ValuesObject;

@RestController
@RequestMapping("/im-workspace")
public class CompanyController {


	@Autowired
	private CompanyRepository companyRepository;
	private static final String BASED_PATH = "/company";

	@GetMapping(BASED_PATH)
	private ResponseEntity<?> getAll() {
		ValuesObject<?> companies = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, "Company"))
				.body(companyRepository.findAll())
				.build();
		return ResponseEntity.ok(companies);
	}

	@GetMapping(BASED_PATH + "/{id}")
	private ResponseEntity<?> getById(@Valid @PathVariable("id") Long id) {

		ValuesObject<?> companies = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_GET, "Company"))
				.body(companyRepository.findById(id))
				.build();
		return ResponseEntity.ok(companies);
	}

	@PostMapping(BASED_PATH + "/" + ADD)
	private ResponseEntity<?> add(@Valid @RequestBody Company company) {
		companyRepository.save(company);
		ValuesObject<?> companies = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_SAVE, "Company"))
				.body(company)
				.build();
		return ResponseEntity.ok(companies);
	}

	@PutMapping(BASED_PATH + "/" + UPDATE)
	private ResponseEntity<?> update(@Valid @RequestBody Company company) {
		companyRepository.save(company);
		ValuesObject<?> companies = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_UPDATE, "Company"))
				.body(company)
				.build();
		return ResponseEntity.ok(companies);
	}

	@DeleteMapping(BASED_PATH + "/" + DELETE)
	private ResponseEntity<?> delete(@Valid @RequestBody Company company) {
		companyRepository.delete(company);
		ValuesObject<?> companies = ValuesObject.builder()
				.outCode(0)
				.message(successMessage(SUCCESS_DELETE, "Company"))
				.body(company)
				.build();
		return ResponseEntity.ok(companies);
	}
}
