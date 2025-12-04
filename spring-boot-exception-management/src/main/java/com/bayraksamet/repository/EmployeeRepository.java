package com.bayraksamet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bayraksamet.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
