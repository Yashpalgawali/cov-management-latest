package com.in28minutes.springboot.covmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_covcen_patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovCenPatient {

	@Id
	@SequenceGenerator(name = "covcenpatient_seq" , allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "covcenpatient_seq" ,strategy =  GenerationType.SEQUENCE)
	private Integer covcenpatient_id;
	
	private String covcenpatient_name;
	
	@OneToOne
	@JoinColumn(name= "covcen_bed_id")
	private CovCenBed covcen_patient_bed;
	
	@OneToOne
	@JoinColumn(name ="covcendoc_id")
	private CovCenDoctor covcen_pat_doc;
}
