package com.jsp.pma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.pma.dao.EmployeeRepository;
import com.jsp.pma.dao.ProjectRepository;
import com.jsp.pma.dto.ChartData;
import com.jsp.pma.dto.EmployeeProject;
import com.jsp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    String ver;

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        model.addAttribute("envVersionNum", ver);

        // Querying the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        //Converting projectData object into a json structure for using in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // [ ["NOTSTARTED",1],["INPROGRESS",2],...  ]
        model.addAttribute("projectStatusCnt", jsonString);

        // Querying the database for employees
        List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
        model.addAttribute("employeesListProjects", employeesProjectCnt);

        return "main/home";
    }
}
