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
import lombok.ToString;

@Entity
@Table(name="tbl_covcenter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CovCenter {

	@Id
	@SequenceGenerator(name = "covcen_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "covcen_seq" , strategy = GenerationType.SEQUENCE)
	private Integer covcenter_id;
	
	private String covcenter_name;
	
	@OneToMany(mappedBy = "covcenter")
	@JsonIgnore
	private List<CovCenDepartment> covcendept;
}
