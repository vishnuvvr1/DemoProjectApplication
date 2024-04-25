package com.java.vishnu.DemoProject.controller.applicationUser;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import com.java.vishnu.DemoProject.models.applicationUser.ApplicationUser;
import com.java.vishnu.DemoProject.models.applicationUser.CreateApplicationUserRequest;
import com.java.vishnu.DemoProject.service.ApplicationUser.ApplicationUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Application User Controller", description = "Manage Application Users in Demo Api")
public class ApplicationUserController {
    @Autowired
    private ApplicationUserService applicationUserService;

    @CrossOrigin(value = "*")
    @PostMapping("/applicationUsers")
    @Operation(summary = "Create Application User", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateApplicationUserRequest.class))
            )
    })

    public ApplicationUser createApplicationUser(@RequestBody CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException {
        return applicationUserService.creteApplicationUser(createApplicationUserRequest);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/applicationUser/{applicationId}")
    @Operation(summary = "Delete ApplicationUser", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public String deleteApplicationUserById(@PathVariable long applicationUserId) {
        applicationUserService.deleteApplicationUserById(applicationUserId);
        return "ApplicationUser Deleted Successfully";
    }

}
