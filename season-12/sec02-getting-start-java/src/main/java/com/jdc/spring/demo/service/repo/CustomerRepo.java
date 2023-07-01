package com.jdc.spring.demo.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.spring.demo.service.entity.Customer;

public interface CustomerRepo extends JpaRepositoryImplementation<Customer, String>{

}
