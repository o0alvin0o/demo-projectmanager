package com.jsp.pma.projectmanagement.dao;

import com.jsp.pma.projectmanagement.dto.EmployeeProject;
import com.jsp.pma.projectmanagement.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e LEFT JOIN project_employee pe ON e.employee_id = pe.employee_id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    List<EmployeeProject> employeeProjects();
}
