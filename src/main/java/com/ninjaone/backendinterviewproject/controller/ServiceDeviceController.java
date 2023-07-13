package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceDeviceController {

    private final ServiceDeviceService serviceDeviceService;

    public ServiceDeviceController(ServiceDeviceService serviceDeviceService) {
        this.serviceDeviceService = serviceDeviceService;
    }


    @PostMapping("/service")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceDevice postServiceDeviceEntity(@RequestBody ServiceDevice serviceDevice){
        return serviceDeviceService.saveServiceDeviceEntity(serviceDevice);
    }

    @GetMapping("/service/{id}")
    public ServiceDevice getServiceDeviceEntity(@PathVariable Integer id){
        return serviceDeviceService.getServiceDeviceEntity(id)
                .orElseThrow();
    }

    @DeleteMapping("/service/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServiceDeviceEntity(@PathVariable Integer id){
        serviceDeviceService.deleteServiceDeviceEntity(id);
    }

}
