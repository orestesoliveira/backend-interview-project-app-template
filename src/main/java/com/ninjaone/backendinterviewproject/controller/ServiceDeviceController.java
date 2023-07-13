package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.ServiceDevice;
import com.ninjaone.backendinterviewproject.service.ServiceDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    @PostMapping("/device")
    @ResponseStatus(HttpStatus.CREATED)
    public Device postDeviceEntity(@RequestBody Device device){
        return serviceDeviceService.saveDeviceEntity(device);
    }

    @GetMapping("/device/{id}")
    private Device getDeviceEntity(@PathVariable Integer id){
        return serviceDeviceService.getDeviceEntity(id)
                .orElseThrow();
    }

    @DeleteMapping("/device/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeviceEntity(@PathVariable Integer id){
        serviceDeviceService.deleteDeviceEntity(id);
    }


    @GetMapping("/types")
    public List<DeviceType> findAllDeviceTypes(){
        return serviceDeviceService.findAllDeviceTypes();
    }

    @GetMapping("/type/{id}")
    private DeviceType getDeviceTypeEntity(@PathVariable Integer id){
        return serviceDeviceService.getDeviceTypeEntity(id)
                .orElseThrow();
    }
}
