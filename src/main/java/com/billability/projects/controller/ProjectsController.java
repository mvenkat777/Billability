package com.billability.projects.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.billability.projects.model.ProjectDAO;
import com.billability.projects.service.ProjectService;
import org.springframework.validation.BindingResult;
//import java.util.ArrayList;

@Controller
public class ProjectsController {
	
	private ProjectService projectService;
	
	@Autowired
	public ProjectsController(ProjectService projectService) {	
      this.projectService = projectService;
    }

    @GetMapping("/projects-list")
    public String projectsList(Model model) {
    	model.addAttribute("projects", projectService.projectList());
    	//System.out.println(bindingResult.getAllErrors());
    	//System.out.println("BEFORE TEST"+projectService.projectList().toString());
        return "projects_list"; //view
    }
    
    @GetMapping("/project-add")
    public String projectAdd(ProjectDAO projectDAO) {
        
        return "projects_add"; //view
    }
    
    @PostMapping("/project-register")
    public String validateProjectAndSave(@Valid ProjectDAO projectDAO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        	
        	//System.out.println(bindingResult.getAllErrors());
            //System.exit(0);//return "form";
            return "projects_add"; //view
        }
        
        projectService.saveProject(projectDAO);
        
        return "redirect:/projects-list";
    }
    
    @GetMapping("/project-edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
    	//projectService.getProjectById(id); 
    	//ProjectDAO project = projectService.getProjectById(id);
    	//System.out.println("BEFORE TEST"+projectService.getProjectById(id).toString());
        model.addAttribute("projectDAO", projectService.getProjectById(id));
        
        return "projects_edit";
    }
    
 
    @PostMapping("/project-update/{id}")
    public String updateProjectInfo(@PathVariable("id") int id, Model model, @ModelAttribute @Valid ProjectDAO projectDAO, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {        	
    		return "projects_edit"; //view
        }
        //System.out.println(user.toString());
        //System.exit(0);
        projectService.saveProject(projectDAO);
        //return "projects-list";
        return "redirect:/projects-list";
    }
    
    @GetMapping("/project-delete/{id}")
    public String deleteUser(@PathVariable("id") int id, ProjectDAO projectDAO) {
    	projectService.deleteProject(projectDAO);
    	return "redirect:/projects-list";
    }

}