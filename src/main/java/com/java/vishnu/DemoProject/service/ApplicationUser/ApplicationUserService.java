package com.java.vishnu.DemoProject.service.ApplicationUser;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;
import com.java.vishnu.DemoProject.models.applicationUser.CreateApplicationUserRequest;

public interface ApplicationUserService {
    ApplicationUser creteApplicationUser(CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException;

    void deleteApplicationUserById(long applicationUserId);

}



