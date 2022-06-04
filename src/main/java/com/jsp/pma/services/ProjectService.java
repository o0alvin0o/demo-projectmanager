package com.jsp.pma.services;

import com.jsp.pma.entities.Project;
import com.jsp.pma.dao.ProjectRepository;
import com.jsp.pma.dto.ChartData;
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
