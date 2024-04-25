package com.java.vishnu.DemoProject.service.ApplicationUser;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.application.Application;
import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;
import com.java.vishnu.DemoProject.models.applicationUser.CreateApplicationUserRequest;
import com.java.vishnu.DemoProject.models.user.User;
import com.java.vishnu.DemoProject.repository.application.ApplicationRepository;
import com.java.vishnu.DemoProject.repository.applicationUser.ApplicationUserRepository;
import com.java.vishnu.DemoProject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ApplicationUser creteApplicationUser(CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException {
        User user = userRepository.getUserByEmail(createApplicationUserRequest.getUserEmail());
        if (user == null) {
            throw new UserNotFoundException("user this email not found" );
        }
        Application application = applicationRepository.getApplicationByName(createApplicationUserRequest.getApplicationName());
        if (application == null) {
            throw new IllegalArgumentException("Application with  this name not found" );
        }
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.getId();
        applicationUser.getApplication();
        return applicationUserRepository.createApplicationUser(applicationUser);
    }


    @Override
    public void deleteApplicationUserById(long applicationUserId) {
        applicationUserRepository.deleteApplicationUserById(applicationUserId);
    }
}