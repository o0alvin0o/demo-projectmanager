package com.jsp.pma.projectmanagement.dao;

import com.jsp.pma.projectmanagement.dao.ProjectRepository;
import com.jsp.pma.projectmanagement.entities.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Assert;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository proRepo;

    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project newProject = new Project("New Test Project", "COMPLETE", "Test");
        proRepo.save(newProject);
        Assert.assertEquals(5,proRepo.findAll().size());
    }
}
