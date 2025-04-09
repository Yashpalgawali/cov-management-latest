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
@Table(name="tbl_covcen_bed")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovCenBed {

	@Id
	@SequenceGenerator(name = "covcenbed_seq",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "covcenbed_seq",strategy = GenerationType.SEQUENCE )
	private Integer covcenbed_id;
	
	private String covcenbed_num;
	
	@ManyToOne
	@JoinColumn(name = "covcenward_id")
	private CovCenWard covcenbed_ward;
}
