package com.usecase2.travelagencysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase2.travelagencysystem.model.TravelAgency;

public interface TASRepository extends JpaRepository<TravelAgency, Long> {

}
