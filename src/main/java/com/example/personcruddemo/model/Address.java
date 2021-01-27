package com.example.personcruddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * @author Manoj Kumar This model is used to serve and persist person address, a
 *         person can have more then one address hence used many to one
 *         relationship.
 */

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotEmpty(message = "Address lineone is required")
	@Column(nullable = false, name = "address_lineone")
	private String addresslineone;
	@Column(name = "address_linetwo")
	private String addresslinetwo;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "postal_code", nullable = false)
	private String postalcode;
	@Column(name = "country", nullable = false)
	private String country;

	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	@JsonBackReference
	private Person person;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddresslineone() {
		return addresslineone;
	}

	public void setAddresslineone(String addresslineone) {
		this.addresslineone = addresslineone;
	}

	public String getAddresslinetwo() {
		return addresslinetwo;
	}

	public void setAddresslinetwo(String addresslinetwo) {
		this.addresslinetwo = addresslinetwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public Person getPerson() {
		return person;
	}

	
	public void setPerson(Person person) {
		this.person = person;
	}

	
}
