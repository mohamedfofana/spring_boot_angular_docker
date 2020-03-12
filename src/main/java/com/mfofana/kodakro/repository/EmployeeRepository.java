package com.mfofana.kodakro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfofana.kodakro.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
