package com.mysql_mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mysql_mvc.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
