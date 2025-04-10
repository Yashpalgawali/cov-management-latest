package com.in28minutes.springboot.covmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.entity.CovCenPatient;
import com.in28minutes.springboot.covmanagement.repository.CovCenPatientRepository;

@RestController
@RequestMapping("covcenpat")
public class CovCenPatientController {

	private final CovCenPatientRepository covcenpatrepo;

	public CovCenPatientController(CovCenPatientRepository covcenpatrepo) {
		super();
		this.covcenpatrepo = covcenpatrepo;
	}
		
	@PostMapping("/")
	public CovCenPatient saveCovCenPatient(@RequestBody CovCenPatient covcenpat)
	{
		return covcenpatrepo.save(covcenpat);
	}

	@GetMapping("/")
	public List<CovCenPatient> getAllCovCenPatients(){
		return covcenpatrepo.findAll();
	}
	
	@GetMapping("/{id}")
	public CovCenPatient getCovCenPatientById(@PathVariable Integer id){
		return covcenpatrepo.findById(id).get();
	}
	
}
