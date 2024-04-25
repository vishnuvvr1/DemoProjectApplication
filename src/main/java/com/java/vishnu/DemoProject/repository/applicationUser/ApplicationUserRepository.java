package com.java.vishnu.DemoProject.repository.applicationUser;

import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;

public interface ApplicationUserRepository {
    ApplicationUser createApplicationUser(ApplicationUser applicationUser);

    void deleteApplicationUserById(long applicationUserId);

}


