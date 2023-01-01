package com.usecase2.travelagencysystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase2.travelagencysystem.model.TravelAgency;
import com.usecase2.travelagencysystem.service.TASService;

@RestController
@RequestMapping("/TravelAgency")
public class TASController {

	@Autowired
	private TASService tasService;

	@PostMapping("/save")
	public ResponseEntity<TravelAgency> createTravelAgency(@Valid @RequestBody TravelAgency travelAgency) {
		return new ResponseEntity<>(tasService.createTravelAgency(travelAgency), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TravelAgency> getTravelAgencyById(@PathVariable int id) {
		return new ResponseEntity<>(tasService.getTravelAgencyById(id), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<TravelAgency>> getAllTravelAgencies() {
		return new ResponseEntity<>(tasService.getAllTravelAgencies(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TravelAgency> updateTravelAgencyById(@PathVariable int id,
			@Valid @RequestBody TravelAgency travelAgency) {
		return new ResponseEntity<>(tasService.updateTravelAgencyById(id, travelAgency), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTravelAgencyById(@PathVariable int id) {
		return new ResponseEntity<>(tasService.deleteTravelAgencyById(id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllTravelAgencies() {
		return new ResponseEntity<>(tasService.deleteAllTravelAgencies(), HttpStatus.ACCEPTED);
	}

}
