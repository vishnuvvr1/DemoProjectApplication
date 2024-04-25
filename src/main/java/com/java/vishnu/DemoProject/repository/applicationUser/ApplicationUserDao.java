package com.java.vishnu.DemoProject.repository.applicationUser;

import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Long> {
}
