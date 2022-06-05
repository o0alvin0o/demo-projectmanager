package com.jsp.pma.api.controllers;

import com.jsp.pma.dao.EmployeeRepository;
import com.jsp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api-api/employees")
public class EmployeeApiController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return empRepo.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee) {
        return empRepo.save(employee);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Employee patchEmployee) {
        Employee emp = empRepo.findById(id).get();
        if (patchEmployee.getEmail() != null) {
            emp.setEmail((patchEmployee.getEmail()));
        }
        if (patchEmployee.getFirstName() != null) {
            emp.setFirstName((patchEmployee.getFirstName()));
        }
        if (patchEmployee.getLastName() != null) {
            emp.setLastName((patchEmployee.getLastName()));
        }

        return empRepo.save(emp);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try {
            empRepo.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex) {
        }
    }
}
