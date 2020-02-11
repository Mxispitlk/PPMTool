package cz.mxispitlk.ppmtool.services;

import cz.mxispitlk.ppmtool.domain.Project;
import cz.mxispitlk.ppmtool.exceptions.ProjectIdException;
import cz.mxispitlk.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception e ){
            throw new ProjectIdException("Project ID" + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }
    public Project findByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project ID" + projectId.toUpperCase() + " doesnt exist");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null){
            throw new ProjectIdException("Cannot find Project with Id " +projectId+ "This project doesn't exit");
        }
        projectRepository.delete(project);
    }

}
