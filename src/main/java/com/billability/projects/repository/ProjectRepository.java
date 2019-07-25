package com.billability.projects.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.billability.projects.model.ProjectDAO;

@Repository("projectRepository")
public interface ProjectRepository extends CrudRepository<ProjectDAO, Long> {
	
	public Iterable<ProjectDAO> findAll();
	
	public ProjectDAO findById(int id);
	
	@Query(nativeQuery =true,value = "select project_code from projects where project_code IN (:codes)")
	public List<String> findByProjectCodes(@Param("codes") List<String> codes);
	
}

