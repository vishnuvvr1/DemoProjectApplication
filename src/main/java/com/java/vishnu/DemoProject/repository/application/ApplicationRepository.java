package com.java.vishnu.DemoProject.repository.application;

import com.java.vishnu.DemoProject.models.application.Application;

import java.util.List;

public interface ApplicationRepository {
    Application createApplication(Application application);

    Application getApplicationById(long applicationId);

    void deleteApplicationById(long applicationId);

    List<Application> listApplications(Long id, String name, String displayName, String loginUrl, String logoutUrl, Long version, String description, boolean active);

    Application updateApplication(Application application);
}


