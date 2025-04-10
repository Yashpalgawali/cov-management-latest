package com.in28minutes.springboot.covmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_covcen_doc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class CovCenDoctor {

	@Id
	@SequenceGenerator(name= "covcendoc_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "covcendoc_seq",strategy = GenerationType.SEQUENCE)
	private Integer covcendoc_id;
	
	private String covcendoc_name;
	
	@ManyToOne
	@JoinColumn(name="covcendept_id") @JsonBackReference
	private CovCenDepartment covcen_doc_dept;

}
