package com.mangodb.EmployeeRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mangodb.documents.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer>  {

}
