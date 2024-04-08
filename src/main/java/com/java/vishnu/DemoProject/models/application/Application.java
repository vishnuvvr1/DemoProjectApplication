package com.java.vishnu.DemoProject.models.application;

import jakarta.persistence.*;

@Entity
@Table(name = "[Application]")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "displayName", length = 50)
    private String displayName;

    @Column(name = "loginUrl", length = 250)
    private String loginUrl;

    @Column(name = "logoutUrl", length = 250)
    private String logoutUrl;

    @Column(name = "version", length = 20)
    private Long version;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "active")
    private boolean active;

    public Application() {
    }

    public Application(Long id, String name, String displayName, String loginUrl, String logoutUrl, Long version, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.loginUrl = loginUrl;
        this.logoutUrl = logoutUrl;
        this.version = version;
        this.description = description;
        this.active = active;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

