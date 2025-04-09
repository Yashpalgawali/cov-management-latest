package com.in28minutes.springboot.covmanagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_covcen_ward_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovCenWardType {

	@Id
	@SequenceGenerator(name = "covcenwardtype_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "covcenwardtype_seq" , strategy = GenerationType.SEQUENCE)
	private Integer covcenwardtype_id;
	
	private String  covcenward_type;
	
	@OneToMany(mappedBy = "covcenward_wardtype") @JsonIgnore
	private List<CovCenWard> covcenwardtype_wards;
	
}