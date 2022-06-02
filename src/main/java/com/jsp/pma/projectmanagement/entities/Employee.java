package com.jsp.pma.projectmanagement.entities;

import lombok.Data;
import java.util.*;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
