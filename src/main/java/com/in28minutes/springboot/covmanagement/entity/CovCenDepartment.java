package com.in28minutes.springboot.covmanagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_covcen_dept")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CovCenDepartment {

	@Id
	@SequenceGenerator(name = "covcendept_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "covcendept_seq", strategy = GenerationType.SEQUENCE)
	private Integer covcendept_id;

	private String covcendept_name;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "covcenter_id")
	private CovCenter covcenter;
	
	
	@OneToMany(mappedBy = "covcen_doc_dept") 
	private List<CovCenDoctor> covcen_dept_doc;

	
	public void addCovCenDoctor(CovCenDoctor covcendoc) {
		covcen_dept_doc.add(covcendoc);
	}
}
