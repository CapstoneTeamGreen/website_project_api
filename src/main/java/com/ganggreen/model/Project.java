package com.ganggreen.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Jason MacKeigan
 */


@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @JsonProperty("projectId")
    @Column (name = "id", unique = true, updatable = false, nullable = false)
    private int id;

    @JsonProperty("projectName")
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty("projectDesc")
    @Column(name = "description", nullable = false)
    private String description;

    @JsonProperty("projectLink")
    @Column(name = "link", nullable = true)
    private String link;

    @JsonProperty("technologies")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Technology> technology = new HashSet<>();

    public Project(int id, String name, String desc, String link, Set<Technology> technology) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.link = link;
        this.technology = technology;
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

    public Set<Technology> getTechnology() {
        return technology;
    }

    public void setTechnology(Set<Technology> technologies) {
        this.technology = technologies;
    }

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
