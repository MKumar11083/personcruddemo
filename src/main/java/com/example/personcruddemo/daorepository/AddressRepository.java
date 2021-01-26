package com.example.personcruddemo.daorepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personcruddemo.model.Address;

/**
 * @author Manoj Kumar
 * 
 * This interface is used to persist the Address entity along with parent personid relationship using spring data jpa.
 *
 */

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
