package com.java.vishnu.DemoProject.repository.application;


import com.java.vishnu.DemoProject.models.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Autowired
    public ApplicationDao applicationDao;

    @Override
    public Application createApplication(Application application) {
        return applicationDao.save(application);
    }

    @Override
    public Application getApplicationById(long applicationId) {
        Optional<Application> application = applicationDao.findById(applicationId);
        return application.orElse(null);
    }

    @Override
    public void deleteApplicationById(long applicationId) {
        applicationDao.deleteById(applicationId);
    }

    @Override
    public List<Application> listApplications(Long id, String name, String displayName, String loginUrl,
                                              String logoutUrl, Long version, String description, boolean active) {
        List<Application> applications = new ArrayList<>();
        if (id != null) {
            applications.add(applicationDao.findById(id).get());
            return applications;
        }
        if (name != null) {
            return applicationDao.findAllByName(name);
        }
        if (displayName != null) {
            return applicationDao.findAllByDisplayName(displayName);
        }
        if (loginUrl != null) {
            return applicationDao.findAllByLoginUrl(loginUrl);
        }
        if (logoutUrl != null) {
            return applicationDao.findAllByLogoutUrl(logoutUrl);
        }
        if (version != null) {
            return applicationDao.findAllByVersion(version);
        }
        if (description != null) {
            return applicationDao.findAllByDescription(description);
        }
        return applicationDao.findAll();
    }

    @Override
    public Application updateApplication(Application application) {
        return applicationDao.save(application);
    }
}
