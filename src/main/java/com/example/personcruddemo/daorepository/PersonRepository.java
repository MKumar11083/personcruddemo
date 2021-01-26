package com.example.personcruddemo.daorepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.personcruddemo.model.Person;

/**
 * @author Manoj Kumar
 * 
 * This interface is used to persist the person entity along with child address entity using spring data jpa.
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	@Query(value = "select * from person  where firstname=?1 and lastname=?2",nativeQuery = true)
	Optional<Person> findPersonByFirstAndLastName(String firstname,String Lastname);
	@Query(value="select * from person where lastname=?1",nativeQuery = true)
	Optional<List<Person>> findPersonByLastName(String lastname);
}