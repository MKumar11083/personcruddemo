package com.example.personcruddemo.controller.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.personcruddemo.AbstractTest;
import com.example.personcruddemo.model.Address;
import com.example.personcruddemo.model.Person;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createPerson() throws Exception {
		String uri = "/rest/createPerson";

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
		String inputJson = super.mapToJson(person);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void createAddress() throws Exception {
		String uri = "/rest/createAddress";

		Person person = new Person();
		person.setPersonid(1);
		Address address = new Address();
		address.setAddresslineone("test");
		address.setCity("Ghaziabad");
		address.setPostalcode("201017");
		address.setCountry("India");
		address.setPersonId(1);
		String inputJson = super.mapToJson(address);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}
	
	@Test
	public void getPersonByFirstNameAndLastName() throws Exception {
		String uri = "/rest/getPerson?firstname=manoj&lastname=Kumar";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void getPersonsByLastName() throws Exception {
		String uri = "/rest/getPersons?lastname=Kumar";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void getPersonById() throws Exception {
		String uri = "/rest/getPerson/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void getAddressById() throws Exception {
		String uri = "/rest/getAddress/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void deletePersonById() throws Exception {
		String uri = "/rest/deletePerson/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

}
