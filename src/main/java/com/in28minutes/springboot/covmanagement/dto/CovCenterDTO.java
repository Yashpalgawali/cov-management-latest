package com.in28minutes.springboot.covmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovCenterDTO {

	private Integer covcenter_id;
	
	private String covcenter_name;
	
	private List<CovCenDepartment> covcendeptlist = new ArrayList<>();
		
	public void addCovCenDepartment(CovCenDepartment covcendept) {
	
		covcendeptlist.add(covcendept);
	}
}
