package com.example.personcruddemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.personcruddemo.model.Address;
import com.example.personcruddemo.model.Person;
import com.example.personcruddemo.service.PersonService;
import com.example.personcruddemo.utilities.ServiceResponseEntity;

/**
 * @author Manoj Kumar This class is an person controller which serve all the
 *         requests for person.
 *
 */
@RestController
public class PersonController {

	Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;
	@Autowired
	Environment environment;

	@PostMapping(value = "/rest/createPerson")
	private ServiceResponseEntity createPerson(@RequestBody Person person) {
		logger.info("Flow started inside createPerson method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Person> personData = personService.savePerson(person);
			if (personData.isPresent()) {
				List<Object> persList = new ArrayList<Object>();
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.created.code")));
				response.setMessage(environment.getProperty("app.rest.service.person.created"));
				persList.add(personData);
				response.setData(persList);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during create person inside method createPerson..." + "Error Message:"
					+ e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.person.create.failed"));
		}
		return response;
	}

	@PostMapping(value = "/rest/createAddress")
	private ServiceResponseEntity createAddress(@RequestBody Address address) {
		logger.info("Flow started inside createAddresss method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Address> addressData = personService.savePersonAddress(address);
			if (addressData.isPresent()) {
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.created.code")));
				response.setMessage(environment.getProperty("app.rest.service.address.created"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during create person address inside method createAddresss..." + "Error Message:"
					+ e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}

	@GetMapping(value = "/rest/getPerson")
	private ServiceResponseEntity getPersonByFirstNameAndLastName(@RequestParam String firstname, @RequestParam String lastname) {
		logger.info("Flow started inside getPerson method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Person> personData = personService.findPersonByFirstAndLastName(firstname, lastname);
			if (personData.isPresent()) {
				List<Object> persList = new ArrayList<Object>();
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				persList.add(personData);
				response.setData(persList);
			} else {
				response.setCode(
						Integer.valueOf(environment.getProperty("app.rest.service.failed.person.notexists.code")));
				response.setMessage(environment.getProperty("app.rest.service.failed.person.notexists"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(
					"Error occured during get persons inside method getPerson..." + "Error Message:" + e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}

	@DeleteMapping(value = "/rest/deletePerson/{id}")
	private ServiceResponseEntity deletePersonById(@PathVariable Integer id) {
		logger.info("Flow started inside deletePerson method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Person> person = personService.findPersonById(id);
			if (person.isPresent()) {
				boolean isDeleted = personService.deletePerson(id);
				if (isDeleted) {
					response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
					response.setMessage(environment.getProperty("app.rest.service.person.deleted"));
				} else {
					response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
					response.setMessage(environment.getProperty("app.rest.service.failed"));
				}
			} else {
				response.setCode(
						Integer.valueOf(environment.getProperty("app.rest.service.failed.person.notexists.code")));
				response.setMessage(environment.getProperty("app.rest.service.failed.person.notexists"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during delete person inside method deletePerson..." + "Error Message:"
					+ e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}

	@GetMapping(value = "/rest/getPersons")
	private ServiceResponseEntity getPersonsByLastName(@RequestParam String lastname) {
		logger.info("Flow started inside getPersons method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<List<Person>> personData = personService.findListOfPersonsByLastName(lastname);
			if (personData.isPresent()) {
				List<Object> persList = new ArrayList<Object>();
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				persList.add(personData);
				response.setData(persList);
			} else {
				response.setCode(
						Integer.valueOf(environment.getProperty("app.rest.service.failed.person.notexists.code")));
				response.setMessage(environment.getProperty("app.rest.service.failed.person.notexists"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(
					"Error occured during get persons inside method getPersons..." + "Error Message:" + e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}
	
	@GetMapping(value = "/rest/getPerson/{id}")
	private ServiceResponseEntity getPersonById(@PathVariable Integer id) {
		logger.info("Flow started inside deletePerson method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Person> person = personService.findPersonById(id);
			if (person.isPresent()) {
				//boolean isDeleted = personService.deletePerson(id);
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				List<Object> persList = new ArrayList<Object>();
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				persList.add(person);
				response.setData(persList);
			} else {
				response.setCode(
						Integer.valueOf(environment.getProperty("app.rest.service.failed.person.notexists.code")));
				response.setMessage(environment.getProperty("app.rest.service.failed.person.notexists"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during delete person inside method deletePerson..." + "Error Message:"
					+ e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}
	
	@GetMapping(value = "/rest/getAddress/{id}")
	private ServiceResponseEntity getAddressById(@PathVariable Integer id) {
		logger.info("Flow started inside deletePerson method inside controller PersonController!");
		ServiceResponseEntity response = new ServiceResponseEntity();
		try {
			Optional<Address> address = personService.findAddressById(id);
			if (address.isPresent()) {
				//boolean isDeleted = personService.deletePerson(id);
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				List<Object> persList = new ArrayList<Object>();
				response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.success.code")));
				response.setMessage(environment.getProperty("app.rest.service.success"));
				persList.add(address);
				response.setData(persList);
			} else {
				response.setCode(
						Integer.valueOf(environment.getProperty("app.rest.service.failed.address.notexists.code")));
				response.setMessage(environment.getProperty("app.rest.service.failed.address.notexists"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during delete person inside method deletePerson..." + "Error Message:"
					+ e.getMessage());
			response.setCode(Integer.valueOf(environment.getProperty("app.rest.service.failed.code")));
			response.setMessage(environment.getProperty("app.rest.service.failed"));
		}
		return response;
	}


}
