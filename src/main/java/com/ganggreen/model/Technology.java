package com.ganggreen.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany
    private Set<Project> projects;

    public Technology() {

    }

    public Technology(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Project> getProjects() {
        return projects;
    }
}
