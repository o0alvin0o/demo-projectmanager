package com.jsp.pma.controller;

import com.jsp.pma.entities.Employee;
import com.jsp.pma.entities.Project;
import com.jsp.pma.services.EmployeeService;
import com.jsp.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService proService;

    @Autowired
    EmployeeService empService;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List<Employee> employees = empService.getAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", aProject);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        proService.save(project);
        return "redirect:new"; // to prevent duplicate submission
    }

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proService.getAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }
}
