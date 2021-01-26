package com.example.personcruddemo.service;

import java.util.List;
import java.util.Optional;

import com.example.personcruddemo.model.Address;
import com.example.personcruddemo.model.Person;

public interface PersonService {

	public Optional<Person> savePerson(Person person);

	public boolean deletePerson(Integer id);

	public Optional<Person> findPersonByFirstAndLastName(String firstname, String Lastname);

	public Optional<List<Person>> findListOfPersonsByLastName(String lastname);

	public Optional<Address> savePersonAddress(Address address);
	
	public Optional<Person> findPersonById(Integer personId);
	
	public Optional<Address> findAddressById(Integer addressId);

}
