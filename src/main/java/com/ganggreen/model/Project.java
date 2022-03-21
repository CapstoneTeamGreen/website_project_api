package com.ganggreen.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Jason MacKeigan
 */


@Entity(name = "Project")
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    @Column (name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    //private List<String> technologies;
    @Column(name = "link", nullable = true)
    private String link;

    public Project(
            @JsonProperty("projectId") int id,
            @JsonProperty("projectName") String name,
            @JsonProperty("projectDesc") String desc,
            @JsonProperty("projectLink")String link) {
        this.id = id;
        this.setName(name);
        this.setDescription(desc);
        //this.setTechnologies(new ArrayList<String>());
        this.setLink(link);
    }

    public Project() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

//    public List<String> getTechnologies() {
//        return technologies;
//    }
//
//    public void setTechnologies(List<String> technologies) {
//        this.technologies = technologies;
//    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
