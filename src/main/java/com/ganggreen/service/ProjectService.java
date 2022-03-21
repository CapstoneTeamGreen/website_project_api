package com.ganggreen.service;

import com.ganggreen.model.Project;
import com.ganggreen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepo) {
        this.projectRepository = projectRepo;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> selectProjectById(int id) {
        return projectRepository.findById(id);
    }
}
