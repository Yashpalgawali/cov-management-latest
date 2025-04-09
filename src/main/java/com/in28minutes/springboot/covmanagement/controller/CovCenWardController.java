package com.in28minutes.springboot.covmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.entity.CovCenWard;
import com.in28minutes.springboot.covmanagement.repository.CovCenWardRepository;

@RestController
@RequestMapping("covcenward")
public class CovCenWardController {

	private final CovCenWardRepository covcenwardrepo;

	public CovCenWardController(CovCenWardRepository covcenwardrepo) {
		super();
		this.covcenwardrepo = covcenwardrepo;
	}
	
	
	@PostMapping("/")
	public CovCenWard saveCovCenWard(@RequestBody CovCenWard covcenward) {
		return covcenwardrepo.save(covcenward);
	}
	
	@GetMapping("/")
	public List<CovCenWard> saveCovCenWard() {
		return covcenwardrepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public CovCenWard getCovCenWardById(@PathVariable Integer id) {
		return covcenwardrepo.findById(id).get(); 
	}
	
	
}
