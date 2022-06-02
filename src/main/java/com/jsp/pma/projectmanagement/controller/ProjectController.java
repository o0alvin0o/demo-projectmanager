package com.jsp.pma.projectmanagement.controller;

import com.jsp.pma.projectmanagement.dao.EmployeeRepository;
import com.jsp.pma.projectmanagement.dao.ProjectRepository;
import com.jsp.pma.projectmanagement.entities.Employee;
import com.jsp.pma.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project", aProject);
        return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        proRepo.save(project);
        return "redirect:/projects/"; // to prevent duplicate submission
    }

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "/projects/list-projects";
    }
}
