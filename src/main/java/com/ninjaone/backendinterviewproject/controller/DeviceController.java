package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class DeviceController {

    private final DeviceService serviceDeviceService;

    public DeviceController(DeviceService serviceDeviceService) {
        this.serviceDeviceService = serviceDeviceService;
    }


    @PostMapping("/device")
    @ResponseStatus(HttpStatus.CREATED)
    public Device postDeviceEntity(@RequestBody Device device){
        return serviceDeviceService.saveDeviceEntity(device);
    }

    @PutMapping("/device")
    @ResponseStatus(HttpStatus.CREATED)
    public Device putDeviceEntity(@RequestBody Device device){
        return serviceDeviceService.updateDeviceEntity(device);
    }

    @GetMapping("/device/{id}")
    public Device getDeviceEntity(@PathVariable Integer id){
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
    public DeviceType getDeviceTypeEntity(@PathVariable Integer id){
        return serviceDeviceService.getDeviceTypeEntity(id)
                .orElseThrow();
    }

    @GetMapping("/device/cost/{id}")
    public BigDecimal getTotalCostDevice(@PathVariable Integer id){
        return serviceDeviceService.calculateDeviceCost(id);
    }

    @PutMapping("/assign/{serviceId}/device/{deviceId}")
    public Device assignServiceToDevice(
            @PathVariable Integer serviceId,
            @PathVariable Integer deviceId
    ){
        return serviceDeviceService.assignServiceToDevice(serviceId,deviceId);
    }
}
