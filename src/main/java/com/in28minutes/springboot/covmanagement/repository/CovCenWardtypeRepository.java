package com.in28minutes.springboot.covmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.covmanagement.entity.CovCenWardType;

@Repository("covcenwardtyperepo")
public interface CovCenWardtypeRepository extends JpaRepository<CovCenWardType, Integer> {

}
