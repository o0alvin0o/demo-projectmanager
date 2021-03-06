package com.jsp.pma.projectmanagement.services;

import com.jsp.pma.projectmanagement.dao.EmployeeRepository;
import com.jsp.pma.projectmanagement.dto.EmployeeProject;
import com.jsp.pma.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects() {
        return empRepo.employeeProjects();
    }

}
