package com.in28minutes.springboot.covmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;
import com.in28minutes.springboot.covmanagement.repository.CovCenDeptRepository;

@RestController
@RequestMapping("covcendept")
public class CovCenDepartmentController {

	private final CovCenDeptRepository covcendeptrepo;

	public CovCenDepartmentController(CovCenDeptRepository covcendeptrepo) {
		super();
		this.covcendeptrepo = covcendeptrepo;
	}
	
	@PostMapping("/")
	public CovCenDepartment saveCovCenDepartment(@RequestBody CovCenDepartment CovCenDepartment) {
		return covcendeptrepo.save(CovCenDepartment);
	}
	
	@GetMapping("/")
	public List<CovCenDepartment> getAllCovCenDepartments(){
		return covcendeptrepo.findAll();
	}
	
	@GetMapping("/{id}")
	public CovCenDepartment getCovCenDepartmentById(@PathVariable int id) {
		return covcendeptrepo.findById(id).get();
	}
	
}
