package com.ganggreen.configuration;

import com.ganggreen.model.Project;
import com.ganggreen.model.Technology;
import com.ganggreen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DatabaseSeedConfiguration {

    private final ProjectService service;

    @Autowired
    public DatabaseSeedConfiguration(ProjectService service) {
        this.service = service;
    }

    @PostConstruct
    public void initialize() {
        Technology technology = new Technology(1, "Java");

        Project project = new Project(1, "Foo", "Bar", "https://google.com", Set.of(technology));

        service.createIfNotExists(project);
    }

}
