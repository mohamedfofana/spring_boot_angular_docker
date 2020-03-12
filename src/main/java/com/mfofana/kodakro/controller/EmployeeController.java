package com.mfofana.kodakro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfofana.kodakro.exception.ResourceNotFoundException;
import com.mfofana.kodakro.model.Employee;
import com.mfofana.kodakro.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/api/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;


	@PostMapping("/")
	public Employee postEmployee(@Valid @RequestBody Employee employee){
		return employeeRepository.saveAndFlush(employee);
	}

	@GetMapping("/all")
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id){
		Optional<Employee> employee= employeeRepository.findById(id);
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteEmployee(@PathVariable("id") Long id){
		employeeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}/address")
	public Employee updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee){
		Employee dbEmployee =  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		if (dbEmployee!=null) {
			dbEmployee.setAddress(employee.getAddress());
			dbEmployee.setZipcode(employee.getZipcode());
			dbEmployee.setCity(employee.getCity());
			dbEmployee.setCountry(employee.getCountry());
		}
		return employeeRepository.save(dbEmployee);
	}
}
