package com.example.personcruddemo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.personcruddemo.daorepository.AddressRepository;
import com.example.personcruddemo.daorepository.PersonRepository;
import com.example.personcruddemo.model.Address;
import com.example.personcruddemo.model.Person;
import com.example.personcruddemo.service.PersonService;

/**
 * @author Manoj Kumar
 * 
 *         This class is an service provider to person controller
 *
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Override
	/**
	 * Method used to save person details
	 */
	public Optional<Person> savePerson(Person person) {
		// TODO Auto-generated method stub
		logger.info("Flow started inside method savePerson...");
		try {
			person = personRepository.save(person);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during save person details inside method savePerson..." + "Error Message:"
					+ e.getMessage());
		}
		return Optional.of(person);
	}

	@Override
	/**
	 * Method used to delete the person entity and it's descendants.
	 */
	public boolean deletePerson(Integer personId) {
		// TODO Auto-generated method stub
		logger.info("Flow started inside method deletePerson...");
		boolean isPersonDeleted;
		try {
			personRepository.deleteById(personId);
			isPersonDeleted = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during delete person inside method deletePerson..." + "Error Message:"
					+ e.getMessage());
			isPersonDeleted = false;
		}
		return isPersonDeleted;
	}

	@Override
	/**
	 * Method is used to save the person address as a person can have more then one
	 * address.
	 */
	public Optional<Address> savePersonAddress(Address address) {
		// TODO Auto-generated method stub
		logger.info("Flow started inside method addPersonAddress...");
		try {
			address = addressRepository.save(address);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during save person address inside method savePersonAddress..."
					+ "Error Message:" + e.getMessage());
		}
		return Optional.of(address);
	}

	@Override
	/**
	 * Method is used to load the person by firstname and lastname.
	 */
	public Optional<Person> findPersonByFirstAndLastName(String firstname, String Lastname) {
		// TODO Auto-generated method stub
		logger.info("Flow stated inside findPersonByFirstAndLastName method.");
		Optional<Person> person = null;
		try {
			person = personRepository.findPersonByFirstAndLastName(firstname, Lastname);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during person loading.. inside findPersonByFirstAndLastName.."
					+ "Error Message:" + e.getMessage());
		}
		return person;
	}

	@Override
	/**
	 * Method used to fetch list of persons by lastname
	 */
	public Optional<List<Person>> findListOfPersonsByLastName(String lastname) {
		// TODO Auto-generated method stub
		logger.info("Flow stated inside findPersonByLastName method.");
		Optional<List<Person>> person = null;
		try {
			person = personRepository.findPersonByLastName(lastname);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during person loading.. inside findPersonByLastName.." + "Error Message:"
					+ e.getMessage());
		}
		return person;
	}

	@Override
	public Optional<Person> findPersonById(Integer personId) {
		// TODO Auto-generated method stub
		logger.info("Flow stated inside findPersonById method.");
		Optional<Person> person = null;
		try {
			person = personRepository.findById(personId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error occured during person loading.. inside findPersonById.." + "Error Message:"
					+ e.getMessage());
		}
		return person;
	}

	@Override
	public Optional<Address> findAddressById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Address> address=null;
		try {
			address=addressRepository.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return address;
	}

}
