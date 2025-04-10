package com.in28minutes.springboot.covmanagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.dto.CovCenDoctorDto;
import com.in28minutes.springboot.covmanagement.entity.CovCenDoctor;
import com.in28minutes.springboot.covmanagement.repository.CovCenDoctorRepository;

@RestController
@RequestMapping("covcendoc")
public class CovCenDoctorController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final CovCenDoctorRepository covcendocrepo;

	public CovCenDoctorController(CovCenDoctorRepository covcendocrepo) {
		super();
		this.covcendocrepo = covcendocrepo;
	}
	
	@PostMapping("/")
	public CovCenDoctor saveCovCenDoctor(@RequestBody CovCenDoctor covcendoc )
	{
		logger.info("doctor Obj is {} ",covcendoc);
		return covcendocrepo.save(covcendoc);
	}
	
	@GetMapping("/")
	public List<CovCenDoctorDto> getAllCovCenDoctors(){
		List<CovCenDoctor> docList = covcendocrepo.findAll();
		
		List<CovCenDoctorDto> docListDto = docList.stream().map(doc->{
			CovCenDoctorDto covcendocdto = new CovCenDoctorDto();
			covcendocdto.setCovcendoc_id(doc.getCovcendoc_id());
			covcendocdto.setCovcendoc_name(doc.getCovcendoc_name());
			
			covcendocdto.setCovcen_doc_dept(doc.getCovcen_doc_dept());
			return covcendocdto;
		}).collect(Collectors.toList());
		
		return docListDto;
	}
	
	@GetMapping("/{id}")
	public CovCenDoctor getCovCenDoctorById(@PathVariable Integer id){
		return covcendocrepo.findById(id).get();
	}
	
}
