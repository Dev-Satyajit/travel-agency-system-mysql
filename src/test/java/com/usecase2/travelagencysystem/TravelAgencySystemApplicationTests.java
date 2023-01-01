package com.usecase2.travelagencysystem;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.usecase2.travelagencysystem.exception.ResourceNotFoundException;
import com.usecase2.travelagencysystem.model.TravelAgency;
import com.usecase2.travelagencysystem.service.TASService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TravelAgencySystemApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private TASService tasService;

	@Test
	@Order(1)
	public void createTravelAgencyTest() {
		for (int i = 0; i < 2; i++) {
			TravelAgency travelAgency = new TravelAgency();
			travelAgency.setFirstName("Satyajit");
			travelAgency.setLastName("Sinha");
			travelAgency.setStartLocation("Howrah");
			travelAgency.setDestinationLocation("Kolkata");
			travelAgency.setLocations("Science City, Victoria, Eco Park, Nicco Park");
			travelAgency.setPackageName("Silver");
			travelAgency.setCost(3000.0);
			travelAgency.setPermanentAddress("Howrah, West Bengal, 711404");
			travelAgency.setCommunicationAddress("Howrah, West Bengal, 711404");
			travelAgency.setPhone("9800965420");
			travelAgency.setNotes("NA");

			tasService.createTravelAgency(travelAgency);
		}

		List<TravelAgency> travelAgency = tasService.getAllTravelAgencies();

		Assertions.assertThat(travelAgency.size()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getTravelAgencyByIdTest() {
		TravelAgency travelAgency = tasService.getTravelAgencyById(1L);
		Assertions.assertThat(travelAgency.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	public void getAllTravelAgenciesTest() {
		List<TravelAgency> travelAgency = tasService.getAllTravelAgencies();
		Assertions.assertThat(travelAgency).isNotEmpty();
	}

	@Test
	@Order(4)
	public void updateTravelAgencyByIdTest() {
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.setFirstName("Subhadip");
		travelAgency.setLastName("Saha");
		travelAgency.setStartLocation("Howrah");
		travelAgency.setDestinationLocation("Kolkata");
		travelAgency.setLocations("Science City, Victoria, Eco Park, Nicco Park");
		travelAgency.setPackageName("Platinum");
		travelAgency.setCost(5000);
		travelAgency.setPermanentAddress("Howrah, West Bengal, 711404");
		travelAgency.setCommunicationAddress("Howrah, West Bengal, 711404");
		travelAgency.setPhone("9800965420");
		travelAgency.setNotes("NA");

		TravelAgency travelAgencyUpdated = tasService.updateTravelAgencyById(1L, travelAgency);

		Assertions.assertThat(travelAgencyUpdated.getFirstName()).isEqualTo("Subhadip");
		Assertions.assertThat(travelAgencyUpdated.getLastName()).isEqualTo("Saha");
		Assertions.assertThat(travelAgencyUpdated.getStartLocation()).isEqualTo("Howrah");
		Assertions.assertThat(travelAgencyUpdated.getDestinationLocation()).isEqualTo("Kolkata");
		Assertions.assertThat(travelAgencyUpdated.getLocations())
				.isEqualTo("Science City, Victoria, Eco Park, Nicco Park");
		Assertions.assertThat(travelAgencyUpdated.getPackageName()).isEqualTo("Platinum");
		Assertions.assertThat(travelAgencyUpdated.getCost()).isEqualTo(5000);
		Assertions.assertThat(travelAgencyUpdated.getPermanentAddress()).isEqualTo("Howrah, West Bengal, 711404");
		Assertions.assertThat(travelAgencyUpdated.getCommunicationAddress()).isEqualTo("Howrah, West Bengal, 711404");
		Assertions.assertThat(travelAgencyUpdated.getPhone()).isEqualTo("9800965420");
		Assertions.assertThat(travelAgencyUpdated.getNotes()).isEqualTo("NA");
	}

	@Test
	@Order(5)
	public void deleteTravelAgencyByIdTest() {
		tasService.deleteTravelAgencyById(1L);
		List<TravelAgency> travelAgency = tasService.getAllTravelAgencies();
		Assertions.assertThat(travelAgency.size()).isEqualTo(1);
	}

	@Test
	@Order(6)
	public void deleteAllTravelAgencies() throws ResourceNotFoundException {
		tasService.deleteAllTravelAgencies();
		List<TravelAgency> travelAgency = tasService.getAllTravelAgencies();
		Assertions.assertThat(travelAgency).isEmpty();
	}

}
