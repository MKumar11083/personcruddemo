package com.example.personcruddemo.serviceimpl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.personcruddemo.daorepository.AddressRepository;
import com.example.personcruddemo.daorepository.PersonRepository;
import com.example.personcruddemo.model.Address;
import com.example.personcruddemo.model.Person;
import com.example.personcruddemo.service.PersonService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PersonServiceImplTests {

	@Autowired
	private PersonService personService;
	@Mock
	private PersonRepository personRepository;
	@Mock
	private AddressRepository addressRepository;

	@Test
	public void savePerson() {
		Person person = new Person();
		person.setFirstname("test");
		person.setLastname("test");
		@SuppressWarnings("deprecation")
		Date d = new Date(1999, 2, 28);
		person.setDob(d);
		List<Address> addressList = new ArrayList<Address>();
		Address address = new Address();
		address.setAddresslineone("test");
		address.setCity("Ghaziabad");
		address.setPostalcode("201017");
		address.setCountry("India");

		addressList.add(address);
		person.setAddress(addressList);

		Mockito.when(personService.savePerson(person)).thenReturn(Optional.of(person));
		Optional<Person> pers = personService.savePerson(person);
		Assert.assertEquals("test", pers.get().getFirstname());
	}

	@Test
	public void deletePerson() {
		Person person = new Person();
		person.setPersonid(1);
		Mockito.when(personService.deletePerson(1)).thenReturn(true);
		boolean isDeleted = personService.deletePerson(1);
		Assert.assertEquals(true, isDeleted);
	}

	@Test
	public void savePersonAddress() {
		Address address = new Address();
		address.setAddresslineone("test");
		address.setCity("Ghaziabad");
		address.setPostalcode("201017");
		address.setCountry("India");
		Mockito.when(personService.savePersonAddress(address)).thenReturn(Optional.of(address));
		Optional<Address> addres = personService.savePersonAddress(address);
		Assert.assertEquals("test", addres.get().getAddresslineone());
	}

	@Test
	public void findPersonByFirstAndLastName() {
		Person person = new Person();
		person.setFirstname("test");
		person.setLastname("test");
		Mockito.when(personService.findPersonByFirstAndLastName("test", "test")).thenReturn(Optional.of(person));
		Optional<Person> pers = personService.findPersonByFirstAndLastName("test", "test");
		Assert.assertEquals("test", pers.get().getFirstname());
	}

	@Test
	public void findListOfPersonsByLastName() {
		Person person = new Person();
		person.setFirstname("test");
		person.setLastname("test");
		@SuppressWarnings("deprecation")
		Date d = new Date(1999, 2, 28);
		person.setDob(d);
		List<Address> addressList = new ArrayList<Address>();
		Address address = new Address();
		address.setAddresslineone("test");
		address.setCity("Ghaziabad");
		address.setPostalcode("201017");
		address.setCountry("India");

		addressList.add(address);
		person.setAddress(addressList);

		List<Person> plist = new ArrayList<Person>();
		plist.add(person);

		Mockito.when(personService.findListOfPersonsByLastName("test")).thenReturn(Optional.of(plist));
		Optional<Person> pers = personService.findPersonByFirstAndLastName("test", "test");
		Assert.assertEquals("test", pers.get().getFirstname());
	}
}
