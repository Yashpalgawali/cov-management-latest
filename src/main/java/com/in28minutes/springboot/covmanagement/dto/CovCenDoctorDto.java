package com.in28minutes.springboot.covmanagement.dto;

import java.util.List;

import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovCenDoctorDto {

	private Integer covcendoc_id;
	
	private String covcendoc_name;
	
	private CovCenDepartment covcen_doc_dept;
	
}
