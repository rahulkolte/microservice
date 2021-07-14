package com.mangodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangodb.EmployeeRepository.EmployeeRepo;
import com.mangodb.documents.Employee;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping
	public String saveEmployee(@RequestBody Employee emp) {

		employeeRepo.insert(emp);

		return "Added Emp id " + emp.getId();
	}

	@GetMapping("get")
	public Optional<Employee> getEmployee(@RequestParam int empId) {

		Optional<Employee> emp = employeeRepo.findById(empId);

		return emp;

	}

	@GetMapping
	public List<Employee> getAllEmployee() {

		List<Employee> allEmployees = employeeRepo.findAll();

		return allEmployees;
	}

	@PutMapping
	public String updateEmployee(@RequestBody Employee e) {

		employeeRepo.save(e);

		return "Updated emp for id " + e.getId();
	}

	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam int empId) {

		employeeRepo.deleteById(empId);

		return "Delete emp for id " + empId;
	}

}
