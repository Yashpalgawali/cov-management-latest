package com.in28minutes.springboot.covmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.springboot.covmanagement.entity.CovCenDoctor;
import com.in28minutes.springboot.covmanagement.entity.CovCenter;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CovCenDepartmenDTO {
	
	private Integer covcendept_id;

	private String covcendept_name;

 
	private Integer covcen_id;
	
	private String covcen_name;
	
	private List<CovCenDoctor> covcendoc_list= new ArrayList<>();
		
	public void addCovCenDoctor(CovCenDoctor covcendoc)
	{
		covcendoc_list.add(covcendoc);
	}
	
}
