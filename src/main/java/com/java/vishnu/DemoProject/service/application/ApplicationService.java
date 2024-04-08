package com.java.vishnu.DemoProject.service.application;

import com.java.vishnu.DemoProject.models.application.Application;
import com.java.vishnu.DemoProject.models.application.CreateApplicationRequest;
import com.java.vishnu.DemoProject.models.application.UpdateApplicationRequest;

import java.util.List;

public interface ApplicationService {
    Application creteApplication(CreateApplicationRequest createApplicationRequest);

    Application getApplicationById(long applicationId);

    void deleteApplicationById(long applicationId);

    List<Application> listApplications(Long id, String name, String displayName, String loginUrl, String logoutUrl, Long version, String description, boolean active);

    Application updateApplication(long applicationId, UpdateApplicationRequest updateApplicationRequest);
}





