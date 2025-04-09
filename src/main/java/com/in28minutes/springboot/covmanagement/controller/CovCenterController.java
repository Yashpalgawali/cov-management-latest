package com.in28minutes.springboot.covmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.covmanagement.dto.CovCenterDTO;
import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;
import com.in28minutes.springboot.covmanagement.entity.CovCenter;
import com.in28minutes.springboot.covmanagement.repository.CovCenDeptRepository;
import com.in28minutes.springboot.covmanagement.repository.CovCenterRepository;

@RestController
@RequestMapping("covcen")
public class CovCenterController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final CovCenterRepository covcenrepo;
	private final CovCenDeptRepository covcendeptrepo;
	
	public CovCenterController(CovCenterRepository covcenrepo,CovCenDeptRepository covcendeptrepo) {
		super();
		this.covcenrepo = covcenrepo;
		this.covcendeptrepo = covcendeptrepo;
	}
	
	@PostMapping("/")
	public CovCenter saveCovCenter(@RequestBody CovCenter covcenter) {
		return covcenrepo.save(covcenter);
	}
	
	@GetMapping("/")
	public List<CovCenterDTO> getAllCovCenters() {

		List<CovCenterDTO> collectList = covcenrepo.findAll().stream().map(cen -> {
			
			CovCenterDTO covcendto = new CovCenterDTO();
			
			covcendto.setCovcenter_id(cen.getCovcenter_id());
			covcendto.setCovcenter_name(cen.getCovcenter_name());
			
			 List<CovCenDepartment> covcendept = covcendeptrepo.findByCovcenterId(cen.getCovcenter_id());
			 covcendept.stream().forEach(dept-> {
				 covcendto.addCovCenDepartment(dept);
			 });
			
			return  covcendto;
		}).collect(Collectors.toList());
		
		
		collectList.stream().forEach(System.err::println);
		return collectList;
	}
	
	@GetMapping("/{id}")
	public CovCenterDTO getCovCenterById(@PathVariable Integer id) {
	
		CovCenterDTO covcendto = new CovCenterDTO();
		CovCenter covcen = covcenrepo.findById(id).get();
		covcendto.setCovcenter_id(covcen.getCovcenter_id());
		covcendto.setCovcenter_name(covcen.getCovcenter_name());
		
		List<CovCenDepartment> list = covcendeptrepo.findByCovcenterId(covcen.getCovcenter_id());
		
		list.stream().forEach(dept -> {
			covcendto.addCovCenDepartment(dept);
		});
		return covcendto;
	}
	
}
