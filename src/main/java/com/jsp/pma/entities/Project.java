package com.jsp.pma.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator",sequenceName = "project_seq", allocationSize = 1)
    private long projectId;
    private String name;
    private String stage; // NOTSTARTED, COMPLETE, INPROGRESS
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name="project_employee",
            joinColumns = @JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id"))
    private List<Employee> employees;

    public Project() {

    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public void addEmployee(Employee emp) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(emp);
    }
}
