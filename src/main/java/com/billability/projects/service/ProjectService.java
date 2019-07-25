package com.billability.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billability.projects.model.ProjectDAO;
import com.billability.projects.repository.ProjectRepository;

@Service("projectService")
public class ProjectService {

	private ProjectRepository projectRepository;
	
    @Autowired
    public ProjectService(ProjectRepository projectRepository) { 
      this.projectRepository = projectRepository;
    }
    
    public Iterable<ProjectDAO> projectList() {
    	return projectRepository.findAll();
    }
	
	public void saveProject(ProjectDAO projectDAO) {
		projectRepository.save(projectDAO);
	}
	
	public ProjectDAO getProjectById(int id) {
    	return projectRepository.findById(id);
    }
	
	public void deleteProject(ProjectDAO projectDAO) {
		projectRepository.delete(projectDAO);
	}

}
