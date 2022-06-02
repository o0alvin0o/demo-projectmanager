package com.jsp.pma.projectmanagement.dao;

import com.jsp.pma.projectmanagement.dto.ChartData;
import com.jsp.pma.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findAll();

    @Query(nativeQuery = true,value = "SELECT stage as label, COUNT(*) as quantity\n" +
            "FROM project\n" +
            "GROUP BY stage\n")
    List<ChartData> getProjectStatus();
}
