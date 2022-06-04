package com.jsp.pma.projectmanagement.services;

import com.jsp.pma.projectmanagement.dao.ProjectRepository;
import com.jsp.pma.projectmanagement.dto.ChartData;
import com.jsp.pma.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;

    public Project save(Project project) {
        return proRepo.save(project);
    }

    public List<Project> getAll() {
        return proRepo.findAll();
    }

    public List<ChartData> getProjectStatus() {
        return proRepo.getProjectStatus();
    }
}
