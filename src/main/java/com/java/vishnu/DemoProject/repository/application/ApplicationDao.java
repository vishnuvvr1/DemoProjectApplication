package com.java.vishnu.DemoProject.repository.application;

import com.java.vishnu.DemoProject.models.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationDao extends JpaRepository<Application, Long> {


    List<Application> findAllByName(String name);

    List<Application> findAllByDisplayName(String displayName);

    List<Application> findAllByLoginUrl(String loginUrl);

    List<Application> findAllByLogoutUrl(String logoutUrl);

    List<Application> findAllByVersion(Long version);

    List<Application> findAllByDescription(String description);

    Application findByName(String applicationName);
}






