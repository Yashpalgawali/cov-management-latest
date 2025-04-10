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

import com.in28minutes.springboot.covmanagement.dto.CovCenDepartmenDTO;
import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;
import com.in28minutes.springboot.covmanagement.repository.CovCenDeptRepository;
import com.in28minutes.springboot.covmanagement.repository.CovCenDoctorRepository;

@RestController
@RequestMapping("covcendept")
public class CovCenDepartmentController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final CovCenDeptRepository covcendeptrepo;
	
	private final CovCenDoctorRepository covcendocrepo;

	public CovCenDepartmentController(CovCenDeptRepository covcendeptrepo,CovCenDoctorRepository covcendocrepo) {
		super();
		this.covcendeptrepo = covcendeptrepo;
		this.covcendocrepo = covcendocrepo;
	}
	
	@PostMapping("/")
	public CovCenDepartment saveCovCenDepartment(@RequestBody CovCenDepartment covCenDept) {
	
		logger.info("");
		
		return null;
		//return covcendeptrepo.save(covCenDept);
	}
	
	@GetMapping("/")
	public List<CovCenDepartmenDTO> getAllCovCenDepartments() {
		List<CovCenDepartment> deptList = covcendeptrepo.findAll();
		
		List<CovCenDepartmenDTO> deptDtoList = deptList.stream().map(dept->{
			CovCenDepartmenDTO covcendeptdtop = new CovCenDepartmenDTO();
			
			covcendeptdtop.setCovcendept_id(dept.getCovcendept_id());
			covcendeptdtop.setCovcendept_name(dept.getCovcendept_name()); 
			covcendeptdtop.setCovcen_id(dept.getCovcenter().getCovcenter_id());
			covcendeptdtop.setCovcen_name(dept.getCovcenter().getCovcenter_name());
			
			covcendocrepo.getCovCenDocByDepartmentId(dept.getCovcendept_id()).forEach(doc -> {
				covcendeptdtop.addCovCenDoctor(doc);
			});
			
			return covcendeptdtop;
		}).collect(Collectors.toList());
		
		return deptDtoList;
	}
	
	@GetMapping("/{id}")
	public CovCenDepartment getCovCenDepartmentById(@PathVariable int id) {
		return covcendeptrepo.findById(id).get();
	}
	
	@GetMapping("/{id}/departments")
	public List<CovCenDepartment> getCovCenDepartmentByCovcenterId(@PathVariable Integer id) {
		List<CovCenDepartment> list = covcendeptrepo.findByCovcenterId(id);
		logger.info("dept list by center {} ",list);
		return list;
	}
	
}
