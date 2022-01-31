package com.ganggreen.controller;

import com.ganggreen.model.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason MacKeigan
 */
@RestController("/project")
public class ProjectController {

    @GetMapping(path = "/{id}")
    @Operation(
            description = "Returns the specific project for the given id.",
            responses = @ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Project.class)))
    )
    public Project get(@RequestAttribute int id) {
        //TODO remove example
        return new Project("Test!");
    }

}
