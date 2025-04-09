package com.in28minutes.springboot.covmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.springboot.covmanagement.entity.CovCenWard;

import lombok.Data;

@Data
public class CovCenWardTypeDTO {

	private Integer covcenwardtype_id;
	
	private String  covcenward_type;
	
	private List<CovCenWard> covcenwards=new ArrayList<>();
	
	public void addCovCenWard(CovCenWard covcenward) {
		covcenwards.add(covcenward);
	}
}
