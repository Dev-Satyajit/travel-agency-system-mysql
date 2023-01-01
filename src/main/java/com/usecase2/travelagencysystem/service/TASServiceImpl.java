package com.usecase2.travelagencysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase2.travelagencysystem.exception.ResourceNotFoundException;
import com.usecase2.travelagencysystem.model.TravelAgency;
import com.usecase2.travelagencysystem.repository.TASRepository;

@Service
public class TASServiceImpl implements TASService {

	@Autowired
	private TASRepository tasRepository;

	@Override
	public TravelAgency createTravelAgency(TravelAgency travelAgency) {
		return tasRepository.save(travelAgency);
	}

	@Override
	public TravelAgency getTravelAgencyById(long id) {
		return tasRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Data not found for the id: " + id));
	}

	@Override
	public List<TravelAgency> getAllTravelAgencies() {
		return tasRepository.findAll();
	}

	@Override
	public TravelAgency updateTravelAgencyById(long id, TravelAgency newTravelAgency) {
		TravelAgency oldTravelAgency = tasRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Data not found for the id: " + id));
		oldTravelAgency.setFirstName(newTravelAgency.getFirstName());
		oldTravelAgency.setLastName(newTravelAgency.getLastName());
		oldTravelAgency.setStartLocation(newTravelAgency.getStartLocation());
		oldTravelAgency.setDestinationLocation(newTravelAgency.getDestinationLocation());
		oldTravelAgency.setLocations(newTravelAgency.getLocations());
		oldTravelAgency.setPackageName(newTravelAgency.getPackageName());
		oldTravelAgency.setCost(newTravelAgency.getCost());
		oldTravelAgency.setPermanentAddress(newTravelAgency.getPermanentAddress());
		oldTravelAgency.setCommunicationAddress(newTravelAgency.getCommunicationAddress());
		oldTravelAgency.setPhone(newTravelAgency.getPhone());
		oldTravelAgency.setNotes(newTravelAgency.getNotes());

		return tasRepository.save(oldTravelAgency);
	}

	@Override
	public String deleteTravelAgencyById(long id) {
		TravelAgency travelAgency = tasRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Data not found for the id: " + id));
		tasRepository.delete(travelAgency);
		return "The data has been deleted successfully for the id: " + id;
	}

	@Override
	public String deleteAllTravelAgencies() {
		if (tasRepository.findAll().size() > 0) {
			tasRepository.deleteAll();
			return "All data deleted successfully";
		}
		throw new ResourceNotFoundException("No data found");
	}

}
