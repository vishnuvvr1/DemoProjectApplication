package com.java.vishnu.DemoProject.models.applicationUser;

public class CreateApplicationUserRequest {
    private  String userEmail;
    public String applicationName;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
