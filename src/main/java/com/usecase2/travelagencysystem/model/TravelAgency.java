package com.usecase2.travelagencysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class TravelAgency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "First name is required")
	private String firstName;
	@NotEmpty(message = "Last name is required")
	private String lastName;
	@NotEmpty(message = "Start location is required")
	private String startLocation;
	@NotEmpty(message = "Destination location is required")
	private String destinationLocation;
	@NotEmpty(message = "Locations are required")
	private String locations;
	@NotEmpty(message = "Package name is required")
	private String packageName;
	@Min(1)
	private double cost;
	@NotEmpty(message = "Permanent address is required")
	@Size(max = 250, message = "Permanent address should not contain more than 250 characters")
	private String permanentAddress;
	@NotEmpty(message = "Communication address is required")
	@Size(max = 250, message = "Communication address should not contain more than 250 characters")
	private String communicationAddress;
	@NotEmpty(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}|$", message = "Please enter a valid phone number")
	private String phone;
	@NotEmpty(message = "First name is required")
	@Size(max = 250, message = "Notes should not contain more than 250 characters")
	private String notes;

	public TravelAgency() {

	}

	public TravelAgency(long id, @NotEmpty(message = "First name is required") String firstName,
			@NotEmpty(message = "Last name is required") String lastName,
			@NotEmpty(message = "Start location is required") String startLocation,
			@NotEmpty(message = "Destination location is required") String destinationLocation,
			@NotEmpty(message = "Locations are required") String locations,
			@NotEmpty(message = "Package name is required") String packageName, @Min(1) double cost,
			@NotEmpty(message = "Permanent address is required") @Size(max = 250, message = "Permanent address should not contain more than 250 characters") String permanentAddress,
			@NotEmpty(message = "Communication address is required") @Size(max = 250, message = "Communication address should not contain more than 250 characters") String communicationAddress,
			@NotEmpty(message = "Phone number is required") @Pattern(regexp = "^[0-9]{10}|$", message = "Please enter a valid phone number") String phone,
			@NotEmpty(message = "First name is required") @Size(max = 250, message = "Notes should not contain more than 250 characters") String notes) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startLocation = startLocation;
		this.destinationLocation = destinationLocation;
		this.locations = locations;
		this.packageName = packageName;
		this.cost = cost;
		this.permanentAddress = permanentAddress;
		this.communicationAddress = communicationAddress;
		this.phone = phone;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "TravelAgency [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", startLocation="
				+ startLocation + ", destinationLocation=" + destinationLocation + ", locations=" + locations
				+ ", packageName=" + packageName + ", cost=" + cost + ", permanentAddress=" + permanentAddress
				+ ", communicationAddress=" + communicationAddress + ", phone=" + phone + ", notes=" + notes + "]";
	}

}
