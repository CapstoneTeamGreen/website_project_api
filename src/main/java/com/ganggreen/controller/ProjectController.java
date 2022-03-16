package com.ganggreen.controller;

import com.ganggreen.model.Project;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.security.Principal;
import java.util.List;

/**
 * @author Jason MacKeigan
 */
@RestController("/project")
public class ProjectController {

    @Autowired
    private RestTemplate restTemplate;

    @Operation(
            description = "Returns a collection of projects.",
            responses = @ApiResponse(responseCode = "200",
                content = @Content(schema = @Schema(implementation = Project.class)))
    )
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAll(Principal principal) {
        return List.of(new Project("Test1"), new Project("Test2"));
    }

}
