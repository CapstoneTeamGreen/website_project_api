package com.ganggreen.controller;

import com.ganggreen.model.Project;
import com.ganggreen.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.ganggreen.service.ProjectService;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

/**
 * @author Jason MacKeigan
 * @contributor Gideon Niemelainen
 */
@RestController("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Operation(
            description = "Returns a collection of projects.",
            responses = @ApiResponse(responseCode = "200",
                content = @Content(schema = @Schema(implementation = Project.class)))
    )

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @Operation (
            description = "Returns a specific selected project.",
            responses = @ApiResponse(responseCode = "200",
                content = @Content(schema = @Schema(implementation = Project.class)))
    )
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Project> getProjectById(@PathVariable("id") int id) {
        return projectService.selectProjectById(id);
    }

//    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Project> getAll() {
//        return List.of(
//                new Project(1, "Test1", "A test project",  "www.test1.com"),
//                new Project(2, "Test2", "A testier project",  "www.test1.com")
//        );
//    }

}
