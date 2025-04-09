package com.in28minutes.springboot.covmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.covmanagement.entity.CovCenWard;
import java.util.List;


@Repository("covcenwardrepo")
public interface CovCenWardRepository extends JpaRepository<CovCenWard, Integer> {

	@Query("SELECT w FROM CovCenWard w WHERE w.covcenward_wardtype.covcenwardtype_id=?1")
	List<CovCenWard>getCovcenWardByTypeId(Integer typeid);
}
