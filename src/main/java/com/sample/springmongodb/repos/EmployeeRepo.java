package com.sample.springmongodb.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.springmongodb.model.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Long>{
    
}
