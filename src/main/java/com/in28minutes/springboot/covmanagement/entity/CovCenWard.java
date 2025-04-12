package com.in28minutes.springboot.covmanagement.entity;

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

@Entity
@Table(name="tbl_covcen_ward")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovCenWard {

	@Id
	@SequenceGenerator(name = "covcenward_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "covcenward_seq")
	private Integer covcenward_id;
	
	private String covcenward_num;
	
	@ManyToOne
	@JoinColumn(name="covcenward_type_id") 
	private CovCenWardType covcenward_wardtype;
}
