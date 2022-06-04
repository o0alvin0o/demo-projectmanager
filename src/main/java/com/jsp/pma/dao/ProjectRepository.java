package com.jsp.pma.dao;

import com.jsp.pma.dto.ChartData;
import com.jsp.pma.entities.Project;
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
