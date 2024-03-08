package com.java.vishnu.DemoProject.models.role;

import jakarta.persistence.*;

@Entity
@Table(name = "[role]")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "type", length = 10)
    private String type;
    @Column(name = "displayName", length = 50)
    private String displayName;

    @Column(name = "internal")
    private boolean internal;

    public Role() {
    }

    public Role(Long id, String name, String description, String type, String displayName, boolean internal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.displayName = displayName;
        this.internal = internal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }
}
