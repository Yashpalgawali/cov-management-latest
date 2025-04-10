package com.in28minutes.springboot.covmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.covmanagement.entity.CovCenDoctor;

@Repository("covcendocrepo")
public interface CovCenDoctorRepository extends JpaRepository<CovCenDoctor, Integer> {

	
	@Query("SELECT c FROM CovCenDoctor c WHERE c.covcen_doc_dept.covcendept_id=?1")
	List<CovCenDoctor> getCovCenDocByDepartmentId(Integer deptId);
}
