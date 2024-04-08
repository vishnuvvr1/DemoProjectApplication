package com.java.vishnu.DemoProject.service.application;

import com.java.vishnu.DemoProject.models.application.Application;
import com.java.vishnu.DemoProject.models.application.CreateApplicationRequest;
import com.java.vishnu.DemoProject.models.application.UpdateApplicationRequest;
import com.java.vishnu.DemoProject.repository.application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    public ApplicationRepository applicationRepository;

    @Override
    public Application creteApplication(CreateApplicationRequest createApplicationRequest) {
        Application application = new Application();
        application.setName(createApplicationRequest.getName());
        application.setDisplayName(createApplicationRequest.getDisplayName());
        application.setLoginUrl(createApplicationRequest.getLoginUrl());
        application.setLogoutUrl(createApplicationRequest.getLoginUrl());
        application.setVersion(createApplicationRequest.getVersion());
        application.setDescription(createApplicationRequest.getDescription());
        application.setActive(createApplicationRequest.isActive());
        return applicationRepository.createApplication(application);
    }

    @Override
    public Application getApplicationById(long applicationId) {
        return applicationRepository.getApplicationById(applicationId);
    }

    @Override
    public void deleteApplicationById(long applicationId) {
        applicationRepository.deleteApplicationById(applicationId);
    }

    @Override
    public List<Application> listApplications(Long id, String name, String displayName, String loginUrl, String logoutUrl, Long version, String description, boolean active) {
        return applicationRepository.listApplications(id, name, displayName, loginUrl, logoutUrl, version, description, active);
    }

    @Override
    public Application updateApplication(long applicationId, UpdateApplicationRequest updateApplicationRequest) {
        Application application = applicationRepository.getApplicationById(applicationId);

        String originalDisplayName = application.getDisplayName();
        String originalLoginUrl = application.getLoginUrl();
        String originalLogoutUrl = application.getLogoutUrl();
        Long originalVersion = application.getVersion();
        String originalDescription = application.getDescription();

        application.setActive(updateApplicationRequest.isActive());

        application.setDisplayName(originalDisplayName);
        application.setLoginUrl(originalLoginUrl);
        application.setLogoutUrl(originalLogoutUrl);
        application.setVersion(originalVersion);
        application.setDescription(originalDescription);

        return applicationRepository.updateApplication(application);
    }
}