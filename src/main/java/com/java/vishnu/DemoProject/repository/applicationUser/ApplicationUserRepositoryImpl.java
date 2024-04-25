package com.java.vishnu.DemoProject.repository.applicationUser;

import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository{

    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Override
    public ApplicationUser createApplicationUser(ApplicationUser applicationUser) {
        return applicationUserDao.save(applicationUser);
    }

    @Override
    public void deleteApplicationUserById(long applicationUserId) {
        applicationUserDao.deleteById(applicationUserId);
    }


}
