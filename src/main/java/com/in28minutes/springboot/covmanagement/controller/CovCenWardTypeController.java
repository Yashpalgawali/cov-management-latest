package com.in28minutes.springboot.covmanagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.dto.CovCenWardTypeDTO;
import com.in28minutes.springboot.covmanagement.entity.CovCenWard;
import com.in28minutes.springboot.covmanagement.entity.CovCenWardType;
import com.in28minutes.springboot.covmanagement.exceptions.ResourceNotFoundException;
import com.in28minutes.springboot.covmanagement.repository.CovCenWardRepository;
import com.in28minutes.springboot.covmanagement.repository.CovCenWardtypeRepository;

@RestController
@RequestMapping("covcenwardtype")
@CrossOrigin("*")
public class CovCenWardTypeController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final CovCenWardtypeRepository covcenwardtyperepo;

	private final CovCenWardRepository covcenwardrepo;
	
	public CovCenWardTypeController(CovCenWardtypeRepository covcenwardtyperepo,CovCenWardRepository covcenwardrepo) {
		super();
		this.covcenwardtyperepo = covcenwardtyperepo;
		this.covcenwardrepo = covcenwardrepo;
	}
	
	
	@PostMapping("/")
	public CovCenWardType saveCovCenWardType(@RequestBody CovCenWardType wardtype) {
		
		return covcenwardtyperepo.save(wardtype);
	}
	
	@GetMapping("/")
	public List<CovCenWardTypeDTO> getAllCovCenWardTypes() {
		
		List<CovCenWardTypeDTO> collectDto = covcenwardtyperepo.findAll().stream().map(type->{
			CovCenWardTypeDTO typedto = new CovCenWardTypeDTO();
			
			typedto.setCovcenwardtype_id(type.getCovcenwardtype_id());
			typedto.setCovcenward_type(type.getCovcenward_type());
			
			List<CovCenWard> wardList = covcenwardrepo.getCovcenWardByTypeId(type.getCovcenwardtype_id());
			wardList.stream().forEach(ward ->{
				typedto.addCovCenWard(ward);
			});
			
			return typedto;
		}).collect(Collectors.toList());
		 
		return collectDto;
	}
	
	@GetMapping("/{id}")
	public CovCenWardType getCovCenWardTypeById(@PathVariable Integer id) throws ResourceNotFoundException {
		
		return covcenwardtyperepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No cov center ward Type found"));
	}
	
	@PutMapping("/")
	public CovCenWardType updateCovCenWardType(@RequestBody CovCenWardType wardtype) {
		
		return covcenwardtyperepo.save(wardtype);
	}
}
