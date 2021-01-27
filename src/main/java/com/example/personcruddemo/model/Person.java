package com.example.personcruddemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Manoj Kumar
 *
 *         This is an model entity of an person which is used to serve and
 *         persist into the data base. A person can have more than one address.
 *         hence used one to many relationship.
 */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
//@JsonInclude(value = Include.NON_EMPTY)
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int personId;
	@NotEmpty(message = "First name is required")
	@Column(name = "person_firstname",nullable = false)
	private String firstname;
	@NotEmpty(message = "Last name is required")
	@Column(name = "person_lastname",nullable = false)
	private String lastname;
	@NotEmpty(message = "DOB is required")
	@Column(name = "person_dob",nullable = false)
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date dob;
	//@OneToMany(mappedBy = "person",cascade = CascadeType.ALL,targetEntity = Address.class)
	@NotEmpty(message = "Address is required")
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY,mappedBy="person",cascade = CascadeType.ALL)
	private List<Address> address=new ArrayList<Address>();
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
}