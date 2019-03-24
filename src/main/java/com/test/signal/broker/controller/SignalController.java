package com.test.signal.broker.controller;

import com.test.signal.broker.model.Signal;
import com.test.signal.broker.service.SignalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/signal")
@Api(value="signal",description = "Operations on signals")
public class SignalController {

    @Autowired
    private SignalService service;

    @ApiOperation(value = "List all received signals", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Signal> getAllSignals() {
        return service.getAllSignals();
    }

    @ApiOperation(value = "Retrieve a received signal", response = Signal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DEVICE')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Signal getSignalById(@PathVariable("id") int id) {
        return service.getSignalById(id);
    }

    @ApiOperation(value = "Deletes a received signal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSignalById(@PathVariable("id") int id) {
        service.deleteSignalById(id);
    }

    @ApiOperation(value = "Updates a received signal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.PUT)
    public void updateSignal(@RequestBody Signal signal) {
        service.updateSignal(signal);
    }

    @ApiOperation(value = "Receives a signal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully executed the operations"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DEVICE')")
    @RequestMapping(method = RequestMethod.POST)
    public void createSignal(@RequestBody Signal signal) {
        signal.setTimestamp(LocalDateTime.now());
        service.createSignal(signal);
    }

}
