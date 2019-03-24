package com.test.signal.broker.controller;


import com.test.signal.broker.model.User;
import com.test.signal.broker.service.IdentityService;
import com.test.signal.broker.service.SignalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Api(value="identity",description = "Services for identity management")
public class IdentityController {

    @Autowired
    private IdentityService service;

    @ApiOperation(value = "List all users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value ="/user", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getUsers(){
        return service.findAllUsers();
    }
}
