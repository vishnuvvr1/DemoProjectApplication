package com.java.vishnu.DemoProject.models.role;


public class CreateRoleRequest {
    private Long id;
    private String name;
    private String description;

    private String type;
    private String displayName;

    private boolean internal;

    public CreateRoleRequest(Long id, String name, String description, String type, String displayName, boolean internal) {
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
