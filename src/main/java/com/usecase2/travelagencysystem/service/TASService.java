package com.usecase2.travelagencysystem.service;

import java.util.List;

import com.usecase2.travelagencysystem.model.TravelAgency;

public interface TASService {

	TravelAgency createTravelAgency(TravelAgency travelAgency);

	TravelAgency getTravelAgencyById(long id);

	List<TravelAgency> getAllTravelAgencies();

	TravelAgency updateTravelAgencyById(long id, TravelAgency travelAgency);

	String deleteTravelAgencyById(long id);

	String deleteAllTravelAgencies();

}
