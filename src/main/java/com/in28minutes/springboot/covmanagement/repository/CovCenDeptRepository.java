package com.in28minutes.springboot.covmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.covmanagement.entity.CovCenDepartment;

@Repository("covcendeptrepo")
public interface CovCenDeptRepository extends JpaRepository<CovCenDepartment, Integer> {

	//@Query("SELECT c FROM CovCenDepartment c WHERE c.covcenter.covcenter_id=?1")
	
	@Query(value ="SELECT cd.* FROM tbl_covcen_dept cd JOIN tbl_covcenter ON tbl_covcenter.covcenter_id=cd.covcenter_id where cd.covcenter_id=?1",nativeQuery = true)
	List<CovCenDepartment> findByCovcenterId(Integer covcenid);
}
